import java.io.BufferedReader;
import com.google.gson.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class TrabajoPractico1 {
	
	public static ArrayList <Alumnos> listado;
	public static ArrayList <String> mensaje;
	public static PrintWriter salida;
	
	public static void main(String[] args) {
		
		String file = args[0];
		double notaAprobacion = Double.parseDouble(args[1]);
		
		//double notaAprobacion = 8;
		//String file = "C:\\Software\\eclipse-workspace\\TPnro1\\archivo.csv";
		leerArchivo(file);
		ordenarPromedios();
		calcularPromGral();
		System.out.println("Alumnos aprobados: "+ verificarAprobados(notaAprobacion));
		System.out.println("Promedio de asistencia de Varones: "+calcularAsistenciaMasculinos());
		System.out.println("Promedio de asistencia de Mujeres: "+calcularAsistenciaFemeninas());
		System.out.println("Cantidad de desaprobados con asistencia mayor a 75%: "+ calcularDesaprobadosAsistencia(notaAprobacion));
		
		Gson gson = new Gson();
		for(int i=0; i< 5;i++) {
			String js = gson.toJson(listado.get(i));
			System.out.println(js);
		}
	}
	
	private static void leerArchivo(String file) {
		BufferedReader archivo;
		try {
			String cadena;
			salida = new PrintWriter("c:/Logs/errores.bad");
			String[] separada;
			FileReader f;
			listado = new ArrayList();
			f = new FileReader(file);
			archivo = new BufferedReader(f);
			int i = 1;
		    while((cadena = archivo.readLine())!=null) {
		    	//System.out.println(cadena);
		    	mensaje = new ArrayList();
		    	
		    	separada = cadena.split(",");
		    	if(validarCadena(separada))
		    		listado.add(new Alumnos(separada[1], Integer.parseInt(separada[0]), separada[2],Double.parseDouble(separada[3]), Double.parseDouble(separada[4]) ,Double.parseDouble(separada[5])));
		    	else {
		    		String error="";
		    		System.out.println("");
		    		System.out.print("Error: En la linea "+i);
		    		error += "Error: En la linea "+i ;
		    		for(int j = 0; j< mensaje.size(); j++) {
		    			System.out.print(", "+ mensaje.get(j));
		    			error += ", "+ mensaje.get(j);
		    		}
		    		grabarArchivo(error);
		    	}
		    	mensaje.clear();
		    	i++;
		    }
			archivo.close();
	    	System.out.println("");
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			salida.close();
		}
	}

	private static void grabarArchivo(String error) {
		salida.println(error);
	}

	private static int calcularDesaprobadosAsistencia(double notaAprobacion) {
		int aprobados =0;
		for(int i =0; i<listado.size(); i++) {
			if (listado.get(i).getAsistencia()>= 75 && listado.get(i).getPromedio() < notaAprobacion)
				aprobados++;
		}
		return aprobados;
	}

	private static double calcularAsistenciaMasculinos() {
		double asistencia = 0;
		int varones = 0;
		for(int i=0;i<listado.size();i++) {
			if(listado.get(i).getSexo().equalsIgnoreCase("M")) {
				asistencia += listado.get(i).getAsistencia();
				varones++;
			}
		}
		asistencia = asistencia / varones;
		return asistencia;
	}
	
	private static double calcularAsistenciaFemeninas() {
		double asistencia = 0;
		int mujeres = 0;
		for(int i=0;i<listado.size();i++) {
			if(listado.get(i).getSexo().equalsIgnoreCase("F")) {
				asistencia += listado.get(i).getAsistencia();
				mujeres++;
			}
		}
		asistencia = asistencia / mujeres;
		return asistencia;
	}

	private static int verificarAprobados(double notaAprobacion) {
		int aprobados = 0;
		for(int i=0;i<listado.size();i++) {
			if(listado.get(i).getPromedio() >= notaAprobacion) {
				aprobados++;
			}
		}
		return aprobados;
	}

	private static void calcularPromGral() {
		double promedioGeneral=0;
		int i=0;
		for(i=0; i< listado.size(); i++) {
			promedioGeneral += listado.get(i).getPromedio();
		}
		promedioGeneral = promedioGeneral / i;
		System.out.println("El promedio general del curso es: "+ promedioGeneral);
	}

	private static boolean validarCadena(String[] separada) {
		String[] cadenaSeparada = separada;
		if (cadenaSeparada.length == 6) {
			if(!separada[0].equals("")) 
				if(!validarDni(separada[0])) {
					mensaje.add(" DNI invalido");
					//return false;
				}
				else ;
			else {
				mensaje.add("No se ingreso DNI");
				//return false;
			}
			if(separada[1].equals("")) {
				//validarNombre(separada[1]);
				mensaje.add("No tiene nombre ingresado");
				//return false;
			}
			if(!separada[2].equals("")) {
				if(!validarSexo(separada[2])) {
					mensaje.add("Se ingreso un valor incorrecto para sexo");
					//return false;
				}
					
			}else {
				mensaje.add("No se ingreso dato del sexo");
				//return false;
			}
			if(!separada[3].equals("") && !separada[4].equals("")) {
				if(!validarNotas(separada[3], separada[4])) {
					//return false;
				}
			}else{
				mensaje.add("Faltan ingresar datos de notas");
				//return false;
			}
			if(!separada[5].equals("")) {
				if(!validarAsistencia(separada[5])) {
					
					//return false;
				}
			}else {
				mensaje.add("No se ingreso valor de asistencia");
				//return false;
			}
			if(mensaje.size()==0)
				return true;
			else
				return false;
		}else {
			mensaje.add("Faltan datos en la linea");
			return false;
		}
	}
	
	private static boolean validarNotas(String nota1, String nota2) {
		double aux;
		aux = Double.parseDouble(nota1);
		if(aux > 10 || aux < 1) {
			mensaje.add("Nota 1er parcial incorrecta");
			return false;
		}
		aux = Double.parseDouble(nota2);
		if(aux > 10 || aux < 1) {
			mensaje.add("Nota 2do parcial incorrecta");
			return false;
		}
		return true;
	}

	private static boolean validarSexo(String sexo) {
		if(!sexo.equalsIgnoreCase("F") &&!sexo.equalsIgnoreCase("M")) {
			return false;
		}
		else return true;
	}

	private static boolean validarAsistencia(String asist) {
		if(Double.parseDouble(asist) > 100 || Double.parseDouble(asist)< 0) {
			mensaje.add("El valor de asistencia no es un porcentaje");
			return false;
		}
		return true;
	}

	private static boolean validarDni(String dni) {
		if(dni.length()<7 || dni.length()>8)
			return false;
		else
			return true;
	}


		
	public static void ordenarPromedios() {
		Alumnos[] promediosOrdenados = new Alumnos [listado.size()]; 
		int i=0;
		Collections.sort(listado, new Comparator<Alumnos>() {
			public int compare(Alumnos p1, Alumnos p2) {
				// Aqui esta el truco, ahora comparamos p2 con p1 y no al reves como antes
				return new Double(p2.getPromedio()).compareTo(new Double(p1.getPromedio()));
			}
		});
		Iterator <Alumnos> iter = listado.iterator();
		int j = 0;
		while (iter.hasNext()) {
			promediosOrdenados [j]= iter.next();
			j++;
		}
		System.out.println("Los 5 mejores promedios son:");
		for (i=0;i < 5; i++) {
			System.out.println("	- "+promediosOrdenados[i].getDNI() + ", "+promediosOrdenados[i].getNombre() + ", " + promediosOrdenados[i].getPromedio() );
		}
	}	
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class LeerArchivo {
	public static ArrayList <Alumnos> listado;
	
	public static void main(String[] args) {
		String cadena;
		String[] separada;
		String file = "C:\\Users\\Java\\eclipse-workspace\\TPnro1\\archivo.txt";
		FileReader f;
		listado = new ArrayList();
	
		
		try {
			f = new FileReader(file);
			BufferedReader b = new BufferedReader(f);
		    while((cadena = b.readLine())!=null) {
		    	//System.out.println(cadena);
		    	separada = cadena.split(",");
		    	//System.out.println(separada.length);
		    	listado.add(new Alumnos(separada[1], Integer.parseInt(separada[0]), separada[2],Double.parseDouble(separada[3]), Double.parseDouble(separada[4]) ,Double.parseDouble(separada[5])));
		    }
		    
		    b.close();
		    verificarPromedios();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}/*
		System.out.println(listado.size());
		System.out.println(listado.get(0).getNombre());
		System.out.println(listado.get(1).getNombre());
		System.out.println(listado.get(1).getPromedio());
	
	/*	
		Alumnos[] alumnos = new Alumnos[separada.length];
    	alumnos [i] = new Alumnos(separada[i+1], Integer.parseInt(separada[i]), separada[i+2], Short.parseShort(separada[i+3]), Short.parseShort(separada[i+4]) ,Double.parseDouble(separada[i+5]));
    	System.out.println(alumnos[i].getNombre());
		*/
		public static void verificarPromedios() {
			Alumnos[] listaPromedios = new Alumnos [listado.size()]; 
			Iterator <Alumnos> iter = listado.iterator();
			int i=0;
			ArrayList <Alumnos> ordenados = new ArrayList();
			//listado.sort(listado<listado.get().getPromedio()>);
			Collections.sort(listado, new Comparator() {
				public int compare(Alumnos p1, Alumnos p2) {
					// Aqui esta el truco, ahora comparamos p2 con p1 y no al reves como antes
					return new Double(p2.getPromedio()).compareTo(new Double(p1.getPromedio()));
				}

				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					return 0;
				}
			});
			while (iter.hasNext()) {
				//if(listaPromedios.)
				int j = 0;
				listaPromedios [j]= iter.next();
			
				System.out.println(listaPromedios[j].getNombre());
				j++;
			}
			Arrays.sort(listaPromedios);
		}
	
}

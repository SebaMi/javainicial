package estructura.secuencial;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		int numero;
		System.out.println("Ingrese un numero de 4 cifras");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()) { 
			numero = sc.nextInt();
			if(numero>999 && numero <10000)
				//dividirNumero (numero);
				separarNumero(numero);
			else
				System.out.println("Ingreso un numero que no es de 4 cifras");
		}
		else
			System.out.println("El valor ingresado no es un numero");	
		
	}
	
	public static void dividirNumero(int num) {
		String cadena = Integer.toString(num);
		for(int i=0; i<cadena.length();i++) {	
			System.out.println(cadena.charAt(i));
		}	
	}
	
	public static void separarNumero(int num) {
		double aux = num;
		for(int i=3;i>=0;i--) {
			aux = aux/(1*Math.pow(10, i));
			System.out.println(aux);
			num = num-(int)(1*Math.pow(10, i));
			aux=num;
		}
		
		
	}

}

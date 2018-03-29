package estructura.secuencial;

import java.util.Scanner;


public class Ejercicio1 {

	public static void main(String[] args) {
		int primero=0, segundo=0;
		String letra= "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Ingrese un entero");
		if(scan.hasNextInt()) 
			primero = scan.nextInt();
		else 
			System.out.println("No es un entero");
		System.out.println("Ingrese un segundo entero");
		if(scan.hasNextInt())
			segundo = scan.nextInt();
		else
			System.out.println("No es un entero");//letra += scan.next();
		
		if(primero != 0) System.out.println(primero);
		if(segundo != 0) System.out.println(segundo);
		//else System.out.println(letra);
	}

}

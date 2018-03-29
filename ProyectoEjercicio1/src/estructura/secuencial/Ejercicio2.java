package estructura.secuencial;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		String nombre;
		int primero, segundo;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un nombre");
		nombre = scan.nextLine();
		System.out.println("Buenos dias "+ nombre);
		System.out.println("Introduce un entero");
		primero = scan.nextInt();
		System.out.println("Introduce otro entero");
		segundo = scan.nextInt();
		System.out.println(String.format("%S los valores que ingresaste son: primero %d"
				+ "segundo fue %d", nombre, primero, segundo));		
		
	}

}

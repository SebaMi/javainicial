package estructura.secuencial;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		double cent;
		double fahrenheit;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce una temperatura en grados Celcius");
		if(scan.hasNextDouble()) {
			fahrenheit = conversionFahrenheit(scan.nextDouble());
			System.out.println("En Fahrenheit es: "+fahrenheit + "ºF");
		} else System.out.println("El valor introducido no es un numero");
	}
	
	public static double conversionFahrenheit (double cent) {
		double fah;
		fah = 32 + (9 * cent / 5);
		return fah;
	}

}

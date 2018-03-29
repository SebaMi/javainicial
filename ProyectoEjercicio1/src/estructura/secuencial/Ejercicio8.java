package estructura.secuencial;

import java.math.*;
import java.util.Scanner;



public class Ejercicio8 {
		
	public static void main(String[] args) {
		double radio;
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese el radio de la esfera");
		if(scan.hasNextDouble()) { 
			radio = scan.nextDouble();
			System.out.println("El volumen de la esfera es: "+calcularVolumen (radio));
			
		}
		else
			System.out.println("El valor ingresado no es un numero");
		
	}
	
	public static double calcularVolumen(double radio) {
		double volumen;
		volumen = 4 * Math.PI * Math.pow(radio, 3) / 3; 
		return volumen;
	}
}

package estructura.secuencial;

import java.util.Scanner;

public class ejercicio6 {

	public static void main(String[] args) {
		double velocidad;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("introduzca una velocidad en KMPH");
		velocidad = scan.nextDouble();
		System.out.println("En Mts/seg es: "+conversorVelocidad(velocidad));
	}
	
	public static double conversorVelocidad(double vel) {
		double mps;
		mps = vel * 1000 /3600;
		return mps;
	}

}

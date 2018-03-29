package programa;

public class Ejercicio4 {

	public static void main(String[] args) {
		/**
		 * 4. Programa java que declare cuatro variables enteras A, B, C y D y 
		 * asígnale un valor acada una. A continuación realiza las instrucciones 
		 * necesarias para que: B tome el valor de C, C tome el valor de A, A tome el 
		 * valor de D, D tome el valor de B.
		 */
		
		int A, B, C, D;
		
		A = 2;
		B = 5;
		C = 12;
		D = 45;
		
		A = A + D;
		D = A - D;
		A = A - D;
		
		System.out.println("A: "+A);
			
		B = B + C;
		C = B - C;
		B = B - C;
		
		System.out.println("B: "+B);
		
		C = C + D;
		D = C - D;
		C = C - D;
		
		System.out.println("C: "+C);
		System.out.println("D: "+D);
		
		
	}

}

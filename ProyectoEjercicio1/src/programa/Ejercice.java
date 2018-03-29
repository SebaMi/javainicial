package programa;

public class Ejercice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i<args.length;i++ ) {
			System.out.print(i!=1 ? args[i] : "CCc" + args[i+1]);
			//System.out.print(args[i] + " ");
		}
	}
}

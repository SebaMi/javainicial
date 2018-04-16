
public class Alumnos {
	private String nombre;
	private int DNI;
	private String sexo;
	private double nota1;
	private double nota2;
	private double asistencia;
	private double promedio;
	
	public Alumnos (String nombre, int DNI, String sexo, double nota1, double nota2, double asistencia){
		this.setNombre(nombre);
		this.setDNI(DNI);
		this.setSexo(sexo);
		this.setNota1(nota1);
		this.setNota2(nota2);
		this.setAsistencia(asistencia);
		this.setPromedio(calcularPromedio());
	}
	
	private double calcularPromedio() {
		return (this.getNota1()+this.getNota2())/2;
	}

	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getNota1() {
		return nota1;
	}

	private void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public String getSexo() {
		return sexo;
	}

	private void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getDNI() {
		return DNI;
	}

	private void setDNI(int dNI) {
		DNI = dNI;
	}

	public double getNota2() {
		return nota2;
	}

	private void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getAsistencia() {
		return asistencia;
	}

	private void setAsistencia(double asistencia) {
		this.asistencia = asistencia;
	}

	public double getPromedio() {
		return promedio;
	}

	private void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	
}

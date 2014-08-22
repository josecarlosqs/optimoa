package tipos;

import biblioteca.Utiles;

public class Usuario {
	private String nombre;
	private String apellido;
	private String codigo;
	private int edad;
	private String ocupacion;
	private String modelo;
	private String resulAgVisual;
	private String resulDaltonismo;
	private int resulOjoDominante;
	private double resulPorcentajeDeficiencia;
	private boolean antiReflex;
	private boolean visible;
	private String fechayhora;
	public static int indice = -1;

	public Usuario(String nombre, String apellido, String codigo,
			double resulPorfentajeDeficiencia, int resulOjoDominante,
			String resulDaltonismo, String resulAgVisual, boolean antiReflex,
			int edad, String ocupacion, String modelo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.resulAgVisual = resulAgVisual;
		this.resulDaltonismo = resulDaltonismo;
		this.resulOjoDominante = resulOjoDominante;
		this.resulPorcentajeDeficiencia = resulPorfentajeDeficiencia;
		this.antiReflex = antiReflex;
		fechayhora = Utiles.fecha() + " a las " + Utiles.hora();
		this.ocupacion = ocupacion;
		this.modelo = modelo;
		this.codigo = codigo;
		this.edad = edad;
		this.visible=true;
		indice++;
	}

	public Usuario() {
		this.nombre = "No realizó aun la prueba";
		this.apellido ="No realizó aun la prueba";
		this.resulAgVisual ="No realizó aun la prueba";
		this.resulDaltonismo = "No realizó aun la prueba";
		this.resulOjoDominante =0;
		this.resulPorcentajeDeficiencia =0;
		this.antiReflex =false;
		fechayhora = Utiles.fecha() + " a las " + Utiles.hora();
		this.ocupacion ="No realizó aun la prueba";
		this.modelo ="No se selecciono modelo";
		this.codigo = "Usted no realiza aun la prueba";
		this.edad = 0;
		visible=true;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getResulAgVisual() {
		return resulAgVisual;
	}

	public void setResulAgVisual(String resulAgVisual) {
		this.resulAgVisual = resulAgVisual;
	}

	public int getResulOjoDominante() {
		return resulOjoDominante;
	}

	public void setResulOjoDominante(int resulOjoDominante) {
		this.resulOjoDominante = resulOjoDominante;
	}

	public double getResulPorcentajeDeficiencia() {
		return resulPorcentajeDeficiencia;
	}

	public void setResulPorcentajeDeficiencia(double resulPorcentajeDeficiencia) {
		this.resulPorcentajeDeficiencia = resulPorcentajeDeficiencia;
	}

	public boolean isAntiReflex() {
		return antiReflex;
	}

	public void setAntiReflex(boolean antiReflex) {
		this.antiReflex = antiReflex;
	}

	public String getResulDaltonismo() {
		return resulDaltonismo;
	}

	public void setResulDaltonismo(String resulDaltonismo) {
		this.resulDaltonismo = resulDaltonismo;
	}

	public boolean isVisible() {
		return visible;
	}

	public String getFechayhora() {
		return fechayhora;
	}

	public void setFechayhora(String fechayhora) {
		this.fechayhora = fechayhora;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String obtenerDatosUsuario() {
		String lista = "";
		lista += "\nCodigo : " + codigo + "\nNombres : " + nombre
				+ "\nApellidos : " + apellido + "\nEdad : " + edad
				+ "\nEl porcentaje de deficiencia es de : "
				+ resulPorcentajeDeficiencia + 
				"\nDaltonismo : " + resulDaltonismo
				+ "\nOjo dominante : "
				+ (resulOjoDominante == 0 ? "Izquierdo" : "Derecho")
				+ "\nAgudeza visual : " + resulAgVisual
				+ "\nProteccion de tipo : "
				+ (antiReflex ? "Antireflex" : "Reflex")
				+ "\nModelo elegido : " + modelo + "\nOcupacion: " + ocupacion
				+ "\nFecha y hora de su ultima medición: " + fechayhora+"\n";
		return lista;
	}


}

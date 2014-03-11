package co.edu.grupo2.clase5.model;

public class Persona {

	private String nombre;
	private String apellido;
	private byte edad;
	private String genero;

	// Identifica la institucion educativa donde consiguio el titulo.
	private String institucion;

	// Identifica el nivel alcanzado, ya sea el semestre en el que se encuentra
	// si es estudiante o el titulo del estudio que ha alcanzado si es docente.
	private String nivel;

	// Enumera las materias que dicta actualmente para un profesor o las areas
	// de interes para un estudiante.
	private String items;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @deprecated
	 */
	public String getInstitucion() {
		return institucion;
	}

	/**
	 * @deprecated
	 */
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	/**
	 * @deprecated
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * @deprecated
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	/**
	 * @deprecated
	 */
	public String getItems() {
		return items;
	}
	
	/**
	 * @deprecated
	 */
	public void setItems(String items) {
		this.items = items;
	}
	
	

}

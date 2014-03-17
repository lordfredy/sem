package co.edu.grupo2.clase5.model;

import java.io.Serializable;

public class Persona implements Serializable {

	private static final long serialVersionUID = 6554325327610197080L;
	
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

	/**
	 * Default constructor
	 */
	public Persona() {
	}

	/**
	 * Constructor for set values
	 * 
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param genero
	 * @param institucion
	 * @param nivel
	 * @param items
	 */
	public Persona(String nombre, String apellido, byte edad, String genero,
			String institucion, String nivel, String items) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.institucion = institucion;
		this.nivel = nivel;
		this.items = items;
	}

	public Persona(Persona persona) {
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
		this.edad = persona.getEdad();
		this.genero = persona.getGenero();
		this.institucion = persona.getInstitucion();
		this.nivel = persona.getNivel();
		this.items = persona.getItems();
	}

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

	public String getInstitucion() {
		return institucion;
	}

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

	public String getFullName() {
		return (getText(getNombre(), " ")) + (getText(getApellido(), ""));
	}

	private String getText(String str, String tag) {
		return (str != null && !str.isEmpty() ? str + tag : "");
	}
}

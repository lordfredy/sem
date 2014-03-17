package co.edu.grupo2.clase5.model;

/**
 * Pojo que representa a un estudiante, extiende la clase Persona y redefine los
 * metodos de acceso para establecer la institucion de graduacion, el semestre
 * alcanzado y las areas de interes.
 * 
 * @author Grupo_02
 * 
 */
@SuppressWarnings("deprecation")
public class Estudiante extends Persona {

	private static final long serialVersionUID = -1816962050552845351L;

	public Estudiante() {
	}

	/**
	 * Constructor for set values
	 * 
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param genero
	 * @param institucion
	 * @param semestre
	 * @param areasDeInteres
	 */
	public Estudiante(String nombre, String apellido, byte edad, String genero,
			String institucion, String semestre, String areasDeInteres) {
		super(nombre, apellido, edad, genero, institucion, semestre,
				areasDeInteres);
	}
	
	public Estudiante(Persona persona) {
		super(persona);
	}

	public String getUniversidad() {
		return getInstitucion();
	}

	public void setUniversidad(String institucion) {
		this.setInstitucion(institucion);
	}

	public String getSemestre() {
		return getNivel();
	}

	public void setSemestre(String nivel) {
		this.setNivel(nivel);
	}

	public String getAreasDeInteres() {
		return getItems();
	}

	public void setAreasDeInteres(String items) {
		this.setItems(items);
	}
}

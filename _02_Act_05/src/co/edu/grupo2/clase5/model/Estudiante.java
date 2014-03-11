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

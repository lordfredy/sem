package co.edu.grupo2.clase5.model;

/**
 * Pojo que representa a un estudiante, extiende la clase Persona y redefine los
 * metodos de acceso para establecer la universidad, el semestre alcanzado y las
 * areas de interes.
 * 
 * @author Grupo_02
 * 
 */
@SuppressWarnings("deprecation")
public class Docente extends Persona {

	public String getUniversidad() {
		return getInstitucion();
	}

	public void setUniversidad(String institucion) {
		this.setInstitucion(institucion);
	}

	public String getProfesion() {
		return getNivel();
	}

	public void setProfesion(String nivel) {
		this.setNivel(nivel);
	}

	public String getMaterias() {
		return getItems();
	}

	public void setMaterias(String items) {
		this.setItems(items);
	}
}

package co.edu.grupo2.clase5.adapter;

import java.util.List;


import co.edu.grupo2.clase5.R;
import co.edu.grupo2.clase5.MainActivity.tipo;
import co.edu.grupo2.clase5.model.Persona;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PersonaAdapter extends ArrayAdapter<Persona> {

	Context context;
	int layoutResourceId;
	List<Persona> persona;
	
	private tipo tipoPersona = tipo.ESTUDIANTE;

	TextView textViewNombre;
	TextView textViewEdad;
	TextView textViewColegio;
	TextView textViewSemestre;

	LinearLayout layout;

	/**
	 * Default Constructor
	 * 
	 * @param context
	 * @param layoutResourceId
	 * @param objects
	 */
	public PersonaAdapter(Context context, int layoutResourceId,
			List<Persona> objects) {
		super(context, layoutResourceId, objects);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.persona = objects;
	}

	@SuppressWarnings("deprecation")
	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(layoutResourceId, parent, false);

		textViewNombre = (TextView) rowView.findViewById(R.id.item_layout_fullname);
		textViewEdad = (TextView) rowView.findViewById(R.id.item_layout_age);
//		textViewColegio = (TextView) rowView.findViewById(R.id.);
		textViewSemestre = (TextView) rowView.findViewById(R.id.item_layout_nivel);
//		layout = (LinearLayout) rowView.findViewById(R.id.estudiantesList);

		textViewNombre.setText(persona.get(pos).getFullName());
		textViewEdad.setText(persona.get(pos).getEdad());
		textViewColegio.setText("Colegio: "
				+ persona.get(pos).getInstitucion());
		textViewSemestre.setText(persona.get(pos).getNivel());

		if (pos % 2 == 0) {
			layout.setBackgroundColor(Color.parseColor("#9999FF"));
		}

		return rowView;
	}

	/**
	 * @return the tipoPersona
	 */
	public tipo getTipoPersona() {
		return tipoPersona;
	}

	/**
	 * @param tipoPersona the tipoPersona to set
	 */
	public void setTipoPersona(tipo tipoPersona) {
		switch (tipoPersona) {
		case DOCENTE:
			this.tipoPersona = tipoPersona;
			break;
		default:
			this.tipoPersona = tipo.ESTUDIANTE;
			break;
		}
	}

}

/**
 * 
 */

package com.udea.clase3_actividadesmascheveres;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityOther extends Activity {

	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_other);
	}

	@Override
	protected void onStart() {

		super.onStart();
		obtenerComponentes();
		escribirPersonaje();
	}

	/**
	 * metodo para obtener los componentes de la actividad
	 */
	private void obtenerComponentes() {

		textView = (TextView) findViewById(R.id.layout_other_textViewPersonaje);
	}

	/**
	 * escribimos el nombre del personaje que fue seleccionado en la actividad
	 * anterior, hacemos una serie de valdiaciones para la informacion que llega
	 */
	private void escribirPersonaje() {

		// tomamos el intent que nos trajo hasta aca
		Intent intent = getIntent();
		// debemos estar seguros de que el intente posee informacion antes de ir
		// a consultarlo
		if (intent.getExtras() != null) {

			// como ya sabemos que el intente llega con informacion, para efecto
			// del ejemplo,
			// verificare si me llega mi bundle
			if (intent.hasExtra("mibundle")) {
				// sabiendo que si lo trae, tomamos su informacion
				Bundle bundle = intent.getBundleExtra("mibundle");

				// tomamos la informacion que necesitamos del bundle
				boolean isCheck = bundle.getBoolean("check");
				String personaje = bundle.getString("personaje");
				textView.setText(personaje);
				if (isCheck) {
					// Dos maneras de tomar de setear un color
					// 1. quemado
					textView.setBackgroundColor(Color.parseColor("#8888FF"));
					// 2. de resources, ver archivo color.xml
					// textView.setBackgroundColor(getResources().getColor(R.color.azulclaro));
				}
			}
			// Si el intent no posee el bundle indicado, para efectos del
			// ejercicio y la practica vamos a preguntar si tiene un extra
			// llamado personaje
			else {
				// preguntamos si el intent posee el extra "personaje"
				if (intent.hasExtra("personaje")) {
					String message = intent.getStringExtra("personaje");
					textView.setText(message);
				} else {
					textView.setText("No se encontro el extra \"personaje\"");
				}
			}

		}
		// si nunca es enviado el personaje
		else {
			textView.setText("No se encontro el extra \"personaje\"");
		}

	}
}

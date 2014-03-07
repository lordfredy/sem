/**
 * 
 */

package com.udea.clase3_actividadesmascheveres;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityOther extends Activity {

	TextView tvNombre;
	TextView tvApellido;
	TextView tvDocumento;
	TextView tvTipoDocumento;
	ImageView imagen;

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

		tvNombre = (TextView) findViewById(R.id.layout_other_nombre);
		tvApellido = (TextView) findViewById(R.id.layout_other_apellido);
		tvDocumento = (TextView) findViewById(R.id.layout_other_documento);
		tvTipoDocumento = (TextView) findViewById(R.id.layout_other_tipo_documento);
		imagen = (ImageView) findViewById(R.id.layout_other_image);

	}

	/**
	 * escribimos el nombre del personaje que fue seleccionado en la actividad
	 * anterior, hacemos una serie de valdiaciones para la informacion que llega
	 */
	private void escribirPersonaje() {

		Intent intent = getIntent();
		if (intent.getExtras() != null) {

			if (intent.hasExtra("mibundle")) {
				Bundle bundle = intent.getBundleExtra("mibundle");

				boolean isCheck = bundle.getBoolean("check");
				String personaje = bundle.getString("personaje");
				tvNombre.setText(personaje);
				if (isCheck) {
					tvNombre.setBackgroundColor(Color.parseColor("#8888FF"));
				}
			} else {
				if (intent.hasExtra("personaje")) {
					String message = intent.getStringExtra("personaje");
					tvNombre.setText(message);
				} else {
					tvNombre.setText("No se encontro el extra \"personaje\"");
				}
			}

		} else {
			tvNombre.setText("No se encontro el extra \"personaje\"");
		}

	}
}

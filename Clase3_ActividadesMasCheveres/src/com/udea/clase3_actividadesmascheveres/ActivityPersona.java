package com.udea.clase3_actividadesmascheveres;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityPersona extends Activity {

	Spinner spinnerTipoDocumento;
	RadioButton radioButton1;
	RadioButton radioButton2;
	RadioGroup radioGroup;
	CheckBox checkBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_persona);
	}

	@Override
	protected void onStart() {

		super.onStart();
		obtenerComponentes();
		iniciarSpinnerTDoc();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_persona, menu);
		return true;
	}

	/**
	 * metodo para obtener los componentes de la actividad
	 */
	private void obtenerComponentes() {

		spinnerTipoDocumento = (Spinner) findViewById(R.id.layout_persona_tipo_documento);
		radioGroup = (RadioGroup) findViewById(R.id.layout_persona_genero);
		radioButton1 = (RadioButton) findViewById(R.id.layout_persona_gen_masculino);
		radioButton2 = (RadioButton) findViewById(R.id.layout_persona_gen_femenino);
		checkBox = (CheckBox) findViewById(R.id.layout_persona_activo);
	}

	/**
	 * metodo que inicia el spinner de la actividad
	 */
	private void iniciarSpinnerTDoc() {

		final String[] tiposDocumeto = new String[] { "Seleccione...",
				"Cédula", "Tajeta identidad", "Cedula extrangeria",
				"Pasaporte", "NIT" };

		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, tiposDocumeto);
		spinnerTipoDocumento.setAdapter(adaptador);

	}

	/**
	 * metodo que se ejecuta cuando en un boton con el onclick asociado a este
	 * metodo es tocado, toma el valor del spinner y lo muestra en pantalla
	 * 
	 * @param view
	 */
	public void getValueSpinner(View view) {

		// obtenemos la posicion del elemento del spinner que se encuentra
		// seleccionado
		String spinnerPosition = String.valueOf(spinnerTipoDocumento
				.getSelectedItemPosition());
		// podemos obtener el texto del elemento que se encuenta seleccionado
		String textSpinner = spinnerTipoDocumento.getSelectedItem().toString();
		Toast.makeText(getApplicationContext(),
				spinnerPosition + " " + textSpinner, Toast.LENGTH_LONG).show();
	}

	/**
	 * metodo que se ejecuta cuando en un boton con el onclick asociado a este
	 * metodo es tocado, toma el valor del radiobutton y lo muestra en pantalla
	 * 
	 * @param view
	 */
	public void getValueRadio(View view) {

		/*
		 * para el RadioGroup, podemos obtener el id del elemento radioButton
		 * que se encuentre seleccionado
		 */
		int idSeleccionado = radioGroup.getCheckedRadioButtonId();
		/*
		 * despues de tomaar el id del radioButton seleccionado, preguntamos
		 * cual es el elemento
		 */
		switch (idSeleccionado) {
		case R.id.layout_persona_gen_masculino:
			Toast.makeText(getApplicationContext(),
					radioButton1.getText().toString(), Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.layout_persona_gen_femenino:
			Toast.makeText(getApplicationContext(),
					radioButton2.getText().toString(), Toast.LENGTH_SHORT)
					.show();
			break;

		default:
			break;
		}
	}

	/**
	 * metodo que se ejecuta cuando en un boton con el onclick asociado a este
	 * metodo es tocado, inicia una nueva actividad sin enviar informacion
	 * 
	 * @param view
	 */
	public void iniciarActividad(View view) {

		// tomado de
		// http://developer.android.com/training/basics/firstapp/starting-activity.html
		/*
		 * el Intent funciona de una manera muy sencilla, solo le indicamos de
		 * donde arrancamos y para donde vamos <br> ActivityPersona ->
		 * ActivityOther
		 */
		Intent intent = new Intent(this, ActivityOther.class);
		/*
		 * iniciamos nuestra nueva actividad con esta linea de codigo <br>
		 * Recuerden que toda actvidad debe estar declarada en el Manifest del
		 * proyecto
		 */
		startActivity(intent);

	}

	/**
	 * metodo que se ejecuta cuando en un boton con el onclick asociado a este
	 * metodo es tocado, inicia una nueva actividad enviando un string
	 * 
	 * @param view
	 */
	public void iniciarActividadExtras(View view) {

		// tomado de
		// http://developer.android.com/training/basics/firstapp/starting-activity.html
		Intent intent = new Intent(this, ActivityOther.class);
		// al intent podemos agregarle informacion que va a llevar a nuestra
		// nueva actividad, tiene
		// un identificador que es el texto en este caso "personaje"
		intent.putExtra("personaje", spinnerTipoDocumento.getSelectedItem().toString());
		startActivity(intent);

	}

	/**
	 * metodo que se ejecuta cuando en un boton con el onclick asociado a este
	 * metodo es tocado, inicia una nueva actividad enviando un BUNDLE
	 * 
	 * @param view
	 */
	public void iniciarActividadBundle(View view) {

		Intent intent = new Intent(this, ActivityOther.class);
		// creamos un bundle, un bundle no es mas que un hashmap en donde vamos
		// a guardar la
		// informacion que querremos llevar a la otra actividad
		Bundle bundle = new Bundle();
		// colocamos un campo boolean con su identificador
		bundle.putBoolean("check", checkBox.isChecked());
		// colocamos un string con su identificador
		bundle.putString("tipoDocumento", spinnerTipoDocumento.getSelectedItem().toString());
		bundle.putBoolean("check", checkBox.isChecked());
		// a nuestro intent debemos agregarle ese bundle para que lo lleve a la
		// nueva actividad
		intent.putExtra("mibundle", bundle);
		startActivity(intent);

	}

}

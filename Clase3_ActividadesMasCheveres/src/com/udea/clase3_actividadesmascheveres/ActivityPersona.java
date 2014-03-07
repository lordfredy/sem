package com.udea.clase3_actividadesmascheveres;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityPersona extends Activity {

	Spinner spinnerTipoDocumento;
	EditText etDocumento;
	EditText etNombres;
	EditText etApellidos;
	EditText etCorreo;
	RadioGroup rgGenero;
	RadioButton rbGeneroMasculino;
	RadioButton rbGeneroFemenino;
	CheckBox cbEstado;

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
		rgGenero = (RadioGroup) findViewById(R.id.layout_persona_genero);
		rbGeneroMasculino = (RadioButton) findViewById(R.id.layout_persona_gen_masculino);
		rbGeneroFemenino = (RadioButton) findViewById(R.id.layout_persona_gen_femenino);
		cbEstado = (CheckBox) findViewById(R.id.layout_persona_activo);
		
		etDocumento = (EditText) findViewById(R.id.layout_persona_documento);
		etNombres = (EditText) findViewById(R.id.layout_persona_nombre);
		etApellidos = (EditText) findViewById(R.id.layout_persona_apellido);
		etCorreo = (EditText) findViewById(R.id.layout_persona_correo);
		
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
		int idSeleccionado = rgGenero.getCheckedRadioButtonId();
		/*
		 * despues de tomaar el id del radioButton seleccionado, preguntamos
		 * cual es el elemento
		 */
		switch (idSeleccionado) {
		case R.id.layout_persona_gen_masculino:
			Toast.makeText(getApplicationContext(),
					rbGeneroMasculino.getText().toString(), Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.layout_persona_gen_femenino:
			Toast.makeText(getApplicationContext(),
					rbGeneroFemenino.getText().toString(), Toast.LENGTH_SHORT)
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
		intent.putExtra("personaje", spinnerTipoDocumento.getSelectedItem()
				.toString());
		startActivity(intent);

	}

	/**
	 * metodo que se ejecuta cuando en un boton con el onclick asociado a este
	 * metodo es tocado, inicia una nueva actividad enviando un BUNDLE
	 * 
	 * @param view
	 */
	public void iniciarActividadBundle(View view) {

		try {
			Intent intent = new Intent(this, ActivityOther.class);
			// creamos un bundle, un bundle no es mas que un hashmap en donde
			// vamos
			// a guardar la
			// informacion que querremos llevar a la otra actividad
			Bundle bundle = new Bundle();
			// colocamos un campo boolean con su identificador

			bundle.putBoolean("check", cbEstado.isChecked());

			String tipoDocumento = spinnerTipoDocumento.getSelectedItem()
					.toString();
			if (spinnerTipoDocumento.getSelectedItemPosition() == 0) {
				Toast.makeText(getApplicationContext(),
						"Seleccione un tipo de documento valido",
						Toast.LENGTH_SHORT).show();
				return;
			}
			String documento = etDocumento.getText().toString();
			String nombre = etNombres.getText().toString();
			String apellidos = etApellidos.getText().toString();
			String correo = etCorreo.getText().toString();

			String genero = "";
			int idSeleccionado = rgGenero.getCheckedRadioButtonId();
			switch (idSeleccionado) {
			case R.id.layout_persona_gen_masculino:
				genero = rbGeneroMasculino.getText().toString();
				break;
			case R.id.layout_persona_gen_femenino:
				genero = rbGeneroFemenino.getText().toString();
				break;
			default:
				Toast.makeText(getApplicationContext(), "Seleccionar genero",
						Toast.LENGTH_SHORT).show();
				return;
			}

			bundle.putString("tipoDocumento", tipoDocumento);
			bundle.putString("documento", documento);
			bundle.putString("nombre", nombre);
			bundle.putString("apellidos", apellidos);
			bundle.putString("correo", correo);
			bundle.putString("genero", genero);

			bundle.putBoolean("estado", cbEstado.isChecked());

			// A nuestro intent debemos agregarle ese bundle para que lo lleve a
			// la
			// nueva actividad
			intent.putExtra("mibundle", bundle);
			startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), "EROR! " + e.getMessage(),
					Toast.LENGTH_SHORT).show();
		}

	}

}

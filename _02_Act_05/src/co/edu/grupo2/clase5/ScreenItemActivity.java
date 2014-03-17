package co.edu.grupo2.clase5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import co.edu.grupo2.clase5.MainActivity.tipo;
import co.edu.grupo2.clase5.model.Persona;

public class ScreenItemActivity extends Activity {

	private String result_key;

	EditText nombres;
	EditText apellidos;
	EditText edad;
	Spinner genero;
	EditText institucion;
	Spinner nivel;
	EditText items;

	TextView lbItems;
	TextView lbInstitucion;
	TextView lbNivel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_item_layout);
	}

	@Override
	protected void onStart() {
		super.onStart();
		verificarTipo();
		obtenerComponentes();
	}

	/**
	 * Check type, if is student or teacher
	 */
	private void verificarTipo() {
		Intent intent = getIntent();
		if (intent.hasExtra(tipo.DOCENTE.name())) {
			this.result_key = tipo.DOCENTE.name();
		} else if (intent.hasExtra(tipo.ESTUDIANTE.name())) {
			this.result_key = tipo.ESTUDIANTE.name();
		} else {
			finish();
		}
	}

	private void obtenerComponentes() {

		// For everything
		nombres = (EditText) findViewById(R.id.add_item_nombre);
		apellidos = (EditText) findViewById(R.id.add_item_apellido);
		edad = (EditText) findViewById(R.id.add_item_edad);
		genero = (Spinner) findViewById(R.id.add_item_genero);

		lbItems = (TextView) findViewById(R.id.add_label_items);
		lbInstitucion = (TextView) findViewById(R.id.add_label_institucion);
		lbNivel = (TextView) findViewById(R.id.add_label_nivel);

		institucion = (EditText) findViewById(R.id.add_item_institucion);
		nivel = (Spinner) findViewById(R.id.add_item_nivel);
		items = (EditText) findViewById(R.id.add_item_items);
		ArrayAdapter<CharSequence> nivelAdapter;

		if (tipo.DOCENTE.name().equals(result_key)) {
			// Set labels
			lbItems.setText("Materias");
			lbInstitucion.setText("Universidad");
			lbNivel.setText("Profesion");
			nivelAdapter = ArrayAdapter.createFromResource(this,
					R.array.profesion_array,
					android.R.layout.simple_spinner_item);
		} else {
			// Set labels
			lbItems.setText("Areas de interes");
			lbInstitucion.setText("Institucion");
			lbNivel.setText("Semestre");
			nivelAdapter = ArrayAdapter.createFromResource(this,
					R.array.semestres_array,
					android.R.layout.simple_spinner_item);
		}
		nivelAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		nivel.setAdapter(nivelAdapter);
	}

	public void guardarPersona(View view) {
		Persona person = new Persona(nombres.getText().toString(), apellidos
				.getText().toString(),
				Byte.parseByte(edad.getText().toString()), genero
						.getSelectedItem().toString(), institucion.getText()
						.toString(), nivel.getSelectedItem().toString(),
				lbItems.getText().toString());

		Intent intent = getIntent();

		intent.putExtra(result_key, person);
		setResult(RESULT_OK, intent);
		finish();
	}

	public void cancelarAdicion(View vew) {
		Intent intent = getIntent();

		intent.putExtra(result_key, "");
		setResult(RESULT_CANCELED, intent);
		finish();
	}
}

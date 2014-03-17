package co.edu.grupo2.clase5;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import co.edu.grupo2.clase5.adapter.PersonaAdapter;
import co.edu.grupo2.clase5.model.Docente;
import co.edu.grupo2.clase5.model.Estudiante;
import co.edu.grupo2.clase5.model.Persona;

public class MainActivity extends Activity {

	public static enum tipo {
		DOCENTE, ESTUDIANTE, EXTRA
	};

	List<Persona> listaEstudiantes = new ArrayList<Persona>();
	List<Persona> listaDocentes = new ArrayList<Persona>();
	ListView vistaListaEstudiantes;
	ListView vistaListaDocentes;

	public static final int ESTUDIANTE_KEY = 1;
	public static final int DOCENTE_KEY = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		obtenerComponentes();
	}

	private void obtenerComponentes() {
		vistaListaEstudiantes = (ListView) findViewById(R.id.layout_main_lista_estudiantes);
		vistaListaDocentes = (ListView) findViewById(R.id.layout_main_lista_docentes);
	}

	public void addEstudiante(View view) {
		showAddScreen(tipo.ESTUDIANTE);
	}

	public void addDocente(View view) {
		showAddScreen(tipo.DOCENTE);
	}

	private void showAddScreen(tipo t) {
		Intent intent = new Intent(getApplicationContext(),
				ScreenItemActivity.class);
		intent.putExtra(t.name(), t);
		startActivity(intent);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK) {
			Persona per = (Persona) data.getExtras().getSerializable(
					tipo.EXTRA.name());
			if (requestCode == ESTUDIANTE_KEY) {
				listaEstudiantes.add(new Estudiante(per));
				updateInfo(tipo.ESTUDIANTE);
				Toast.makeText(this, "Estudiante adicionado",
						Toast.LENGTH_SHORT).show();
			} else if (requestCode == DOCENTE_KEY) {
				listaDocentes.add(new Docente(per));
				updateInfo(tipo.DOCENTE);
				Toast.makeText(this, "Docente adicionado",
						Toast.LENGTH_SHORT).show();
			} else {
				listaDocentes.add(new Docente(per));
				updateInfo(tipo.DOCENTE);
				Toast.makeText(this, "Docente adicionado por omision!",
						Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(this, "Operacion cancelada",
					Toast.LENGTH_SHORT).show();
		}

	}

	private void updateInfo(tipo t) {

		if (tipo.DOCENTE.equals(t)) {
			PersonaAdapter adapterEstudiante = new PersonaAdapter(
					getApplicationContext(), R.layout.show_item_layout,
					listaDocentes);
			vistaListaDocentes.setAdapter(adapterEstudiante);
		} else if (tipo.ESTUDIANTE.equals(t)) {
			PersonaAdapter adapterEstudiante = new PersonaAdapter(
					getApplicationContext(), R.layout.show_item_layout,
					listaEstudiantes);
			vistaListaEstudiantes.setAdapter(adapterEstudiante);
		}

	}

}

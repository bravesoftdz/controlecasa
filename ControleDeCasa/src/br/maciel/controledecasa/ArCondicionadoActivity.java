package br.maciel.controledecasa;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ArCondicionadoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ar_condicionado);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ar_condicionado, menu);
		return true;
	}

}

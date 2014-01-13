package br.maciel.controledecasa;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.maciel.controledecasa.dao.DataBaseConnector;
import br.maciel.controledecasa.model.Configuracao;
import br.maciel.controledecasa.utils.Utils;

public class ConfiguracaoActivity extends Activity {

	private EditText edtUrl;
	private Button btnSalvar;
	private Button btnCancelar;
	
	private Configuracao conf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configuracao);
	
		edtUrl = (EditText) findViewById(R.id.edtUrl);
		btnSalvar = (Button) findViewById(R.id.btnSalvar);
		btnCancelar = (Button) findViewById(R.id.btnCancelar);
		
		conf = Utils.getConfiguracao(getBaseContext());
		
		edtUrl.setText(conf.getUrl());
		
		metodosBotoes();
		
	}
	
	public void metodosBotoes(){
		btnSalvar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				conf.setUrl(edtUrl.getText().toString().trim());
				DataBaseConnector.updateConfiguracao(conf);		
				conf = null;
				finish();
			}
		});
		
		btnCancelar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				conf = null;
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.configuracao, menu);
		return true;
	}

}

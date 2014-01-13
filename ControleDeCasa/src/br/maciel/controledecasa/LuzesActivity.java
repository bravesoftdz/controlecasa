package br.maciel.controledecasa;

import br.maciel.controledecasa.model.Configuracao;
import br.maciel.controledecasa.utils.ClienteHttpGet;
import br.maciel.controledecasa.utils.Utils;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ToggleButton;

public class LuzesActivity extends Activity {

	private ToggleButton tgbtnLampadaSala;
	private ToggleButton tgbtnLampadaCozinha;	
	private ToggleButton tgbtnLampadaHall;
	private ToggleButton tgbtnLampadaBanheiro;
	private ToggleButton tgbtnLampadaQuarto01;
	private ToggleButton tgbtnLampadaQuarto02;	
	private ClienteHttpGet clienteHttp;
	private Configuracao conf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.luzes);
		
		tgbtnLampadaSala = (ToggleButton) findViewById(R.id.tgbtnLampadaSala);
		tgbtnLampadaCozinha = (ToggleButton) findViewById(R.id.tgbtnLampadaCozinha);		
		tgbtnLampadaHall = (ToggleButton) findViewById(R.id.tgbtnLampadaHall);
		tgbtnLampadaBanheiro = (ToggleButton) findViewById(R.id.tgbtnLampadaBanheiro);
		tgbtnLampadaQuarto01 = (ToggleButton) findViewById(R.id.tgbtnLampadaQuarto01);
		tgbtnLampadaQuarto02 = (ToggleButton) findViewById(R.id.tgbtnLampadaQuarto02);
		
		conf = Utils.getConfiguracao(getBaseContext());
		
		metodosBotoes();
	}
	
	private void metodosBotoes() {
		
		/**
		 * 
		 */
		tgbtnLampadaSala.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaSala.isSelected()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMSALAOFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMSALAON");
				}
			}
		});
		
		/**
		 * 
		 */
		tgbtnLampadaCozinha.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaCozinha.isSelected()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMCOZOFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMCOZON");
				}
			}
		});
		
		/**
		 * 
		 */
		tgbtnLampadaHall.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaHall.isSelected()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMHALLOFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMHALLON");
				}
			}
		});
		
		/**
		 * 
		 */
		tgbtnLampadaBanheiro.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaBanheiro.isSelected()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMBANOFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMBANON");
				}
			}
		});
		
		/**
		 * 
		 */
		tgbtnLampadaQuarto01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaQuarto01.isSelected()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMQUA01OFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMQUA01ON");
				}
			}
		});
		
		/**
		 * 
		 */
		tgbtnLampadaQuarto02.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tgbtnLampadaQuarto02.isSelected()){
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMQUA02OFF");
				}else{
					clienteHttp =  new ClienteHttpGet(conf.getUrl() + "?CMD=LAMQUA02ON");
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.luzes, menu);
		return true;
	}

}

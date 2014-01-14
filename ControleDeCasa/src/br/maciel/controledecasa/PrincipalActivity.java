package br.maciel.controledecasa;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import br.maciel.controledecasa.dao.DataBaseConnector;
import br.maciel.controledecasa.model.Configuracao;
import br.maciel.controledecasa.utils.ClienteHttpGet;

public class PrincipalActivity extends Activity {

	protected static final int RESULT_SPEECH = 1;
	
	private Button btnComandoVoz;
	private Button btnLuzes;
	private Button btnConfiguracao;
	private Button btnTelevisao;
	private Button btnConsumoEnergia;
	private Button btnArCondicionado;
	private ClienteHttpGet clienteHttp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);

		btnComandoVoz = (Button) findViewById(R.id.btnComandoVoz);
		btnLuzes = (Button) findViewById(R.id.btnLuzes);		
		btnConfiguracao = (Button) findViewById(R.id.btnConfiguracao);
		btnTelevisao = (Button) findViewById(R.id.btnTelevisao);
		btnConsumoEnergia = (Button) findViewById(R.id.btnConsumo);
		btnArCondicionado = (Button) findViewById(R.id.btnArCondicionado);	

		metodosBotoes();
	}

	private void metodosBotoes() {

		/**
		 * M�todo do Bot�o de "Comando de Voz"
		 */
		btnComandoVoz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(
						RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "pt-BR");

				try {
					startActivityForResult(intent, RESULT_SPEECH);
				} catch (ActivityNotFoundException a) {
					Toast t = Toast.makeText(
									getApplicationContext(),
									"Ops! Seu dispositivo n�o suporta Comando por Voz.",
									Toast.LENGTH_SHORT);
					t.show();
				}
			}
		});
		
		/**
		 * M�todo para abrir um novo layout
		 */
		btnLuzes.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(PrincipalActivity.this, LuzesActivity.class);
				startActivity(i);
			}
		});
		
		/**
		 * M�todo para abrir um novo layout
		 */
		btnConfiguracao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(PrincipalActivity.this, ConfiguracaoActivity.class);
				startActivity(i);
			}
		});
		
		/**
		 * M�todo para abrir um novo layout
		 */
		btnTelevisao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(PrincipalActivity.this, TelevisaoActivity.class);
				startActivity(i);
			}
		});
		
		/**
		 * M�todo para abrir um novo layout
		 */
		btnArCondicionado.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(PrincipalActivity.this, ArCondicionadoActivity.class);
				startActivity(i);
			}
		});
		
		/**
		 * M�todo para abrir um novo layout
		 */
		btnConsumoEnergia.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(PrincipalActivity.this, ConsumoEnergiaActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		String comando = null;
		switch (requestCode) {
		case RESULT_SPEECH: {
			if (resultCode == RESULT_OK && null != data) {
				ArrayList<String> text = data
						.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
				comando = text.get(0);
				
				Toast.makeText(getApplicationContext(), comando, Toast.LENGTH_LONG).show();
				
				executarComandoVoz(comando);
			}
			break;
		}

		}
	}
	
	private void executarComandoVoz(String comando){		
		
		if (comando.equalsIgnoreCase("ligar l�mpada sala") || 
				comando.equalsIgnoreCase("ligar l�mpada da sala")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMSALAON");
		} else if (comando.equalsIgnoreCase("ligar l�mpada do quarto 1") ||
				comando.equalsIgnoreCase("ligar l�mpada quarto 1")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMQUA01ON");
		} else if (comando.equalsIgnoreCase("ligar l�mpada do quarto 2") ||
				comando.equalsIgnoreCase("ligar l�mpada quarto 2")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMQUA02ON");
		} else if (comando.equalsIgnoreCase("ligar l�mpada do rau") ||
				comando.equalsIgnoreCase("ligar l�mpada rau")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMHALLON");
		} else if (comando.equalsIgnoreCase("ligar l�mpada do banheiro") ||
				comando.equalsIgnoreCase("ligar l�mpada banheiro")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMBANON");
		} else if (comando.equalsIgnoreCase("ligar l�mpada da cozinha") ||
				comando.equalsIgnoreCase("ligar l�mpada cozinha")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMCOZON");
		} else if (comando.equalsIgnoreCase("desligar l�mpada sala") || 
				comando.equalsIgnoreCase("desligar l�mpada da sala")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMSALAOFF");
		} else if (comando.equalsIgnoreCase("desligar l�mpada do quarto 1") ||
				comando.equalsIgnoreCase("desligar l�mpada quarto 1")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMQUA01OFF");
		} else if (comando.equalsIgnoreCase("desligar l�mpada do quarto 2") ||
				comando.equalsIgnoreCase("desligar l�mpada quarto 2")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMQUA02OFF");
		} else if (comando.equalsIgnoreCase("desligar l�mpada do rau") ||
				comando.equalsIgnoreCase("desligar l�mpada rau")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMHALLOFF");
		} else if (comando.equalsIgnoreCase("desligar l�mpada do banheiro") ||
				comando.equalsIgnoreCase("desligar l�mpada banheiro")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMBANOFF");
		} else if (comando.equalsIgnoreCase("desligar l�mpada da cozinha") ||
				comando.equalsIgnoreCase("desligar l�mpada cozinha")){
			clienteHttp =  new ClienteHttpGet("http://192.168.0.155:8090/?CMD=LAMCOZOFF");
		} else {
			Toast.makeText(getApplicationContext(), "Comando n�o reconhecido", Toast.LENGTH_LONG).show();
		}
	}

}

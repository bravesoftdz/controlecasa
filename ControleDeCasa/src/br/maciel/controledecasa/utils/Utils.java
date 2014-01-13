package br.maciel.controledecasa.utils;

import android.content.Context;
import android.database.Cursor;
import br.maciel.controledecasa.dao.DataBaseConnector;
import br.maciel.controledecasa.model.Configuracao;

public class Utils {	
	
	public static Configuracao getConfiguracao(Context contexto){
		DataBaseConnector dataBaseConnector;
		
		Configuracao configuracao;
		//Seta o contexto no conector
		dataBaseConnector = new DataBaseConnector(contexto);
		//Abre a conexao
		dataBaseConnector.open();
		//o cursor recebe a configuracao
		Cursor cursor = dataBaseConnector.getConfiguracao();
		//move o cursor para o inicio
		cursor.moveToPosition(0);
		//seta o objeto com as informcoes do cursor
		configuracao = new Configuracao(cursor.getInt(0),
				cursor.getString(1));
		
		return configuracao;
	}
}

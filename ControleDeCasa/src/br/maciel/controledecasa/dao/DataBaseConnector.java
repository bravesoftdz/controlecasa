package br.maciel.controledecasa.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.maciel.controledecasa.model.Configuracao;


public class DataBaseConnector {

	private static final String DATABASE_NAME = "dbcontrolecasa";
	private static final String TABLE_TELEVISAO = "tbtelevisao";
	private static final String TABLE_ARCONDICIONADO = "tbarcondicionado";
	private static final String TABLE_CONSUMOENERGIA = "tbconsumoenergia";
	private static final String TABLE_COMANDOVOZ = "tbcomandovoz";
	private static final String TABLE_CONFIGURACAO = "tbconfiguracao";

	private static SQLiteDatabase dataBase;
	private static DatabaseOpenHelper databaseOpenHelper;

	// Construtor publico
	public DataBaseConnector(Context context) {
		// cria um novo databaseOpenHelper
		databaseOpenHelper = new DatabaseOpenHelper(context, DATABASE_NAME,
				null, 1);
	}

	public static void open() {
		// cria ou abre um banco de dados
		dataBase = databaseOpenHelper.getWritableDatabase();
		// dataBase.beginTransaction();
	}

	public static void close() {
		if (dataBase != null) {
			dataBase.close();
		}
	}

	public void insertConfiguracao(Configuracao conf) {
		ContentValues newConf = new ContentValues();

		newConf.put("url", conf.getUrl());

		open();
		dataBase.insert(TABLE_CONFIGURACAO, null, newConf);
		close();
	}

	public static void updateConfiguracao(Configuracao conf) {
		ContentValues editConf = new ContentValues();
		int id = conf.getId();

		editConf.put("pkconfiguracao", conf.getId());
		editConf.put("url", conf.getUrl());

		open();
		dataBase.update(TABLE_CONFIGURACAO, editConf, "pkconfiguracao=" + id,
				null);
		close();
	}

	public Cursor getConfiguracao() {
		return dataBase
				.query(TABLE_CONFIGURACAO, new String[] { "pkconfiguracao",
						"url" }, null, null, null, null,
						"pkconfiguracao");
	}

	public Cursor getOneConfiguracao(int id) {
		return dataBase.query(TABLE_CONFIGURACAO, null, "pkconfiguracao=" + id,
				null, null, null, null);
	}

	public void deleteConfiguracao(int id) {
		open();
		dataBase.delete(TABLE_CONFIGURACAO, "pkconfiguracao=" + id, null);
		close();
	}
}

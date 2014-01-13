package br.maciel.controledecasa.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

	// DDLs das tabelas para criação em formado de constantes
	private static final String CREATE_TABLE_CONFIGURACAO = "CREATE TABLE TBCONFIGURACAO "
			+ " ( pkconfiguracao INTEGER PRIMARY KEY, " + " url TEXT);";
	private static final String INSERT_PADRAO_CONFIGURACAO = "INSERT INTO TBCONFIGURACAO (URL) "
			+ " VALUES ('http://192.168.0.155:8090/')";

	public DatabaseOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_CONFIGURACAO);
		db.execSQL(INSERT_PADRAO_CONFIGURACAO);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}

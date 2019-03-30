package com.dpefz.reporteapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DadosOpenHelper extends SQLiteOpenHelper {

	public DadosOpenHelper(Context context) {
		super(context, "reportappBD", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) { // será o local onde se irá criar as tabelas da base de dados
		db.execSQL(ScriptDLL.getCreateTableReports());
		db.execSQL(ScriptDLL.getCreateTableFuncionario()); //metodos criados na classe scriptdll
		db.execSQL(ScriptDLL.getCreateTableUsuario());
		

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {// local onde irá se realizar
																				// actualizações da base dados
		// TODO Auto-generated method stub

	}

}

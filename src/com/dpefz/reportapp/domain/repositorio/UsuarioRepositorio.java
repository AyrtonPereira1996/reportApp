package com.dpefz.reportapp.domain.repositorio;

import com.dpefz.reportapp.domain.Usuario;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioRepositorio {
	private SQLiteDatabase conexao;
	
	public UsuarioRepositorio(SQLiteDatabase conexao) {
		this.conexao=conexao;
	}
	
	public void inserirUsuario(Usuario usuario) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("codigoFuncionario", usuario.codigoFuncionario);
		contentValues.put("usuario", usuario.usuario);
		contentValues.put("senha", usuario.usuario);
		
		conexao.insert("login", null, contentValues);
		
	}
	
}

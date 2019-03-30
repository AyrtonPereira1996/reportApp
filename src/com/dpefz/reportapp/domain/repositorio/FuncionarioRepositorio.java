package com.dpefz.reportapp.domain.repositorio;

import com.dpefz.reportapp.domain.Funcionario;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class FuncionarioRepositorio {
	private SQLiteDatabase conexao;
	
	public FuncionarioRepositorio(SQLiteDatabase conexao) {
		this.conexao = conexao;
	}
	
	public void inserirFuncionario(Funcionario funcionario) {
		ContentValues contentValues= new ContentValues();
		contentValues.put("codigoFuncionario", funcionario.codigoFuncionario );
		contentValues.put("nomeFuncionario", funcionario.nomeFuncionario);
		contentValues.put("apelidoFuncionario", funcionario.apelidoFuncionario);
		contentValues.put("departamento", funcionario.departamento);
		contentValues.put("reparticao", funcionario.reparticao);
		contentValues.put("cargo", funcionario.cargo);
		contentValues.put("carreira", funcionario.carreira);
		contentValues.put("dataRegisto", funcionario.dataregisto);
		
		conexao.insertOrThrow("funcionario", null, contentValues);
		
	}
		
	}
	


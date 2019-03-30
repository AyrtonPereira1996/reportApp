package com.dpefz.reportapp.domain.repositorio;

import com.dpefz.reportapp.domain.Report;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class ReportRepositorio {

	private SQLiteDatabase conexao;

	public ReportRepositorio(SQLiteDatabase conexao) {
		this.conexao = conexao;
	}

	public void inserirReport(Report report) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("descricaoReport", report.descricao);
		contentValues.put("nomeFuncionario", report.nomeFuncionario);
		contentValues.put("apelidoFuncionario", report.apelidoFuncionario);
		contentValues.put("departamento", report.departamento);
		contentValues.put("data", report.data);
		contentValues.put("hora", report.hora);
		contentValues.put("piso", report.piso);

		conexao.insertOrThrow("reports", null, contentValues);

	}

}

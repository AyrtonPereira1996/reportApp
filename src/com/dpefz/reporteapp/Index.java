package com.dpefz.reporteapp;

import com.dpefz.reporteapp.database.DadosOpenHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Index extends Activity {
	private ImageButton btnLogin, btnInfo;
	
	DadosOpenHelper dadosOpenHelper;
	SQLiteDatabase conexao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		
		btnLogin = (ImageButton) findViewById(R.id.btnLogin);
		btnInfo = (ImageButton) findViewById(R.id.btnInfo);
		
		autenticacao();
		abrirInfo();
		criarConexao();
		}
	
	private void autenticacao() {
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Index.this, Login.class);
				startActivity(intent);
			}
		});
	}
	
	private void abrirInfo() {
		btnInfo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Index.this, Info.class);
				startActivity(intent);
			}
		});
	}
	
	private void criarConexao() {
		try {
			dadosOpenHelper = new DadosOpenHelper(this);
			conexao = dadosOpenHelper.getWritableDatabase();
			Toast.makeText(getApplicationContext(), "Conectado!", Toast.LENGTH_SHORT).show();
		} catch (SQLException ex) {
			AlertDialog.Builder dlg = new AlertDialog.Builder(this);
			dlg.setTitle("Erro!");
			dlg.setMessage(ex.getMessage());
			dlg.setNeutralButton("OK", null);
			dlg.show();
		}
		
		
	}
	
	
}

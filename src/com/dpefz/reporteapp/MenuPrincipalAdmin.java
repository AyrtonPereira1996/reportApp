package com.dpefz.reporteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuPrincipalAdmin extends Activity {
	Button btnRegFuncionario, btnRegUsuario, btnConsultarReports, btnConsultarFuncionarios, btnConsultarUserAcesso;
	ImageButton btnVoltar2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuprincipaladmin);
		btnRegFuncionario = (Button) findViewById(R.id.btnRegFun);
		btnRegUsuario = (Button) findViewById(R.id.btnRegUsuario);
		btnVoltar2 = (ImageButton) findViewById(R.id.btnVoltar2);
		btnConsultarUserAcesso = (Button) findViewById(R.id.btnConsultarUserAcesso);
		btnConsultarFuncionarios = (Button) findViewById(R.id.btnConsultarFuncionarios);
		btnConsultarReports = (Button) findViewById(R.id.btnConsultarReports);

		irRegFun();
		irRegUser();
		abrirIndex();
		irConFun();
		irConReport();
		irConUsua();
	}

	private void irRegFun() {
		btnRegFuncionario.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuPrincipalAdmin.this, RegFuncionario.class);
				startActivity(intent);
			}
		});
	}

	private void irRegUser() {
		btnRegUsuario.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuPrincipalAdmin.this, UsuarioForm.class);
				startActivity(intent);

			}
		});
	}

	private void irConFun() {
		btnConsultarFuncionarios.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuPrincipalAdmin.this, Funcionarios.class);
				startActivity(intent);
			}
		});

	}

	private void irConUsua() {
		btnConsultarUserAcesso.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuPrincipalAdmin.this, ContAcesso.class);
				startActivity(intent);
				
			}
		});
	}

	private void irConReport() {
		btnConsultarReports.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuPrincipalAdmin.this, Reports.class);
				startActivity(intent);
			}
		});
	}

	private void abrirIndex() {
		btnVoltar2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_principal_admin, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

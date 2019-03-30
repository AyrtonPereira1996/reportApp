package com.dpefz.reporteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Login extends Activity {
	Button btnEntrar, btnSair;
	EditText txtUsuario, txtSenha;
	ImageButton btnVoltar3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		txtUsuario = (EditText) findViewById(R.id.txtUsuario);
		txtSenha = (EditText) findViewById(R.id.txtSenha);
		btnEntrar = (Button) findViewById(R.id.btnEntrar);
		btnVoltar3 = (ImageButton) findViewById(R.id.btnVoltar4);

		logar();
		voltarIndex();
	}

	private void logar() {
		btnEntrar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String usuario = txtUsuario.getText().toString();
				String senha = txtSenha.getText().toString();

				if (usuario.equals("admin") && senha.equals("admin")) {
					Intent intent = new Intent(Login.this, MenuPrincipalAdmin.class);
					startActivity(intent);
					Toast.makeText(getApplicationContext(), "Login efectuado com sucesso! Bem-vindo admin",
							Toast.LENGTH_SHORT).show();

				} else if (usuario.equals("funcionario") && senha.equals("funcionario")) {
					Intent intent = new Intent(Login.this, MenuPrincipal.class);
					startActivity(intent);
					Toast.makeText(getApplicationContext(), "Login efectuado com sucesso! Bem-vindo funcionário",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Nome de usuário ou senha errados! Por favor volte a preecher correctamente",
							Toast.LENGTH_SHORT).show();
				}

			}
		});
	}

	private void voltarIndex() {
		btnVoltar3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}
		});

	}
}

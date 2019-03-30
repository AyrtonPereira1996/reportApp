package com.dpefz.reporteapp;

import com.dpefz.reportapp.domain.Usuario;
import com.dpefz.reportapp.domain.repositorio.UsuarioRepositorio;
import com.dpefz.reporteapp.database.DadosOpenHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class UsuarioForm extends Activity {
	EditText txtCodFunc, txtNomeUsuario, txtPass;
	Button btnRegistaUser;

	DadosOpenHelper dadosOpenHelper;
	SQLiteDatabase conexao;
	Usuario usuario;
	UsuarioRepositorio usuarioRepositorio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.usuarioform);
		txtCodFunc = (EditText) findViewById(R.id.txtCodFunc);
		txtNomeUsuario = (EditText) findViewById(R.id.txtNomeUsuario);
		txtPass = (EditText) findViewById(R.id.txtPass);
		
		btnRegistaUser = (Button) findViewById(R.id.btnRegistaUser);

		criarConexao();
		registar();
		confirmar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.usuario_form, menu);
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

	private void criarConexao() {
		try {
			dadosOpenHelper = new DadosOpenHelper(this);
			conexao = dadosOpenHelper.getWritableDatabase();
			Toast.makeText(getApplicationContext(), "Pronto para o registo!", Toast.LENGTH_SHORT).show();
			usuarioRepositorio = new UsuarioRepositorio(conexao);
		} catch (SQLException ex) {
			AlertDialog.Builder dlg = new AlertDialog.Builder(this);
			dlg.setTitle("Aviso!");
			dlg.setMessage(ex.getMessage());
			dlg.setNeutralButton("OK", null);
			dlg.show();

		}

	}

	private boolean isCampoVazio(String valor) {
		boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
		return resultado;
	}

	private boolean validaCampos() {
		boolean res = false;

		String codigo = txtCodFunc.getText().toString();
		String nomeUsuario = txtNomeUsuario.getText().toString();
		String senha = txtPass.getText().toString();

		usuario.codigoFuncionario = codigo;
		usuario.usuario = nomeUsuario;
		usuario.senha = senha;

		if (res = isCampoVazio(codigo)) {
			txtCodFunc.requestFocus();
		} else if (res = isCampoVazio(nomeUsuario)) {
			txtNomeUsuario.requestFocus();
		} else if (res = isCampoVazio(senha)) {
			txtPass.requestFocus();
		}

		if (res) {
			AlertDialog.Builder dlg = new AlertDialog.Builder(this);
			dlg.setTitle("Aviso");
			dlg.setMessage("Há campos vázios. Preencha por favor!");
			dlg.setNeutralButton("Ok", null);
			dlg.show();
		}
		return res;
	}

	private void confirmar() {
		usuario = new Usuario();
		if (validaCampos() == false) {
			try {
				usuarioRepositorio.inserirUsuario(usuario);
				Toast.makeText(getApplicationContext(), "Registado com sucesso!", Toast.LENGTH_SHORT).show();
				finish();
			} catch (SQLException ex) {
				AlertDialog.Builder dlg = new AlertDialog.Builder(this);
				dlg.setTitle("Erro");
				dlg.setMessage(ex.getMessage());
				dlg.setNeutralButton("Ok", null);
				dlg.show();
			}

		}
	}
	
	private void registar() {
		btnRegistaUser.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				confirmar();
				
			}
		});
	}
}

package com.dpefz.reporteapp;

import com.dpefz.reportapp.domain.Funcionario;
import com.dpefz.reportapp.domain.repositorio.FuncionarioRepositorio;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegFuncionario extends Activity {
	EditText txtCodigoReg, txtDepartamentoReg, txtNomeReg, txtApelidoReg, txtDataRegisto, txtReparticaoReg, txtCargoReg,
			txtCarreira;
	Button btnRegistaFun;

	DadosOpenHelper dadosOpenHelper;
	SQLiteDatabase conexao;
	Funcionario funcionario;
	FuncionarioRepositorio funcionarioRepositorio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formfuncionario);
		txtCodigoReg = (EditText) findViewById(R.id.txtCodigoReg);
		txtNomeReg = (EditText) findViewById(R.id.txtNomeReg);
		txtApelidoReg = (EditText) findViewById(R.id.txtApelidoReg);
		txtReparticaoReg = (EditText) findViewById(R.id.txtReparticaoReg);
		txtDepartamentoReg = (EditText) findViewById(R.id.txtDepartamentoReg);
		txtCargoReg = (EditText) findViewById(R.id.txtCargoReg);
		txtCarreira = (EditText) findViewById(R.id.txtCarreira);
		txtDataRegisto = (EditText) findViewById(R.id.txtDataRegisto);
		btnRegistaFun = (Button) findViewById(R.id.btnRegistaFun);

		criarConexao();
		confirmar();
		registar();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reg_funcionario, menu);
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
			funcionarioRepositorio = new FuncionarioRepositorio(conexao);
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

		String codigo = txtCodigoReg.getText().toString();
		String nome = txtNomeReg.getText().toString();
		String apelido = txtApelidoReg.getText().toString();
		String departamento = txtDepartamentoReg.getText().toString();
		String reparticao = txtReparticaoReg.getText().toString();
		String cargo = txtCargoReg.getText().toString();
		String carreira = txtCarreira.getText().toString();
		String dataRegisto = txtDataRegisto.getText().toString();

		funcionario.codigoFuncionario = codigo;
		funcionario.nomeFuncionario = nome;
		funcionario.apelidoFuncionario = apelido;
		funcionario.departamento = departamento;
		funcionario.reparticao = reparticao;
		funcionario.cargo = cargo;
		funcionario.carreira = carreira;
		funcionario.dataregisto = dataRegisto;

		if (res = isCampoVazio(codigo)) {
			txtCodigoReg.requestFocus();
		} else if (res = isCampoVazio(nome)) {
			txtNomeReg.requestFocus();
		} else if (res = isCampoVazio(apelido)) {
			txtApelidoReg.requestFocus();
		} else if (res = isCampoVazio(departamento)) {
			txtDepartamentoReg.requestFocus();
		} else if (res = isCampoVazio(reparticao)) {
			txtReparticaoReg.requestFocus();
		} else if (res = isCampoVazio(cargo)) {
			txtCargoReg.requestFocus();
		} else if (res = isCampoVazio(carreira)) {
			txtCarreira.requestFocus();
		} else if (res = isCampoVazio(dataRegisto)) {
			txtDataRegisto.requestFocus();
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
		funcionario = new Funcionario();

		if (validaCampos() == false) {
			try {
				funcionarioRepositorio.inserirFuncionario(funcionario);
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
		btnRegistaFun.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				confirmar();

			}
		});
	}

}

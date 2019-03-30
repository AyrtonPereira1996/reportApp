package com.dpefz.reporteapp;

import com.dpefz.reportapp.domain.Report;
import com.dpefz.reportapp.domain.repositorio.ReportRepositorio;
import com.dpefz.reporteapp.database.DadosOpenHelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class ReportActivity extends Activity {
	private Button btnReportar;
	private EditText txtHora, txtData, txtNome, txtApelido, txtDepartamento, txtPiso, txtProblema;
	private ImageButton btnVoltar;

	private ReportRepositorio reportRepositorio;
	private SQLiteDatabase conexao;
	private DadosOpenHelper dadosOpenHelper;
	private Report report;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reportform);
		txtHora = (EditText) findViewById(R.id.txtHora);
		txtData = (EditText) findViewById(R.id.txtData);
		txtNome = (EditText) findViewById(R.id.txtNome);
		txtApelido = (EditText) findViewById(R.id.txtApelido);
		txtDepartamento = (EditText) findViewById(R.id.txtDepartamento);
		txtPiso = (EditText) findViewById(R.id.txtPiso);
		txtProblema = (EditText) findViewById(R.id.txtProblema);
		btnReportar = (Button) findViewById(R.id.btnReportar);
		btnVoltar = (ImageButton) findViewById(R.id.btnVoltar);

		voltarMenu();
		criarConexao();
		report();
		confirmar();

	}

	private void criarConexao() {
		try {
			dadosOpenHelper = new DadosOpenHelper(this);
			conexao = dadosOpenHelper.getWritableDatabase();
			Toast.makeText(getApplicationContext(), "Pronto para o registo!", Toast.LENGTH_SHORT).show();
			reportRepositorio = new ReportRepositorio(conexao);

		} catch (SQLException ex) {
			AlertDialog.Builder dlg = new AlertDialog.Builder(this);
			dlg.setTitle("Aviso!");
			dlg.setMessage(ex.getMessage());
			dlg.setNeutralButton("Ok", null);
			dlg.show();
		}
	}

	private void confirmar() {
		report = new Report();
		if (validaCampos() == false) {
			try {
				reportRepositorio.inserirReport(report);
				Toast.makeText(getApplicationContext(), "Reportado com sucesso!", Toast.LENGTH_SHORT).show();
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

	private void report() {
		btnReportar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				confirmar();

			}
		});
	}

	private boolean validaCampos() {

		boolean res = false;

		String nome = txtNome.getText().toString();
		String apelido = txtApelido.getText().toString();
		String departamento = txtDepartamento.getText().toString();
		String piso = txtPiso.getText().toString();
		String problema = txtProblema.getText().toString();
		String hora = txtHora.getText().toString();
		String data = txtData.getText().toString();

		report.nomeFuncionario = nome;
		report.apelidoFuncionario = apelido;
		report.departamento = departamento;
		report.piso = piso;
		report.problema = problema;
		report.data = data;
		report.hora = hora;

		if (res = isCampoVazio(nome)) {
			txtNome.requestFocus();
		} else

		if (res = isCampoVazio(apelido)) {
			txtApelido.requestFocus();
		} else

		if (res = isCampoVazio(departamento)) {
			txtDepartamento.requestFocus();
		} else

		if (res = isCampoVazio(piso)) {
			txtPiso.requestFocus();
		} else

		if (res = isCampoVazio(problema)) {
			txtProblema.requestFocus();
		}

		if (res) {
			AlertDialog.Builder dlg = new AlertDialog.Builder(this);
			dlg.setTitle("Aviso!");
			dlg.setMessage("Há campos vázios. Preencha por favor!");
			dlg.setNeutralButton("Ok", null);
			dlg.show();
		}

		return res;
	}

	private boolean isCampoVazio(String valor) {
		boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty()); // ira retornar mesmo que tenha dados
																					// espaco
		return resultado;

	};

	private void voltarMenu() {
		btnVoltar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report_form, menu);
		return true;
	}

}

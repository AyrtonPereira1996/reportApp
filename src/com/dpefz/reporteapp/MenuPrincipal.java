package com.dpefz.reporteapp;

import android.app.Activity; 
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*; //vais ter que importar estes pacotes

public class MenuPrincipal extends Activity { 
	
	Button btnReport; 
	ImageButton btnSair;
	
	@Override                                                 
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menuprincipalfuncionario); 
		
		
		btnReport = (Button) findViewById(R.id.btnReport); 
		abrirReport();  
															
		btnSair = (ImageButton) findViewById(R.id.btnSair);
		abrirIndex();
		
		
		
	}
	
	private void abrirReport() {  
		btnReport.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuPrincipal.this, ReportActivity.class); 
				startActivity(intent);                                                    
			}																		      
		});																				  
		}
	
	private void abrirIndex() {
		btnSair.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}

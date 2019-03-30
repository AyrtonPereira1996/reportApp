package com.dpefz.reporteapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Info extends Activity {
	ImageButton btnVoltar4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);
		
		btnVoltar4 = (ImageButton) findViewById(R.id.btnVoltar4);
		
		voltarIndex();
	}
	
	private void voltarIndex() {
		btnVoltar4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
				Toast.makeText(getApplicationContext(), "Bem vindo!", Toast.LENGTH_SHORT).show();
			}
		});
	
			
	}
}

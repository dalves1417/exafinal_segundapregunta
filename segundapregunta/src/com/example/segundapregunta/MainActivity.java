package com.example.segundapregunta;

import com.example.segundapregunta.AdminSQLite;
import com.example.segundapregunta.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText valor1;
	private EditText valor2;
	private EditText valor3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor1=(EditText)findViewById(R.id.editText1);
        valor2=(EditText)findViewById(R.id.editText2);
        valor3=(EditText)findViewById(R.id.editText3);
    }
    public void guardar(View view){
    	AdminSQLite adminsql = new AdminSQLite(this, "administrador", null, 1);
    	
    	SQLiteDatabase bdtrabajadores =adminsql.getWritableDatabase();
    	
    	String valor1_tempo1 = valor1.getText().toString();
    	String valor2_tempo2 = valor2.getText().toString();
    	String valor3_tempo3 = valor3.getText().toString();
    	
    	ContentValues formulario =  new ContentValues();
    	formulario.put("nombre",valor1_tempo1);
    	formulario.put("apellidos",valor2_tempo2);
    	formulario.put("edad",valor3_tempo3);
    	
    	try {
    		bdtrabajadores.insert("empleado",null,formulario);
    		Toast.makeText(this, "PERSONAL GUARDADO", Toast.LENGTH_LONG).show();
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(this, "error"+e.getMessage(), Toast.LENGTH_LONG).show();
		}
    }
    public void clear (View view){
    	valor1.setText("  ");
    	valor2.setText("  ");
    	valor3.setText("  ");
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

package com.example.segundapregunta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLite extends SQLiteOpenHelper {

	public AdminSQLite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase bdtrabajadores) {
		// TODO Auto-generated method stub
		bdtrabajadores.execSQL("CREATE  table empleado(nombre integer primary key,apellidos text,edad int)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase bdtrabajadores, int versionantigua, int versionnueva) {
		// TODO Auto-generated method stub
		bdtrabajadores.execSQL("selec * from empleado");
		bdtrabajadores.execSQL("update set");
		bdtrabajadores.execSQL("drop table if exists empleado");
		bdtrabajadores.execSQL("CREATE  table empleado(nombre integer primary key, nombre text,apellidos text,edad int)");
	}

}

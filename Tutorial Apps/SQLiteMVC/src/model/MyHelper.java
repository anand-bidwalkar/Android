package model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyHelper extends SQLiteOpenHelper {

	public static final int VERSION=1;
	public static final String DBNAME="StudDB";
	public static final String tblStudent="Student";
	
	Context ctx;
	public MyHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		ctx=context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("create table "+tblStudent+" (rno Integer, name text, fees real )");
		//db.execSQL("insert into "+tblStudent + " values(101, 'Jai', 7890)");
		
		Toast.makeText(ctx, "onCreate", 5).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Toast.makeText(ctx, "onUpgrade", 5).show();
	}
	
}

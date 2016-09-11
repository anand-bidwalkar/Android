package controller;

import java.util.ArrayList;

import model.MyHelper;
import model.Student;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StudentManager {
	Context context;
	MyHelper helper;
	

	public StudentManager(Context context) {
		super();
		this.context = context;
		helper=new MyHelper(context, MyHelper.DBNAME, null, MyHelper.VERSION);	
	}
	
	public void editStudent(Student s) {
		SQLiteDatabase db =  helper.getWritableDatabase();
		
		//db.execSQL("update student set name='"+s.getName()+"', fees="+s.getFees()+" where rno = "+s.getRno());
		
		ContentValues cv = new ContentValues();
		cv.put("name", s.getName());
		cv.put("fees", s.getFees());
		
		db.update(MyHelper.tblStudent, cv, "rno=?", new String[]{s.getRno()+""});
	}
	
	
	public void newStudent(Student s) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		
		
		ContentValues cv = new ContentValues();
		cv.put("rno", s.getRno());
		cv.put("name", s.getName());
		cv.put("fees", s.getFees());
		
		db.insert(MyHelper.tblStudent, null, cv);
		db.close();		
	}
	
	public ArrayList<Student> getStudents() {
		ArrayList<Student> slist=new ArrayList<Student>();
		
		//code to retreive data from table
		SQLiteDatabase db = helper.getReadableDatabase();
		
		Cursor cr = db.rawQuery("select * from "+MyHelper.tblStudent, null);
		
		while(cr.moveToNext())
		{
			int rno = cr.getInt(0);
			String name = cr.getString(1);
			float fees = cr.getFloat(2);
			
			Student s = new Student(rno, name, fees);
			slist.add(s);
		}
		
		db.close();
		
		return slist;
	}
	
}

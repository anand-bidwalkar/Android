package com.example.sqlitemvc;

import java.util.ArrayList;

import model.Student;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import controller.StudentManager;

public class StudentList extends ListActivity {
	ListView lv;
	ArrayAdapter<Student> adap;
	ArrayList<Student> slist;
	EditText editRno,editName,editFees;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		lv=getListView();
		
		slist=new ArrayList<Student>();
		
		registerForContextMenu(lv);
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		StudentManager sm = new StudentManager(this);
		slist = sm.getStudents();
		
		adap=new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1,slist);
		lv.setAdapter(adap);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("New Student").setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent in =new Intent(StudentList.this, MainActivity.class);
				startActivity(in);
				return false;
			}
		});
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		
		MenuItem mnuView =  menu.add("View");
		MenuItem mnuEdit = menu.add("Edit");
		MenuItem mnuDelete = menu.add("Delete");
		
		
		mnuView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		
		mnuEdit.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				
				AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
				Student s = slist.get(info.position);
				
				AlertDialog.Builder build = new Builder(StudentList.this);
				build.setTitle("Edit Student");
				build.setIcon(R.drawable.ic_launcher);
				
				LayoutInflater linf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
				View v = linf.inflate(R.layout.activity_main, null);
				
				editRno = (EditText) v.findViewById(R.id.editRno);
				editName = (EditText) v.findViewById(R.id.editName);
				editFees = (EditText) v.findViewById(R.id.editFees);
				Button btnSave = (Button) v.findViewById(R.id.btnSave);
				
				editRno.setText(s.getRno()+"");
				editName.setText(s.getName());
				editFees.setText(s.getFees()+"");
				
				build.setView(v);
				
				final AlertDialog dialog= build.create();
				dialog.show();
				
				btnSave.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						
						int rno = Integer.parseInt(editRno.getText().toString());
						String name = editName.getText().toString();
						float fees = Float.parseFloat(editFees.getText().toString());
						
						Student s = new Student(rno, name, fees);
						
						StudentManager sm = new StudentManager(StudentList.this);
						sm.editStudent(s);
						
						Toast.makeText(StudentList.this, "Record updated", 5).show();
						
						slist=sm.getStudents();
						adap=new ArrayAdapter<Student>(StudentList.this, android.R.layout.simple_list_item_1,slist);
						lv.setAdapter(adap);
						
						
						dialog.cancel();
						
						
						
						
						
					}
				});
				
				
				
				
				
				
				
				return false;
			}
		});
		
		mnuDelete.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		super.onCreateContextMenu(menu, v, menuInfo);
	}
}

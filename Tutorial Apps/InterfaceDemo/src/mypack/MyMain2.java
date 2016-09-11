package mypack;

import java.util.Scanner;

public class MyMain2 {

	public static void main(String[] args) 
	{
		
		
		
		/*//bm.show();
		//bm.calcTax();
		
		Person p=bm;
		p.show();
		
		Tax t=bm;
		t.calcTax();
		*/
		BusinessMan bm=new BusinessMan();
		bm.name="Atul";
		bm.age=35;
		bm.shopName="Raj bookstore";
		bm.income=120000;
		
		Employee emp=new Employee();
		emp.name="Priya";
		emp.salary=5600;
	
		System.out.println("Enter choice to calc tax:");
		System.out.println("1 Employee");
		System.out.println("2 Businessman");
		
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		
		if(ch==1)
			showTax(emp);
		
		if(ch==2)
			showTax(bm);
		
		
		
		
	}
	
	static void showTax(Tax t)
	{
		t.calcTax();
	}
}

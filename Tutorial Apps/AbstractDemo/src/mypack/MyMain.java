package mypack;

public class MyMain 
{
  public static void main(String[] args) 
  {
	 Employee emp=null;
	 
	 PartTime pt=new PartTime();
	 pt.name="Amit";
	 pt.hours=30;
	
	 
	 FullTime ft=new FullTime();
	 ft.name="Priya";
	 ft.basic=4000;
	 ft.pf=8;
	 
	 printEmployee(ft);
	 
  }
  static void printEmployee(Employee e)
  {
	  e.calcSalary();
		 e.show();
  }
}

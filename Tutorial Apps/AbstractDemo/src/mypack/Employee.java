package mypack;

public abstract class Employee 
{
  String name;
  float salary;
  void show()
  {
	  System.out.println(name+":"+salary);
  }
abstract  void calcSalary();
  
}

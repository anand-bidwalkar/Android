package mypack;

public class Person
{
  String name;
  int age;
  Person()
  {	  
  }
  Person(String n, int a)
  {
	  name=n;
	  age=a;
  }
  
  void show()
  {
	  System.out.println(name+":"+age);	
  }
  boolean isVoter()
  {
	  if(age>=18)
		  return true;
	  else
		  return false;
  }
}

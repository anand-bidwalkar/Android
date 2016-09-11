package mypack;

public class Employee extends Person  implements Tax
{
   float salary;
   public void calcTax()
   {
	   float t=salary*10/100;
	   System.out.println("tax is :"+t);
   }
 
}

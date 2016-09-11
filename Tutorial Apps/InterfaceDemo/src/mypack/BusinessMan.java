package mypack;

public class BusinessMan extends Person implements Tax
{
	float income;
	String shopName;
	public void calcTax()
	   {
		   float t=income*12.5f/100;
		   System.out.println("tax is :"+t);
	   }
	

}

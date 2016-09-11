package mypack;

public class MyMain 
{
   public static void main(String[] args) 
   {
	 Employee emp=new Employee();
	 emp.name="Amit";
	 emp.salary=12000;
	 emp.calcTax();
	 
	 BusinessMan bm=new BusinessMan();
	 bm.name="Rajesh";
	 bm.shopName="Raj electricals";
	 bm.income=340000;
	 bm.calcTax();
	 
	 
	 
}
}

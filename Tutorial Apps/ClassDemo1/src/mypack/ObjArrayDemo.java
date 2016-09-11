package mypack;

public class ObjArrayDemo 
{
   public static void main(String[] args) 
   {
	
	   Person p1=new Person("Amit",34);
	   Person p2=new Person("Priya",15);
	   Person p3=new Person("Rahul",25);
	   
	   p1.show();
	   p2.show();
	   p2.show();
	   ///altername;
	   
	   int ar[]=new int[5];
	   // array of person class references
	   Person par[]=new Person[5];
	   //initialize
	   par[0]=new Person("Ram",21);
	   par[1]=new Person("Atul",44);
	   par[2]=new Person("Som",17);
	   par[3]=new Person("Megha",12);
	   par[4]=new Person("Rakhi",24);
	   
	   //print array object
	   for(int k=0;k<par.length;k++)
	   {
		   par[k].show();
	   }
	   //count how many are voters;
	   int voters=0;
	   for(int j=0;j<par.length;j++)
	   {
		   boolean r= par[j].isVoter();
		   if(r==true)
			   voters++;
	   }
	   System.out.println("Total voters are:"+voters);
	   
  }
}

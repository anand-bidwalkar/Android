package mypack;

public class MyMain2 
{
  public static void main(String[] args) 
  
  {
       Person p1=new Person();       
       Person p2=p1;
       
       Student s1=new Student();
       Person p3=s1;
       
      s1.name="Rahul";
      s1.age=12;
      s1.marks=456;
      s1.show();
      s1.printPercent();
      
      p3.name="Megha";
      p3.age=14;
      p3.show();
     // p3.marks=356;
      //p3.printPercent();
      
      
      
      
       
       
 }
}

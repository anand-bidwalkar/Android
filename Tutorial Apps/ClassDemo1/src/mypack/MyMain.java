package mypack;

public class MyMain 
{
 public static void main(String[] args) 
 {
     Person p1=new Person();
     p1.name="Amit";
     p1.age=17;
     
     p1.show();
     
     boolean b=p1.isVoter();
     System.out.println(b);
 }
}

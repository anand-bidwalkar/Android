
public class MyMain {
public static void main(String[] args) 
{
    Person p1=new Person();
    p1.name="Amit";
    p1.count=1;
    //p1.voting_age=21; voting_age is final
    p1.show();
    System.out.println("--------------------");
    Person p2=new Person();
    p2.name="Priya";
    p2.count=5;
    p2.show();
    
    System.out.println("--------------------");
    p1.show();
    
 }
}

package mypack;
//			child			super/parent
public class Student extends Person
{ 
 float marks;
 void printPercent()
 {
	 float percent=marks/500*100;
	 System.out.println(percent);
 }
 void printPercent(float total)
 {
	 float percent=marks/total*100;
	 System.out.println(percent);
 }

}

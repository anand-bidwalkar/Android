
public class MyMain 
{
public static void main(String[] args) 
{
	Outer out1=new Outer();
	out1.setData(4, 5);
	out1.show();
	//out.x
	Outer.x=1;
}
}

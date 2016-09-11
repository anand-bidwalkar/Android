
public class Outer
{
  static int x;
  Inner in;
  void show()
  {
	  System.out.println(x);	  
  } 
  void setData(int a, int b)
  {
	  in=new Inner();
	  in.y=a;
	  in.z=b;
	  in.sum();
  }
  class Inner 
  {
	  int y;
	  int z;
	  void sum()
	  {
		  x=y+z;
	  }
  }
}


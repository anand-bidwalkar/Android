package mypack;

public class MyMain2 
{
  public static void main(String[] args) 
  {
	// array demo
	  int []ar= new int[5];
	  
	 
	  
	  //insert values in array
	  ar[0]=4;
	  ar[1]=3;
	  ar[2]=23;
	  ar[3]=1;
	  ar[4]=8;
	  
	  //print array
	  for(int i=0;i<5;i++)
		  System.out.println(ar[i]);
	  
	  // initializing an array
	  int data[]={45,23,78,56};
	//sum array
	  int sum=0;
	  for(int i=0;i<data.length;i++)
	  {
		  sum=sum+data[i];
	  }
	  System.out.print(sum);
}
}

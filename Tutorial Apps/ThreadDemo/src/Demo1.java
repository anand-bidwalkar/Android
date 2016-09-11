
public class Demo1 {
public static void main(String[] args) 
{
	
     /*MyThread t1=new MyThread();
     t1.setName("Ankit");
     t1.start();
     
     MyThread t2=new MyThread();
     t2.setName("Megha");
     t2.start();*/
	for(int i=0;i<=10;i++)
	{
		System.out.println(i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     
}
}

class MyThread extends Thread
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			String name=Thread.currentThread().getName();
			System.out.println(i+":"+name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
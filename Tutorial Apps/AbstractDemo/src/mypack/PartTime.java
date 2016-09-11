package mypack;

public class PartTime extends Employee
{
  int hours;
  int rate=100;
	
	@Override
	void calcSalary() {
		// TODO Auto-generated method stub
		salary=hours*rate;
	}

}

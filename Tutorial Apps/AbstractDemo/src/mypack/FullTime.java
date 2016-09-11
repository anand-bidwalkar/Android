package mypack;

public class FullTime extends Employee
{
float basic;
float pf;
	@Override
	void calcSalary() {
		// TODO Auto-generated method stub
		salary=basic+basic*pf/100;
	}

}

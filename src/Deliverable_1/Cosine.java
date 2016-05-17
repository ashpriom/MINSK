package Deliverable_1;

import java.util.Scanner;

public class Cosine {
	private double PI = 3.141592653589793;
	public double cosine_radians(double x)
	{
		double sum=0;
		if (x==0)
			sum = 1.0;
		else
		{
			if(x==1.57)
			{
				sum=0;
			}
			else 
			{
				for(int i=1;i<=10;i++)
				{
					int temp = (2* i)-2;
					double q = MathFunctions.computePower(x, temp);
					double fact_i = MathFunctions.computeFactorial(temp);
					if (i%2==1)
                        sum+= (q/fact_i);
                    else
                    	sum-=(q/fact_i);
				}
			}
		}
		return sum;
	}
	
	public double consine_degrees(int y){
		int temp;
		if(y>=0){
			temp = y;
		}else{
			temp =-y;
		}
		int rem = temp%360;
		double res = 0;
		if(rem>=0&&rem<=90){
			double x = (PI/180)*(rem-90);
			res = cosine_radians(x);
		}
		return res;
	}
	
	public static void main(String args[])
	{
		Cosine cs=new Cosine();
		System.out.println(Math.cos(30));
		System.out.println(cs.consine_degrees(30));
	}
}

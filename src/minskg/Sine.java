package minskg;

public class Sine {
	private double PI = 3.141592653589793;
	
	public static double computeSine(double x){
		double sum = 0;
		if(x!=0){
			int i = 1;
			while(i<=10){
				int tmp = (2*i)-1;
				double q = MathFunctions.computePower(x, tmp);
				double fact_i = MathFunctions.computeFactorial(tmp);
				if(i%2==1){
					sum+=(q/fact_i);
				}else{
					sum-=(q/fact_i);
				}
				i+=1;
			}
		}
		return sum;
	}
	
	public static double computeCosine(double radians){
		double deg = 57.2958*radians;
		double cos_deg=90-deg;
		double cos_rad = cos_deg* 0.0174533;
		return computeSine(cos_rad);
	}
	
	public double computeArcCosine(double radians){
		
		return 0d;
	}
	public double acos(double x) {
		   return (-0.69813170079773212 * x * x - 0.87266462599716477) * x + 1.5707963267948966;
	}
	public static void main(String[] args) {
		Sine a = new Sine();
		/*
		System.out.println(a.computeCosine(1.5707963267948966/3d));
		System.out.println(Math.cos(1.5707963267948966/3d));
		*/
		System.out.println(a.acos(0.9));
		System.out.println(Math.acos(0.9));
	}
}

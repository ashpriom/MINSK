package minskg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Quadratic {
	String x1 = "", x2 = "";
	double a = 0, b = 0, c = 0, d=0;
	public boolean isNumber(String value){
		return value.matches("^-?[0-9]+$");
	}
	public void setCoefficient(int a, int b, int c) {
		this.a = a;this.b = b;this.c = c;
		compute();
	}
	public String getX() {
		return "x1: " + x1 + "\nx2: " + x2 + "\n";
	}
	public void compute() {
    d = (b*b)-(4*a*c);
    //roots are real and unequal
    if(d>0)
    {
    	
        x1=""+(- b + Math.sqrt(d))/(2 * a);
        x2=""+(- b - Math.sqrt(d))/(2 * a);
    }
    //roots are imaginary
    else if(d<0)
    {
    	
    	x1=""+-b+"+"+"("+d+"i)";
    	x2=""+-b+"-"+"("+d+"i)";
    }
   //roots are real and equal (d==0)
    else
    {
     x1=""+(-b+Math.sqrt(d))/(2 * a);  
    }
	}
	
	public void quadraticFunction() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		String choice = "";
		System.out.println("1:: to put number");	
		System.out.println("2:: to read large number of quadratic eqn's co-efficient and write output solutions to file");
		boolean is_choice = false;
		do {
			if(is_choice){
				System.out.println("choice "+ choice +" is not available");
			}
			choice = input.next();
		}while(is_choice=!(choice.equals("1") || choice.equals("2")));
		Quadratic quad=new Quadratic();
		if(choice.equals("1")){
			int coeff[] = new int[3];
			for(int i = 0; i<coeff.length;i++){
				String value = "";
				boolean is_number = false;
				do{
					char coeff_var = i==0?'a':i==1?'b':'c';
					System.out.println("put coefficient "+coeff_var+ " value :");
					value = input.next();
					is_number = quad.isNumber(value);
					if(is_number){
						coeff[i] = Integer.parseInt(value);
					}else{
						System.out.println(value+" is not number, put coefficient "+coeff_var+" again");
					}
				}while(!is_number);
			}
			
			quad.setCoefficient(coeff[0], coeff[1], coeff[2]);
			System.out.println(quad.getX());
		}
		else if(choice.equals("2")){
			input = new Scanner(new File("cubic_coefficient.txt"));
			File file = new File ("cubic_output.txt");
		    PrintWriter writer = new PrintWriter(file);
			// case3
			// ALL 3 Roots Are Real
			while(input.hasNext()){
				String line = input.nextLine();
				String value[] = line.split(" ");
				if(value.length<3){
					writer.println("there is "+value.length+" coefficients");
				}else{
					int coeff[] = new int[3];
					for(int i =0; i<value.length;i++){
						if(quad.isNumber(value[i]))
						{
							coeff[i]=Integer.parseInt(value[i]);
						}
					}
					writer.println("a:"+coeff[0]);
					writer.println("b:"+coeff[1]);
					writer.println("c:"+coeff[2]);
					quad.setCoefficient(coeff[0], coeff[1], coeff[2]);
					writer.println(quad.getX());
				}
			}
			writer.close();
		}
	}
	}
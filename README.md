# MINSK
The project involves developing program for three mathematical equations: the quadratic equation, cubic equation and a function to find primality of a number from software engineering perspective. Specialized goals of this project include ensuring presence of quality attributes such as coding style, optimal Cyclomatic complexity and measure various aspects of the programs.

***

Quadratic Equation:
Step 1: Start 
Step 2: Declare variables a, b, c, d, x1, x2 for storing coefficient, determinant and roots.
Step 3: Read the coefficients of the equation and constants.
Step 4: Find the determinant, d = (b * b) – (4 * a *c).
Step 5: If (d > 0), then
          	    5.1.1: compute roots
                               x1 = (-b + square_root(d)) / (2 * a)
		 x2 = (-b - square_root(d)) / (2 * a)
    5.1.2: Display roots are real and unequal
                  5.1.3: Print x1 and x2 values.
          Else if (d < 0), then
   	   5.2.1 compute roots
		x1 = -b + i(d)
		x2 = -b - i(d) 
    	   5.2.2: Display roots are imaginary
                  5.2.3: Print roots x1 and x2 values. 
           Else, Display roots are real and equal (d==0)
                  5.3.1: compute root, x1 = (-b + square_root(d)) / (2 * a)
        5.3.2: Print x1 value.
Step 6: Stop.


Cubic Equation:
Step 1: Start
Step 2: Declare variables a, b, c, d, f, g, h, x1, x2 for storing coefficient, determinant and roots.
Step 3: Read the coefficients of the equation and constants.
Step 4: Compute the following,
	f = ((3 * c / a) - Power(b, 2) / Power(a, 2))) / 3d
	g = ((2 * Power(b, 3)/Power(a,3)) -(9 * b * c/Power(a, 2)) + (27 * d / a))/ 27
	h = (g * g / 4) + (Power(f, 3) / 27)
Step 5: if (h > 0), then 
	 5.1.1: Declare local variables r, s, t, u and compute the following,
                       	r = -(g / 2) + square_root(h)
   	    	s = square_root(r)
	    	t = -(g / 2) - square_root (h)
	    	u = cube_root(t);
         	x1 = ((s + u) - (b / (3 * a)))
	   	x2 = (-(s + u) / 2 - (b / (3 * a))) +(i)(((s - u) 
* square_root(3) / 2d))
         	x3 = (-(s + u) / 2 -(b /(3 * a))) + (-i)(((s - u)
*square_root (3) / 2d))   
       5.1.2 Display one root is real and others are imaginary roots 
       5.1.3 Print the roots x1, x2 and x3 values.   
 
         Else if (f == 0 && g == 0 && h==0) , then
	5.2.1: Compute the following,
x1 = "" + (cube_root (d / a) * -1)
		x2 = "" + (cube_root (d / a) * -1)
		x3 = "" + (cube_root (d / a) * -1)
	5.2.2:Display all roots are real and equal. 
5.2.3: Print the roots x1, x2 and x3 values.
        Else, 
5.3.1: Declare local variables I, j, k, l , m, n, p and compute the following,
	   i = square_root (((g * g) / 4) - h)
 	   j = cube_root (i)
	   k = arccosine(-(g / (2 * i)))
	   l = j * -1
	   m = Cosine(k / 3)
	   n = square_root (3) * sine(k / 3)
	   p = (b / (3d * a)) * -1
	5.3.2 Compute the roots,
               x1 = "" + ((2 * j * cosine(k / 3d)) - (b / (3d * a)))
	   x2 = "" + (l * (m + n) + p)
	   x3 = "" + (l * (m - n) + p)
	5.3.3: Display all roots are real. 
5.3.4: Print the roots x1, x2 and x3 values.
Step 6: Stop


Check Primality:
Step 1: Start
Step 2: Declare variables i and number.
Step 3: Initialize variables i=5
Step 4: Read value for the variable ‘number’.
Step 5.1: If (number <= 1) 
Display as not a prime and invalid number and return
        5.2 Else if (number == 2 && number ==3)
            Display as prime number and return 
        5.3 Else if (number % 2 ==0 || number % 3 == 0)
             Display as not a prime number and return       
Step 6: Loop While ‘i’ is from 5 to number
        6.1 If (number % i == 0) || (number % (i+2) == 0)
             Display as not a prime number and return
        6.2 Else, Increment i= i+6
Step 7: Display as prime number and return 
Step 8: Stop
Check Addition of Coefficients (absolute) Values is Prime Number:
Step 1: Start
Step 2: Declare variables a, b, c, absVal.
Step 3: If (a==0), then
	return false
Step 4: If (a<0), then
	a = a * -1
Step 5: If (b<0), then
	b = b* -1
Step 6: If (c<0), then
	c = c * -1
Step 7: Compute absVal = a + b + c
Step 8: If (isPrime(absVal)), then
	 Return true
	Else 
	 Return false
Step 9: Stop


Check Addition of Coefficients (absolute) are Odd Composite:
Step 1: Start
Step 2: Declare variables a, b, c, d, absVal.
Step 3: If (a==0), then
	Return false
Step 4: If (a<0), then
	a = a * -1
Step 5: If (b<0), then
	b = b* -1
Step 6: If (c<0), then
	c = c * -1
Step 7: If (d<0), then
	d = d * -1
Step 8: Compute absVal = a + b + c
Step 9: If (isPrime(absVal))
	 Return false
	Else if (absVal % 2 == 1)
	 Return true
Step 10: Stop


Calculate Sine Values:
Step 1: Start
Step 2: Declare variables x, I, sum, temp, q, fact.
Step 3: Initialize sum = 0
Step 4: If (x  > 6.283188), then
	x = ((x * 1000000) % (6.283188 * 1000000)) / 1000000;
Step 5: If (x != 0), then 
	  5.1: Loop while ‘i’ is from 1 to 10 			
	     temp = (2 * i) - 1;
	      q = power( x,  temp );
	      fact  = factorial(temp);
               5.2: If (i % 2 == 1), then
 	               sum = sum + (q / fact);
	           Else, sum -= (q / fact_i);
	   5.3 increment i=i+1
Step 6: return sum;


Calculate Cosine Values:
Step 1: Start
Step 2: Declare variables radians, deg, cos_deg, cos_rad
Step 3: If (radians > 6.28319), then
	   radians = ((radians * 100000) % (6.28319 * 100000)) / 100000;
Step 4: Compute the following,
   deg = 57.2958 * radians;
	   cos_deg = 90 - deg;
	   cos_rad = cos_deg * 0.0174533;
Step 5: return Sine(cos_rad)

Calculate Arc Cosine Values:
Step 1: Start
Step 2: Declare variables x, r, flag
Step 3: If(x < 0), then flag = 1
	Else, flag =0
Step 4: Compute the following:
	            x  = absolute (x);
	           double ret = -0.0187293;
	            r= r * x;
		r= r + 0.0742610;
		r= r * x;
		r = r - 0.2121144;
		r = r * x;
		r = r + 1.5707288;
		r = r * square_root (1.0 - x);
		r = r - 2 * flag * r;
Step 5: Return (flag * 3.14159265358979 + r)

***

The MIT License (MIT)
Copyright (c) 2015 Nuttakit Phichitsakuldes, Ronak Ramanlal Prajapati, Pratyusha Prathikantham,
Syed Ashfaque Uddin Priom, Golnoush Rahimzadeh, Dhanvin Raval, Kumaran Ayyappan Ravi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

/** 
 * @author teamG
 * MINSK
 * SOEN 6611 - G
 * The MIT License (MIT)
 * Copyright (c) 2015 Nuttakit Phichitsakuldes, Ronak Ramanlal Prajapati, Pratyusha Prathikantham
   Syed Ashfaque Uddin Priom, Golnoush Rahimzadeh, Dhanvin Raval, Kumaran Ayyappan Ravi

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.
*/

package minskg.gui;

import java.awt.event.*;
import javax.swing.*;

import minskg.Cubic;
import minskg.Prime;
import minskg.Quadratic;


public class MainGUI {
	static final int WIDTH = 600, MAIN_HEIGHT = 80, HEIGHT_1 = 160, HEIGHT_2 = 190, HEIGHT_3 = 220;
	JFrame jf;
	JButton jbGo, jbSolve, jbBack;
	JComboBox<String> jcbMode;
	JTextField jtf1, jtf2, jtf3, jtf4;
	JLabel jl1, jl2, jl3, jltf1, jltf2, jltf3, jltf4, jlInfo;
	double a,b,c,d;
	long ee;
	
	/**
	 * set some components' actions
	 */
	public void setListener() {
		jbSolve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (jcbMode.getSelectedIndex() == 0) {
						String text = jtf2.getText();
						if(text.length()>19){
							JOptionPane.showMessageDialog(null, "Please put a number less than 19 digits");
						}else{
							ee = Long.parseLong(text);
							jl1.setText(ee+" is "+(Prime.isPrime(ee)?"":"not")+" prime number");
						}
					} else if (jcbMode.getSelectedIndex() == 1) {
						a = Double.parseDouble(jtf1.getText());
						b = Double.parseDouble(jtf2.getText());
						c = Double.parseDouble(jtf3.getText());
						Quadratic quad = new Quadratic();
						quad.setCoefficient(a, b, c);
						jl1.setText("X1 :"+quad.getX1());
						jl2.setText("X2 :"+quad.getX2());
					} else if (jcbMode.getSelectedIndex() == 2) {
						a = Double.parseDouble(jtf1.getText());
						b = Double.parseDouble(jtf2.getText());
						c = Double.parseDouble(jtf3.getText());
						d = Double.parseDouble(jtf4.getText());
						Cubic cubic = new Cubic();
						cubic.setCoefficient(a, b, c, d);
						jl1.setText("X1 :"+cubic.getX1());
						jl2.setText("X2 :"+cubic.getX2());
						jl3.setText("X3 :"+cubic.getX3());
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please put a number into the textbox");
				}
			}
		});

		jbBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.setSize(WIDTH, MAIN_HEIGHT);
				jbGo.setVisible(true);
				jcbMode.setVisible(true);
				jbBack.setVisible(false);
				jbSolve.setVisible(false);
				jlInfo.setVisible(false);
			}
		});

		jbGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				jbGo.setVisible(false);
				jcbMode.setVisible(false);
				jbBack.setVisible(true);
				jbSolve.setVisible(true);
				jl1.setText("           ANSWER 1");
				if (jcbMode.getSelectedIndex() == 0) {
					jf.setSize(WIDTH, HEIGHT_1);
					jtf2.setText("");
					jtf1.setVisible(false);
					jltf2.setText("Prime number :");
					jtf2.setBounds(215, 65, 160, 30);
					jltf2.setBounds(105, 65, 100, 30);
					jtf3.setVisible(false);
					jtf4.setVisible(false);
					jltf1.setVisible(false);
					jltf2.setVisible(true);
					jltf3.setVisible(false);
					jltf4.setVisible(false);
					jlInfo.setText("Insert a number to check primality:");
					//
				} else if (jcbMode.getSelectedIndex() == 1) {
					jf.setSize(WIDTH, HEIGHT_2);
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jltf1.setText("value A :");
					jltf2.setText("value B :");
					jltf3.setText("value C :");
					jltf1.setBounds(80, 65, 50, 30);
					jltf2.setBounds(230, 65, 50, 30);
					jltf3.setBounds(380, 65, 50, 30);
					jtf1.setBounds(140, 65, 80, 30);
					jtf2.setBounds(290, 65, 80, 30);
					jtf3.setBounds(440, 65, 80, 30);
					jtf1.setVisible(true);
					jtf3.setVisible(true);
					jtf4.setVisible(false);
					jltf1.setVisible(true);
					jltf2.setVisible(true);
					jltf3.setVisible(true);
					jltf4.setVisible(false);
					jl2.setText("           ANSWER 2");
					jlInfo.setText("Insert values for a, b, and c for a Quadratic Equation:");
				} else {
					jf.setSize(WIDTH, HEIGHT_3);
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jtf4.setText("");
					jtf1.setVisible(true);
					jtf3.setVisible(true);
					jtf4.setVisible(true);
					jltf1.setVisible(true);
					jltf2.setVisible(true);
					jltf3.setVisible(true);
					jltf4.setVisible(true);
					jltf1.setText("value A :");
					jltf2.setText("value B :");
					jltf3.setText("value C :");
					jltf4.setText("value D :");
					jltf1.setBounds(10, 65, 50, 30);
					jltf2.setBounds(150, 65, 50, 30);
					jltf3.setBounds(290, 65, 50, 30);
					jltf4.setBounds(430, 65, 50, 30);
					jtf1.setBounds(65, 65, 80, 30);
					jtf2.setBounds(205, 65, 80, 30);
					jtf3.setBounds(345, 65, 80, 30);
					jtf4.setBounds(485, 65, 80, 30);
					jl2.setText("           ANSWER 2");
					jl3.setText("           ANSWER 3");
					jlInfo.setText("Insert values for a, b, c, and d for a Cubic Equation:");
				}
				jlInfo.setVisible(true);
			}
		});

		jf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * set components visibility
	 */
	public void setVisible() {
		jl1.setVisible(true);
		jl2.setVisible(true);
		jl3.setVisible(true);
		jlInfo.setVisible(false);
		jtf1.setVisible(true);
		jtf2.setVisible(true);
		jtf3.setVisible(true);
		jtf4.setVisible(true);
		
		jbBack.setVisible(false);
		jbSolve.setVisible(false);
		jbGo.setVisible(true);
		jcbMode.setVisible(true);
		jf.setVisible(true);
	}
	
	/**
	 * to initial all variable and set them in the frame
	 */
	public void init() {
		jf = new JFrame("MINSK");
		jbGo = new JButton("Go");
		jbBack = new JButton("Back");
		jbSolve = new JButton("Solve");
		jcbMode = new JComboBox<String>(new String[] { "Prime", "Quadratic Equation", "Cubic Equation" });
		jlInfo = new JLabel();
		jl1 = new JLabel("           ANSWER 1");
		jl2 = new JLabel("           ANSWER 2");
		jl3 = new JLabel("           ANSWER 3");
		jltf1= new JLabel("value A");
		jltf2= new JLabel("value B");
		jltf3= new JLabel("value C");
		jltf4= new JLabel("value D");
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		
		jf.setIconImage((new ImageIcon(getClass().getResource("my_logo.gif"))).getImage());
		jf.setLayout(null);
		jf.setResizable(false);

		jf.add(jbGo);
		jf.add(jbBack);
		jf.add(jbSolve);
		jf.add(jcbMode);
		jf.add(jl1);
		jf.add(jl2);
		jf.add(jl3);
		jf.add(jlInfo);
		jf.add(jltf1);
		jf.add(jltf2);
		jf.add(jltf3);
		jf.add(jltf4);
		jf.add(jtf1);
		jf.add(jtf2);
		jf.add(jtf3);
		jf.add(jtf4);
		jf.setBounds(200,300,WIDTH, MAIN_HEIGHT);
		jcbMode.setBounds(185, 10, 150, 30);
		jbGo.setBounds(340, 10, 55, 30);
		jbSolve.setBounds(200, 10, 90, 30);
		jbBack.setBounds(300, 10, 90, 30);
		jlInfo.setBounds(200, 45, 200, 15);
		jl1.setBounds(125, 100, 350, 20);
		jl2.setBounds(125, 130, 350, 20);
		jl3.setBounds(125, 160, 350, 20);
		setVisible();
		setListener();
	}
	
	/**
	 * the main function
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainGUI g = new MainGUI();
		g.init();
	}
}

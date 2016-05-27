package minskg.gui;

import java.awt.event.*;
import javax.swing.*;

import minskg.Cubic;
import minskg.Prime;
import minskg.Quadratic;

public class MainGUI {
	static final int WIDTH = 400, MAIN_HEIGHT = 80, HEIGHT_1 = 160, HEIGHT_2 = 190, HEIGHT_3 = 220;
	JFrame jf;
	JButton jbGo, jbSolve, jbBack;
	JComboBox<Integer> jcbMode;
	JTextField jtf1, jtf2, jtf3, jtf4;
	JLabel jl1, jl2, jl3, jlInfo;
	double a,b,c,d;
	long ee;
	public void setListener() {
		jbSolve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (jcbMode.getSelectedIndex() == 0) {
						String text = jtf2.getText();
						if(text.length()>19){
							JOptionPane.showMessageDialog(null, "Please put the number less than 19 digits");
						}else{
							ee = Long.parseLong(text);
							Prime p = new Prime();
							jl1.setText(ee+" is "+(p.isPrime(ee)?"":"not")+" prime number");
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
					JOptionPane.showMessageDialog(null, "Please put number into the textbox");
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
				jl1.setText("ANSWER 1");
				if (jcbMode.getSelectedIndex() == 0) {
					jf.setSize(WIDTH, HEIGHT_1);
					jtf1.setVisible(false);
					jtf2.setBounds(115, 65, 160, 30);
					jtf3.setVisible(false);
					jtf4.setVisible(false);
					jlInfo.setText("put number to check prime number");
					//
				} else if (jcbMode.getSelectedIndex() == 1) {
					jf.setSize(WIDTH, HEIGHT_2);
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jtf1.setBounds(70, 65, 80, 30);
					jtf2.setBounds(155, 65, 80, 30);
					jtf3.setBounds(240, 65, 80, 30);
					jtf1.setVisible(true);
					jtf3.setVisible(true);
					jtf4.setVisible(false);
					jl2.setText("ANSWER 2");
					jlInfo.setText("put a, b, c for quadratic equation");
				} else {
					jf.setSize(WIDTH, HEIGHT_3);
					jtf1.setText("");
					jtf2.setText("");
					jtf3.setText("");
					jtf4.setText("");
					jtf1.setVisible(true);
					jtf3.setVisible(true);
					jtf4.setVisible(true);
					jtf1.setBounds(30, 65, 80, 30);
					jtf2.setBounds(115, 65, 80, 30);
					jtf3.setBounds(200, 65, 80, 30);
					jtf4.setBounds(285, 65, 80, 30);
					jl2.setText("ANSWER 2");
					jl3.setText("ANSWER 3");
					jlInfo.setText("put a, b, c, d for cubic equation");
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

	public void init() {
		jf = new JFrame("MINSK");
		jbGo = new JButton("Go");
		jbBack = new JButton("Back");
		jbSolve = new JButton("Solve");
		jcbMode = new JComboBox(new String[] { "Prime", "Quadratic Equation", "Cubic Equation" });
		jlInfo = new JLabel();
		jl1 = new JLabel("ANSWER 1");
		jl2 = new JLabel("ANSWER 2");
		jl3 = new JLabel("ANSWER 3");
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
		jf.add(jtf1);
		jf.add(jtf2);
		jf.add(jtf3);
		jf.add(jtf4);
		jf.setBounds(200,300,WIDTH, MAIN_HEIGHT);
		jcbMode.setBounds(85, 10, 150, 30);
		jbGo.setBounds(240, 10, 55, 30);
		jbSolve.setBounds(100, 10, 90, 30);
		jbBack.setBounds(200, 10, 90, 30);
		jlInfo.setBounds(100, 45, 200, 15);
		jl1.setBounds(25, 100, 350, 20);
		jl2.setBounds(25, 130, 350, 20);
		jl3.setBounds(25, 160, 350, 20);
		setVisible();
		setListener();
	}

	public static void main(String[] args) {
		MainGUI g = new MainGUI();
		g.init();
	}
}

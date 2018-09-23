package main;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CalculatorWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textVisor;
	String firstString = "";
	String secondString = "";
	String operator = "";
	boolean erasable = false;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorWindow frame = new CalculatorWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorWindow() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 0, 0));
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btn3);
		
		JButton btnErase = new JButton("C");
		btnErase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erase();
			}
		});
		panel.add(btnErase);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btn6);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingOperator(e.getActionCommand());
			}
		});
		panel.add(btnPlus);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btn9);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingOperator(e.getActionCommand());
			}
		});
		panel.add(btnMinus);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
				addingNumbers(e.getActionCommand());
			}
		});
		panel.add(btnDot);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingOperator(e.getActionCommand());
			}
		});
		panel.add(btnDiv);
		
		JButton btnMult = new JButton("*");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addingOperator(e.getActionCommand());
			}
		});
		panel.add(btnMult);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateResult();
			}
		});
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(btnEqual, BorderLayout.SOUTH);
		
		textVisor = new JTextField();
		textVisor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textVisor.setEditable(false);
		contentPane.add(textVisor, BorderLayout.NORTH);
		textVisor.setColumns(10);
	}
	
	protected void addingOperator(String text) {
		checkErase();
		addToVisor(" " + text + " ");
		operator = text;
	}
	
	public void addingNumbers(String text) {
		checkErase();
		addToVisor(text);
	
		if (operator == "") {
			firstString += text;
		} else if (operator != "") {
			secondString += text;
		} else if (operator != "" && secondString != ""){
			textVisor.setText("Apenas uma operação");
		}
	}
	
	private void checkErase() {
		if (erasable) {
			erase();
		}	
		
		erasable = false;
	}

	public void addToVisor(String text) {
		textVisor.setText(textVisor.getText() + text);
	}

	protected void erase() {
		textVisor.setText("");
		operator = "";
		firstString = "";
		secondString = "";
	}
	
	public void generateResult() {
		double firstNum = 0.0;
		double secondNum = 0.0;
		double result = 0.0;
		
		try {
			firstNum = Double.parseDouble(firstString);
			secondNum = Double.parseDouble(secondString);
			
		} catch (NumberFormatException e) {
			textVisor.setText("ERROR");
		}
	
		if(operator == "+") {
			result = firstNum + secondNum;
		} else if (operator == "-") {
			result = firstNum - secondNum;
		} else if (operator == "*") {
			result = firstNum * secondNum;
		} else if (operator == "/") {
			result = firstNum / secondNum;
		} else {
			textVisor.setText("ERROR");
		}
				
		addToVisor(" = " + Double.toString(result) + "\t");
		firstString = "";
		secondString = "";
		operator = "";
		erasable = true;
	}
}

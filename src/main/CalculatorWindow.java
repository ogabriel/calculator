package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;

public class CalculatorWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textVisor;

	/**
	 * Launch the application.
	 */
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
		panel.add(btn1);
		
		JButton btn2 = new JButton("2");
		panel.add(btn2);
		
		JButton btn3 = new JButton("3");
		panel.add(btn3);
		
		JButton btnErase = new JButton("C");
		panel.add(btnErase);
		
		JButton btn4 = new JButton("4");
		panel.add(btn4);
		
		JButton btn5 = new JButton("5");
		panel.add(btn5);
		
		JButton btn6 = new JButton("6");
		panel.add(btn6);
		
		JButton btnPlus = new JButton("+");
		panel.add(btnPlus);
		
		JButton btn7 = new JButton("7");
		panel.add(btn7);
		
		JButton btn8 = new JButton("8");
		panel.add(btn8);
		
		JButton btn9 = new JButton("9");
		panel.add(btn9);
		
		JButton btnMinus = new JButton("-");
		panel.add(btnMinus);
		
		JButton btn0 = new JButton("0");
		panel.add(btn0);
		
		JButton btnDot = new JButton(".");
		panel.add(btnDot);
		
		JButton btnDiv = new JButton("/");
		panel.add(btnDiv);
		
		JButton btnMult = new JButton("*");
		panel.add(btnMult);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(btnEqual, BorderLayout.SOUTH);
		
		textVisor = new JTextField();
		textVisor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textVisor.setEditable(false);
		contentPane.add(textVisor, BorderLayout.NORTH);
		textVisor.setColumns(10);
	}

}

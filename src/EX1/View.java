package EX1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * FUI FAZER O EXERCICIO 4 E ACABEI QUEBRANDO O PROJETO, MAS ESTAVA TUDO FUNCIONANDO DO EXERCICIO 1, 2,3 E 5
 */

public class View implements ActionListener
{
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JLabel value;
	private JLabel result;
	private JTextField valueField;

	private Color DarkGrey = new Color(18, 18, 18);
	private Color ClearPurple = new Color(187, 134, 252);

	public View()
	{
		frame = new JFrame("Fatorial");
		panel = new JPanel();
		button = new JButton("Calculate");
		value = new JLabel("Factorial of: ");
		result = new JLabel("Result: ");
		valueField = new JTextField(3);
		configurePanel();
		configureLabel1();
		configureTextFields();
		configureButton();
		configureLabel2();
		configureFrame();
	}

	public void configurePanel()
	{
		panel.setBackground(DarkGrey);
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(null);
	}

	public void configureTextFields()
	{
		valueField.setBounds(140, 40, 80, 25);
		panel.add(valueField);
	}

	public void configureButton()
	{
		button.setBackground(ClearPurple);
		button.setBounds(260, 40, 100, 25);
		panel.add(button);
		button.addActionListener(this);
	}

	public void configureLabel1()
	{
		value.setForeground(Color.WHITE);
		value.setBounds(40, 40, 80, 25);
		panel.add(value);
	}

	public void configureLabel2()
	{
		result.setForeground(Color.WHITE);
		result.setBounds(40, 120, 360, 25);
		panel.add(result);
	}

	public void configureFrame()
	{
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setTitle("Fatorial");
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent click)
	{
		try
		{
			String valueString = valueField.getText();
			long valueLong = Integer.parseInt(valueString);
			result.setText("Result: " + Controller.factorial(valueLong));
		} catch (NumberFormatException nfe)
		{
			result.setText("Write a number you wish to calculate");
		} catch (ArithmeticException ae)
		{
			result.setText("Only calculate a positive number");
		}
	}

	public Point getButtonLocation()
	{
		return (button.getLocationOnScreen());
	}

	public Point getTextFieldLocation()
	{
		return (valueField.getLocationOnScreen());
	}

	public String getTextPrinted()
	{
		return (result.getText());
	}

	public boolean isTextFieldEmpty()
	{
		if (valueField.getText().equals(""))
		{
			return (true);
		}
		return (false);
	}
}
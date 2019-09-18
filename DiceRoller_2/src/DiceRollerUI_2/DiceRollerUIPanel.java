package DiceRollerUI_2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import DiceRollerTest_2.*;

/**
 * DiceRollerUIPanel is a child of JPanel and handles all label, text fields, and buttons
 * @author Blaise Mahoro
 *
 */
@SuppressWarnings("serial")
public class DiceRollerUIPanel extends JPanel
{
	private JButton rollButton;
	
	private JLabel numberOfDiceLabel;
	private JTextField numberOfDiceTextField;
	private JLabel numberOfFacesLabel;
	private JTextField numberOfFacesTextField;
	
	public static JLabel totalLabel;
	public static JLabel errorMessageLabel;
	public static JLabel numberList;
	private int numberOfFaces;
	private int numberOfDice;
	
	//private DiceBagTest dice;
	public DiceRollerUIPanel()
	{
		
		rollButton = new JButton("Roll");
		rollButton.setBackground(Color.green);
		
		//labels
		numberOfDiceLabel = new JLabel("Enter the number of dice");
		numberOfFacesLabel = new JLabel("Enter the number of faces");
		//Text fields
		numberOfDiceTextField = new JTextField(6);
		//numberOfDiceTextField.addActionListener(new TextFieldListener());
		numberOfFacesTextField = new JTextField(6);
		//numberOfFacesTextField.addActionListener(new TextFieldListener());
		
		
		totalLabel = new JLabel("Total  ----");
		errorMessageLabel = new JLabel("");
		numberList =  new JLabel("");
		errorMessageLabel.setForeground(Color.RED);;		
		rollButton.addActionListener(new ButtonListener());
		add(numberOfDiceLabel);
		add(numberOfDiceTextField);
		add(numberOfFacesLabel);
		add(numberOfFacesTextField);
		add(rollButton);
		add(totalLabel);
		add(errorMessageLabel);
		add(numberList);
		
		
	}
	
	/**
	 *ButtonListener sets up reactions to the rollButton event   
	 * @author Blaise Mahoro
	 *
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String text2 = numberOfDiceTextField.getText();
			
			String text1 = numberOfFacesTextField.getText();
			
			numberOfFaces =Integer.parseInt(text1);
			numberOfDice =  Integer.parseInt(text2);
			DiceBagTest.Test(numberOfDice, numberOfFaces);
			
		}
	}

	

}

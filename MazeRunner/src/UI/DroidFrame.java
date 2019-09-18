package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mazePD.Droid;
import mazePD.Maze;
import mazePD.Maze.MazeMode;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class DroidFrame extends JFrame implements DroidListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	 private DefaultComboBoxModel ComboBoxModel;
	 private  JComboBox comboBox;
	 private	Droid droid;
	 private JPanel panel_1;
	/**
	 * Launch the application.
	 */
	public static void UI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DroidFrame frame = new DroidFrame();
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
	public DroidFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 973, 396);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDimension = new JLabel("Dimension:");
		lblDimension.setBounds(12, 24, 70, 16);
		panel.add(lblDimension);
		
		textField = new JTextField();
		textField.setBounds(82, 21, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDepth = new JLabel("Depth:");
		lblDepth.setBounds(12, 63, 56, 16);
		panel.add(lblDepth);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 53, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCret = new JButton("Create");
		btnCret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int size=Integer.parseInt(textField.getText());
				int depth=Integer.parseInt(textField_1.getText());
				Maze maze=new Maze(size,depth,MazeMode.NORMAL);
				droid= new Droid("DBN-03",maze);
				droid.enterMaze();
				ComboBoxModel.removeAllElements();;
				for(int i=0; i<droid.getMazeDepth();i++)
			         ComboBoxModel.addElement(i);
				
				
					
				droid.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent e) {
					
						textField_2.setText(droid.getCurrentLoc().toString());
						//textField_3.setText(new Integer(droid.getMoves().size()).toString());
						comboBox.setSelectedItem(droid.getCurrentLoc().getZ());
						//lblStatus.setText("Status : "+droid.getStatus());
						panel_1.removeAll();
						GridPanel mazeGridPanel = new GridPanel(droid,droid.getCurrentLoc().getZ());
						
						panel_1.add(mazeGridPanel);
						revalidate();
						repaint();
						}
					});
				
				panel_1.removeAll();
				GridPanel mazeGridPanel = new GridPanel(droid,droid.getCurrentLoc().getZ());
				
				panel_1.add(mazeGridPanel);
				revalidate();
				repaint();
			}
		});
		btnCret.setBounds(62, 95, 97, 25);
		panel.add(btnCret);
		
		JLabel lblCurrentLoc = new JLabel("Current Loc:");
		lblCurrentLoc.setBounds(12, 159, 97, 16);
		panel.add(lblCurrentLoc);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 156, 82, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		ComboBoxModel=new DefaultComboBoxModel();
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setBounds(12, 204, 56, 16);
		panel.add(lblLevel);
		//this.Thread.sleep(1000);
		comboBox = new JComboBox(ComboBoxModel);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()!=null) {
				panel_1.removeAll();
				GridPanel mazeGridPanel = new GridPanel(droid,(int)comboBox.getSelectedItem());
				
				panel_1.add(mazeGridPanel);
				revalidate();
				repaint();
				}
			}
		});
		comboBox.setBounds(82, 201, 43, 22);
		panel.add(comboBox);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread thread=new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						droid.run();
					}
					
				});
				thread.setDaemon(true);
				thread.start();
			}
		});
		btnRun.setBounds(62, 254, 97, 25);
		panel.add(btnRun);
		
		panel_1 = new JPanel();
		panel_1.setBounds(208, 0, 765, 396);
		panel.add(panel_1);
		
		
		
		
	}

	@Override
	public void update(Droid droid) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}

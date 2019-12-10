package dealership;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AddCar extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddCar(ArrayList<Car> usedList) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblMake = new JLabel("Make");
		lblMake.setBounds(10, 26, 46, 14);
		getContentPane().add(lblMake);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(10, 51, 46, 14);
		getContentPane().add(lblModel);
		
		JLabel Price = new JLabel("Price");
		Price.setBounds(10, 73, 46, 14);
		getContentPane().add(Price);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(10, 98, 46, 14);
		getContentPane().add(lblColor);
		
		JLabel lblMileage = new JLabel("Mileage");
		lblMileage.setBounds(10, 123, 46, 14);
		getContentPane().add(lblMileage);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(10, 148, 46, 14);
		getContentPane().add(lblYear);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 173, 46, 14);
		getContentPane().add(lblType);
		
		JLabel lblBodyType = new JLabel("Body Type");
		lblBodyType.setBounds(10, 198, 60, 14);
		getContentPane().add(lblBodyType);
		
		JLabel lblTerrain = new JLabel("Terrain");
		lblTerrain.setBounds(10, 223, 46, 14);
		getContentPane().add(lblTerrain);
		
		JLabel lblVin = new JLabel("VIN");
		lblVin.setBounds(10, 248, 46, 14);
		getContentPane().add(lblVin);
		
		JLabel warning = new JLabel("Make sure everything is filled");
		warning.setHorizontalAlignment(SwingConstants.LEFT);
		warning.setBounds(10, 287, 316, 19);
		getContentPane().add(warning);
		
		textField = new JTextField();
		textField.setBounds(85, 23, 313, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 48, 313, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(85, 70, 313, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(85, 95, 313, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(85, 120, 315, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(85, 145, 315, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(85, 170, 315, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(85, 195, 315, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(84, 220, 316, 20);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(83, 245, 317, 20);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnAddCar = new JButton("Add Car");
		btnAddCar.setBounds(435, 298, 89, 23);
		getContentPane().add(btnAddCar);
		
		JButton btnclear = new JButton("Clear");
		btnclear.setBounds(336, 298, 89, 23);
		getContentPane().add(btnclear);
		
		JLabel lblNewLabel = new JLabel("Add A Car Window");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 0, 148, 20);
		getContentPane().add(lblNewLabel);
		
		btnAddCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnAddCar) {	
					if(textField.getText().isEmpty() || textField_1.getText().isEmpty()
							|| textField_2.getText().isEmpty() || textField_3.getText().isEmpty()
							||textField_4.getText().isEmpty()|| textField_5.getText().isEmpty()
							|| textField_6.getText().isEmpty()|| textField_7.getText().isEmpty()
							|| textField_8.getText().isEmpty() || textField_9.getText().isEmpty()) {
						
						warning.setText("Atleast one of the label is empty");
						
					}
					else {
							boolean price = true;
							boolean mileage = true;
							boolean year = true;
							try {
								Double.parseDouble(textField_2.getText());
							}catch(NumberFormatException ignore) {
								
								price = false;
							}
						
							try {
								Double.parseDouble(textField_4.getText());
							}catch(NumberFormatException ignore) {
								mileage = false;
							}
							try {
								Integer.parseInt(textField_5.getText());
							} catch(NumberFormatException ignore) {
								year = false;
							}
							if((Integer.parseInt(textField_5.getText()) >= Calendar.getInstance().get(Calendar.YEAR))){
								year = false;							
							}
							if(price & mileage & year) {
								String[] info = {textField.getText(),textField_1.getText(), textField_2.getText(), 
										textField_3.getText(),textField_4.getText(), textField_5.getText(),
										textField_6.getText(), textField_7.getText(), textField_8.getText(),
										textField_9.getText()};
								int i;
								for(i = 0; i < usedList.size(); i++) {
									if(info[0].startsWith(usedList.get(i).getMake()))
										break;
								}
								usedList.add(i, new Car(info));
								warning.setText("Car has been successfully added to the system");
								clearFields();
								writeUsed(usedList);
							}
							else {
								warning.setText("Price/Mileage/Year is Invalid");
							}
					}	
				}
			}
		});
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource() == btnclear)
					clearFields();
			}
		});
	}

	public void writeUsed(ArrayList<Car> usedList){
		try{
			FileOutputStream datain = new FileOutputStream("serialUsed.dat");
			ObjectOutputStream dataout = new ObjectOutputStream(datain);
			dataout.writeObject(usedList);
			datain.close();
			dataout.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void clearFields() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		textField_8.setText("");
		textField_9.setText("");
	}

}

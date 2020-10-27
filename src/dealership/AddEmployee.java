package dealership;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddEmployee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnClearFields;
	private JLabel lblMakeSureAll;
	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AddEmployee(ArrayList<Employee> employees) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(107, 24, 121, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 27, 62, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(238, 26, 62, 17);
		contentPane.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(310, 24, 128, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 68, 62, 14);
		contentPane.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 66, 332, 17);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(10, 139, 86, 20);
		contentPane.add(lblDateOfBirth);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 139, 114, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 114, 46, 14);
		contentPane.add(lblCity);
		
		textField_4 = new JTextField();
		textField_4.setBounds(106, 108, 114, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblZip = new JLabel("Zip ");
		lblZip.setBounds(230, 114, 46, 14);
		contentPane.add(lblZip);
		
		textField_5 = new JTextField();
		textField_5.setBounds(275, 111, 149, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(230, 142, 46, 14);
		contentPane.add(lblId);
		
		textField_6 = new JTextField();
		textField_6.setBounds(275, 139, 149, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblPayRate = new JLabel("Pay Rate");
		lblPayRate.setBounds(10, 191, 71, 14);
		contentPane.add(lblPayRate);
		
		textField_7 = new JTextField();
		textField_7.setBounds(106, 188, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		lblMakeSureAll = new JLabel("Make sure all fields are filled");
		lblMakeSureAll.setBounds(10, 231, 249, 19);
		contentPane.add(lblMakeSureAll);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnAddEmployee) {
					if(textField.getText().isEmpty() || textField_1.getText().isEmpty()
							|| textField_2.getText().isEmpty() || textField_3.getText().isEmpty()
							||textField_4.getText().isEmpty()|| textField_5.getText().isEmpty()
							|| textField_6.getText().isEmpty()|| textField_7.getText().isEmpty()) {
						lblMakeSureAll.setText("Atleast one field is empty");
					}
					else {
						boolean pay = true;
						try {
							Double.parseDouble(textField_7.getText());
						}catch(NumberFormatException ignore) {
							pay = false;
						}
						if(pay) {
							String[] info = {textField.getText(), textField_1.getText(),textField_2.getText()
									+ "," + textField_3.getText() + "," + textField_4.getText(),
												textField_5.getText(), textField_6.getText(), textField_7.getText()};
							employees.add(new Employee(info));
							lblMakeSureAll.setText("Employee added");
							clearFields();
							writeEmployees(employees);
						}else {
							lblMakeSureAll.setText("pay rate is not valid");
						}
					}
				}
			}
		});
		
		btnAddEmployee.setBounds(389, 229, 128, 23);
		contentPane.add(btnAddEmployee);
		
		btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnClearFields) {
					clearFields();
				}
			}
		});
		
		btnClearFields.setBounds(275, 229, 104, 23);
		contentPane.add(btnClearFields);
		
		
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
	}
	
	 public void writeEmployees(ArrayList<Employee> employees){
	        try{
	            FileOutputStream datain = new FileOutputStream("serialEmployees.dat");
	            ObjectOutputStream dataout = new ObjectOutputStream(datain);
	            dataout.writeObject(employees);
	            datain.close();
	            dataout.close();
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }
	    }

}

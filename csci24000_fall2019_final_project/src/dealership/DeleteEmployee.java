package dealership;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DeleteEmployee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DeleteEmployee(ArrayList<Employee> employees) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter Employee ID to remove Employee");
		lblEnterEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterEmployeeId.setBounds(124, 46, 241, 14);
		contentPane.add(lblEnterEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(165, 72, 183, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		

		JLabel lblEnterAValid = new JLabel("Enter a valid ID");
		lblEnterAValid.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAValid.setBounds(53, 121, 176, 20);
		contentPane.add(lblEnterAValid);
		
		JButton btnRemoveEmployee = new JButton("Remove Employee");
		btnRemoveEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnRemoveEmployee) {
					int index = -1;
					String id = textField.getText();
					for(int i = 0; i < employees.size(); i++) {
						if(employees.get(i).getID().equals(id)) {
							index = i;
						}
					}
					if(index != -1) {
						lblEnterAValid.setText("Employee " + employees.get(index).getFname() + " is removed");
						employees.remove(index);		
						writeEmployees(employees);
					}
					else {
						lblEnterAValid.setText("Employee not found, try again");
					}
				}
			}
		});
		btnRemoveEmployee.setBounds(325, 117, 121, 23);
		contentPane.add(btnRemoveEmployee);
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

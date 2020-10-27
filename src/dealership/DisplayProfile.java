package dealership;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class DisplayProfile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DisplayProfile(Employee employee) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(31, 27, 73, 22);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(251, 31, 67, 14);
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(31, 79, 73, 14);
		contentPane.add(lblAddress);
		
		JLabel lblDateOfBith = new JLabel("Date Of Birth");
		lblDateOfBith.setBounds(31, 120, 73, 14);
		contentPane.add(lblDateOfBith);

		JLabel lblID = new JLabel("ID");
		lblID.setBounds(31, 156, 46, 14);
		contentPane.add(lblID);		
		
		JLabel lblPayRate = new JLabel("Pay Rate");
		lblPayRate.setBounds(27, 193, 67, 14);
		contentPane.add(lblPayRate);
		
		JLabel lblNewLabel_1 = new JLabel(employee.getFname());
		lblNewLabel_1.setBounds(132, 31, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(employee.getLname());
		lblNewLabel_2.setBounds(346, 31, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(employee.getAddress());
		lblNewLabel_3.setBounds(132, 73, 278, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(employee.getDob());
		lblNewLabel_4.setBounds(131, 120, 104, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(employee.getID());
		lblNewLabel_5.setBounds(132, 156, 104, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(String.valueOf(employee.getPayRate()));
		lblNewLabel_6.setBounds(132, 193, 96, 14);
		contentPane.add(lblNewLabel_6);
		
	}
}

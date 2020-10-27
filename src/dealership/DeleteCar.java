package dealership;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DeleteCar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public DeleteCar(ArrayList<Car> usedList) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterCarVin = new JLabel("Enter Car Vin ");
		lblEnterCarVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterCarVin.setBounds(115, 50, 189, 18);
		contentPane.add(lblEnterCarVin);
		
		textField = new JTextField();
		textField.setBounds(115, 79, 243, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		

		JLabel lblEnterAppropriateCar = new JLabel("Enter Appropriate Car Vin");
		lblEnterAppropriateCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAppropriateCar.setBounds(10, 135, 263, 19);
		contentPane.add(lblEnterAppropriateCar);
		
		JButton btnDeleteCar = new JButton("Delete Car");
		btnDeleteCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnDeleteCar) {
					String vin = textField.getText();
					int index = -1;
					for(int i = 0; i < usedList.size(); i++) {
						if(usedList.get(i).getVin().equals(vin)) {
							index = i;
						}
					}
					if(index != -1) {
						usedList.remove(index);
						lblEnterAppropriateCar.setText("Car has been sucessfully deleted");		
						writeUsed(usedList);
					}
					else
						lblEnterAppropriateCar.setText("Car not found, try again");						
				}
			}
		});
		btnDeleteCar.setBounds(294, 131, 89, 23);
		contentPane.add(btnDeleteCar);
		
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

}

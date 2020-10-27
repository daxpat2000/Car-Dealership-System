package dealership;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Button;

public class EmployeePanel extends JPanel {

	
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public EmployeePanel(ArrayList<Car> usedList, Employee employee) {
		setLayout(null);
		//declaring all required buttons and placing them
		JLabel lblHead = new JLabel("Welcome " + employee.getFname());
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(153, 11, 135, 26);
		add(lblHead);
		
		Button btnProfile = new Button("Profile");
		btnProfile.setBounds(305, 11, 107, 23);
		add(btnProfile);
		
		JRadioButton rdbtnMake = new JRadioButton("Search By Make\r\n");
		rdbtnMake.setBounds(26, 53, 155, 23);
		add(rdbtnMake);
		
		JRadioButton rdbtnYear = new JRadioButton("Search By Min Year");
		rdbtnYear.setBounds(26, 98, 155, 23);
		add(rdbtnYear);
		
		JRadioButton rdbtnPrice = new JRadioButton("Search By Price");
		rdbtnPrice.setBounds(26, 140, 155, 23);		
		add(rdbtnPrice);
		
		JRadioButton rdbtnColor = new JRadioButton("Search By Color");
		rdbtnColor.setBounds(26, 185, 155, 23);
		add(rdbtnColor);
		
		JButton btnGetList = new JButton("Get List");
		btnGetList.setBounds(299, 249, 89, 23);
		add(btnGetList);
		
		JComboBox<String> comboBoxMake = new JComboBox<String>();
		comboBoxMake.setBounds(203, 54, 100, 20);
		
		//grouping buttons
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnColor);
		radioGroup.add(rdbtnPrice);
		radioGroup.add(rdbtnYear);
		radioGroup.add(rdbtnMake);
		
		//comoboxMake assignments to buttons
		comboBoxMake.setVisible(true);
		ArrayList<String> makes = new ArrayList<String>();
		for(int i = 0; i < usedList.size(); i++) {
			if(!makes.contains(usedList.get(i).getMake()))
				makes.add(usedList.get(i).getMake());
		}
		for(int i = 0; i < makes.size(); i++)
			comboBoxMake.addItem(makes.get(i));	
		add(comboBoxMake);
		
		//comBox Year
		JComboBox<String> comboBoxYear = new JComboBox<String>();
		comboBoxYear.setBounds(203, 99, 100, 20);
		ArrayList<String> years = new ArrayList<String>();
		for(int i = 0; i < usedList.size(); i++) {
			if(!years.contains(usedList.get(i).getyear()))
					years.add(usedList.get(i).getyear());
		}
		for(int i = 0; i < years.size(); i++)
			comboBoxYear.addItem(years.get(i));
		add(comboBoxYear);
		
		//comBox Year
		JComboBox<String> comboBoxPrice = new JComboBox<String>();
		comboBoxPrice.setBounds(203, 141, 100, 20);
		add(comboBoxPrice);
		comboBoxPrice.addItem("0-5000");
		comboBoxPrice.addItem("5000-15000");
		comboBoxPrice.addItem("15000-25000");
		comboBoxPrice.addItem("25000-35000");
		comboBoxPrice.addItem("35000-50000");
		comboBoxPrice.addItem("50000-65000");
		comboBoxPrice.addItem("65000 and above");
		
		add(comboBoxPrice);
		
		//comBox Year
		JComboBox<String> comboBoxColor = new JComboBox<String>();
		comboBoxColor.setBounds(203, 186, 100, 20);
		ArrayList<String> colors = new ArrayList<String>();
		for(int i = 0; i < usedList.size(); i++) {
			if(!colors.contains(usedList.get(i).getColor())){
				colors.add(usedList.get(i).getColor());
			}
		}
		for(int i = 0; i < colors.size(); i++)
			comboBoxColor.addItem(colors.get(i));
		add(comboBoxColor);
		
		btnGetList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMake.isSelected()) {
					ArrayList<Car> filtered = Filter.filterByMake(usedList, comboBoxMake.getSelectedItem().toString());
					DisplayCars disp = new DisplayCars(filtered);
					disp.setVisible(true);
				}
				else if(rdbtnYear.isSelected()) {
					ArrayList<Car> filtered = Filter.filterByYear(usedList, comboBoxYear.getSelectedItem().toString());
					DisplayCars disp = new DisplayCars(filtered);
					disp.setVisible(true);
				}
				else if(rdbtnPrice.isSelected()) {
					 if(comboBoxPrice.getSelectedIndex() == 0) {
						ArrayList<Car> filtered = Filter.filterByPrice(usedList, "0", "5000");
						DisplayCars disp = new DisplayCars(filtered);
						disp.setVisible(true);
					}
					else if(comboBoxPrice.getSelectedIndex() == 1) {
						ArrayList<Car> filtered = Filter.filterByPrice(usedList, "5000", "15000");
						DisplayCars disp = new DisplayCars(filtered);
						disp.setVisible(true);
					}
					else if(comboBoxPrice.getSelectedIndex() == 2) {
						ArrayList<Car> filtered = Filter.filterByPrice(usedList, "15000", "25000");
						DisplayCars disp = new DisplayCars(filtered);
						disp.setVisible(true);						
					}
					else if(comboBoxPrice.getSelectedIndex() == 3) {
						ArrayList<Car> filtered = Filter.filterByPrice(usedList, "25000", "35000");
						DisplayCars disp = new DisplayCars(filtered);
						disp.setVisible(true);						
					}
					else if(comboBoxPrice.getSelectedIndex() == 4) {
						ArrayList<Car> filtered = Filter.filterByPrice(usedList, "35000", "50000");
						DisplayCars disp = new DisplayCars(filtered);
						disp.setVisible(true);
					}
					else if(comboBoxPrice.getSelectedIndex() == 5) {
						ArrayList<Car> filtered = Filter.filterByPrice(usedList, "50000", "65000");
						DisplayCars disp = new DisplayCars(filtered);
						disp.setVisible(true);
					}
					else if(comboBoxPrice.getSelectedIndex() == 6) {
						ArrayList<Car> filtered = Filter.filterByPrice(usedList, "650000", "1000000");
						DisplayCars disp = new DisplayCars(filtered);
						disp.setVisible(true);
					}
					//end nested if else
				}				
				else if(rdbtnColor.isSelected()) {
					ArrayList<Car> filtered = Filter.filterByColor(usedList, comboBoxColor.getSelectedItem().toString());
					DisplayCars disp = new DisplayCars(filtered);
					disp.setVisible(true);
				}
			}
		});
		
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnProfile) {
					DisplayProfile disp = new DisplayProfile(employee);
					disp.setResizable(true);
					disp.setVisible(true);
				}
			}
		});

	}
}

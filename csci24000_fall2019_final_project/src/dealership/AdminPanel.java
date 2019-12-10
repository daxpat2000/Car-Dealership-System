package dealership;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class AdminPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnListInventory;
	private JButton btnListEmployees;
	private JButton btnAddACar;
	private JButton btnDeleteCar;
	private JButton btnAddEmployee;
	private JButton btnDeleteEmployee;
	/**
	 * Create the panel.
	 */
	public AdminPanel(ArrayList<Car> usedList, ArrayList<Employee> employees) {
		setLayout(null);
		
		btnAddACar = new JButton("Add a Car");
		btnAddACar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnAddACar){
					AddCar pane = new AddCar(usedList);
					pane.setVisible(true);
				}
			}
		});
		btnAddACar.setBounds(41, 112, 122, 23);
		add(btnAddACar);
		
		btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnAddEmployee) {
					AddEmployee disp = new AddEmployee(employees);
					disp.setVisible(true);
				}
			}
		});
		btnAddEmployee.setBounds(245, 112, 139, 23);
		add(btnAddEmployee);
		
		btnDeleteCar = new JButton("Delete Car");
		btnDeleteCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnDeleteCar) {
					DeleteCar pane = new DeleteCar(usedList);
					pane.setVisible(true);
				}
			}
		});
		btnDeleteCar.setBounds(39, 154, 124, 23);
		add(btnDeleteCar);
		
		btnListInventory = new JButton("List Inventory");
		btnListInventory.setBounds(41, 67, 122, 23);
		add(btnListInventory);
		btnListInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayCars disp = new DisplayCars(usedList);
				disp.setVisible(true);
			}
		});
		
		btnDeleteEmployee = new JButton("Delete Employee");
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnDeleteEmployee) {
					DeleteEmployee pane = new DeleteEmployee(employees);
					pane.setVisible(true);
				}
			}
		});
		btnDeleteEmployee.setBounds(245, 154, 139, 23);
		add(btnDeleteEmployee);
		
		
		btnListEmployees = new JButton("List Employees");
		btnListEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayEmployees disp  = new DisplayEmployees(employees);
				disp.setVisible(true);
			}
		});
		btnListEmployees.setBounds(243, 67, 141, 23);
		add(btnListEmployees);
		
		Label label = new Label("Welcome Admin");
		label.setBounds(168, 10, 91, 37);
		add(label);


	}
}

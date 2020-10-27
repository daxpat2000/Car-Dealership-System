package dealership;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class CarDealershipApplication {
	
	ArrayList<Car> usedList;
	ArrayList<Employee> employees;
	String[] adminInfo = {"Dax", "Patel", "8605 E Maint St, Lexington, 47382", "1/13/1990"};
	Admin admin = new Admin(this.adminInfo);

	private JFrame frmCarDealershipSystem;
	private CardLayout cards;
	private JPasswordField pwdLogin;
	
	private JPanel LoginPanel;
	private JPanel EmployeePanel;
	private JPanel AdminPanel;
	
	private JLabel lblInstruction;
	private JButton btnEmployeeLogin;
	private JButton btnAdminLogin;
	private JButton btnLogin;
	private JButton btnLogout;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarDealershipApplication window = new CarDealershipApplication();
					window.frmCarDealershipSystem.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CarDealershipApplication() {
		this.usedList = new ArrayList<Car>();
        this.employees = new ArrayList<Employee>();    
        File serialCar = new File("serialUsed.dat");
        if(!serialCar.exists()){
            listUsed();
            writeUsed();
        }

        File serialWorkers = new File("serialEmployees.dat");
        if(!serialWorkers.exists()){
            listEmployees();
            writeEmployees();
        }
        loadUsed();
        loadEmployees();
        initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarDealershipSystem = new JFrame();
		frmCarDealershipSystem.setTitle("Car Dealership System\r\n");
		frmCarDealershipSystem.setBounds(100, 100, 572, 371);
		frmCarDealershipSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cards = new CardLayout();
		frmCarDealershipSystem.getContentPane().setLayout(cards);
		
		LoginPanel = new JPanel();
		LoginPanel.setLayout(null);
		pwdLogin = new JPasswordField();
		pwdLogin.setBounds(170, 171, 137, 20);
		LoginPanel.add(pwdLogin);
		pwdLogin.setText("");
		
		lblInstruction = new JLabel("Select Login Type");
		lblInstruction.setBounds(154, 288, 207, 14);
		LoginPanel.add(lblInstruction);
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnEmployeeLogin = new JButton("Employee Login");
		btnEmployeeLogin.setBounds(298, 75, 137, 69);
		LoginPanel.add(btnEmployeeLogin);
		
		btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setBounds(83, 75, 137, 69);
		LoginPanel.add(btnAdminLogin);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(216, 227, 74, 23);
		LoginPanel.add(btnLogin);
		frmCarDealershipSystem.getContentPane().add(LoginPanel, "Login");
		
		frmCarDealershipSystem.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               storeListUsed();
               storeListEmployees();
            }
        });
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(21, 298, 89, 23);
		//LoginPanel.add(btnNewButton);
		
		
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == btnLogout) {
					cards.show(frmCarDealershipSystem.getContentPane(), "Login");
					pwdLogin.setText("");
					lblInstruction.setText("Select Login Type");
				}												
			}
		});
		
		btnEmployeeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnEmployeeLogin ) {
					pwdLogin.setVisible(true);
					lblInstruction.setText("Enter Employee ID to login");
					lblInstruction.setVisible(true);		
					btnLogin.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(e.getSource() == btnLogin) {
								String a = new String(pwdLogin.getPassword());
								int index = -1;
								for(int i = 0; i < employees.size(); i++) {
									if(employees.get(i).getID().equals(a)) {
										index = i;
									}
								}
								if(index != -1) {
									EmployeePanel = new EmployeePanel(usedList, employees.get(index));
									EmployeePanel.add(btnLogout);							
									frmCarDealershipSystem.getContentPane().add(EmployeePanel, "Employee");
									cards.show(frmCarDealershipSystem.getContentPane(), "Employee");
									
								}
								else {
									lblInstruction.setText("Invalid Login Credentials");
								}
							}
						}
					});
				}
			}
		});
		
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnAdminLogin ) {
					pwdLogin.setVisible(true);
					lblInstruction.setText("Enter admin password to login");
					lblInstruction.setVisible(true);
					btnLogin.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if((new String(pwdLogin.getPassword())).equals("password")){
								AdminPanel = new AdminPanel(usedList, employees);
								AdminPanel.add(btnLogout);
								frmCarDealershipSystem.getContentPane().add(AdminPanel, "Admin");
								cards.show(frmCarDealershipSystem.getContentPane(), "Admin");
							}
							else {
								lblInstruction.setText("Invalid Admin Login Credentials");
							}
							
						}
						
					});
					
				}
			}
		});		
		lblInstruction.setVisible(true);
	}
	
	
	
	public void writeUsed(){
        try{
            FileOutputStream datain = new FileOutputStream("serialUsed.dat");
            ObjectOutputStream dataout = new ObjectOutputStream(datain);
            dataout.writeObject(this.usedList);
            datain.close();
            dataout.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    public void writeEmployees(){
        try{
            FileOutputStream datain = new FileOutputStream("serialEmployees.dat");
            ObjectOutputStream dataout = new ObjectOutputStream(datain);
            dataout.writeObject(this.employees);
            datain.close();
            dataout.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadUsed(){
        try{
            FileInputStream indata = new FileInputStream("serialUsed.dat");
            ObjectInputStream list = new ObjectInputStream(indata);
            this.usedList = (ArrayList<Car>)list.readObject();
            indata.close();
            list.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadEmployees(){
        try{
            FileInputStream indata = new FileInputStream("serialEmployees.dat");
            ObjectInputStream list = new ObjectInputStream(indata);
            this.employees = (ArrayList<Employee>)list.readObject();
            indata.close();
            list.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listUsed(){
        try{
            FileReader used = new FileReader("UsedInventory.csv");
            Scanner read = new Scanner(used);
            read.nextLine();
            while(read.hasNext()){
                String[] currentLine = read.nextLine().split(",");
                this.usedList.add(new Car(currentLine));
            }
            read.close();
            used.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    } 

    public void listEmployees(){    
        try{
            FileReader workers = new FileReader("Employee.csv");
            Scanner input = new Scanner(workers);
            input.nextLine();
            while(input.hasNext()){
                String[] currentLine = input.nextLine().split(",");
                String[] info = new String[6];
                info[0] = currentLine[0];
                info[1] = currentLine[1];
                info[2] = currentLine[2] + ", " + currentLine[3] + ", " + currentLine[4];
                info[3] = currentLine[5];
                info[4] = currentLine[6];
                info[5] = currentLine[7];
                this.employees.add(new Employee(info));
            }
            input.close();
            workers.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void storeListUsed() {
    	try {
    		FileWriter a = new FileWriter("UsedInventory.csv", false);
    		PrintWriter b = new PrintWriter(a);
    		b.println("Make,Model,Price,Color,Mileage,Year,Type,Body,Terrain,VIN");
    		for(int i = 0; i < this.usedList.size(); i++)
    			b.println(this.usedList.get(i).dispFormat());
    		b.close();    		
    	}catch(IOException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void storeListEmployees() {
    	try {
    		FileWriter a = new FileWriter("Employee.csv", false);
    		PrintWriter b = new PrintWriter(a);
    		b.println("First Name, Last Name, Address, City, Zip, DOB, ID, Pay Rate");
    		for(int i = 0; i < this.employees.size(); i++)
    			b.println(this.employees.get(i).dispInfo());
    		b.close();
    	}catch(IOException e) {
    		System.out.println(e.getMessage());
    	}
    }
}


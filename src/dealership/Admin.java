//System Administrator functionality
package dealership;

import java.util.ArrayList;

public class Admin extends Person{

  //admin will use ID and password to login
  private static final long serialVersionUID = 1L;
  String password = "password";

  public Admin(String[] info){
      super(info);
  }

  public void addUsedCar(ArrayList<Car> usedList){
      
  }

  public void deleteUsedCar(ArrayList<Car> usedList){

  }

  public void printInventory(ArrayList<Car> usedList){
      System.out.printf("%20s %15s %6s %15s %7s %4s %5s %5s %7s %14s\n", "Make", "Model", "Price", "Color", 
      "Mileage","Year", "Type", "Body", "Terrain", "Vin Number");
      for(int i = 0; i < usedList.size(); i++){
          usedList.get(i).printInfo();
      }
  }

  public void printEmployees(ArrayList<Employee> employees){
      System.out.printf("\n\n%11s  %11s  %40s  %8s  %8s  %8s\n", "FirstName", "LastName", "Address", "DOB", "ID", "PayRate");
      for(int i = 0; i < employees.size(); i++)
          employees.get(i).printInfo();
  }
  
  public void dispEmployees(ArrayList<Employee> employees) {
	  DisplayEmployees disp = new DisplayEmployees(employees);
	  disp.setVisible(true);
  }
  
  public void displayCars(ArrayList<Car> usedList){
	  DisplayCars disp = new DisplayCars(usedList);
	  disp.setVisible(true);
  }
}


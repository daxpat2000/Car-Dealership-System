package dealership;

public class Employee extends Person{

    private static final long serialVersionUID = 1L;
    private double payRate;
    private String ID;

    //constructors
    public Employee(String fname, String lname){
        super(fname, lname);
    }   

    public Employee(String[] info){
        super(info);
        this.ID = info[4];
        this.payRate = Double.parseDouble(info[5]);
    } 
    //end constructors

    //setters
    public void setPayRate(double payRate){
        this.payRate = payRate;
    }
    public void setID(String id){
        this.ID = id;
    }
    //end setters

    //getters
    public double getPayRate(){
        return this.payRate;
    }
    public String getID(){
        return this.ID;
    }

    public String[] getInfo(){
        String[] info = new String[6];
        info[0] = this.firstName;
        info[1] = this.lastName;
        info[2] = this.address;
        info[3] = this.dateOfBirth;
        info[4] = this.ID;
        info[5] = String.valueOf(payRate);
        return info;
    }

    public void printInfo(){
        System.out.printf("%11s  %11s  %40s  %8s  %8s  %.2f\n", this.firstName, this.lastName, this.address, this.dateOfBirth, this.ID, 
                            this.payRate);
    }
    
    public String dispInfo() {
    	String a = String.format("%s,%s,%s,%s,%s,%.2f", this.firstName, this.lastName, this.address, this.dateOfBirth, this.ID, 
                this.payRate);
    	return a;
    }
}


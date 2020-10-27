//abstract person class
package dealership;
import java.io.Serializable;

public abstract class Person implements Serializable{

    private static final long serialVersionUID = 1L;

    protected String firstName;
    protected String lastName;
    protected String address;
    protected String dateOfBirth;

    //constructors
    public Person(String fname, String lname){
        this.firstName = fname;
        this.lastName = lname;
    }

    public Person(String[] info){
        this.firstName = info[0];
        this.lastName = info[1];
        this.address = info[2];
        this.dateOfBirth = info[3];
    }
    //end constructors

    //setters
    public void setFname(String fname){
        this.firstName = fname;
    }
    public void setLname(String lname){
        this.lastName = lname;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setDob(String Dob){
        this.dateOfBirth = Dob;
    }
    //end setters

    //getters
    public String getFname(){
        return this.firstName;
    }

    public String getLname(){
        return this.lastName;
    }
    
    public String getAddress(){
        return this.address;
    }

    public String getDob(){
        return this.dateOfBirth;
    }
    //end getters
}

package dealership;
import java.io.Serializable;

public class Car implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String make;
    private String model;
    private String vinNumber;
    private String color;
    private String mileage;
    private String year;
    private String type; 
    private String bodyStyle;
    private String terrainType;
    private String price;

    //constructors
    public Car(String make, String model, String year){
        this.make = make;
        this.model = model;
        this.year = year;
    }   

    public Car(String[] details){
        this.make = details[0];
        this.model = details[1];
        this.price = details[2];
        this.color = details[3];
        this.mileage = details[4];
        this.year = details[5];
        this.type = details[6];
        this.bodyStyle = details[7];
        this.terrainType = details[8];
        this.vinNumber = details[9];
    }
    //end constructors

    //setters 
    public void setMake(String make){
        this.make = make;
    }
    public void serModel(String model){
        this.model = model;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public void setyear(String year){
        this.year = year;
    }
    public void setVin(String vin){
        this.vinNumber = vin;
    }
    public void setMileage(String mileage){
        this.mileage = mileage;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setBodyStyle(String style){
        this.bodyStyle = style;
    }
    public void setTerrain(String terrain){
        this.terrainType = terrain;
    }
    //end setter

    //getter
    public String getMake(){
        return this.make;
    }
    public String getModel(){
        return this.model;
    }
    public String getPrice(){
        return this.price;
    }
    public String getVin(){
        return this.vinNumber;
    }
    public String getColor(){
        return this.color;
    }
    public String getMileage(){
        return this.mileage;
    } 
    public String getyear(){
        return this.year;
    }
    public String type(){
        return this.type;
    }
    public String bodyStyle(){
        return this.bodyStyle;
    }
    public String getTerrainType(){
        return this.terrainType;
    }
    //end getters

    //bulk getter to get all info in string form
    public String[] getInfo(){
        String[] details = new String[10];
        details[0] = this.make;
        details[1] = this.model;
        details[2] = this.price;
        details[3] = this.color;
        details[4] = this.mileage;
        details[5] = this.year;
        details[6] = this.type;
        details[7] = this.bodyStyle;
        details[8] = this.terrainType;
        details[9] = this.vinNumber;
        return details;
    }

    public void printInfo(){
        System.out.printf("%20s %15s %6s %15s %7s %4s %5s %5s %7s %14s\n", this.make, this.model, this.price, this.color, 
                            this.mileage,this.year, this.type, this.bodyStyle, this.terrainType, this.vinNumber);
    }
    
    public String dispFormat() {
    	String a = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",this.make, this.model, this.price, this.color, 
                this.mileage,this.year, this.type, this.bodyStyle, this.terrainType, this.vinNumber);
    	return a;
    }
    //end bulk getters
    
}//end Car

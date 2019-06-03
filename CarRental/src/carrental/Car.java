        
package carrental;

public class Car {
    private String brand, numPlate, rental, charge;
    
    Car(String b, String n, String r, String c){
        brand = b;
        numPlate = n;
        rental = r;
        charge = c;
    }
    
    public String getBrand(){
        return this.brand;
    }
    public String getNumPlate(){
        return this.numPlate;
    }
    public String getRental(){
        return this.rental;
    }
    public String getCharge(){
        return this.charge;
    }
    
    public void setBrand(String b){
        brand = b;
    }
    public void setRental(String r){
        rental = r;
    }
    public void setCharge(String c){
        charge = c;
    }
}

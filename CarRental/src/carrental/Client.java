 
package carrental;

public class Client {
    private String name, ic, licenseNum, phoneNum;
    
    Client(String n, String i, String l, String p){
        name = n;
        ic = i;
        licenseNum = l;
        phoneNum = p;
    }
    
    public String getName(){
        return this.name;
    }
    public String getIC(){
        return this.ic;
    }
    public String getLicenseNum(){
        return this.licenseNum;
    }
    public String getPhoneNum(){
        return this.phoneNum;
    }
    
    public void setName(String n){
        name = n;
    }
    public void setLicenseNum(String l){
        licenseNum = l;
    }
    public void setPhoneNum(String p){
        phoneNum = p;
    }
}

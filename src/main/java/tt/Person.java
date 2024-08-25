package tt;

public class Person {
    private  String ID;
    private  String Name;
    private String email;

    private  String pass;

    private String phoneNum;
    private  String City;
    private  String Role;
    private String businessInfo;






    public Person(  String id,String un, String pa,String em, String city, String pn, String role) {
        ID=id;
        Name =un;
        pass=pa;
         email=em;
         City=city;
        phoneNum=pn;
        Role=role;
    }


    public String getID() {
        return ID;
    }
    public String getUserName() {
        return Name;
    }
    public String getPass() {
        return pass;
    }
    public String getCity(){return City;}
    public String getPhoneNum(){return phoneNum;}


    public String getEmail() {
        return email;
    }
    public String getRole() {
        return Role;
    }

    public Person() {

    }



    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setname(String Name) { 
        this.Name= Name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum=phoneNum;
    }

    public void setCity(String City) {
        this.City=City;
    }



    public String getBusinessInfo() {
        return businessInfo;
    }

    public void setBusinessInfo(String businessInfo) {
        this.businessInfo = businessInfo;
    }




}

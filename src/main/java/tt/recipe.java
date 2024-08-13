package tt;

public class recipe {
    private  String rename;
    private  String Descreption;
    private  String reid;
    private  String owner_of_recipe;
    public recipe(String rename, String Descreption , String reid, String owner_of_recipe) {
        this.rename = rename;
        this.reid = reid;
        this.Descreption = Descreption;
        this.owner_of_recipe=owner_of_recipe ;

    }

    public String getrename() {
        return rename;
    }

    public String  getreid() {
        return reid;
    }

    public String getDescreption() {
        return Descreption;
    }

    public  String getowner_of_recipe() {
        return  owner_of_recipe;
    }



    public void setrename(String rename ) {
        this.rename= rename;
    }

    public void setreid(String reid) {
        this.reid = reid;
    }

    public void setDescreption(String Descreption) {
        this.Descreption = Descreption;
    }

    public void setowner_of_recipe(String owner_of_recipe) {
        this.owner_of_recipe= owner_of_recipe;

    }

}

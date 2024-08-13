package tt;

public class product {
    private String productName;
    private String category;
    private double price;
    private int quantity;


    public product(String productName, String category, double price, int quantity) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity =quantity;


    }


    public String getproductName() {
        return productName;
    }

    public String getcategory() {
        return category;
    }

    public double getprice() {
        return price;
    }

    public int getquantity() {
        return quantity;
    }


    public void setproductName(String productName) {
        this.productName = productName;
    }


    public void setcategory(String category ) {
        this. category= category;
    }

    public void setprice(double price) {
        this.price = price;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }



}

package tt;



import java.util.Date;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class order {
    private String orderName;
    private Date date;
    private String description;
    private double total;
    private List<product> products;  // Using a list to hold multiple products

    // Constructor that initializes the order with multiple products
    public order(String orderName, Date date, String description, List<product> products) {
        this.orderName = orderName;
        this.date = date;
        this.description = description;
        this.products = products;
        this.total = calculateTotal(products); // Calculate total based on the products list
    }

    // Method to calculate the total price of the order
    private double calculateTotal(List<product> products) {
        double total = 0;
        for (product product : products)
            total += product.getprice() * product.getquantity();  // Assuming Product has getPrice and getQuantity methods
        return total;
    }

    // Getters
    public String getOrderName() {
        return orderName;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getTotal() {
        return total;
    }

    public List<product> getProducts() {
        return products;
    }

    // Setters
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Adding and removing products
    public void addProduct(product product) {
        this.products.add(product);
        this.total = calculateTotal(this.products);
    }

    public void removeProduct(product product) {
        this.products.remove(product);
        this.total = calculateTotal(this.products);
    }
}

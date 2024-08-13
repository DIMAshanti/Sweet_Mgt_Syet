package tt;

import java.util.Date;
import java.util.List;

public class Torder {

    private String orderName;
    private Date date;
    private String description;
    private double total;
    private List<Tproduct> products;  // Using a list to hold multiple products

    // Constructor that initializes the order with multiple products
    public Torder(String orderName, Date date, String description, List<Tproduct> products) {
        this.orderName = orderName;
        this.date = date;
        this.description = description;
        this.products = products;
        this.total = calculateTotal(products); // Calculate total based on the products list
    }

    // Method to calculate the total price of the order
    private double calculateTotal(List<Tproduct> products) {
        double total = 0;
        for (Tproduct product : products)
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

    public List<Tproduct> getProducts() {
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
    public void addProduct(Tproduct product) {
        this.products.add(product);
        this.total = calculateTotal(this.products);
    }

    public void removeProduct(Tproduct product) {
        this.products.remove(product);
        this.total = calculateTotal(this.products);
    }

}
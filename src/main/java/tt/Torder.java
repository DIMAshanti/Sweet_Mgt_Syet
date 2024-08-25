package tt;

import java.time.LocalDateTime;
import java.util.List;


public class Torder {
    private String oid;
    private String userEmail;
    private LocalDateTime orderTime;

    private double total;
    private List<Tproduct> products;


    public Torder(String oid, String userEmail, List<Tproduct> products) {
        this.oid = oid;
        this.userEmail = userEmail;
        this.orderTime = LocalDateTime.now();

        this.products = products;
        this.total = calculateTotal(products);
    }

    // Method to calculate the total price of the order
    private double calculateTotal(List<Tproduct> products) {
        double total = 0;
        for (Tproduct product : products) {
            total += product.getprice() * product.getquantity();
        }
        return total;
    }

    // Getters
    public String getOid() { return oid; }
    public String getUserEmail() { return userEmail; }
    public LocalDateTime getOrderTime() { return orderTime; }
   // public String getDescription() { return description; }
    public double getTotal() { return total; }
    public List<Tproduct> getProducts() { return products; }

    // Setters
   // public void setDescription(String description) { this.description = description; }

    // Adding and removing products
    public void addProduct(Tproduct product) {
        this.products.add(product);
        this.total = calculateTotal(this.products);
    }

    public void removeProduct(Tproduct product) {
        this.products.remove(product);
        this.total = calculateTotal(this.products);
    }

    @Override
    public String toString() {
        StringBuilder productDetails = new StringBuilder();
        for (Tproduct product : products) {
            productDetails.append(String.format("Product ID: %s, Name: %s, Quantity: %d, Price: %.2f\n",
                    product.getPid(), product.getproductName(), product.getquantity(), product.getprice()));
        }

        return String.format("Order ID: %s\nUser Email: %s\nOrder Time: %s\nTotal: %.2f\nProducts:\n%s",
                oid, userEmail, orderTime, total, productDetails.toString());
    }
}

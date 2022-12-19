package EcommerceAPITests.Pojo;

public class AddToCart {

    private String country;
    private Product product;

    public String getId() {
        return country;
    }

    public void setCountry(String id) {
        this.country = country;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

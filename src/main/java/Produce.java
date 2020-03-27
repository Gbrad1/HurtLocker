public class Produce {

    private String name;
    private String price;

    Produce(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String details = "name: %s Price: %s";
        details = String.format(details, getName(), getPrice());
        return details;
    }

}

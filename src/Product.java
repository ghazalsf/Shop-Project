public class Product {
    private int price;
    private int score;
    private String name;
    private String category;
    private String description;

    public Product(String name){
        this.name= name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

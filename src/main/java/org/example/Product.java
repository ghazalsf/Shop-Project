public class Product {
    private int price;
    private double score;
    private int stock;
    private String name;
    private String category;

    private String description;

    public Product(int price,double score,int stock,String name,String description){
        this.price=price;
        this.score=score;
        this.stock=stock;
        this.name=name;
        this.description=description;
    }

    public void setPrice(int price){
        this.price=price;
    }
    public void setScore(double score){
        this.score=score;
    }
    public void setStock(int stock){
        this.stock=stock;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public int getPrice(){
        return this.price;
    }
    public double getScore(){
        return this.score;
    }
    public int getStock(){
        return this.stock;
    }
    public String getName(){
        return this.name;
    }
    public  String getDescription(){
        return this.description;
    }
}

package demos.interfacejdk8;

public class Product {
    private int id;
    private String name;
    public Product(){
        System.out.println("inside ctr");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package Projekt;

public class Ogloszenie {
    private int id;

    private int price;

    private String title;

    private String description;

    public Ogloszenie(){};


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public int getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package Projekt;

public class Ogloszenie {
    private int id;

    private int price;

    private String title;

    private String tresc;

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

    public String getTresc() {
        return tresc;
    }
    public int getPrice() {
        return price;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
}

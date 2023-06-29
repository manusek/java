package Projekt;

import java.util.List;

public class MenuMieszkanie extends Menu {

    private List<OgloszenieMieszkanie> houseList = ZarzadzajBazaDanych.readHouseTable();

    boolean isValid = false;
    int num = 0;
    String choice;
    @Override
    public void addAdd() {
        System.out.println("=== Dodaj ogłoszenie ===");
        OgloszenieMieszkanie house = new OgloszenieMieszkanie();
        System.out.print("Wpisz tytuł: ");
        house.setTitle(InputS());

        System.out.print("Wpisz treść: ");
        house.setDescription(InputS());

        do {
            System.out.print("Podaj cene: ");
            choice = InputS();
            try {
                num = Integer.parseInt(choice);
                isValid = true;
                house.setPrice(num);
            }catch(NumberFormatException e)
            {
                System.out.println("Podano niewłaściwy typ");
            }
        }while(house.getPrice()<=0 || isValid == false);

        do {
            System.out.print("Podaj wielkosc: ");
            house.setSurface(Input());
        }while(house.getSurface()<=0);

        do {
            System.out.print("Podaj pietro: ");
            house.setFloorNumber(Input());
        }while(house.getFloorNumber()<0);

        house.setId(houseList.size() + 1);

        houseList.add(house);

        System.out.println("Ogłoszenie zostało dodane.");
    }

    @Override
    public void showAdd() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int houseID = Input();

        OgloszenieMieszkanie house = findHouseById(houseID);
        if (house != null) {
            System.out.println("ID: " + house.getId());
            System.out.println("Tytuł: " + house.getTitle());
            System.out.println("Tresc: " + house.getDescription());
            System.out.println("Cena: " + house.getPrice());
            System.out.println("Pietro: " + house.getFloorNumber());
            System.out.println("Wielkosc[m^2]: " + house.getSurface());
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    @Override
    public void editAdd() {
        System.out.println("=== Edytuj ogłoszenia ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int houseID = Input();

        OgloszenieMieszkanie house = findHouseById(houseID);
        if (house != null) {
            System.out.print("Wpisz nowy tytuł: ");
            house.setTitle(InputS());

            System.out.print("Wpisz nową treść: ");
            house.setDescription(InputS());

            System.out.print("Podaj nową cene: ");
            house.setPrice(Input());

            System.out.print("Podaj nowe pietro: ");
            house.setFloorNumber(Input());

            System.out.print("Podaj nową wielkosc: ");
            house.setSurface(Input());

            System.out.println("Ogłoszenie zostało zaaktualizowane.");
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    @Override
    public void deleteAdd() {
        System.out.println("=== Usuń ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int houseID = Input();

        OgloszenieMieszkanie house = findHouseById(houseID);
        if (house != null) {
            houseList.remove(house);
            System.out.println("Ogłoszenie zostało usunięte.");
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    @Override
    public void showAllAds() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.println("Lista ogłoszen ");
        System.out.println("-----------------------");

        for (OgloszenieMieszkanie house : houseList) {
            System.out.println("ID: " + house.getId());
            System.out.println("Tytuł: " + house.getTitle());
            System.out.println("Tresc: " + house.getDescription());
            System.out.println("Cena: " + house.getPrice());
            System.out.println("Pietro: " + house.getFloorNumber());
            System.out.println("Wielkosc[m^2] : " + house.getSurface());
            System.out.println("-----------------------");
        }
    }

    @Override
    public void exitTable() {
        ZarzadzajBazaDanych.saveHouseTable(houseList);
    }

    private OgloszenieMieszkanie findHouseById(int id) {
        for (OgloszenieMieszkanie house : houseList) {
            if (house.getId() == id) {
                return house;
            }
        }
        return null;
    }
}

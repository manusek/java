package Projekt;

import java.util.List;

public class MenuSamochod extends Menu {

    private List<OgloszenieSamochod> carList = ZarzadzajBazaDanych.readCarsTable();
    @Override
    public void addAdd() {
        System.out.println("=== Dodaj ogłoszenie ===");
        OgloszenieSamochod car = new OgloszenieSamochod();
        System.out.print("Wpisz tytuł: ");
        car.setTitle(InputS());

        System.out.print("Wpisz treść: ");
        car.setDescription(InputS());

        do {
            System.out.print("Podaj cene: ");
            car.setPrice(Input());
        } while (car.getPrice() < 0);

        do {
            System.out.print("Podaj przebieg: ");
            car.setCarMileage(Input());
        } while (car.getCarMileage() < 0);

        do {
            System.out.print("Podaj rok produkcji: ");
            car.setYearOfProduction(Input());
        }while (car.getYearOfProduction() < 0) ;

            car.setId(carList.size() + 1);

            carList.add(car);

            System.out.println("Ogłoszenie zostało dodane.");
        }

    @Override
    public void showAdd() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int carId = Input();

        OgloszenieSamochod car = findCarById(carId);
        if (car != null) {
            System.out.println("ID: " + car.getId());
            System.out.println("Tytuł: " + car.getTitle());
            System.out.println("Tresc: " + car.getDescription());
            System.out.println("Cena: " + car.getPrice());
            System.out.println("Przebieg: " + car.getCarMileage());
            System.out.println("Rok produkcji: " + car.getYearOfProduction());
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    @Override
    public void editAdd() {
        System.out.println("=== Edytuj ogłoszenia ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int carID = Input();

        OgloszenieSamochod car = findCarById(carID);
        if (car != null) {
            System.out.print("Wpisz nowy tytuł: ");
            car.setTitle(InputS());

            System.out.print("Wpisz nową treść: ");
            car.setDescription(InputS());

            System.out.print("Podaj nową cene: ");
            car.setPrice(Input());

            System.out.print("Podaj nowy przebieg: ");
            car.setCarMileage(Input());

            System.out.print("Podaj nowy rok produkcji: ");
            car.setYearOfProduction(Input());

            System.out.println("Ogłoszenie zostało zaaktualizowane.");
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    @Override
    public void deleteAdd() {
        System.out.println("=== Usuń ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int carID = Input();

        OgloszenieSamochod car = findCarById(carID);
        if (car != null) {
            carList.remove(car);
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

        for (OgloszenieSamochod car : carList) {
            System.out.println("ID: " + car.getId());
            System.out.println("Tytuł: " + car.getTitle());
            System.out.println("Tresc: " + car.getDescription());
            System.out.println("Cena: " + car.getPrice());
            System.out.println("Przebieg: " + car.getCarMileage());
            System.out.println("Rok produkcji : " + car.getYearOfProduction());
            System.out.println("-----------------------");
        }
    }

    @Override
    public void exitTable() {
        ZarzadzajBazaDanych.saveCarsTable(carList);
    }

    private OgloszenieSamochod findCarById(int id) {
        for (OgloszenieSamochod car : carList) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }


}

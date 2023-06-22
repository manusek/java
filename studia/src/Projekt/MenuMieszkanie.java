package Projekt;

import java.util.List;

public class MenuMieszkanie extends Menu {

    private List<OgloszenieMieszkanie> mieszkanieList = ZarzadzajBazaDanych.odczytajMieszkanieOgloszenia();

    @Override
    public void DodajOgloszenie() {
        System.out.println("=== Dodaj ogłoszenie ===");
        OgloszenieMieszkanie mieszkanie = new OgloszenieMieszkanie();
        System.out.print("Wpisz tytuł: ");
        mieszkanie.setTitle(InputS());

        System.out.print("Wpisz treść: ");
        mieszkanie.setTresc(InputS());

        System.out.print("Podaj cene: ");
        mieszkanie.setPrice(Input());

        System.out.print("Podaj wielkosc: ");
        mieszkanie.setWielkosc(Input());

        System.out.print("Podaj pietro: ");
        mieszkanie.setPietro(Input());

        mieszkanie.setId(mieszkanieList.size() + 1);

        mieszkanieList.add(mieszkanie);

        System.out.println("Ogłoszenie zostało dodane.");
    }

    @Override
    public void WyswietlOgloszenie() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int mieszkanieID = Input();

        OgloszenieMieszkanie mieszkanie = findMieszkanieById(mieszkanieID);
        if (mieszkanie != null) {
            System.out.println("ID: " + mieszkanie.getId());
            System.out.println("Tytuł: " + mieszkanie.getTitle());
            System.out.println("Tresc: " + mieszkanie.getTresc());
            System.out.println("Cena: " + mieszkanie.getPrice());
            System.out.println("Pietro: " + mieszkanie.getPietro());
            System.out.println("Wielkosc[m^2]: " + mieszkanie.getWielkosc());
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    @Override
    public void EdytujOgloszenie() {
        System.out.println("=== Edytuj ogłoszenia ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int mieszkanieID = Input();

        OgloszenieMieszkanie mieszkanie = findMieszkanieById(mieszkanieID);
        if (mieszkanie != null) {
            System.out.print("Wpisz nowy tytuł: ");
            mieszkanie.setTitle(InputS());

            System.out.print("Wpisz nową treść: ");
            mieszkanie.setTresc(InputS());

            System.out.print("Podaj nową cene: ");
            mieszkanie.setPrice(Input());

            System.out.print("Podaj nowe pietro: ");
            mieszkanie.setPietro(Input());

            System.out.print("Podaj nową wielkosc: ");
            mieszkanie.setWielkosc(Input());

            System.out.println("Ogłoszenie zostało zaaktualizowane.");
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    @Override
    public void UsunOgloszenie() {
        System.out.println("=== Usuń ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int mieszkanieID = Input();

        OgloszenieMieszkanie mieszkanie = findMieszkanieById(mieszkanieID);
        if (mieszkanie != null) {
            mieszkanieList.remove(mieszkanie);
            System.out.println("Ogłoszenie zostało usunięte.");
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    @Override
    public void WyswietlWszystkieOgloszenia() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.println("Lista ogłoszen ");
        System.out.println("-----------------------");

        for (OgloszenieMieszkanie mieszkanie : mieszkanieList) {
            System.out.println("ID: " + mieszkanie.getId());
            System.out.println("Tytuł: " + mieszkanie.getTitle());
            System.out.println("Tresc: " + mieszkanie.getTresc());
            System.out.println("Cena: " + mieszkanie.getPrice());
            System.out.println("Pietro: " + mieszkanie.getPietro());
            System.out.println("Wielkosc[m^2] : " + mieszkanie.getWielkosc());
            System.out.println("-----------------------");
        }
    }

    @Override
    public void ZakonczOgloszenia() {
        ZarzadzajBazaDanych.zapiszMieszkanieOgloszenia(mieszkanieList);
    }

    private OgloszenieMieszkanie findMieszkanieById(int id) {
        for (OgloszenieMieszkanie mieszkanie : mieszkanieList) {
            if (mieszkanie.getId() == id) {
                return mieszkanie;
            }
        }
        return null;
    }
}

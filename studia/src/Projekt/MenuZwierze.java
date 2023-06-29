package Projekt;

import java.util.List;

public class MenuZwierze extends Menu{
    private List<OgloszenieZwierze> animalList = ZarzadzajBazaDanych.readAnimalsTable();

    @Override
    public void addAdd() {
        System.out.println("=== Dodaj ogłoszenie ===");
        OgloszenieZwierze animal = new OgloszenieZwierze();
        System.out.print("Wpisz tytuł: ");
        animal.setTitle(InputS());

        System.out.print("Wpisz treść: ");
        animal.setDescription(InputS());

        do {
            System.out.print("Podaj cene: ");
            animal.setPrice(Input());
        }while(animal.getPrice()<0);

        System.out.print("Podaj gatunek: ");
        animal.setSpeciesOfAnimal(InputS());

        do {
            System.out.print("Podaj rok wiek (lata): ");
            animal.setAge(Input());
        }while(animal.getAge()<0);

        animal.setId(animalList.size() + 1);

        animalList.add(animal);

        System.out.println("Ogłoszenie zostało dodane.");
    }

    @Override
    public void showAdd() {
        System.out.println("=== Wyświetl ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int animalID = Input();

        OgloszenieZwierze animal = findAnimalById(animalID);
        if (animal != null) {
            System.out.println("ID: " + animal.getId());
            System.out.println("Tytuł: " + animal.getTitle());
            System.out.println("Tresc: " + animal.getDescription());
            System.out.println("Cena: " + animal.getPrice());
            System.out.println("Gatunek: " + animal.getSpeciesOfAnimal());
            System.out.println("Wiek: " + animal.getAge());
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    @Override
    public void editAdd() {
        System.out.println("=== Edytuj ogłoszenia ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int animalID = Input();

        OgloszenieZwierze animal = findAnimalById(animalID);
        if (animal != null) {
            System.out.print("Wpisz nowy tytuł: ");
            animal.setTitle(InputS());

            System.out.print("Wpisz nową treść: ");
            animal.setDescription(InputS());

            System.out.print("Podaj nową cene: ");
            animal.setPrice(Input());

            System.out.print("Podaj nowy gatunek: ");
            animal.setSpeciesOfAnimal(InputS());

            System.out.print("Podaj nowy wiek: ");
            animal.setAge(Input());

            System.out.println("Ogłoszenie zostało zaaktualizowane.");
        } else {
            System.out.println("Nie znaleziono ogłoszenia.");
        }
    }

    @Override
    public void deleteAdd() {
        System.out.println("=== Usuń ogłoszenie ===");
        System.out.print("Podaj ID ogłoszenia: ");
        int animalID = Input();

        OgloszenieZwierze animal = findAnimalById(animalID);
        if (animal != null) {
            animalList.remove(animal);
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

        for (OgloszenieZwierze animal : animalList) {
            System.out.println("ID: " + animal.getId());
            System.out.println("Tytuł: " + animal.getTitle());
            System.out.println("Tresc: " + animal.getDescription());
            System.out.println("Cena: " + animal.getPrice());
            System.out.println("Gatunek: " + animal.getSpeciesOfAnimal());
            System.out.println("Wiek: " + animal.getAge());
            System.out.println("-----------------------");
        }
    }

    @Override
    public void exitTable() {
        ZarzadzajBazaDanych.saveAnimalsTable(animalList);
    }

    private OgloszenieZwierze findAnimalById(int id) {
        for (OgloszenieZwierze animal : animalList) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }
}

package algorytmy2;

import java.util.LinkedList;

public class linkedListList {
    public static void main(String[] args) {
        LinkedListList theList = new LinkedListList();

        theList.pushFirst(22);       // wstawiamy na poczatek
        theList.pushFirst(44);
        theList.pushFirst(66);

        theList.pushLast(11);        // wstawiamy na koniec
        theList.pushLast(33);
        theList.pushLast(55);

        theList.print();         // wypisujemy zawartosc listy

        theList.deleteFirst();         // usuwamy pierwsze dwa elementy
        theList.deleteFirst();

        theList.print();         // wypisujemy ponownie

        theList.deleteLast(); //usuwamy ostatni element

        theList.print();         // wypisujemy ponownie
    }

    public static class LinkedListList {
        private LinkedList<Integer> list;

        public LinkedListList()          // konstruktor
        {
            list = new LinkedList<Integer>();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }


        public void pushFirst(int element){
            list.addFirst(element);
        }

        public void pushLast(int element){
            list.addLast(element);
        }

        public int deleteFirst(){
            return list.removeFirst();
        }

        public int deleteLast(){
            return list.removeLast();
        }

        public int getFirst(){
            return list.getFirst();
        }

        public int getLast(){
            return list.getLast();
        }

        public int size(){
            return list.size();
        }

        public void print(){
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i) + "");
            }
        }



    }
}

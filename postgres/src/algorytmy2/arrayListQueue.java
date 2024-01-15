package algorytmy2;

//Implementacja kolejki liczb calkowitych za pomoca klasy ArrayList przez OSADZANIE

import java.util.ArrayList;


public class arrayListQueue {
    public static void main(String[] args) {
        ArrayListQueue theQueue = new ArrayListQueue();  // kolejka pięcioelementowa z relokacja

        System.out.println("Wstawiam: 10");
        theQueue.push(10);
        System.out.println("Wstawiam: 20");
        theQueue.push(20);
        System.out.println("Wstawiam: 30");
        theQueue.push(30);
        System.out.println("Wstawiam: 40");
        theQueue.push(40);

        int elem = theQueue.remove();              // usuwamy 3 elementy
        System.out.println(" Usuwam: " + elem);
        System.out.println(" Usuwam: " + theQueue.remove());
        System.out.println(" Usuwam: " + theQueue.remove());

        System.out.println("Wstawiam: 50");
        theQueue.push(50);
        System.out.println("Wstawiam: 60");
        theQueue.push(60);
        System.out.println("Wstawiam: 70");
        theQueue.push(70);
        System.out.println("Wstawiam: 80");
        theQueue.push(80);

        while (!theQueue.isEmpty())    // usuwamy i wypisujemy...
        {                            // ...wszystkie elementy
            System.out.println(" Usuwam: " + theQueue.remove());
        }
        System.out.println("");
    }

    public static class ArrayListQueue{
        private ArrayList<Integer> listQueue;

        public ArrayListQueue() {
            listQueue = new ArrayList<Integer>();
        }

        public void push(int element){
            listQueue.add(element);
        }

        public int peek(){
            return listQueue.get(0).intValue();
        }

        public boolean isEmpty(){
            return listQueue.isEmpty();
        }

        public int remove(){
            int firsElement = listQueue.get(0).intValue();
            listQueue.remove(0);
            return firsElement;
        }

        public int size(){
            return listQueue.size();
        }
    }


}

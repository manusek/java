package algorytmy2;

import java.util.LinkedList;

public class linkedListQueue {
    public static void main(String[] args) {
        LinkedListQueue theQueue = new LinkedListQueue();  // kolejka

        System.out.println("Wstawiam: 10");
        theQueue.push(10);
        System.out.println("Wstawiam: 20");
        theQueue.push(20);
        System.out.println("Wstawiam: 30");
        theQueue.push(30);
        System.out.println("Wstawiam: 40");
        theQueue.push(40);

        int elem = theQueue.remove();              // usuwamy 3 elementy
        System.out.println(" Usuwam: "+elem);
        System.out.println(" Usuwam: "+theQueue.remove());
        System.out.println(" Usuwam: "+theQueue.remove());

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
            System.out.println(" Usuwam: "+theQueue.remove());
        }
        System.out.println("");
    }

    public static class LinkedListQueue{
        private LinkedList<Integer> listQueue;

        public LinkedListQueue() {
            listQueue = new LinkedList<Integer>();
        }

        public void push(int element){
            listQueue.add(element);
        }

        public int peek(){
            return listQueue.peekFirst().intValue();
        }

        public boolean isEmpty(){
            return listQueue.isEmpty();
        }

        public int size(){
            return listQueue.size();
        }

        public int remove(){
            int firstElement = listQueue.peekFirst().intValue();
            listQueue.removeFirst();
            return firstElement;
        }
    }


}

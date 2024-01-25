package agortymyPoprawka;

import java.util.LinkedList;

public class z6 {
    public static void main(String[] args) {
        IHashTable1 hashTable = new IHashTable1(10);

        hashTable.add(1);
        hashTable.add(11);
        hashTable.add(2);
        hashTable.add(32);
        hashTable.add(42);
        hashTable.add(3);
        hashTable.add(33);
        hashTable.add(4);
        hashTable.add(3);

        hashTable.print();

        boolean result1 = hashTable.find(11);
        System.out.println("Wynik wyszukiwania 3:" + result1);

        hashTable.delete(3);

        hashTable.print();
//
        boolean result2 = hashTable.find(33);
        System.out.println("Wynik wyszukiwania 3:" + result2);
    }

    public static class IHashTable1 {
        private LinkedList[] list;
        private int listSize;

        public IHashTable1(int size) {
            list = new LinkedList[size];
            listSize = size;
            for (int i = 0; i < size; i++) {
                list[i] = new LinkedList();
            }
        }

        public LinkedList getList(int element) {
            return list[element];
        }

        public int size() {
            return listSize;
        }

        public int hashFUNC(int element) {
            return element % listSize;
        }

        public void add(int element) {
            int hashVAL = hashFUNC(element);
            if (!list[hashVAL].contains(element)) {
                list[hashVAL].addFirst(element);
            }
        }

        public void delete(int element) {
            int hashVAL = hashFUNC(element);
            list[hashVAL].remove((Object) element);
        }

        public boolean find(int element) {
            int hashVAL = hashFUNC(element);
            return list[hashVAL].contains(element);
        }

        public void print(){
            for (int i = 0; i < size(); i++) {
                for (Object val : getList(i)){
                    System.out.println(val.toString());
                }
            }
        }
    }
}


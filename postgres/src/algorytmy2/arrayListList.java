package algorytmy2;

import java.util.ArrayList;

public class arrayListList {
    public static void main(String[] args) {
        ArrayListList theList = new ArrayListList();

        theList.addLast(234);
        theList.addLast(23);
        theList.addLast(2444);
        theList.addLast(2344444);
        theList.addLast(25);
        theList.addLast(1);
        theList.print();
        System.out.println("");

        System.out.println(theList.get(3));
        System.out.println("");

        theList.print();
        System.out.println("");

        System.out.println(theList.removeLast());
        System.out.println("");

        System.out.println(theList.find(23));
        System.out.println("");

        theList.print();
        System.out.println("");
    }

    public static class ArrayListList {
        private ArrayList<Integer> listList;

        public ArrayListList() {
            listList = new ArrayList<Integer>();
        }

        public boolean addLast(int element){
            return listList.add(element);
        }

        public int removeLast(){
            int lastElement = listList.size() - 1;
            return listList.remove(lastElement);
        }

        public int size(){
            return listList.size();
        }

        public int find(int element){
            return listList.indexOf(element);
        }

        public int get(int element){
            return listList.get(element);
        }

        public void print(){
            for (int i = 0; i < listList.size(); i++) {
                System.out.println(listList.get(i));
            }
        }
    }
}

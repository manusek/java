package algorytmy2;

import java.util.ArrayList;

public class arrayListList {
    public static void main(String[] args) {
        ArrayListListt theList = new ArrayListListt();

        theList.push(234);
        theList.push(23);
        theList.push(2444);
        theList.push(2344444);
        theList.push(25);
        theList.push(1);
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

        public boolean pushLast(int element) {
            return listList.add(element);
        }

        public int removeLast() {
            int a = listList.get(listList.size() - 1);
            return listList.remove(a);
        }

        public int size() {
            return listList.size();
        }

        public int find(int element) {
            return listList.indexOf(element);
        }

        public int get(int element) {
            return listList.get(element);
        }

        public void print() {
            for (int i = 0; i < listList.size(); i++) {
                System.out.println(listList.get(i) + " ");
            }
        }
    }

    public static class ArrayListListt{
        private ArrayList<Integer> list;

        public ArrayListListt() {
            list = new ArrayList<Integer>();
        }

        public boolean push(int element){
            return list.add(element);
        }

        public int removeLast(){
            int a = list.size() - 1;
            return list.remove(a);
        }

        public int size(){
            return list.size();
        }

        public int find(int element){
            return list.indexOf(element);
        }

        public int get(int element){
            return list.get(element);
        }

        public void print(){
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i) + " ");
            }
        }
    }
}

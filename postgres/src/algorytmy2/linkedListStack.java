package algorytmy2;

import java.util.LinkedList;

public class linkedListStack {
    public static void main(String[] args) {
        LinkedListStack xd = new LinkedListStack();

        xd.push(1);
        xd.push(3);
        xd.push(4);
        xd.push(5);
        xd.push(7);

        while(!xd.isEmpty()){
            int value = xd.pop();
            System.out.println(value + " ");
        }
    }

   public static class LinkedListStack{
        private LinkedList<Integer> listStack;

       public LinkedListStack() {
           listStack = new LinkedList<Integer>();
       }

       public void push(int element){
           listStack.add(element);
       }

       public int pop(){
           return listStack.pop();
       }

       public int peek(){
           return listStack.peek();
       }

       public boolean isEmpty(){
           return listStack.isEmpty();
       }
   }

}

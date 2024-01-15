package algorytmy2;

import java.util.ArrayList;

public class arrayListStack {
    public static void main(String[] args) {
        // czesc B
        //1 na 3
        //2 na 3
        //3 na 3
        //4 na 3
        //5 na 4
        //6 na 4
        //8 na 3
        //9 na 3

        ArrayListStack xd = new ArrayListStack();

        xd.push(123);
        xd.push(3);
        xd.push(3);
        xd.push(5);
        xd.push(6);

        while (!xd.isEmpty()){
            int v = xd.pop();
            System.out.println(v + " ");
        }

    }

  public static class ArrayListStack{
        private ArrayList<Integer> arrayList;

      public ArrayListStack() {
          arrayList = new ArrayList<Integer>();
      }

      public void push(int element){
          arrayList.add(element);
      }

      public int pop(){
          int elementTop = arrayList.get(arrayList.size() - 1);
          arrayList.remove(arrayList.size() - 1);
          return elementTop;
      }

      public int peek(){
          return arrayList.get(arrayList.size() - 1);
      }

      public boolean isEmpty(){
          return arrayList.isEmpty();
      }

  }


}

package agortymyPoprawka;

public class z2 {
    public static void main(String[] args) {
        OrdIntDynArray xd = new OrdIntDynArray(6);

        System.out.println("rozmiar" + xd.size());

//        xd.add2(3);
//        xd.add2(445);
//        xd.add2(65);
//        xd.add2(345);
//        xd.add2(67);
//        xd.add2(0);

        xd.add(3);
        xd.add(445);
        xd.add(65);
        xd.add(345);
        xd.add(67);
        xd.add(0);


        System.out.println("rozmiar" + xd.size());

        xd.print();

        xd.remove(3);
        xd.print();
    }

    public static class OrdIntDynArray {
        static private int[] table;
        private int nElems;

        public OrdIntDynArray(int maxSize) {
            table = new int[maxSize];
            nElems = 0;
        }

        public void add(int element) {
            if (element >= nElems) {
                int[] localTable = new int[table.length * 2];
                for (int i = 0; i < table.length; i++) {
                    localTable[i] = table[i];
                }
                table = localTable;
            }
            int j;
            for (j = 0; j < nElems; j++) {
                if (table[j] > element) break;
            }
            for (int k = nElems; k > j; k--) {
                table[k] = table[k - 1];
            }
            table[j] = element;
            nElems++;
        }

        public boolean remove(int element) {
            if (nElems == 0 || element >= nElems || element < 0) {
                return false;
            }
            for (int i = element; i < nElems - 1; i++) {
                table[i] = table[i + 1];
            }
            nElems--;
            return true;
        }

        public int find(int element) {
            int left = 0;
            int right = nElems - 1;
            int current;

            while (true) {
                current = (right + left) / 2;

                if (table[current] == element) return current;
                else {
                    if (left > right) return -1;
                    else {
                        if (table[current] < element){
                            left = current + 1;
                        }
                        else {
                            right = current - 1;
                        }
                    }
                }
            }
        }

        public void print(){
            for (int i = 0; i < nElems; i++) {
                System.out.println(table[i]);
            }
        }

        public int size(){
            return nElems;
        }

        public int get(int element){
            return table[element];
        }
    }
}

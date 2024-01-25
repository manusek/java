package agortymyPoprawka;

public class z1 {
    public static void main(String[] args) {
        IntDynArray xd = new IntDynArray(5);

        System.out.println("rozmiar" + xd.size());

        xd.add(3);
        xd.add(4);
        xd.add(7);
        xd.add(9);
        xd.add(312);

        System.out.println("rozmiar" + xd.size());
        xd.print();

        xd.remove(3);

        System.out.println("rozmiar" + xd.size());
        xd.print();

        System.out.println("szukanie" + xd.find(312));
    }

    public static class IntDynArray {
        static private int[] table;

        private int nElems;

        public IntDynArray(int maxSize) {
            table = new int[maxSize];
            nElems = 0;
        }

        public void add(int element) {
            if (element >= nElems){
                int[] localTable = new int[table.length * 2];
                for (int i = 0; i < table.length; i++) {
                    localTable[i] = table[i];
                }
                table = localTable;
            }
            table[nElems] = element;
            nElems++;
        }

        public boolean remove(int element){
            if (nElems == 0 || element >= nElems || element < 0){
                return false;
            }
            for (int i = element; i < nElems - 1; i++) {
                table[i] = table[i + 1];
            }
            nElems--;
            return true;
        }

        public int find(int element){
            for (int i = 0; i < nElems; i++) {
                if (table[i] == element) return element;
            }
            return -1;
        }

        public int get(int element){
            return table[element];
        }

        public int size(){
            return nElems;
        }

        public void print(){
            for (int i = 0; i < nElems; i++) {
                System.out.println(table[i]);
            }
        }
    }
}

package algorytmy;

public class DZ_epidemia {
    public static void main(String[] args) {
        final int dni = 7;
        System.out.println("zdrowych zostalo: " + (10000 - epidemia(dni)));
        System.out.println("chorych zostalo: " + (epidemia(dni)));
    }
    static int epidemia(int dni){
        if(dni == 1) return 10;
        else{
            return (2*epidemia(dni - 1) + epidemia(dni-1));
        }
    }
}

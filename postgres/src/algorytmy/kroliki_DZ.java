package algorytmy;

public class kroliki_DZ {
    public static void main(String[] args) {
        System.out.println(kroliki(5));
    }
    static int kroliki(int miesiac){
        if(miesiac == 0 || miesiac == 1)return 1;
        else
            return kroliki(miesiac - 2) + kroliki(miesiac - 1);
    }
}

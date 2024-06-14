import java.util.*;

public class No_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[5];
        System.out.print("Masukkan Array a : ");
        for (int i = 0;i<a.length;i++){
            a[i] = in.nextInt();
        }
        int b = a[2];
        a[2] = a[4];
        a[4] = b;

        System.out.print("Apabila index a[2] dengan a[4] dibalik akan menjadi : " +Arrays.toString(a));
    }

}

import java.util.*;

public class No_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // int[] a = new int[10];
        // System.out.print("Array a adalah : ");
        // for(int i = 0; i<a.length; i++){
        // a[i] = in.nextInt();
        // }
        // System.out.print("Array a ketika dibalik akan menjadi : ");
        // for (int i = a.length-1 ; i >= 0;i--){
        // System.out.print(a[i]+" ");
        // }

        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.toString(a));

        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
    }
}

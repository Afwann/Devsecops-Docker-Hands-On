import java.util.*;

public class No_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Silahkan masukkan panjang matriks :");
        int index = in.nextInt();
        int[][] a = new int[index][index];
        int[][] b = new int[index][index];
        int[][] c = new int[index][index];

        System.out.print("silahkan masukkan nilai matriks a : ");
        for (int i = 0; i < a.length; i++) {
            for (int x = 0; x < a[i].length; x++) {
                a[i][x] = in.nextInt();
            }
        }

        System.out.print("Silahkan masukkan nilai matriks b : ");
        for (int i = 0; i < b.length; i++) {
            for (int x = 0; x < b[i].length; x++) {
                b[i][x] = in.nextInt();
            }
        }

        System.out.println("Penjumlahan matriks a dan b adalah : ");
        for (int i = 0; i < c.length; i++) {
            for (int x = 0; x < c[i].length; x++) {
                System.out.print(c[i][x] + " ");
            }
            System.out.println("");
        }

    }
}
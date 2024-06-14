import java.util.*;
import java.text.*;

public class Kasus1_1 {
  public static void main(String[] args) {
    /*
     * Afwan Mulia Pratama
     * 21515020111059
     * Kelas F
     */
    Scanner in = new Scanner(System.in);
    System.out.println("Selamat datang di FILKOM-MART");
    System.out.println("-----------------------------");
    System.out.print("Masukkan Jumlah barang : ");
    double JmlhBarang = in.nextDouble(); // input nilai jumlah barang
    System.out.print("Masukkan Harga barang  : Rp");
    double HargaBarang = in.nextDouble(); // input nilai harga barang

    // total harga Barang
    double Total = JmlhBarang * HargaBarang;
    String Total2 = NumberFormat.getCurrencyInstance(new Locale("id", "ID")).format(Total);
    System.out.println("Total Pembayaran       : " + Total2);
    System.out.println("");
    System.out.print("Terima Kasih telah berbelanja, silakan datang kembali.");
    in.close();
  }

}

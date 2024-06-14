import java.util.*;
import java.text.*;

public class FilkomRail {
    static Scanner in = new Scanner(System.in);
    static String Border1 = "========================================================";
    static String Border2 = "--------------------------------------------------------";
    static String[] Formatting = new String[99];

    public static void main(String[] args) {
        Input();
    }

    public static void Input() {
        System.out.println(Border1);
        System.out.printf("%34s\n", "FILKOM RAIL EXPRESS");
        System.out.printf("%40s\n", "PROGRAM PEMESANAN TIKET KERETA");
        System.out.println(Border1);

        System.out.println(Border2);
        System.out.println("Silakan masukkan data diri");
        System.out.println(Border2);
        System.out.printf("%-24s%s", "Nama", ": ");
        String nama = in.nextLine();
        System.out.printf("%-24s%s", "Nomor KTP", ": ");
        String ktp = in.nextLine();
        System.out.printf("%-24s%s", "Alamat", ": ");
        String alamat = in.nextLine();
        System.out.printf("%-24s%s", "Nomor Telepon", ": ");
        String notelp = in.nextLine();
        System.out.printf("%-24s%s", "Tanggal keberangkatan", ": ");
        String brngkt = in.nextLine();
        System.out.printf("%-24s%s", "Stasiun asal", ": ");
        String asal = in.nextLine();
        System.out.printf("%-24s%s", "Stasiun tujuan", ": ");
        String tujuan = in.nextLine();
        System.out.printf("%-24s%s", "Jumlah tiket", ": ");
        int tiket = in.nextInt();
        System.out.printf("%-24s%s", "Nominal pembayaran", ": ");
        double bayar = in.nextDouble();

        Formatting(nama, ktp, alamat, notelp, brngkt, asal, tujuan, tiket, bayar);
        Pembayaran(bayar, tiket);
    }

    public static void Formatting(String nama, String ktp, String alamat, String notelp, String brngkt, String asal,
            String tujuan, int tiket, double bayar) {

        String namaS = String.format("%s", nama);
        String ktpS = String.format("%s", ktp);
        String alamatS = String.format("%s", alamat);
        String notelpS = String.format("%s", notelp);
        String brngktS = String.format("%s", brngkt);
        String asalS = String.format("%s", asal);
        String tujuanS = String.format("%s", tujuan);
        String tiketS = String.format("%s", tiket);
        String bayarS = String.format("%s", bayar);

        Formatting[0] = namaS;
        Formatting[1] = ktpS;
        Formatting[2] = alamatS;
        Formatting[3] = brngkt;
        Formatting[4] = asalS;
        Formatting[5] = tujuanS;
        Formatting[6] = tiketS;
        Formatting[7] = bayarS;
    }

    public static void Pembayaran(Double bayar, int tiket) {
        double total = tiket * 50000;
        Double kembalian = bayar - total;
        NumberFormat Rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        String kembalianRP = Rupiah.format(kembalian);
        String bayarRp = Rupiah.format(bayar);
        String totalRp = Rupiah.format(total);
        Formatting[8] = kembalianRP;
        Formatting[9] = bayarRp;
        Formatting[10] = totalRp;

        Hasil(bayar, total);
    }

    public static void Hasil(double bayar, double total) {
        if (bayar < total) {
            System.out.println(Border1);
            System.out.println("UANG TIDAK MENCUKUPI\n");
            System.out.println(Border1);
        } else {
            System.out.println(Border1);
            System.out.println("\nPemesanan Tiket Berhasil !\n");
            System.out.println(Border1);
            System.out.printf("%34s\n", "DETAIL PEMESANAN");
            System.out.println(Border1);
            System.out.printf("%-24s%s%s\n", "Nama", ": ", Formatting[0]);
            System.out.printf("%-24s%s%s\n", "Nomor KTP", ": ", Formatting[2]);
            System.out.printf("%-24s%s%s\n", "Alamat", ": ", Formatting[3]);
            System.out.printf("%-24s%s%s\n", "Nomor Telepon", ": ", Formatting[4]);
            System.out.printf("%-24s%s%s\n", "Tanggal keberangkatan", ": ", Formatting[5]);
            System.out.printf("%-24s%s%s%s%s\n", "Rute", ": ", Formatting[4], " - ", Formatting[5]);
            System.out.printf("%-24s%s%s\n\n", "Jumlah tiket", ": ", Formatting[6]);
            System.out.printf("%-24s%s%s%s\n", "Total harga", ": ", Formatting[10], ",-");
            System.out.printf("%-24s%s%s%s\n", "Nominal pembayaran", ": ", Formatting[9], ",-");
            System.out.printf("%-24s%s%s%s\n", "Kembalian", ": ", Formatting[8], ",-");
            System.out.println(Border1);
            System.out.println("Selamat menikmati perjalanan anda");
        }
    }
}

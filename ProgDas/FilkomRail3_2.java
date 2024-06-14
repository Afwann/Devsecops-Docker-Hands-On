import java.text.*;
import java.util.*;

public class FilkomRail3_2 {
    public static void main(String[] args) {
        String Border1 = "========================================================";
        String Border2 = "--------------------------------------------------------";
        Scanner in = new Scanner(System.in);

        System.out.println(Border1);
        System.out.printf("%34s\n", "FILKOM RAIL EXPRESS");
        System.out.printf("%40s\n", "PROGRAM PEMESANAN TIKET KERETA");
        System.out.println(Border1);

        System.out.println(Border2);
        System.out.println("Silahkan masukkan data diri");
        System.out.println(Border2);
        System.out.printf("%-24s%s", "Nama", ": ");
        String nama = in.nextLine();
        System.out.printf("%-24s%s", "Nomor KTP", ": ");
        String ktp = in.nextLine();
        System.out.printf("%-24s%s", "Alamat", ": ");
        String alamat = in.nextLine();
        System.out.printf("%-24s%s", "Nomor Telepon", ": ");
        String notelp = in.nextLine();
        System.out.println("");
        System.out.println(Border2);
        System.out.println("Silahkan masukkan data tiket");
        System.out.println(Border2);
        System.out.println("");
        System.out.println("List Stasiun Tersedia :");
        System.out.println("1. Malang       4. Semarang     7. Serang");
        System.out.println("2. Surabaya     5. Bandung");
        System.out.println("3. Yogyakarta   6. Jakarta");
        System.out.println("");
        System.out.println("Jenis Tiket :");
        System.out.println("1. Hijau (Ekonomi)  2. Kuning (Premium) 3. Merah (Eksklusif)");
        System.out.println("");
        System.out.printf("%-24s%s", "Tanggal keberangkatan", ": ");
        String tgl = in.nextLine();
        System.out.printf("%-24s%s", "Stasiun asal", ": ");
        String asal = in.nextLine();
        System.out.printf("%-24s%s", "Stasiun tujuan", ": ");
        String tujuan = in.nextLine();
        System.out.printf("%-24s%s", "Jenis Tiket", ": ");
        String Tiket = in.nextLine();
        System.out.printf("%-24s%s", "Jumlah Tiket", ": ");
        int Jtiket = in.nextInt();
        System.out.printf("%-24s%s", "Nominal Pembayaran", ": ");
        int bayar = in.nextInt();
        System.out.println(Border1);

        int Rute1 = 0;
        int Rute2 = 0;
        int Rute;
        switch (asal.toLowerCase()) {
            case "malang" -> Rute1 += 0;
            case "surabaya" -> Rute1 += 100;
            case "yogyakarta" -> Rute1 += 400;
            case "semarang" -> Rute1 += 450;
            case "bandung" -> Rute1 += 800;
            case "jakarta" -> Rute1 += 900;
            case "serang" -> Rute1 += 1000;
            default -> {
            }
        }
        switch (tujuan.toLowerCase()) {
            case "Malang" -> Rute2 += 0;
            case "Surabaya" -> Rute2 += 100;
            case "Yogyakarta" -> Rute2 += 400;
            case "Semarang" -> Rute2 += 450;
            case "Bandung" -> Rute2 += 800;
            case "Jakarta" -> Rute2 += 900;
            case "Serang" -> Rute2 += 1000;
            default -> {
            }
        }
        Rute = Math.abs(Rute1 - Rute2);
        int Tiket1 = 0;
        if (Tiket.equalsIgnoreCase("Hijau")) {
            Tiket1 += 440;
        }
        if (Tiket.equalsIgnoreCase("Kuning")) {
            Tiket1 += 710;
        }
        if (Tiket.equalsIgnoreCase("Merah")) {
            Tiket1 += 1000;
        }
        switch (Tiket.toLowerCase()) {
            case "hijau":
                Tiket1 += 440;
                break;
            case "kuning":
                Tiket1 += 710;
                break;
            case "merah":
                Tiket1 += 1000;
                break;
        }
        double jumlah = Rute * Tiket1 * Jtiket;

        double Diskon = 0;
        if (Rute > 700) {
            if (Tiket.equalsIgnoreCase("Hijau")) {
                Diskon = jumlah * 0.8;
            } else if (Tiket.equalsIgnoreCase("Kuning")) {
                Diskon = jumlah * 0.75;
            } else if (Tiket.equalsIgnoreCase("Merah")) {
                Diskon = jumlah * 0.7;
            }
        } else if (Rute > 400) {
            if (Tiket.equalsIgnoreCase("Kuning")) {
                Diskon = jumlah * 0.8;
            } else if (Tiket.equalsIgnoreCase("Merah")) {
                Diskon = jumlah * 0.75;
            }
        } else if (Rute >= 300) {
            if (Tiket.equalsIgnoreCase("Merah")) {
                Diskon = jumlah * 0.8;
            }
        } else {
            Diskon = jumlah * 0.95;
        }

        Double kembalian = bayar - Diskon;
        NumberFormat Rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        String kembalian1 = Rupiah.format(kembalian);
        String Diskon1 = Rupiah.format(Diskon);
        String bayar1 = Rupiah.format(bayar);
        if (bayar < jumlah) {
            System.out.println("");
            System.out.println("UANG TIDAK MENCUKUPI\n");
            System.out.println("========================================================");
        } else {
            System.out.println("");
            System.out.println("Pemesanan Tiket Berhasil !\n");
            System.out.println("========================================================");
            System.out.printf("%34s\n", "DETAIL PEMESANAN");
            System.out.println("========================================================");
            System.out.printf("%-24s%s%s\n", "Nama", ": ", nama);
            System.out.printf("%-24s%s%s\n", "Nomor KTP", ": ", ktp);
            System.out.printf("%-24s%s%s\n", "Alamat", ": ", alamat);
            System.out.printf("%-24s%s%s\n", "Nomor Telepon", ": ", notelp);
            System.out.printf("%-24s%s%s\n", "Tanggal keberangkatan", ": ", tgl);
            System.out.printf("%-24s%s%s%s%s%s%s%s\n", "Rute", ": ", asal, " - ", tujuan, " -> ", Rute, " km");
            System.out.printf("%-24s%s%s\n\n", "Jumlah tiket", ": ", Jtiket);
            System.out.printf("%-24s%s%s%s\n", "Total harga", ": ", Diskon1, ",-");
            System.out.printf("%-24s%s%s%s\n", "Nominal pembayaran", ": ", bayar1, ",-");
            System.out.printf("%-24s%s%s%s\n", "Kembalian", ": ", kembalian1, ",-");
            System.out.println("========================================================\n");
            System.out.println("Selamat menikmati perjalanan anda\n");
            System.out.println("========================================================\n");
            in.close();
        }
    }

}
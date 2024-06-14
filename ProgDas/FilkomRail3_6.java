import java.util.*;
 
import java.text.*;
 
public class FilkomRail3_6 {
 
    static Scanner in = new Scanner(System.in);
    static int a, i = 1, urut = -1;
    static String asal1 = "", tujuan1 = "", Tiket2 = "", asal, tujuan, Tiket;
    static double Diskon;
    static String History[][] = new String[5][12];
 
    public static void main(String[] args) {
        System.out.println("========================================================");
        System.out.printf("%34s\n", "FILKOM RAIL EXPRESS");
        System.out.printf("%40s\n", "PROGRAM PEMESANAN TIKET KERETA");
        System.out.println("========================================================");
 
        do {
            Daftar();
        } while (i == 2);
    }
 
    public static void Daftar() {
        System.out.println(
                "Menu\n1. Daftar\n2. Lihat jenis tiket\n3. Stasiun\n4. Riwayat Pesanan\n5. Cek Pesanan\n6. Keluar");
        System.out.print("Masukkan Pilihan anda: ");
        a = in.nextInt();
        in.nextLine();
        switch (a) {
            case 1 -> {
                menu1();
            }
            case 2 -> {
                System.out.println("========================================================");
                ListTiket();
                System.out.println("========================================================");
            }
            case 3 -> {
                System.out.println("========================================================");
                ListStasiun();
                System.out.println("========================================================");
            }
            case 4 -> {
                History();
            }
            case 5 -> {
                CekPesanan();
            }
            case 6 -> {
                System.out.println("terima kasih telah menggunakan layanan filkom express");
                i =1;
                return;
            }
        }
 
    }
 
    public static void menu1() {
        urut += 1;
        if (urut == 5) {
            urut = 0;
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("Silahkan masukkan data diri");
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-24s%s", "Nama", ": ");
        String nama = in.nextLine();
        System.out.printf("%-24s%s", "Nomor KTP", ": ");
        String ktp = in.nextLine();
        System.out.printf("%-24s%s", "Alamat", ": ");
        String alamat = in.nextLine();
        System.out.printf("%-24s%s", "Nomor Telepon", ": ");
        String notelp = in.nextLine();
        System.out.println("");
        System.out.println("--------------------------------------------------------");
        System.out.println("Silahkan masukkan data tiket");
        System.out.println("--------------------------------------------------------");
        ListStasiun();
        ListTiket();
        System.out.printf("%-24s%s", "Tanggal keberangkatan", ": ");
        String tgl = in.nextLine();
        // ---------------------- Asal
        int JarakRute1;
        String IDasal;
        do {
            i = 1;
            System.out.printf("%-24s%s", "Stasiun asal", ": ");
            asal = in.nextLine();
            JarakRute1 = HitungRute(asal);
            IDasal = IDRute(asal);
        } while (i == 2);
 
        // ---------------------- Tujuan
        int JarakRute2;
        String IDtuju;
        do {
            i = 1;
            System.out.printf("%-24s%s", "Stasiun tujuan", ": ");
            tujuan = in.nextLine();
            JarakRute2 = HitungRute(tujuan);
            IDtuju = IDRute(tujuan);
        } while (i == 2);
 
        int Rute = Math.abs(JarakRute1 - JarakRute2);
 
        // ---------------------- Jenis
        int HargaJenis;
        String IDJenis2;
        do {
            i = 1;
            System.out.printf("%-24s%s", "Jenis Tiket", ": ");
            Tiket = in.nextLine();
            HargaJenis = JenisTiket(Tiket);
            IDJenis2 = IDJenis(Tiket);
        } while (i == 2);
 
        // ---------------------- Jumlah dan nominal
        System.out.printf("%-24s%s", "Jumlah Tiket", ": ");
        int Jtiket = in.nextInt();
        Diskon = Diskon(Rute, HargaJenis, Jtiket, Tiket);
        double bayar, kembalian;
        do {
            i = 1;
            System.out.printf("%-24s%s", "Nominal Pembayaran", ": ");
            bayar = in.nextDouble();
            CekBayar(bayar, Diskon);
            kembalian = bayar - Diskon;
        } while (i == 2);
 
        // ---------------------------- ID TIKET
        ID(kembalian, Diskon, bayar, IDasal, IDtuju,
                Tiket2, ktp, Jtiket, nama, alamat, tgl, notelp, Rute);
 
        // ---------------------------------Struk
        Struk();
    }
 
    // ------------------------ Rute
    public static int HitungRute(String kota) {
        int Rute1 = 0;
 
        switch (kota.toLowerCase()) {
            case "malang" ->
                Rute1 += 0;
            case "surabaya" ->
                Rute1 += 100;
            case "yogyakarta" ->
                Rute1 += 400;
            case "semarang" ->
                Rute1 += 450;
            case "bandung" ->
                Rute1 += 800;
            case "jakarta" ->
                Rute1 += 900;
            case "serang" ->
                Rute1 += 1000;
            default -> {
                System.out.println("Mohon masukkan kota sesuai daftar !");
                i = 2;
            }
        }
        return Rute1;
 
    }
 
    //-------------- ID Rute
    public static String IDRute(String kota) {
        switch (kota.toLowerCase()) {
            case "malang":
                asal1 = "MLG";
                break;
            case "jakarta":
                asal1 = "JKT";
                break;
            case "surabaya":
                asal1 = "SBY";
                break;
            case "bandung":
                asal1 = "BDG";
                break;
            case "semarang":
                asal1 = "SMR";
                break;
            case "yogyakarta":
                asal1 = "YOG";
                break;
            case "serang":
                asal1 = "SRG";
                break;
        }
        return asal1;
    }
 
    // ------------------- Harga Jenis Tiket
    public static int JenisTiket(String Tiket) {
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
        return Tiket1;
    }
 
    // ------------------ ID Jenis dan Cek Tiket
    public static String IDJenis(String input) {
        switch (input.toLowerCase()) {
            case "hijau":
                Tiket2 = "01";
                break;
            case "kuning":
                Tiket2 = "02";
                break;
            case "merah":
                Tiket2 = "03";
                break;
            default:
                i = 2;
                System.out.println("Mohon masukkan jenis tiket sesuai daftar !");
        }
        return Tiket2;
    }
 
    // ------------ Diskon dan harga total
    public static double Diskon(int Rute, int Tiket1, int Jtiket, String Tiket) {
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
        return Diskon;
    }
 
    public static void CekBayar(double bayar, double Diskon) {
        if (bayar < Diskon) {
            System.out.println("");
            System.out.println("UANG TIDAK MENCUKUPI\n");
            System.out.println("========================================================");
            do {
                System.out.println("Maaf, uang Anda tidak mencukupi untuk melakukan pembayaran sebesar " + Diskon);
                System.out.println("1. membatalkan pesanan\n2. mengulangi pembayaran");
                int c = in.nextInt();
                switch (c) {
                    case 1 -> {
                        System.out.println("kami tunggu anda kembali");
                        return;
                    }
                    case 2 -> {
                        i = 1;
                        break;
                    }
                }
            } while (i == 2);
        }
    }
 
    public static String[][] ID(double kembalian, double Diskon, double bayar, String asal1, String tujuan1,
            String Tiket2, String ktp, int Jtiket, String nama, String alamat, String tgl, String notelp,
            int Rute) {
        String ktp2 = ktp.substring(ktp.length() - 3);
 
        NumberFormat Rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        String kembalian1 = Rupiah.format(kembalian);
        String Diskon1 = Rupiah.format(Diskon);
        String bayar1 = Rupiah.format(bayar);
 
        String IDS = String.format("%s%s%s%s%s%03d", asal1, "-", tujuan1, Tiket2, ktp2, Jtiket);
        String namaS = String.format("%s", nama);
        String ktpS = String.format("%s", ktp);
        String alamatS = String.format("%s", alamat);
        String tglS = String.format("%s", tgl);
        String notelpS = String.format("%s", notelp);
        String jtiketS = String.format("%s", Jtiket);
        String ruteS = String.format("%s%s%s%s%s%s\n", asal, " - ", tujuan, " -> ", Rute, " km");
        String TiketS = String.format("%s", Tiket);
 
        History[urut][0] = IDS;
        History[urut][1] = namaS;
        History[urut][2] = ktpS;
        History[urut][3] = alamatS;
        History[urut][4] = tglS;
        History[urut][5] = notelpS;
        History[urut][6] = jtiketS;
        History[urut][7] = ruteS;
        History[urut][8] = TiketS;
 
        History[urut][9] = kembalian1;
        History[urut][10] = Diskon1;
        History[urut][11] = bayar1;
 
        return History;
    }
 
    public static void Struk() {
        System.out.println("");
        System.out.println("Pemesanan Tiket Berhasil !\n");
        System.out.println("========================================================");
        System.out.printf("%34s\n", "DETAIL PEMESANAN");
        System.out.println("========================================================");
        System.out.printf("%-24s%s%s\n", "ID", ": ", History[urut][0]);
        System.out.printf("%-24s%s%s\n", "Nama", ": ", History[urut][1]);
        System.out.printf("%-24s%s%s\n", "KTP", ": ", History[urut][2]);
        System.out.printf("%-24s%s%s\n", "Alamat", ": ", History[urut][3]);
        System.out.printf("%-24s%s%s\n", "Nomor Telepon", ": ", History[urut][5]);
        System.out.printf("%-24s%s%s\n", "Tanggal Keberangkatan", ": ", History[urut][4]);
        System.out.printf("%-24s%s%s\n", "Rute", ": ", History[urut][7]);
        System.out.printf("%-24s%s%s\n", "Jumlah Tiket", ": ", History[urut][6]);
        System.out.printf("%-24s%s%s%s\n", "Total harga", ": ", History[urut][10], ",-");
        System.out.printf("%-24s%s%s%s\n", "Nominal pembayaran", ": ", History[urut][11], ",-");
        System.out.printf("%-24s%s%s%s\n", "Kembalian", ": ", History[urut][9], ",-");
        System.out.println("========================================================\n");
        System.out.println("Selamat menikmati perjalanan anda\n");
        System.out.println("========================================================\n");
        i = 2;
    }
 
    public static void ListStasiun() {
        System.out.println("");
        System.out.println("List Stasiun Tersedia :");
        System.out.println("1. Malang       4. Semarang     7. Serang");
        System.out.println("2. Surabaya     5. Bandung");
        System.out.println("3. Yogyakarta   6. Jakarta");
        System.out.println("");
        i = 2;
    }
 
    public static void ListTiket() {
        System.out.println("Jenis Tiket :");
        System.out.println("1. Hijau (Ekonomi)  2. Kuning (Premium) 3. Merah (Eksklusif)");
        System.out.println("");
        i = 2;
    }
 
    public static void History() {
        System.out.println("---------------------------");
        System.out.println("Riwayat Pemesanan Tiket");
        System.out.println("---------------------------");
        System.out.println("1. " + History[0][0] + ": " + History[0][4]);
        System.out.println("2. " + History[1][0] + ": " + History[1][4]);
        System.out.println("3. " + History[2][0] + ": " + History[2][4]);
        System.out.println("4. " + History[3][0] + ": " + History[3][4]);
        System.out.println("5. " + History[4][0] + ": " + History[4][4] + "\n");
        i = 2;
    }
 
    public static void CekPesanan() {
        int h = 1;
        System.out.println("---------------------------------");
        System.out.println("Cek Tiket");
        System.out.println("---------------------------------");
        System.out.print("Masukkan ID Pesanan anda : ");
        String IDhistory = in.nextLine();
        System.out.print("Masukkan Nomor KTP anda : ");
        String KTPhistory = in.nextLine();
        System.out.println("");
 
        for (int b = 0; b < History.length; b++) {
            if (IDhistory.equals(History[b][0]) && KTPhistory.equals(History[b][2])) {
                System.out.println("==============================================");
                System.out.println("    DETAIL PEMESANAN");
                System.out.println("==============================================");
                System.out.printf("%-24s%s%s\n", "ID Pesanan", ": ", History[b][0]);
                System.out.printf("%-24s%s%s\n", "Nomor KTP", ": ", History[b][2]);
                System.out.printf("%-24s%s%s\n", "Nama Pemesanan", ": ", History[b][1]);
                System.out.printf("%-24s%s%s\n", "Rute", ": ", History[b][7]);
                System.out.printf("%-24s%s%s\n", "Tanggal Keberangkatan", ": ", History[b][4]);
                System.out.printf("%-24s%s%s\n", "Jenis Tiket", ": ", History[b][8]);
                System.out.printf("%-24s%s%s\n", "Jumlah Tiket", ": ", History[b][6]);
                System.out.println("==============================================");
                h = 2;
            }
        }
        if (h == 1) {
            System.out.println("Pesanan tidak ditemukan");
        }
        i = 2;
    }
}
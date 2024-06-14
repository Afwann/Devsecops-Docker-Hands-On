import java.util.*;

public class test {
    static Scanner scan = new Scanner(System.in);
    static String nama, ktp, alamat, telp, tanggal, asal, tujuan, jenis, KT;
    static boolean gaunik, unik;
    static int i, tiket, harga;
    static double kembali, nominal, total, jartot;
    static String[][] arr = { { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" },
            { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" } };

    public static void main(String[] args) {
        int i = 0;
        boolean unik = true;
        boolean gaunik = true;
        System.out.println("=====================================================");
        System.out.println("                 Filkom Rail Express                ");
        System.out.println("            Program Pemesanan Tiket Kereta          ");
        System.out.println("=====================================================");
        do {
            menu();
            int pilihan = scan.nextInt();
            scan.nextLine();
            switch (pilihan) {
            case 1:
                datadiri();
                break;
            case 2:
                System.out.println("---------------------------------------------------------------");
                jenistiket();
                System.out.println("---------------------------------------------------------------");
                break;

            case 3:
                System.out.println("---------------------------------------------------------------");
                stasiun();
                System.out.println("---------------------------------------------------------------");
                break;

            case 4:
                riwayat();
                break;

            case 5:
                case5();
                break;

            case 6:
                System.out.println("Terima kasih telah menggunakan layanan FILKOM EXPRESS");
                unik = false;
                break;
            }

        } while (unik);
    }

    public static void menu() {
        System.out.println("Menu");
        System.out.println("1. Daftar");
        System.out.println("2. Lihat jenis tiket");
        System.out.println("3. Stasiun");
        System.out.println("4. Riwayat Pesanan");
        System.out.println("5. Cek Pesanan");
        System.out.println("6. Keluar");
        System.out.print("Masukkan pilihan anda: ");
    }

    public static void stasiun() {
        System.out.println("List Stasiun Tersedia");
        System.out.println("Silahkan masukkan data tiket");
        System.out.println("1. Malang       4. Semarang     7. Serang");
        System.out.println("2. Surabaya     5. Bandung");
        System.out.println("3. Yogyakarta   6. Jakarta");
    }

    public static void jenistiket() {
        System.out.println("Jenis Tiket");
        System.out.println("1. Hijau (Ekonomi)  2. Kuning (Premium)  3. Merah (Exclusive)");
    }

    public static void datadiri() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Silakan masukkan data diri");
        System.out.println("-----------------------------------------------------");
        System.out.printf("Nama                          : ");
        String nama = scan.nextLine();
        System.out.printf("Nomor KTP                     : ");
        String ktp = scan.nextLine();
        System.out.printf("Alamat                        : ");
        String alamat = scan.nextLine();
        System.out.printf("Nomor Telepon                 : ");
        String telp = scan.nextLine();
        System.out.println("-----------------------------------------------------");
        System.out.println("Silahkan masukkan data tiket");
        System.out.println("-----------------------------------------------------");
        stasiun();
        jenistiket();
        System.out.printf("Tanggal Keberangkatan        : ");
        String tanggal = scan.nextLine();
        System.out.printf("Stasiun Asal                 : ");
        String asal = scan.nextLine();
        System.out.printf("Stasiun Tujuan               : ");
        String tujuan = scan.nextLine();
        System.out.printf("Jenis Tiket                  : ");
        String jenis = scan.nextLine();
        System.out.printf("Jumlah Tiket                 : ");
        int tiket = scan.nextInt();
        System.out.printf("Nominal Pembayaran           : ");
        double nominal = scan.nextDouble();

        String KTP1 = ktp.substring(ktp.length() - 3);

        int harga = 0;
        String KT = "";
        iharga();

        String kotas = "";
        switch (asal.toUpperCase()) {
        case "MALANG":
            kotas = "MLG";
            break;
        case "SURABAYA":
            kotas = "SBY";
            break;
        case "YOGYAKARTA":
            kotas = "YOG";
            break;
        case "SEMARANG":
            kotas = "SMR";
            break;
        case "BANDUNG":
            kotas = "BDG";
            break;
        case "JAKARTA":
            kotas = "JKT";
            break;
        case "SERANG":
            kotas = "SRG";
            break;
        }
        String kotuj = "";
        switch (tujuan.toUpperCase()) {
        case "MALANG":
            kotuj = "MLG";
            break;
        case "SURABAYA":
            kotuj = "SBY";
            break;
        case "YOGYAKARTA":
            kotuj = "YOG";
            break;
        case "SEMARANG":
            kotuj = "SMR";
            break;
        case "BANDUNG":
            kotuj = "BDG";
            break;
        case "JAKARTA":
            kotuj = "JKT";
            break;
        case "SERANG":
            kotuj = "SRG";
            break;
        }
        // Malang - Surabaya - Yogyakarta - Semarang - Bandung - Jakarta - Serang
        jarak();
        diskon();

        double kembali = (nominal - total);
        if (nominal < total) {
            do {
                System.out.println("Maaf, uang anda tidak mencukupi untuk melakukan pembayaran sebesar " + total);
                System.out.println("1. Membatalkan pesanan");
                System.out.println("2. Mengulangi pembayaran");
                int ulang = scan.nextInt();
                switch (ulang) {

                case 1:
                    System.out.println("Kami tunggu Anda kembali");
                    gaunik = false;
                    break;

                case 2:
                    System.out.println("Nominal Pembayaran: ");
                    double nominal2 = scan.nextDouble();
                    kembali = nominal2 - total;
                    if (nominal2 < total) {
                        nominal2 = 0;
                        gaunik = true;

                    } else {
                        System.out.println("=====================================================");
                        System.out.println("              Pemesanan Tiket Berhasil!           ");
                        System.out.println("=====================================================");
                        System.out.println("                   Detail Pemesanan                 ");
                        System.out.println("=====================================================");
                        String idformat = String.format("%s%c%s%s%s%03d", kotas, '-', kotuj, KT, KTP1, tiket);
                        System.out.print("ID                       :");
                        System.out.printf("%s%c%s%s%s%03d\n", kotas, '-', kotuj, KT, KTP1, tiket);
                        System.out.println("Nama                     :" + nama);
                        System.out.println("Nomor KTP                :" + ktp);
                        System.out.println("Alamat                   :" + alamat);
                        System.out.println("Nomor Telepon            :" + telp);
                        System.out.println("Tanggal Keberangkatan    :" + tanggal);
                        System.out.println("Rute                     :" + asal + '-' + tujuan + "->" + jartot);
                        System.out.println("Jumlah Tiket             :" + tiket);
                        String tiketf = String.format("03d", tiket);
                        System.out.println("Total Harga              : Rp" + total);
                        System.out.println("Nominal Pembayaran       : Rp" + nominal);
                        System.out.println("Kembalian                : Rp" + kembali);

                        System.out.println("=====================================================");
                        System.out.println("           Selamat Menikmati Perjalanan Anda           ");
                        System.out.println("=====================================================");
                        gaunik = false;
                        if (i < 5) {
                            arr[i][0] = idformat;
                            arr[i][1] = ktp;
                            arr[i][2] = nama;
                            arr[i][3] = asal + '-' + tujuan;
                            arr[i][4] = tanggal;
                            arr[i][5] = jenis;
                            arr[i][6] = tiketf;
                            if (i == 4) {
                                i = -1;
                            }
                        }
                        i += 1;
                    }
                    break;
                }
            } while (gaunik);
        } else {
            String idformat = String.format("%s%c%s%s%s%03d", kotas, '-', kotuj, KT, KTP1, tiket);
            String tiketf = String.format("03d", tiket);
            System.out.println("=====================================================");
            System.out.println("              Pemesanan Tiket Berhasil!           ");
            System.out.println("=====================================================");
            System.out.println("                   Detail Pemesanan                 ");
            System.out.println("=====================================================");
            System.out.print("ID                       :");
            System.out.printf("%s%c%s%s%s%03d\n", kotas, '-', kotuj, KT, KTP1, tiket);
            System.out.println("Nama                     :" + nama);
            System.out.println("Nomor KTP                :" + ktp);
            System.out.println("Alamat                   :" + alamat);
            System.out.println("Nomor Telepon            :" + telp);
            System.out.println("Tanggal Keberangkatan    :" + tanggal);
            System.out.println("Rute                     :" + asal + '-' + tujuan + "->" + jartot);
            System.out.println("Jumlah Tiket             :" + tiket);
            System.out.println("Total Harga              : Rp" + total);
            System.out.println("Nominal Pembayaran       : Rp" + nominal);
            System.out.println("Kembalian                : Rp" + kembali);

            System.out.println("=====================================================");
            System.out.println("           Selamat Menikmati Perjalanan Anda           ");
            System.out.println("=====================================================");
            if (i < 5) {
                arr[i][0] = idformat;
                arr[i][1] = ktp;
                arr[i][2] = nama;
                arr[i][3] = asal + '-' + tujuan;
                arr[i][4] = tanggal;
                arr[i][5] = jenis;
                arr[i][6] = tiketf;
                if (i == 4) {
                    i = -1;
                }
            }

            i += 1;
        }
    }

    public static void jarak() {
        int jarak1 = 0;
        int jarak2 = 0;
        int jartot;
        switch (asal.toLowerCase()) {
        case "malang" -> jarak1 += 0;
        case "surabaya" -> jarak1 += 100;
        case "yogyakarta" -> jarak1 += 400;
        case "semarang" -> jarak1 += 450;
        case "bandung" -> jarak1 += 800;
        case "jakarta" -> jarak1 += 900;
        case "serang" -> jarak1 += 1000;
        default -> {
        }
        }

        switch (tujuan.toLowerCase()) {
        case "malang" -> jarak2 += 0;
        case "surabaya" -> jarak2 += 100;
        case "yogyakarta" -> jarak2 += 400;
        case "semarang" -> jarak2 += 450;
        case "bandung" -> jarak2 += 800;
        case "jakarta" -> jarak2 += 900;
        case "serang" -> jarak2 += 1000;
        default -> {
        }
        }
        jartot = Math.abs(jarak1 - jarak2);
    }

    public static void diskon() {
        double total = (tiket * harga * jartot);
        if (jartot > 700) {
            if (jenis.equals("hijau")) {
                total = total * 0.8;
            } else if (jenis.equals("kuning")) {
                total = total * 0.75;
            } else if (jenis.equals("merah")) {
                total = total * 0.70;
            }
        } else if (jartot > 400) {
            if (jenis.equals("kuning")) {
                total = total * 0.80;
            }
            if (jenis.equals("merah")) {
                total = total * 0.75;
            }
        } else if (jartot >= 300) {
            if (jenis.equals("merah")) {
                total = total * 0.80;
            }
        } else {
            total = total * 0.95;
        }
    }

    public static void iharga() {
        switch (jenis.toLowerCase()) {
        case "hijau":
            harga += 440;
            KT = "01";
            break;
        case "kuning":
            harga += 710;
            KT = "02";
            break;
        case "merah":
            harga += 1000;
            KT = "03";
            break;
        }
    }

    public static void riwayat() {
        System.out.println("Riwayat Pemesanan Tiket: ");
        System.out.println("1. " + arr[0][0] + ": " + arr[0][4]);
        System.out.println("2. " + arr[1][0] + ": " + arr[1][4]);
        System.out.println("3. " + arr[2][0] + ": " + arr[2][4]);
        System.out.println("4. " + arr[3][0] + ": " + arr[3][4]);
        System.out.println("5. " + arr[4][0] + ": " + arr[4][4]);
    }

    public static void case5() {
        System.out.println("----------------------------------------");
        System.out.println("Cek tiket");
        System.out.println("----------------------------------------");
        System.out.print("Masukkan id pesanan anda: ");
        String idp = scan.nextLine();
        System.out.print("Masukkan nomor KTP: ");
        String ktp2 = scan.nextLine();
        int z = 0;
        for (int a = 0; a < 5; a++) {
            if (arr[a][0].equals(idp) && arr[a][1].equals(ktp2)) {
                z = 1;
                System.out.println("=============================================");
                System.out.println("             DETAIL PEMESANAN");
                System.out.println("=============================================");
                System.out.println("ID Pesanan               : " + arr[a][0]);
                System.out.println("Nomor KTP                : " + arr[a][1]);
                System.out.println("Nama Pemesan             : " + arr[a][2]);
                System.out.println("Rute                     : " + arr[a][3]);
                System.out.println("Tanggal Keberangkatan    : " + arr[a][4]);
                System.out.println("Jenis Tiket              : " + arr[a][5]);
                System.out.println("Jumlah Tiket             : " + arr[a][6]);
                break;
            }
        }
        if (z == 0) {
            System.out.println("Pesanan tidak ditemukan");
        }
        System.out.println("----------------------------------------");
    }

}

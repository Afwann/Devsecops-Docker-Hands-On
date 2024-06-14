import java.util.*;
import java.text.*;

public class FilkomRail3_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("========================================================");
        System.out.printf("%34s\n", "FILKOM RAIL EXPRESS");
        System.out.printf("%40s\n", "PROGRAM PEMESANAN TIKET KERETA");
        System.out.println("========================================================");
        int i = 1;
        do {
            System.out.println("Menu\n1. Daftar\n2. Lihat jenis tiket\n3. Stasiun\n4. Keluar");
            System.out.print("Masukkan Pilihan anda: ");
            int a = in.nextInt();
            in.nextLine();
            switch (a) {
            case 1:
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

                String asal1 = "", tujuan1 = "", Tiket2 = "", asal, tujuan, Tiket;
                int Rute1 = 0;
                int Rute2 = 0;
                int Rute;
                do {
                    i = 2;
                    System.out.printf("%-24s%s", "Stasiun asal", ": ");
                    asal = in.nextLine();
                    switch (asal.toLowerCase()) {
                    case "malang" -> Rute1 += 0;
                    case "surabaya" -> Rute1 += 100;
                    case "yogyakarta" -> Rute1 += 400;
                    case "semarang" -> Rute1 += 450;
                    case "bandung" -> Rute1 += 800;
                    case "jakarta" -> Rute1 += 900;
                    case "serang" -> Rute1 += 1000;
                    default -> {
                        System.out.println("Mohon masukkan kota sesuai daftar !");
                        i = 1;
                    }
                    }
                } while (i == 1);

                do {
                    i = 2;
                    System.out.printf("%-24s%s", "Stasiun tujuan", ": ");
                    tujuan = in.nextLine();
                    switch (tujuan.toLowerCase()) {
                    case "malang" -> Rute2 += 0;
                    case "surabaya" -> Rute2 += 100;
                    case "yogyakarta" -> Rute2 += 400;
                    case "semarang" -> Rute2 += 450;
                    case "bandung" -> Rute2 += 800;
                    case "jakarta" -> Rute2 += 900;
                    case "serang" -> Rute2 += 1000;
                    default -> {
                        System.out.println("Mohon masukkan kota sesuai daftar !");
                        i = 1;
                    }
                    }
                } while (i == 1);

                do {
                    i = 2;
                    System.out.printf("%-24s%s", "Jenis Tiket", ": ");
                    Tiket = in.nextLine();
                    switch (Tiket.toLowerCase()) {
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
                        i = 1;
                        System.out.println("Mohon masukkan jenis tiket sesuai daftar !");
                    }
                } while (i == 1);
                i = 1;

                System.out.printf("%-24s%s", "Jumlah Tiket", ": ");
                int Jtiket = in.nextInt();
                System.out.printf("%-24s%s", "Nominal Pembayaran", ": ");
                int bayar = in.nextInt();
                System.out.println("========================================================");

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
                /*
                 * ● Malang : MLG ● Jakarta : JKT ● Surabaya : SBY ● Bandung : BDG ● Semarang :
                 * SMR ● Yogyakarta : YOG ● Serang : SRG
                 */

                switch (asal.toLowerCase()) {
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

                switch (tujuan.toLowerCase()) {
                case "malang":
                    tujuan1 = "MLG";
                    break;
                case "jakarta":
                    tujuan1 = "JKT";
                    break;
                case "surabaya":
                    tujuan1 = "SBY";
                    break;
                case "bandung":
                    tujuan1 = "BDG";
                    break;
                case "semarang":
                    tujuan1 = "SMR";
                    break;
                case "yogyakarta":
                    tujuan1 = "YOG";
                    break;
                case "serang":
                    tujuan1 = "SRG";
                    break;
                }

                String ktp2 = ktp.substring(ktp.length() - 3);

                Double kembalian = bayar - Diskon;
                NumberFormat Rupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
                String kembalian1 = Rupiah.format(kembalian);
                String Diskon1 = Rupiah.format(Diskon);
                String bayar1 = Rupiah.format(bayar);
                if (bayar < Diskon) {
                    System.out.println("");
                    System.out.println("UANG TIDAK MENCUKUPI\n");
                    System.out.println("========================================================");
                    int j = 1;
                    do {
                        System.out.println(
                                "Maaf, uang Anda tidak mencukupi untuk melakukan pembayaran sebesar " + jumlah);
                        System.out.println("1. membatalkan pesanan\n2. mengulangi pembayaran");
                        int c = in.nextInt();
                        switch (c) {
                        case 1:
                            System.out.println("kami tunggu anda kembali");
                            j = 2;
                            break;
                        case 2:
                            System.out.print("Nominal Pembayaran : ");
                            int bayar2 = in.nextInt();

                            if (bayar2 < Diskon) {
                                j = 1;
                                bayar2 = 0;
                            } else {
                                double kembalian2 = bayar2 - Diskon;
                                System.out.println("");
                                System.out.println("Pemesanan Tiket Berhasil !\n");
                                System.out.println("========================================================");
                                System.out.printf("%34s\n", "DETAIL PEMESANAN");
                                System.out.println("========================================================");
                                System.out.printf("%-24s%s%s%s%s%s%s%03d\n", "ID", ": ", asal1, "-", tujuan1, Tiket2,
                                        ktp2, Jtiket);
                                System.out.printf("%-24s%s%s\n", "Nama", ": ", nama);
                                System.out.printf("%-24s%s%s\n", "Nomor KTP", ": ", ktp);
                                System.out.printf("%-24s%s%s\n", "Alamat", ": ", alamat);
                                System.out.printf("%-24s%s%s\n", "Nomor Telepon", ": ", notelp);
                                System.out.printf("%-24s%s%s\n", "Tanggal keberangkatan", ": ", tgl);
                                System.out.printf("%-24s%s%s%s%s%s%s%s\n", "Rute", ": ", asal, " - ", tujuan, " -> ",
                                        Rute, " km");
                                System.out.printf("%-24s%s%s\n\n", "Jumlah tiket", ": ", Jtiket);
                                System.out.printf("%-24s%s%s%s\n", "Total harga", ": ", Diskon1, ",-");
                                System.out.printf("%-24s%s%s%s\n", "Nominal pembayaran", ": ", bayar2, ",-");
                                System.out.printf("%-24s%s%s%s\n", "Kembalian", ": ", kembalian2, ",-");
                                System.out.println("========================================================\n");
                                System.out.println("Selamat menikmati perjalanan anda\n");
                                System.out.println("========================================================\n");
                                j = 2;
                            }
                            break;
                        }
                    } while (j == 1);
                } else {
                    System.out.println("");
                    System.out.println("Pemesanan Tiket Berhasil !\n");
                    System.out.println("========================================================");
                    System.out.printf("%34s\n", "DETAIL PEMESANAN");
                    System.out.println("========================================================");
                    System.out.printf("%-24s%s%s%s%s%s%s%03d\n", "ID", ": ", asal1, "-", tujuan1, Tiket2, ktp2, Jtiket);
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
                }
                break;
            case 2:
                System.out.println("Jenis Tiket :");
                System.out.println("1. Hijau (Ekonomi)  2. Kuning (Premium) 3. Merah (Eksklusif)");
                System.out.println("");
                break;
            case 3:
                System.out.println("List Stasiun Tersedia :");
                System.out.println("1. Malang       4. Semarang     7. Serang");
                System.out.println("2. Surabaya     5. Bandung");
                System.out.println("3. Yogyakarta   6. Jakarta");
                System.out.println("");
                break;
            case 4:
                System.out.println("terima kasih telah menggunakan layanan filkom express");
                i = 2;
                break;
            }
        } while (i == 1);

    }
}
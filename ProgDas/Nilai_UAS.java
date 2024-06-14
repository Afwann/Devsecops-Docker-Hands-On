import java.util.*;
public class Nilai_UAS {
    public static void main (String [] args){
        Scanner in = new Scanner (System.in);
        
        //------------------------Input-------------------------------
        System.out.println("Silahkan masukkan Nilai Tugas anda  :");
        double Tugas = in.nextDouble();
        System.out.println("Silahkan masukkan Nilai Kuis anda  :");
        double Kuis = in.nextDouble();
        System.out.println("Silahkan masukkan Nilai UAS anda  :");
        double UAS = in.nextDouble();

        //--------------Penghitungan Nilai Akhir -----------------------
        double akhir = 0;
        if(Kuis>UAS){
            akhir = 0.4*Kuis + 0.4*UAS + 0.2*Tugas;
        } else{
            akhir = 0.3*Kuis + 0.5*UAS + 0.2*Tugas;
        }
        //---------------------------------------------------------------

        //--------------------Output-------------------------------------
        if(akhir<=49){
            System.out.println("Anda mendapatkan E dengan nilai " +(akhir)+ " dengan Bobot 0, mohon maaf anda gagal");
        } else if(akhir<=64){
            System.out.println("Anda mendapatkan D dengan nilai " +(akhir)+ " dengan Bobot 1, Nilai anda Kurang");
        } else if(akhir<=74){
            System.out.println("Anda mendapatkan C dengan nilai " +(akhir)+ " dengan Bobot 2, Nilai anda Sudah Cukup");
        } else if(akhir<=84){
            System.out.println("Anda mendapatkan B dengan nilai " +(akhir)+ " dengan Bobot 3, Nilai anda Sudah Baik");
        } else if(akhir<=100){
            System.out.println("Anda mendapatkan A dengan nilai " +(akhir)+ " dengan Bobot 4, Nilai anda Sangat Baik");
        }
        //--------------------------------------------------------------------
    in.close();
    }
}
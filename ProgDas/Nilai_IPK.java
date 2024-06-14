import java.util.*;

public class Nilai_IPK {
    public static void main (String[]args){

        //---------------------Input-------------------------------------
        Scanner in = new Scanner (System.in);
        System.out.print("Silakan Input Nilai IPK anda        :");
        Double IPK = in.nextDouble();
        System.out.println("");
        //----------------------------------------------------------------

        //-------------------Output---------------------------------------
        if(IPK<2.0){
            System.out.println("Nilai IPK anda kurang");
        } else if(IPK<=2.4){
            System.out.println("Nilai IPK anda Baik");
        } else if(IPK<=2.9){
            System.out.println("Nilai IPK anda Baik Sekali");
        } else if(IPK<=3.4){
            System.out.println("Nilai IPK anda Memuaskan");
        } else if(IPK<=4.0){
            System.out.println("Nilai IPK anda Sangat Memuaskan");
        }
        //----------------------------------------------------------------
        in.close();
    }
}
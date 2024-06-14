import java.util.*;

public class test2 {
    public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    Long detik1 = in.nextLong();

    long jam = detik1 / 3600;
    long menit = (detik1 % 3600) / 60;
    long detik = detik1 % 60;

    String a = jam+" jam ";
    String b = menit+" menit ";
    String c = detik+" detik ";
    
    if(jam == 0 && menit ==0){
        System.out.println(c);
    } else if(menit == 0 && detik ==0){
        System.out.println(a);
    } else if(detik == 0 && jam == 0){
        System.out.println(b);
    } else if (detik == 0){
        if(menit == 0){
            System.out.println(a);
        } else if(jam == 0){
            System.out.println(b);
        } else {
            System.out.println(a+b);
        }
    } else if (menit == 0 ){
        if( detik == 0){
            System.out.println(a);
        } else if(jam == 0){
            System.out.println(c);
        } else {
            System.out.println(a+c);
        }
    } else if (jam == 0 ){
        if(detik == 0){
            System.out.println(b);
        } else if(menit == 0){
            System.out.println(c);
        } else {
            System.out.println(b+c);
        }
    } else {
        System.out.println(a+b+c);
    }
    in.close();
    
    }
}
import java.util.Scanner; //import scanner untuk input

public class Latihan_1 {
    public static void main(String[] args) {
    /* Afwan Mulia Pratama
        215150201111059
        Kelas F*/
        Scanner in = new Scanner (System.in); //object scanner baru
        //Input nilai bagian 1
        System.out.println("Masukkan Nama 1:");
        String Name1 = in.nextLine();
        System.out.println("Masukkan Umur 1:");
        int Age1 = in.nextInt();
        System.out.println("Masukkan Jenis Kelamin 1:");
        char Gender1 = in.next().charAt(0); 
        in.nextInt();
        
        //input nilai bagian 2
        System.out.println("Masukkan Nama 2:");
        String Name2 = in.nextLine(); 
        System.out.println("Masukkan Umur 2:");
        int Age2 = in.nextInt(); 
        System.out.println("Masukkan Jenis Kelamin 2:");
        char Gender2 = in.next().charAt(0);
        in.nextLine();

        //input nilai bagian 3
        System.out.println("Masukkan Nama 3:");
        String Name3 = in.nextLine();
        System.out.println("Masukkan Umur 3:");
        int Age3 = in.nextInt();
        System.out.println("Masukkan Jenis Kelamin 3:");
        char Gender3 = in.next().charAt(0);

        //tampilan data hasil
        System.out.println("Data yang tersimpan:");
        System.out.printf("%-37.37s\n","-------------------------------------");
        System.out.printf("%c%-10s%c%-10s%c%-13s%c\n",'|',"Nama",'|',"Umur",'|',"Jenis Kelamin",'|');
        System.out.printf("%-37.37s\n","-------------------------------------");
            System.out.printf("%c%-10s%c%-10s%c%-13s%c\n",'|',Name1,'|',Age1,'|',Gender1,'|');
            System.out.printf("%c%-10s%c%-10s%c%-13s%c\n",'|',Name2,'|',Age2,'|',Gender2,'|');
            System.out.printf("%c%-10s%c%-10s%c%-13s%c\n",'|',Name3,'|',Age3,'|',Gender3,'|');
            in.close();
    }

}

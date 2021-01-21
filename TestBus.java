import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Class TestBus digunakan sebagai class utama karena memiliki method main. Class ini digunakan untuk menampilkan simulasi proses naik dan turunnya penumpang dalam satu bus.
 *
 * @author Muhammad Saifullah Sani
 * @version 12/01/2021
 */
public class TestBus
{
    private Scanner in;
    private Scanner input;
    private Bus b;
    
    /**
     * Constructor untuk class TestBus untuk membuat objek dan langsung menjalankan program.
     */
    public TestBus()
    {
        in = new Scanner(System.in);
        input = new Scanner(System.in);
        b = new Bus();
        
        menu();
    }
    
    /**
     * Method untuk menginput data penumpang dan menaikkan penumpang.
     */
    public void naikPenumpang()
    {
        String nama = " ";
        char jk = 'l';
        char cHamil = 'n';
        boolean hamil = false;
        int umur = 0;
        int ID = 0;
        int min = 1;
        int max = 40;
        
        // Input data nama penumpang
        System.out.print("Nama                : ");
        nama = input.nextLine();
                
        // Input data jenis kelamin penumpang dan exception handling-nya (buatan sendiri)
        System.out.print("Jenis kelamin (l/p) : ");
        jk = in.next().charAt(0);
        
        while((jk != 'l') && (jk != 'L') && (jk != 'p') && (jk !='P')) {
            System.out.println("\n\nMaaf, mohon input l atau p");
            System.out.print("Jenis kelamin (l/p) : ");
            jk = in.next().charAt(0);
        }
               
        // Input data status hamil khusus penumpang wanita dan exception handling-nya (buatan sendiri)
        if(jk == 'p' || jk == 'P') {
            System.out.print("Hamil (y/n)         : ");
            cHamil = in.next().charAt(0);
                
            while((cHamil != 'y') && (cHamil != 'Y') && (cHamil != 'n') && (cHamil !='N')) {
                System.out.println("\n\nMaaf, mohon input y atau n");
                System.out.print("Hamil (y/n)         : ");
                cHamil = in.next().charAt(0);
            }
                
            if((cHamil == 'y') || (cHamil == 'Y')) {
                hamil = true;
            }
        }
        
        // Input data umur penumpang
        do {
            try {
                System.out.print("Umur                : ");
                umur = in.nextInt();
            }
            catch(InputMismatchException e) {
                in.nextLine();
            }
            
            if(umur < 0) {
                    System.out.println("\n\nMaaf, mohon input bilangan bulat >= 0 !");                
            }
        } while(umur < 0);

        // Memilih ID penumpang yang merupakan primary key
        ID = (int) ( min + (Math.random() * (max-min)) );
        while(b.cekID(ID) == true) {
            ID = (int) ( min + (Math.random() * (max-min)) );
        }
        
        Penumpang p = new Penumpang(ID, nama, jk, hamil, umur);
        
        // Menambahkan penumpang ke dalam array list jika berhasil
        if(b.naikkanPenumpang(p) == true) {
            System.out.println("\n     /");
            System.out.println("    /");
            System.out.println("\\  /\tPenumpang berhasil ditambahkan !");
            System.out.println(" \\/\n");
            System.out.println("\n" + b.toString() + "\n");
        }
        else {
            System.out.println("\n\\     /");
            System.out.println(" \\   /");
            System.out.println("  \\ /");
            System.out.println("   X \tPenumpang gagal ditambahkan !");
            System.out.println("  / \\");
            System.out.println(" /   \\");
            System.out.println("/     \\");
        }
    }
    
    /**
     * Method untuk menurunkan penumpang berdasarkan nama atau ID.
     */
    public void turunPenumpang()
    {
        int pilihan = 0;
        int ID = 0;
        String nama = " ";
        
        // Memberikan pilihan penghapusan penumpang berdasarkan ID atau nama penumpang
        System.out.println("1. Turunkan berdasarkan ID\n2. Turunkan berdasarkan nama\n3. Batal\n");
        
        do {
            try {
                System.out.print("Pilihan : ");
                pilihan = in.nextInt();
            }
            catch(InputMismatchException e) {
                in.nextLine();
            }
            
            if(pilihan != 1 && pilihan != 2 && pilihan != 3) {
                System.out.println("\n\nMohon input 1, 2, atau 3 !");
            }
        } while(pilihan < 1 || pilihan > 3);
        
        System.out.println();
        
        if(pilihan == 1) {
            try {
                System.out.print("ID : ");
                ID = in.nextInt();                
            }
            catch(InputMismatchException e) {
                System.out.println("\n\nMaaf, yang Anda input tidak valid. Berikut data mengenai bus.\n");
                System.out.println(b.toString() + "\n");
                in.nextLine();
            }
        }
        else if(pilihan == 2) {
            System.out.print("Nama : ");
            nama = input.nextLine();
        }
        else if(pilihan == 3) {
            System.out.println("\n \\     /");
            System.out.println("  \\   /   /");
            System.out.println("   \\ /   /");
            System.out.println(" \\  X   /     Penumpang batal diturunkan !");
            System.out.println("  \\/ \\ /");
            System.out.println("  /\\  /");
            System.out.println(" /  \\/ \\\n");
        }
            
        if( (pilihan != 3) && (b.turunkanPenumpang(nama) || b.turunkanPenumpangID(ID) == true) ) {
            System.out.println("\n     /");
            System.out.println("    /");
            System.out.println("\\  /\tPenumpang berhasil turun !");
            System.out.println(" \\/\n");
            System.out.println("\n" + b.toString() + "\n");
        }
        else if(pilihan != 3) {
            System.out.println("\n\\     /");
            System.out.println(" \\   /");
            System.out.println("  \\ /");
            System.out.println("   X \tPenumpang tidak ditemukan !");
            System.out.println("  / \\");
            System.out.println(" /   \\");
            System.out.println("/     \\\n");
            System.out.println("\n" + b.toString() + "\n");
        }
    }
    
    /**
     * Method untuk menambahkan saldo penumpang berdasarkan ID.
     */
    public void menambahSaldo()
    {
        int ID = 0;
        int saldoTambahan = 0;
        
        while(ID < 1 || saldoTambahan < 1) {
            try {
                System.out.print("          ID           : ");
                ID = in.nextInt();
                System.out.print("Nominal saldo tambahan : Rp. ");
                saldoTambahan = in.nextInt();
            }
            catch(InputMismatchException e) {
                in.nextLine();
            }
            
            if(ID == 0 || saldoTambahan == 0) {
                System.out.println("\nMohon input ID dan nominal saldo tambahan dengan angka > 0 !");
            }
        }
        
        if(b.menambahkanSaldo(ID, saldoTambahan) == true) {
            System.out.println("\n     /");
            System.out.println("    /");
            System.out.println("\\  /\tSaldo penumpang dengan ID " + ID + " berhasil ditambahkan sejumlah " + saldoTambahan);
            System.out.println(" \\/\n");
            System.out.println("\n" + b.toString() + "\n");
        }
        else {
            System.out.println("\n\\     /");
            System.out.println(" \\   /");
            System.out.println("  \\ /");
            System.out.println("   X \tPenumpang tidak ditemukan !");
            System.out.println("  / \\");
            System.out.println(" /   \\");
            System.out.println("/     \\\n");
            System.out.println("\n" + b.toString() + "\n");
        }
    }
    
    /**
     * Method untuk meminta sembarang input untuk melanjutkan program.
     */
    public void tekanEnter()
    {
        // Tekan enter untuk kembali ke menu
        System.out.print("Tekan enter untuk kembali ke menu... ");
        try {
            System.in.read();
        }
        catch(Exception e) {
        }
    }
    
    /**
     * Method untuk mencetak menu dan menjalankan program utama.
     */
    public void menu()
    {
        int pilihan = 0;
        
        System.out.println("\n         ________________________________");
        System.out.println("        |                                |");
        System.out.println("        +->>   BUS TRANS KOETARADJA   <<-+");
        System.out.println("        |________________________________|");
        
        // Program akan terus berulang hingga dipilih keluar dari menu
        while(pilihan != 5) {
            System.out.println("\n\nMENU :\n1. Naikkan penumpang\n2. Turunkan penumpang\n3. Menambahkan saldo penumpang\n4. Lihat Penumpang\n5. Keluar dari menu\n");
       
            // Exception handling untuk pilihan menu
            do {
                try {
                    System.out.print("Pilihan : ");
                    pilihan = in.nextInt();
                } catch(InputMismatchException e) {
                    in.nextLine();
                }

                if(pilihan < 1 || pilihan > 5) {
                    System.out.print("\nMohon input 1, 2, 3, 4, atau 5 !\n");
                }
            } while(pilihan < 1 || pilihan > 5);
            
            System.out.println("\n");
        
            if(pilihan == 1) {
                naikPenumpang();
                tekanEnter();
            }
            else if(pilihan == 2) {
                turunPenumpang();
                tekanEnter();
            }
            else if(pilihan == 3) {
                menambahSaldo();
                tekanEnter();
            }
            else if(pilihan == 4) {
                System.out.println(b);
                
                // Tujuan dua fitur di bwh ini sama aja.
                // tekanEnter();
                input.nextLine();
            }
        }
    }

    /**
     * Method utama untuk menjalankan program.
     *
     * @param args argumen CLA yang tIDak digunakan.
     */
    public static void main(String[] args)
    {
        new TestBus();
    }
}

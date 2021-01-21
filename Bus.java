import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Class Bus akan dijadikan sebagai objek kartu penumpang.
 *
 * @author Muhammad Saifullah Sani
 * @version 12/01/2021
 */
public class Bus
{
    private Scanner in;
    private ArrayList<Penumpang> penumpangPrioritas;
    private ArrayList<Penumpang> penumpangBiasa;
    private ArrayList<Penumpang> penumpangBerdiri;
    private static final int ONGKOS_BUS = 2000;
    private int totalPendapatan;
    private Iterator<Penumpang> itr1;
    private Iterator<Penumpang> itr2;
    private Iterator<Penumpang> itr3;

    /**
     * Constructor class Bus yang akan dijadikan sebagai objek kartu penumpang.
     * Constructor ini menginisialisasikan array atribut penumpangPrioritas, penumpangBiasa, dan penumpangBeriri, dan memberikan nilai awal untuk atribut totalPendapatan.
     */
    public Bus()
    {
        in = new Scanner(System.in);
        penumpangPrioritas = new ArrayList<Penumpang>();
        penumpangBiasa = new ArrayList<Penumpang>();
        penumpangBerdiri = new ArrayList<Penumpang>();
        this.totalPendapatan = 0;        
    }
    
    /**
     * Method untuk mengembalikan data penumpang prioritas.
     * Method ini tidak digunakan karena ada yang lebih baik.
     * 
     * @return penumpangPrioritas mengembalikan data penumpang prioritas.
     */
    @Deprecated
    public ArrayList<Penumpang> getPenumpangPrioritas()
    {
        return this.penumpangPrioritas;
    }
    
    /**
     * Method untuk mengembalikan data penumpang biasa.
     * Method ini tidak digunakan karena ada yang lebih baik.
     * 
     * @return penumpangBiasa mengembalikan data penumpang biasa.
     */
    @Deprecated
    public ArrayList<Penumpang> getPenumpangBiasa()
    {
        return this.penumpangBiasa;
    }
    
    /**
     * Method untuk mengembalikan data penumpang berdiri.
     * Method ini tidak digunakan karena ada yang lebih baik.
     * 
     * @return penumpangBerdiri mengembalikan data penumpang berdiri.
     */
    @Deprecated
    public ArrayList<Penumpang> getPenumpangBerdiri()
    {
        return this.penumpangBerdiri;
    }
    
    /**
     * Method untuk menghitung jumlah penumpang prioritas.
     * 
     * @return jumlah penumpang prioritas.
     */
    public int getJumlahPenumpangPrioritas()
    {
        return this.penumpangPrioritas.size();
    }
    
    /**
     * Method untuk menghitung jumlah penumpang biasa.
     * 
     * @return jumlah penumpang biasa.
     */
    public int getJumlahPenumpangBiasa()
    {
        return this.penumpangBiasa.size();
    }
    
    /**
     * Method untuk menghitung jumlah penumpang berdiri.
     * 
     * @return jumlah penumpang berdiri.
     */
    public int getJumlahPenumpangBerdiri()
    {
        return this.penumpangBerdiri.size();
    }
    
    /**
     * Method untuk mencetak nama dan ID setiap penumpang yang duduk di kursi penumpang prioritas.
     */
    public void cetakDataPenumpangPrioritas()
    {        
        this.itr1 = this.penumpangPrioritas.iterator();
        int i = 1;  
        
        while(itr1.hasNext()) {
            Penumpang p = itr1.next();
            
            if( (i == getJumlahPenumpangPrioritas()) || (getJumlahPenumpangPrioritas() == 1) ) {
                System.out.print(p.getNama() + " (ID : " + p.getID() + ")");
            }
            else {
               System.out.print(p.getNama() + " (ID : " + p.getID() + "), "); 
            }            
            i++;
        }
        System.out.println();
    }
    
    /**
     * Method untuk mencetak nama dan ID setiap penumpang yang duduk di kursi penumpang biasa dan penumpang yang berdiri.
     */
    public void cetakDataPenumpangBiasa()
    {        
        this.itr2 = this.penumpangBiasa.iterator();
        this.itr3 = this.penumpangBerdiri.iterator();
        int i = 1;  
        
        while(itr2.hasNext()) {
            Penumpang p = itr2.next();
            
            if( (i == getJumlahPenumpangBiasa()) || (getJumlahPenumpangBiasa() == 1) ) {
                System.out.print(p.getNama() + " (ID : " + p.getID() + ")");
            }
            else {
               System.out.print(p.getNama() + " (ID : " + p.getID() + "), "); 
            }            
            i++;
        }
        
        i = 1;
        
        while(itr3.hasNext()) {
            Penumpang p = itr3.next();
            
            if( (i == getJumlahPenumpangBerdiri()) || (getJumlahPenumpangBerdiri() == 1) ) {
                System.out.print(p.getNama() + " (ID : " + p.getID() + ")");
            }
            else {
               System.out.print(p.getNama() + " (ID : " + p.getID() + "), "); 
            }            
            i++;
        }
        System.out.println();
    }
    
    /**
     * Method yang mengecek apakah ID yang ingin diberikan sudah dimiliki oleh penumpang lain agar ID tersebut menjadi primary key penumpang yang ada dalam bus.
     * 
     * @param id data ID penumpang yang ingin dinaikkan ke dalam bus.
     * @return true apabila ID tersebut sudah dimiliki oleh penumpang di dalam bus dan false apabila ID tersebut belum dimiliki oleh penumpang di dalam bus.
     */
    public boolean cekID(int id)
    {        
        this.itr1 = this.penumpangPrioritas.iterator();
        this.itr2 = this.penumpangBiasa.iterator();
        this.itr3 = this.penumpangBerdiri.iterator();
        
        while(itr1.hasNext()) {
            Penumpang p = itr1.next();
            
            if(p.getID() == id) {
                return true;
            }
        }
        
        while(itr2.hasNext()) {
            Penumpang p = itr2.next();
            
            if(p.getID() == id) {
                return true;
            }
        }
        
        while(itr3.hasNext()) {
            Penumpang p = itr3.next();
            
            if(p.getID() == id) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method untuk menaikkan penumpang ke dalam bus berdasarkan kursi yang sesuai.
     * 
     * @param penumpang objek penumpang yang ingin dinaikkan ke dalam bus.
     * @return true apabila penumpang tersebut berhasil dinaikkan dan false apabila penumpang tersebut gagal dinaikkan.
     */
    public boolean naikkanPenumpang(Penumpang penumpang)
    {
        char prioritasKeBiasa = 'n';
        
        if( ( (getJumlahPenumpangPrioritas() + getJumlahPenumpangBerdiri() + getJumlahPenumpangBiasa()) < 41) && (penumpang.getSaldo() >= ONGKOS_BUS) ) {
            if( (penumpang.getHamil() == true) || (penumpang.getUmur() > 60) || (penumpang.getUmur() < 10) ) {
                if(getJumlahPenumpangPrioritas() <= 4) {
                    //tambahin penumpang ke dlm array penumpang prioritas
                    this.penumpangPrioritas.add(penumpang);
                    penumpang.kurangiSaldo(ONGKOS_BUS);
                    this.totalPendapatan += ONGKOS_BUS;
                    return true;
                }
                else if(getJumlahPenumpangBiasa() <= 16) {
                    System.out.print("\n\nApakah Anda ingin duduk di kursi penumpang biasa dan dianggap sebagai penumpang biasa (y/n) ? ");
                    prioritasKeBiasa = in.next().charAt(0);
                    
                    while( (prioritasKeBiasa != 'y') && (prioritasKeBiasa != 'Y') && (prioritasKeBiasa != 'n') && (prioritasKeBiasa != 'N') ) {
                        System.out.println("\n\nMaaf, mohon input y atau n");
                        System.out.print("Apakah Anda ingin duduk di kursi penumpang biasa dan dianggap sebagai penumpang biasa (y/n) ? ");
                        prioritasKeBiasa = in.next().charAt(0);
                    }
                    
                    if( (prioritasKeBiasa == 'y') || (prioritasKeBiasa == 'Y') ) {
                        //Penumpang prioritas ini tambahin ke dalam array penumpang biasa
                        this.penumpangBiasa.add(penumpang);
                        penumpang.kurangiSaldo(ONGKOS_BUS);
                        this.totalPendapatan += ONGKOS_BUS;
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
            else {
                if(getJumlahPenumpangBiasa() <= 16) {
                    //tambahin penumpang ke dlm array penumpang biasa
                    this.penumpangBiasa.add(penumpang);
                    penumpang.kurangiSaldo(ONGKOS_BUS);
                    this.totalPendapatan += ONGKOS_BUS;
                    return true;
                }
                else if(getJumlahPenumpangBerdiri() <= 20) {
                    //tambahin penumpang ke dlm array penumpang berdiri
                    this.penumpangBerdiri.add(penumpang);
                    penumpang.kurangiSaldo(ONGKOS_BUS);
                    this.totalPendapatan += ONGKOS_BUS;
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Method untuk menurunkan penumpang yang ada di dalam bus dengan menggunakan pencarian berdasarkan nama penumpang yang ingin diturunkan.
     * 
     * @param nama adalah nama penumpang yang ingin diturunkan.
     * @return true apabila penumpang tersebut berhasil diturunkan dan false apabaila penumpang tersebut gagal diturunkan.
     */
    public boolean turunkanPenumpang(String nama)
    {
        this.itr1 = this.penumpangPrioritas.iterator();
        this.itr2 = this.penumpangBiasa.iterator();
        this.itr3 = this.penumpangBerdiri.iterator();
        int i = 0;  
        
        while(itr1.hasNext()) {
            Penumpang p = itr1.next();
            
            if(p.getNama().equalsIgnoreCase(nama)) {
                this.penumpangPrioritas.remove(i);
                return true;
            }
            i++;
        }
        
        i = 0;
        
        while(itr2.hasNext()) {
            Penumpang p = itr2.next();
            
            if(p.getNama().equalsIgnoreCase(nama)) {
                this.penumpangBiasa.remove(i);
                return true;
            }
            i++;
        }
        
        i = 0;
        
        while(itr3.hasNext()) {
            Penumpang p = itr3.next();
            
            if(p.getNama().equalsIgnoreCase(nama)) {
                this.penumpangBerdiri.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }
   
    /**
     * Method untuk menurunkan penumpang berdasarkan ID penumpang.
     * 
     * @param ID data ID penumpang yang ingin diturunkan.
     * @return true jika penumpang dengan ID tersebut ditemukan dan false jika penumpang dengan ID tersebut tidak ditemukan.
     */
    public boolean turunkanPenumpangID(int ID)
    {
        for(int i = 0; i < getJumlahPenumpangPrioritas(); i++) {
            if(penumpangPrioritas.get(i).getID() == ID) {
                penumpangPrioritas.remove(i);
                return true;
            }
        }
         
        for(int i = 0; i < getJumlahPenumpangBiasa(); i++) {
            if(penumpangBiasa.get(i).getID() == ID) {
                penumpangBiasa.remove(i);
                return true;
            }
        }
         
        for(int i = 0; i < getJumlahPenumpangBerdiri(); i++) {
            if(penumpangBerdiri.get(i).getID() == ID) {
                penumpangBerdiri.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method untuk menambahkan saldo penumpang dengan pencarian berdasarkan ID penumpang.
     * 
     * @param ID data ID penumpang yang saldonya ingin ditambahkan.
     * @param saldoTambahan nominal saldo yang ingin ditambahkan.
     * @return true apabila saldo penumpang tersebut berhasil ditambahkan dan false apabila saldo penumpang tersebut gagal ditambahkan.
     */
    public boolean menambahkanSaldo(int ID, int saldoTambahan)
    {
        this.itr1 = this.penumpangPrioritas.iterator();
        this.itr2 = this.penumpangBiasa.iterator();
        this.itr3 = this.penumpangBerdiri.iterator();
        int i = 0;  
        
        while(itr1.hasNext()) {
            Penumpang p = itr1.next();
            
            if(p.getID() == ID) {
                this.penumpangPrioritas.get(i).tambahSaldo(saldoTambahan);
                return true;
            }
            i++;
        }
        
        i = 0;
        
        while(itr2.hasNext()) {
            Penumpang p = itr2.next();
            
            if(p.getID() == ID) {
                this.penumpangBiasa.get(i).tambahSaldo(saldoTambahan);
                return true;
            }
            i++;
        }
        
        i = 0;
        
        while(itr3.hasNext()) {
            Penumpang p = itr3.next();
            
            if(p.getID() == ID) {
                this.penumpangBerdiri.get(i).tambahSaldo(saldoTambahan);
                return true;
            }
            i++;
        }
        return false;
    }
    
    /**
     * Method yang mencetak daftar nama dan ID setiap penumpang prioritas (penumpang yang duduk di kursi penumpang prioritas), daftar nama dan ID setiap penumpang Biasa (penumpang yang
     * duduk di kursi penumpang biasa dan penumpang yang berdiri), jumlah penumpang, dan jumlah pendapatan bus.
     * 
     * @return daftar nama dan ID setiap penumpang prioritas (penumpang yang duduk di kursi penumpang prioritas), daftar nama dan ID setiap penumpang Biasa (penumpang yang duduk di
     * kursi penumpang biasa dan penumpang yang berdiri), jumlah penumpang, dan jumlah pendapatan bus.
     */
    @Override
    public String toString()
    {        
        if( (getJumlahPenumpangPrioritas() + getJumlahPenumpangBiasa() + getJumlahPenumpangBerdiri()) == 0 ) {
            return "Penumpang prioritas : <kosong>" +
                   "\nPenumpang biasa     : <kosong>" + 
                   "\nJumlah penumpang    : 0" +
                   "\nJumlah pendapatan   : 0";
        }
        else if( (getJumlahPenumpangBiasa() == 0) && (getJumlahPenumpangBerdiri() == 0) ) {   
            System.out.print("Penumpang prioritas : "); 
            cetakDataPenumpangPrioritas();
            System.out.println("Penumpang biasa     : <kosong>"); 
            System.out.println("Jumlah penumpang    : " + getJumlahPenumpangPrioritas());           
            System.out.print("Jumlah pendapatan   : " + this.totalPendapatan);
            return "";
        }
        else if(getJumlahPenumpangPrioritas() == 0) {
            System.out.println("Penumpang prioritas : <kosong>");
            System.out.print("Penumpang biasa     : ");
            cetakDataPenumpangBiasa();
            System.out.println("Jumlah penumpang    : " + (getJumlahPenumpangBiasa() + getJumlahPenumpangBerdiri()));
            System.out.println("Jumlah pendapatan   : " + this.totalPendapatan);
            return "";
        }       
        else {
            System.out.print("Penumpang prioritas : "); 
            cetakDataPenumpangPrioritas();
            System.out.print("Penumpang biasa     : ");
            cetakDataPenumpangBiasa();
            System.out.println("Jumlah penumpang    : " + (getJumlahPenumpangPrioritas() + getJumlahPenumpangBiasa() + getJumlahPenumpangBerdiri()));
            System.out.println("Jumlah pendapatan   : " + this.totalPendapatan);
            return "";
        }
    }
}
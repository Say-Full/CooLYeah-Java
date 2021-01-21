
/**
 * Class Penumpang adalah class yang akan dijadikan objek penumpang.
 *
 * @author Muhammad Saifullah Sani
 * @version 12/01/2021
 */
public class Penumpang
{
    private int id;
    private String nama;
    private char jenisKelamin;
    private boolean hamil;
    private int umur;
    private int saldo;

    /**
     * Constructor untuk objek class Penumpang yang memberikan nilai awal id, nama, umur, dan hamil berdasarkan parameter, dan memberikan nilai awal saldo.
     * 
     * @param id ID penumpang yang diberikan.
     * @param nama nama penumpang.
     * @param jenisKelamin jenis kelamin penumpang.
     * @param hamil status kehamilan penumpang.
     * @param umur umur penumpang.
     */
    public Penumpang(int id, String nama, char jenisKelamin, boolean hamil, int umur)
    {
        this.id = id;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.hamil = hamil;
        this.umur = umur;
        this.saldo = 10000;
    }
    
    /**
     * Method accessor atribut ID.
     * 
     * @return ID penumpang.
     */
    public int getID()
    {
        return this.id;
    }
    
    /**
     * Method accessor nama penumpang.
     * 
     * @return nama penumpang.
     */
    public String getNama()
    {
        return this.nama;
    }
    
    /**
     * Method accessor jenis kelamin penumpang.
     * 
     * @return jenis kelamin penumpang.
     */
    public char getJenisKelamin()
    {
        return this.jenisKelamin;
    }
    
    /**
     * Method accessor status hamil penumpang.
     * 
     * @return true jika penumpang sedang hamil dan false jika penumpang tidak hamil.
     */
    public boolean getHamil()
    {
        return this.hamil;
    }
    
    /**
     * Method accessor umur penumpang.
     * 
     * @return umur penumpang.
     */
    public int getUmur()
    {
        return this.umur;
    }
    
    /**
     * Method accessor saldo penumpang.
     * 
     * @return saldo penumpang.
     */
    public int getSaldo()
    {
        return this.saldo;
    }
    
    /**
     * Method mutator saldo penumpang untuk menambah saldo penumpang.
     * 
     * @param saldoBaru nominal penambahan saldo penumpang.
     */
    public void tambahSaldo(int saldoBaru)
    {
        this.saldo += saldoBaru;
    }
    
    /**
     * Method mutator saldo penumpang untuk mengurangi saldo penumpang.
     * 
     * @param ongkos nominal pengurangan saldo penumpang.
     */
    public void kurangiSaldo(int ongkos)
    {
        this.saldo -= ongkos;
    }
}

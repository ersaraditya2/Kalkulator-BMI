/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ersaraditya2
 */
public abstract class Kalkulator {
    private String nama;
    private String jenisK;
    private double berat;
    private int tinggi;
    

    public Kalkulator(String nama, String jenisK,double berat, int tinggi) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama ga boleh kosong");
        }
        
        this.jenisK = jenisK;
        this.nama = nama;
        this.berat = berat;
        this.tinggi = tinggi;
    }

    public String getNama() {
        return nama;
    }

    public double getBerat() {
        return berat;
    }

    public int getTinggi() {
        return tinggi;
    }
    
    public abstract double hitungBMI();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ersaraditya2
 */
public class kalkulatorBMI extends Kalkulator{

    public kalkulatorBMI(String nama, String jenisK, double berat, int tinggi) {
        super(nama, jenisK, berat, tinggi);
    }
    
    @Override
    public double hitungBMI() {
        return (getBerat() / (getTinggi() * getTinggi()) * 10000);
    }
    
}

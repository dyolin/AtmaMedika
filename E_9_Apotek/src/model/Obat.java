/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Obat {
    private int id_obat;
    private String nama_obat;
    private String kategori;
    private double harga_obat;
    private int jumlah_stok;

    public Obat(int id_obat, String nama_obat, String kategori, double harga_obat, int jumlah_stok) {
        this.id_obat = id_obat;
        this.nama_obat = nama_obat;
        this.kategori = kategori;
        this.harga_obat = harga_obat;
        this.jumlah_stok = jumlah_stok;
    }
    
     public Obat(String nama_obat, String kategori, double harga_obat, int jumlah_stok) {
        this.nama_obat = nama_obat;
        this.kategori = kategori;
        this.harga_obat = harga_obat;
        this.jumlah_stok = jumlah_stok;
    }

    public int getId_obat() {
        return id_obat;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public String getKategori() {
        return kategori;
    }

    public double getHarga_obat() {
        return harga_obat;
    }

    public int getJumlah_stok() {
        return jumlah_stok;
    }

    public void setId_obat(int id_obat) {
        this.id_obat = id_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setHarga_obat(double harga_obat) {
        this.harga_obat = harga_obat;
    }

    public void setJumlah_stok(int jumlah_stok) {
        this.jumlah_stok = jumlah_stok;
    }

    @Override
    public String toString(){
        return nama_obat;
    }
    
}

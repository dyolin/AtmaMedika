/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class PengadaanObat {
    private int id_pengadaan, id_apoteker, id_supplier, id_obat;
    private Apoteker apoteker;
    private Supplier supplier;
    private Obat obat;
    private double harga_total;
    private String tanggal_pengadaan;
    private int kuantitas;

    public PengadaanObat(int id_pengadaan, int id_apoteker, int id_supplier, int id_obat, Apoteker apoteker, Supplier supplier, Obat obat, double harga_total, String tanggal_pengadaan, int kuantitas) {
        this.id_pengadaan = id_pengadaan;
        this.id_apoteker = id_apoteker;
        this.id_supplier = id_supplier;
        this.id_obat = id_obat;
        this.apoteker = apoteker;
        this.supplier = supplier;
        this.obat = obat;
        this.harga_total = harga_total;
        this.tanggal_pengadaan = tanggal_pengadaan;
        this.kuantitas = kuantitas;
    }

    public PengadaanObat(int id_apoteker, int id_supplier, int id_obat, Apoteker apoteker, Supplier supplier, Obat obat, double harga_total, String tanggal_pengadaan, int kuantitas) {
        this.id_apoteker = id_apoteker;
        this.id_supplier = id_supplier;
        this.id_obat = id_obat;
        this.apoteker = apoteker;
        this.supplier = supplier;
        this.obat = obat;
        this.harga_total = harga_total;
        this.tanggal_pengadaan = tanggal_pengadaan;
        this.kuantitas = kuantitas;
    }

    public int getId_pengadaan() {
        return id_pengadaan;
    }

    public void setId_pengadaan(int id_pengadaan) {
        this.id_pengadaan = id_pengadaan;
    }

    public int getId_apoteker() {
        return id_apoteker;
    }

    public void setId_apoteker(int id_apoteker) {
        this.id_apoteker = id_apoteker;
    }

    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public int getId_obat() {
        return id_obat;
    }

    public void setId_obat(int id_obat) {
        this.id_obat = id_obat;
    }

    public Apoteker getApoteker() {
        return apoteker;
    }

    public void setApoteker(Apoteker apoteker) {
        this.apoteker = apoteker;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Obat getObat() {
        return obat;
    }

    public void setObat(Obat obat) {
        this.obat = obat;
    }

    public double getHarga_total() {
        harga_total = kuantitas * obat.getHarga_obat();
        return harga_total;
    }

    public void setHarga_total(double harga_total) {
        this.harga_total = harga_total;
    }

    public String getTanggal_pengadaan() {
        return tanggal_pengadaan;
    }

    public void setTanggal_pengadaan(String tanggal_pengadaan) {
        this.tanggal_pengadaan = tanggal_pengadaan;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }
    
    

    

    
}

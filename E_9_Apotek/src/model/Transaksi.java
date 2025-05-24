/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Transaksi {
    private int id_transaksi, id_apoteker, id_pelanggan, id_obat;
    private Apoteker apoteker;
    private Pelanggan pelanggan;
    private Obat obat;
    private String tanggal_transaksi;
    private int kuantitas;
    private String metode_pembayaran;
    private double harga_total;

    public Transaksi(int id_transaksi, int id_apoteker, int id_pelanggan, int id_obat, Apoteker apoteker, Pelanggan pelanggan, Obat obat, String tanggal_transaksi, int kuantitas, String metode_pembayaran, double harga_total) {
        this.id_transaksi = id_transaksi;
        this.id_apoteker = id_apoteker;
        this.id_pelanggan = id_pelanggan;
        this.id_obat = id_obat;
        this.apoteker = apoteker;
        this.pelanggan = pelanggan;
        this.obat = obat;
        this.tanggal_transaksi = tanggal_transaksi;
        this.kuantitas = kuantitas;
        this.metode_pembayaran = metode_pembayaran;
        this.harga_total = harga_total;
    }

    

    public Transaksi(int id_apoteker, int id_pelanggan, int id_obat, Apoteker apoteker, Pelanggan pelanggan, Obat obat, String tanggal_transaksi, int kuantitas, String metode_pembayaran, double harga_total) {
        this.id_apoteker = id_apoteker;
        this.id_pelanggan = id_pelanggan;
        this.id_obat = id_obat;
        this.apoteker = apoteker;
        this.pelanggan = pelanggan;
        this.obat = obat;
        this.tanggal_transaksi = tanggal_transaksi;
        this.kuantitas = kuantitas;
        this.metode_pembayaran = metode_pembayaran;
        this.harga_total = harga_total;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_apoteker() {
        return id_apoteker;
    }

    public void setId_apoteker(int id_apoteker) {
        this.id_apoteker = id_apoteker;
    }

    public int getId_pelanggan() {
        return id_pelanggan;
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
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

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Obat getObat() {
        return obat;
    }

    public void setObat(Obat obat) {
        this.obat = obat;
    }

    public String getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(String tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public double getHarga_total() {
        return harga_total;
    }

    public void setHarga_total(double harga_total) {
        this.harga_total = harga_total;
    }
}

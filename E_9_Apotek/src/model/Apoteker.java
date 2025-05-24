/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class Apoteker {
    private int id_apoteker;
    private String nama;
    private String alamat;
    private String no_telepon;
    private String pengalaman;
    private double gaji;

    public Apoteker(int id_apoteker, String nama, String alamat, String no_telepon, String pengalaman, double gaji) {
        this.id_apoteker = id_apoteker;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
        this.pengalaman = pengalaman;
        this.gaji = gaji;
    }
    
    public Apoteker(String nama, String alamat, String no_telepon, String pengalaman, double gaji) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
        this.pengalaman = pengalaman;
        this.gaji = gaji;
    }
    
    public int getId_apoteker() {
        return id_apoteker;
    }

    public void setId_apoteker(int id_apoteker) {
        this.id_apoteker = id_apoteker;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getPengalaman() {
        return pengalaman;
    }

    public void setPengalaman(String pengalaman) {
        this.pengalaman = pengalaman;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    
    @Override
    public String toString(){
        return nama;
    }
    
}

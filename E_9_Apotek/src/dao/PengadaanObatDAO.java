/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import connection.DbConnection;
import InterfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.*;
/**
 *
 * @author Sherlyna Alfelia
 */
public class PengadaanObatDAO implements IDAO<PengadaanObat, String>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;

    @Override
    public void insert(PengadaanObat PO) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO `pengadaanobat` "
                + "(`id_apoteker`, `id_supplier`, `id_obat`, `tanggal_pengadaan`, `kuantitas`, `harga_total`)"
                + " VALUES "
                + "('" + PO.getId_apoteker() + "', '" + PO.getId_supplier() + "', '"
                +PO.getId_obat() + "', '" + PO.getTanggal_pengadaan() + "', '" + PO.getKuantitas() + "', '" + PO.getHarga_total() + "')";
        System.out.println("Adding Pengadaan Obat...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Pengadaan Obat");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Pengadaan Obat...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<PengadaanObat> showData(String data) {
        con = dbCon.makeConnection();
        
            String sql = "SELECT * "
                    + "FROM pengadaanobat PO "
                    + "JOIN apoteker A ON (PO.id_apoteker = A.id_apoteker) "
                    + "JOIN supplier S ON (PO.id_supplier = S.id_supplier) "
                    + "JOIN obat O ON (PO.id_obat = O.id_obat) "
                    + "WHERE (PO.tanggal_pengadaan LIKE '%" +data+ "%' "
                    + "OR A.nama LIKE '%" +data+ "%' "
                    + "OR S.nama LIKE '%" +data+ "%' "
                    + "OR O.nama_obat LIKE '%" +data+ "%')";
            
            System.out.println("Mengambil data Pengadaan Obat...");
            List<PengadaanObat> listPengadaan = new ArrayList();
            //KendaraanE k = null;
            
            try{
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                
                if(rs!=null){
                    while(rs.next()){
                        Supplier S = new Supplier(
                            rs.getInt("S.id_supplier"),
                            rs.getString("S.nama"),
                            rs.getString("S.alamat"),
                            rs.getString("S.no_telepon")
                        );
                        
                        Apoteker A = new Apoteker(
                                rs.getInt("A.id_apoteker"),
                                rs.getString("A.nama"),
                                rs.getString("A.alamat"),
                                rs.getString("A.no_telepon"),
                                rs.getString("A.pengalaman"),
                                rs.getDouble("A.gaji")
                                
                        );
                        
                        Obat O = new Obat(
                                rs.getInt("O.id_obat"),
                                rs.getString("O.nama_obat"),
                                rs.getString("O.kategori"),
                                rs.getDouble("O.harga_obat"),
                                rs.getInt("O.jumlah_stok")
                                
                        );
                        
                        PengadaanObat PO = new PengadaanObat(
                            rs.getInt("PO.id_pengadaan"),
                            rs.getInt("PO.id_apoteker"),
                            rs.getInt("PO.id_supplier"),
                            rs.getInt("PO.id_obat"),
                            A,
                            S,
                            O,
                            rs.getDouble("PO.harga_total"),
                            rs.getString("PO.tanggal_pengadaan"),
                            rs.getInt("PO.kuantitas")
                        );
                        listPengadaan.add(PO);
                    }
                }
                
                rs.close();
                statement.close();
            }catch(Exception e){
                System.out.println("Error Fetching data...");
                System.out.println(e);
            }
            System.out.println("Berhasil");
            dbCon.closeConnection();
            return listPengadaan;
    }

    @Override
    public void update(PengadaanObat PO, String id_pengadaan) {
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `pengadaanobat` SET "
                + "`id_apoteker`= '" + PO.getId_apoteker() + "', `id_supplier`= " + PO.getId_supplier() + ", "
                + "`id_obat`= '" +PO.getId_obat()+ "', "
                + "`kuantitas`= '" +PO.getKuantitas()+ "', `harga_total` = '" + PO.getHarga_total()+ "' "
                + "WHERE `id_pengadaan` = " + id_pengadaan + "";
        System.out.println("Editing Transaksi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Transaksi");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data) {
         con = dbCon.makeConnection();
        
        String sql = "DELETE FROM pengadaanobat "
                + "WHERE id_pengadaan = " +data+ "";
        System.out.println("Deleting Pengadaan Obat...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Pengadaan Obat");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Deleting Pengadaan Obat...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}

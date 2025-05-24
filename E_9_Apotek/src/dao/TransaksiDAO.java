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
public class TransaksiDAO implements IDAO<Transaksi, String>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Transaksi t) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO `transaksi` "
                + "(`id_apoteker`, `id_pelanggan`, `id_obat`, `tanggal_transaksi`, `kuantitas`, `metode_pembayaran`, `total_harga`)"
                + " VALUES "
                + "('" + t.getId_apoteker() + "', '" + t.getId_pelanggan() + "', '"
                + t.getId_obat() + "', '" + t.getTanggal_transaksi() + "', '" + t.getKuantitas() + "', '" + t.getMetode_pembayaran() + "', '" + t.getHarga_total() + "')";
        System.out.println("Adding Transaksi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Transaksi");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    
    @Override
    public List<Transaksi> showData(String data) {
        con = dbCon.makeConnection();
        
            String sql = "SELECT * "
                    + "FROM transaksi T "
                    + "JOIN apoteker A ON (T.id_apoteker = A.id_apoteker) "
                    + "JOIN pelanggan P ON (T.id_pelanggan = P.id_pelanggan) "
                    + "JOIN obat O ON (T.id_obat = O.id_obat) "
                    + "WHERE (T.tanggal_transaksi LIKE '%" +data+ "%' "
                    + "OR T.metode_pembayaran LIKE '%" +data+ "%')";
            
            System.out.println("Mengambil data Transaksi...");
            List<Transaksi> listTransaksi = new ArrayList();
            //KendaraanE k = null;
            
            try{
                Statement statement = con.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                
                if(rs!=null){
                    while(rs.next()){
                        Pelanggan P = new Pelanggan(
                            rs.getInt("P.id_pelanggan"),
                            rs.getString("P.nama"),
                            rs.getString("P.alamat"),
                            rs.getString("P.no_telepon")
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
                        
                        Transaksi T = new Transaksi(
                            rs.getInt("T.id_transaksi"),
                            rs.getInt("T.id_apoteker"),
                            rs.getInt("T.id_pelanggan"),
                            rs.getInt("T.id_obat"),
                            A,
                            P,
                            O,
                            rs.getString("T.tanggal_transaksi"),
                            rs.getInt("T.kuantitas"),
                            rs.getString("T.metode_pembayaran"),
                            rs.getDouble("T.total_harga")
                        );
                        listTransaksi.add(T);
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
            return listTransaksi;
    }
    
    @Override
    public void update(Transaksi t, String id_transaksi){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE `transaksi` SET "
                + "`id_apoteker`= " + t.getId_apoteker() + ", "
                + "`id_pelanggan`= " + t.getId_pelanggan() + ", "
                + "`id_obat`= " +t.getId_obat()+ ", "
                + "`tanggal_transaksi` = '" +t.getTanggal_transaksi()+ "', "
                + "`kuantitas`= " +t.getKuantitas()+ ", "
                + "`metode_pembayaran`= '" +t.getMetode_pembayaran()+"', "
                + "`total_harga` = " + t.getHarga_total()+ " "
                + "WHERE `id_transaksi` = " + id_transaksi + "";
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
        
        String sql = "DELETE FROM transaksi "
                + "WHERE id_transaksi = " +data+ "";
        System.out.println("Deleting transaksi...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Transaksi");
            statement.close();
        }catch(Exception e){
            System.out.println("Error Deleting Transaksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
}

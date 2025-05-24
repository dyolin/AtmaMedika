/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import connection.DbConnection;
import InterfaceDAO.IDAO;
import InterfaceDAO.IShowForDropdown;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Obat;
/**
 *
 * @author Sherlyna Alfelia
 */
public class ObatDAO implements IDAO<Obat, String>, IShowForDropdown<Obat>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Obat O) {
        con = dbCon.makeConnection();
        String sql = 
                "INSERT INTO `obat` (`nama_obat`, `kategori`, `harga_obat`, `jumlah_stok`)" +
                "VALUES ('"+O.getNama_obat()+"', '"+O.getKategori()+"', '"+O.getHarga_obat()+"', '"+O.getJumlah_stok()+"')";
        
        System.out.println("Adding Obat...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Obat");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Obat...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Obat> showData(String data) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM obat O "
                + "WHERE (O.nama_obat LIKE '%" +data+ "%' "
                + "OR O.kategori LIKE '%" +data+ "%')";        
        System.out.println("Fetching Data...");
        List<Obat> o = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null)
                while(rs.next())
                    o.add(new Obat(rs.getInt("id_obat"),
                        rs.getString("nama_obat"),
                        rs.getString("kategori"),
                        rs.getDouble("harga_obat"),
                        rs.getInt("jumlah_stok")));
                
                rs.close();
                statement.close();
            
        }catch(Exception e){
            System.out.println("Error Fetching Data ....");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return o;
    }

    @Override
    public void update(Obat O, String id_obat) {
         con = dbCon.makeConnection();
        String sql = "UPDATE `obat` SET "
                + "`nama_obat`='" +O.getNama_obat()+ "',"
                + "`kategori`='" +O.getKategori()+ "',"
                + "`harga_obat`='" +O.getHarga_obat()+ "',"
                + "`jumlah_stok`='" +O.getJumlah_stok()+ "' "
                + "WHERE `id_obat`='" +id_obat + "'";
        System.out.println("Updating Obat");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Obat " +id_obat);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Obat...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `obat` WHERE `id_obat` = " +data+ "";
        System.out.println("Deleting Customer...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" +result+ " Customer " +data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating customer...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    @Override
    public List<Obat> IShowForDropdown() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT obat.* FROM obat";
        
        System.out.println("Fetching Data...");
        List<Obat> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Obat o = null;
            
            if(rs!=null)
                while(rs.next()){
                    o = new Obat(
                        rs.getInt("id_obat"),
                        rs.getString("nama_obat"),
                        rs.getString("kategori"),
                        rs.getDouble("harga_obat"),
                        rs.getInt("jumlah_stok"));
                    
                    list.add(o);
                }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching Data ....");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
}

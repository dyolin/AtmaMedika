/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import connection.DbConnection;
import InterfaceDAO.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pelanggan;
/**
 *
 * @author Sherlyna Alfelia
 */
public class PelangganDAO implements IDAO<Pelanggan, String>, IShowForDropdown<Pelanggan>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;
   
    @Override
    public void insert(Pelanggan P) {
        con = dbCon.makeConnection();
        String sql = 
                "INSERT INTO `pelanggan` (`nama`, `alamat`, `no_telepon`)" +
                "VALUES ('"+P.getNama()+"', '"+P.getAlamat()+"', '"+P.getNo_telepon()+"')";
        
        System.out.println("Adding pelanggan...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " pelanggan");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Pelanggan> showData(String data) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM pelanggan P "
                + "WHERE (P.nama LIKE '%" +data+ "%' "
                + "OR P.alamat LIKE '%" +data+ "%' "
                + "OR P.no_telepon LIKE '%" +data+ "')";
        System.out.println("Fetching Data...");
        List<Pelanggan> p = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null)
                while(rs.next())
                    p.add(new Pelanggan(rs.getInt("id_pelanggan"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon")));
                
                rs.close();
                statement.close();
            
        }catch(Exception e){
            System.out.println("Error Fetching Data ....");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return p;
    }

    @Override
    public void update(Pelanggan p, String id_pelanggan) {
        con = dbCon.makeConnection();
        String sql = "UPDATE `pelanggan` SET "
                + "`nama`='" +p.getNama()+ "',"
                + "`alamat`='" +p.getAlamat()+ "',"
                + "`no_telepon`='" +p.getNo_telepon()+ "' "
                + "WHERE `id_pelanggan`= " +id_pelanggan + " ";
        System.out.println("Updating Pelanggan");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Pelanggan " +id_pelanggan);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `pelanggan` WHERE `id_pelanggan` = " +data+ "";
        System.out.println("Deleting Pelanggan...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" +result+ " Pelanggan " +data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating pelanggan...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Pelanggan> IShowForDropdown() {
        con = dbCon.makeConnection();
        String sql = "SELECT pelanggan.* FROM pelanggan;";
        System.out.println("Fetching data...");
        List<Pelanggan> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Pelanggan k = null;
            
            if(rs!=null)
                while(rs.next()){
                    k = new Pelanggan(
                        rs.getInt("id_pelanggan"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"));
                    list.add(k);
                }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error Fetching data...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return list;
    }
    
    
}

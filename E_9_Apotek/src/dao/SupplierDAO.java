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
import model.Supplier;
/**
 *
 * @author Sherlyna Alfelia
 */
public class SupplierDAO implements IDAO<Supplier, String>, IShowForDropdown<Supplier>{
     protected DbConnection dbCon = new DbConnection();
    protected Connection con;
    
    @Override
    public void insert(Supplier S) {
        con = dbCon.makeConnection();
        String sql = 
                "INSERT INTO `supplier` (`nama`, `alamat`, `no_telepon`)" +
                "VALUES ('"+S.getNama()+"', '"+S.getAlamat()+"', '"+S.getNo_telepon()+"')";
        
        System.out.println("Adding supplier...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Supplier");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Supplier...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Supplier> showData(String data) {
         con = dbCon.makeConnection();
        String sql = "SELECT * FROM supplier S "
                + "WHERE (S.nama LIKE '%" +data+ "%' "
                + "OR S.alamat LIKE '%" +data+ "%' "
                + "OR S.no_telepon LIKE '%" +data+ "%')";
        System.out.println("Fetching Data...");
        List<Supplier> s = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null)
                while(rs.next())
                    s.add(new Supplier(rs.getInt("id_supplier"),
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
        return s;
    }

    @Override
    public void update(Supplier S, String id_supplier) {
        con = dbCon.makeConnection();
        String sql = "UPDATE `supplier` SET " 
                + "`nama`='" +S.getNama()+ "',"
                + "`alamat`='" +S.getAlamat()+ "',"
                + "`no_telepon`='" +S.getNo_telepon()+ "' "
                + "WHERE `id_supplier`='" +id_supplier + "'";
        System.out.println("Updating Supplier");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Suuplier " +id_supplier);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Supplier...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `supplier` WHERE `id_supplier` = " +data+ "";
        System.out.println("Deleting Supplier...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" +result+ " Supplier " +data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating supplier...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    
     @Override
    public List<Supplier> IShowForDropdown() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT supplier.* FROM supplier";
        
        System.out.println("Fetching Data...");
        List<Supplier> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Supplier s = null;
            
            if(rs!=null)
                while(rs.next()){
                    s = new Supplier(
                        rs.getInt("id_supplier"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"));
                    
                    list.add(s);
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

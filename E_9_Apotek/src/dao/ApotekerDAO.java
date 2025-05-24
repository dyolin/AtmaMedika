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
import model.Apoteker;
/**
 *
 * @author Sherlyna Alfelia
 */
public class ApotekerDAO implements IDAO<Apoteker, String>, IShowForDropdown<Apoteker>{
    protected DbConnection dbCon = new DbConnection();
    protected Connection con;

    @Override
    public void insert(Apoteker A) {
        con = dbCon.makeConnection();
        String sql = 
                "INSERT INTO `apoteker` (`nama`, `alamat`, `no_telepon`, `pengalaman`, `gaji`)" +
                "VALUES ('"+A.getNama()+"', '"+A.getAlamat()+"', '"+A.getNo_telepon()+"', '"+A.getPengalaman()+"', '"+A.getGaji()+"')";
        
        System.out.println("Adding Apoteker...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " +result+ " Apoteker");
            statement.close();
        }catch(Exception e){
            System.out.println("Error adding Apoteker...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Apoteker> showData(String data) {
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM apoteker A "
                + "WHERE (A.nama LIKE '%" +data+ "%' "
                + "OR A.alamat LIKE '%" +data+ "%' "
                + "OR A.no_telepon LIKE '%" +data+ "%' "
                + "OR A.pengalaman LIKE '%" +data+ "%')";
        System.out.println("Fetching Data...");
        List<Apoteker> a = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null)
                while(rs.next())
                    a.add(new Apoteker(rs.getInt("A.id_apoteker"),
                        rs.getString("A.nama"),
                        rs.getString("A.alamat"),
                        rs.getString("A.no_telepon"),
                        rs.getString("A.pengalaman"),
                        rs.getDouble("A.gaji")));
                
                rs.close();
                statement.close();
            
        }catch(Exception e){
            System.out.println("Error Fetching Data ....");
            System.out.println(e);
        }
        dbCon.closeConnection();
        return a;
    }

    @Override
    public void update(Apoteker a, String id_apoteker) {
         con = dbCon.makeConnection();
        String sql = "UPDATE `apoteker` SET "
                + "`nama`='" +a.getNama()+ "',"
                + "`alamat`='" +a.getAlamat()+ "',"
                + "`no_telepon`='" +a.getNo_telepon()+ "',"
                + "`pengalaman`='" +a.getPengalaman()+ "',"
                + "`gaji`='" +a.getGaji()+ "' "
                + "WHERE `id_apoteker`='" +id_apoteker + "'";
        System.out.println("Updating Apoteker");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Apoteker " +id_apoteker);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating Apoteker...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public void delete(String data) {
        con = dbCon.makeConnection();
        String sql = "DELETE FROM `apoteker` WHERE `id_apoteker` = " +data+ "";
        System.out.println("Deleting Apoteker...");
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" +result+ " Apoteker " +data);
            statement.close();
        }catch(Exception e){
            System.out.println("Error Updating apoteker...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }

    @Override
    public List<Apoteker> IShowForDropdown() {
        con = dbCon.makeConnection();
        String sql = "SELECT apoteker.* FROM apoteker;";
        System.out.println("Fetching data...");
        List<Apoteker> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Apoteker k = null;
            
            if(rs!=null)
                while(rs.next()){
                    k = new Apoteker(
                        rs.getInt("id_apoteker"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("no_telepon"),
                        rs.getString("pengalaman"),
                        rs.getDouble("gaji"));
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

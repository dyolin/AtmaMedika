/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PelangganDAO;
import java.util.List;
import model.Apoteker;
import model.Pelanggan;
import table.TablePelanggan;

public class PelangganControl{
    private PelangganDAO pDao = new PelangganDAO();
    
    public void insertDataPelanggan(Pelanggan p){
        pDao.insert(p);
    }
   
    public TablePelanggan showTable(String target){
        List<Pelanggan> dataPelanggan = pDao.showData(target);
        TablePelanggan tablePelanggan = new TablePelanggan(dataPelanggan);
        
        return tablePelanggan;
    }
    
    public void updatePelanggan(Pelanggan p, int id_pelanggan){
        pDao.update(p, Integer.toString(id_pelanggan));
    }
    
    public void deletePelanggan(int id_pelanggan){
        pDao.delete(Integer.toString(id_pelanggan));
    }
    
    public List<Pelanggan> showListPelanggan(){
        List<Pelanggan> dataPelanggan = pDao.IShowForDropdown();
        return dataPelanggan;
    }
}

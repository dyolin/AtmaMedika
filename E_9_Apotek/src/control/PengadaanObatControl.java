/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import dao.PengadaanObatDAO;
import java.util.List;
import model.PengadaanObat;
import table.TablePengadaanObat;
/**
 *
 * @author Sherlyna Alfelia
 */
public class PengadaanObatControl {
     private PengadaanObatDAO poDao = new  PengadaanObatDAO();
    
    public void insertDataPengadaan(PengadaanObat po){
        poDao.insert(po);
    }
   
    public TablePengadaanObat showTable(String target){
        List<PengadaanObat> dataPengadaan = poDao.showData(target);
        TablePengadaanObat tablePengadaanObat = new TablePengadaanObat(dataPengadaan);
        
        for(PengadaanObat pengadaan : dataPengadaan){
            System.out.println(pengadaan.getObat().getNama_obat());
        }
        
        return tablePengadaanObat;
    }
    
    public void updatePengadaan(PengadaanObat po, int id_pengadaan){
        poDao.update(po, Integer.toString(id_pengadaan));
    }
    
    public void deletePengadaan(int id_pengadaan){
        poDao.delete(Integer.toString(id_pengadaan));
    }
}

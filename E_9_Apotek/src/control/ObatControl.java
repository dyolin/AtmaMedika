/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import dao.ObatDAO;
import java.util.List;
import model.Obat;
import table.TableObat;
/**
 *
 * @author Sherlyna Alfelia
 */
public class ObatControl {
    private ObatDAO oDao = new ObatDAO();
    
    public void insertDataObat(Obat o){
        oDao.insert(o);
    }
   
    public TableObat showTable(String target){
        List<Obat> dataObat = oDao.showData(target);
        TableObat tableObat = new TableObat(dataObat);
        
        return tableObat;
    }
    
    public void updateObat(Obat o, int id_obat){
        oDao.update(o, Integer.toString(id_obat));
    }
    
    public void deleteObat(int id_obat){
        oDao.delete(Integer.toString(id_obat));
    }
    
    public List<Obat> showListObat(){
        List<Obat> dataObat = oDao.IShowForDropdown();
        return dataObat;
    }
}

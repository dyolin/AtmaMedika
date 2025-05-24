/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import dao.ApotekerDAO;
import java.util.List;
import model.Apoteker;
import table.TableApoteker;
/**
 *
 * @author Sherlyna Alfelia
 */
public class ApotekerControl {
    private ApotekerDAO aDao = new ApotekerDAO();
    
    public void insertDataApoteker(Apoteker a){
        aDao.insert(a);
    }
   
    public TableApoteker showTable(String target){
        List<Apoteker> dataApoteker = aDao.showData(target);
        TableApoteker tableApoteker = new TableApoteker(dataApoteker);
        
        return tableApoteker;
    }
    
    public void updateApoteker(Apoteker a, int id_apoteker){
        aDao.update(a, Integer.toString(id_apoteker));
    }
    
    public void deleteApoteker(int id_apoteker){
        aDao.delete(Integer.toString(id_apoteker));
    }
    
    public List<Apoteker> showListApoteker(){
        List<Apoteker> dataApoteker = aDao.IShowForDropdown();
        return dataApoteker;
    }
}

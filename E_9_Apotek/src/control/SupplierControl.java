/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.SupplierDAO;
import java.util.List;
import model.Supplier;
import table.TableSupplier;

public class SupplierControl{
    private SupplierDAO sDao = new SupplierDAO();
    
    public void insertDataSupplier(Supplier s){
        sDao.insert(s);
    }
   
    public TableSupplier showTable(String target){
        List<Supplier> dataSupplier = sDao.showData(target);
        TableSupplier tableSupplier = new TableSupplier(dataSupplier);
        
        return tableSupplier;
    }
    
    public void updateSupplier(Supplier s, int id_supplier){
        sDao.update(s, Integer.toString(id_supplier));
    }
    
    public void deleteSupplier(int id_supplier){
        sDao.delete(Integer.toString(id_supplier));
    }
    
    public List<Supplier> showListSupplier(){
        List<Supplier> dataSupplier = sDao.IShowForDropdown();
        return dataSupplier;
    }
}
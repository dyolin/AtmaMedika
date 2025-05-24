/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.TransaksiDAO;
import java.util.List;
import model.Transaksi;
import table.TableTransaksi;

public class TransaksiControl{
    private TransaksiDAO tDao = new TransaksiDAO();
    
    public void insertDataTransaksi(Transaksi t){
        tDao.insert(t);
    }
   
    public TableTransaksi showTable(String target){
        List<Transaksi> dataTransaksi = tDao.showData(target);
        TableTransaksi tableTransaksi = new TableTransaksi(dataTransaksi);
        
        for(Transaksi transaksi : dataTransaksi){
            System.out.println(transaksi.getObat().getNama_obat());
        }
        
        return tableTransaksi;
    }
    
    public void updateTransaksi(Transaksi t, int id_transaksi){
        tDao.update(t, Integer.toString(id_transaksi));
    }
    
    public void deleteTransaksi(int id_transaksi){
        tDao.delete(Integer.toString(id_transaksi));
    }
}
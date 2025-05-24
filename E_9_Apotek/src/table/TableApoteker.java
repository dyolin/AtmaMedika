/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Apoteker;

public class TableApoteker extends AbstractTableModel{
    private List<Apoteker> list;

    public TableApoteker(List<Apoteker> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_apoteker();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getAlamat();
            case 3:
                return list.get(rowIndex).getNo_telepon();
            case 4:
                return list.get(rowIndex).getPengalaman();
            case 5:
                return list.get(rowIndex).getGaji();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Apoteker";
            case 1:
                return "Nama Apoteker";
            case 2:
                return "Alamat";
            case 3:
                return "Nomor Telepon";
            case 4:
                return "Pengalaman Kerja";
            case 5:
                return "Gaji";
            default:
                return null;
        }
    }
}
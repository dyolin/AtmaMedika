/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.PengadaanObat;

/**
 *
 * @author ASUS
 */
public class TablePengadaanObat extends AbstractTableModel{
    private List<PengadaanObat> list;

    public TablePengadaanObat(List<PengadaanObat> list) {
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
                return list.get(rowIndex).getObat().getNama_obat();
            case 1:
                return list.get(rowIndex).getSupplier().getNama();
            case 2:
                return list.get(rowIndex).getApoteker().getNama();
            case 3:
                return list.get(rowIndex).getTanggal_pengadaan();
            case 4:
                return list.get(rowIndex).getKuantitas();
            case 5:
                return list.get(rowIndex).getHarga_total();
            case 6:
                return list.get(rowIndex).getObat().getId_obat();
            case 7:
                return list.get(rowIndex).getSupplier().getId_supplier();
            case 8:
                return list.get(rowIndex).getApoteker().getId_apoteker();
            case 9:
                return list.get(rowIndex).getId_pengadaan();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nama Obat";
            case 1:
                return "Supplier";
            case 2:
                return "Apoteker";
            case 3:
                return "Tanggal";
            case 4:
                return "Kuantitas";
            case 5:
                return "Total Harga";
            default:
                return null;
        }
    }
}

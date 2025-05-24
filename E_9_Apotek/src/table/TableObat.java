/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Obat;

/**
 *
 * @author ASUS
 */
public class TableObat extends AbstractTableModel{
    private List<Obat> list;

    public TableObat(List<Obat> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId_obat();
            case 1:
                return list.get(rowIndex).getNama_obat();
            case 2:
                return list.get(rowIndex).getKategori();
            case 3:
                return list.get(rowIndex).getHarga_obat();
            case 4:
                return list.get(rowIndex).getJumlah_stok();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Obat";
            case 1:
                return "Nama Obat";
            case 2:
                return "Kategori Obat";
            case 3:
                return "Harga Obat";
            case 4:
                return "Jangka Simpan (bulan)";
            default:
                return null;
        }
    }
}

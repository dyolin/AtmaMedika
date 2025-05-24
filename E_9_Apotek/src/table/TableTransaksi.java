/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Transaksi;

/**
 *
 * @author ASUS
 */
public class TableTransaksi extends AbstractTableModel{
    private List<Transaksi> list;

    public TableTransaksi(List<Transaksi> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 7;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getTanggal_transaksi();
            case 1:
                return list.get(rowIndex).getApoteker().getNama();
            case 2:
                return list.get(rowIndex).getPelanggan().getNama();
            case 3:
                return list.get(rowIndex).getObat().getNama_obat();
            case 4:
                return list.get(rowIndex).getKuantitas();
            case 5:
                return list.get(rowIndex).getMetode_pembayaran();
            case 6:
                return list.get(rowIndex).getHarga_total();
            case 7:
                return list.get(rowIndex).getApoteker().getId_apoteker();
            case 8:
                return list.get(rowIndex).getPelanggan().getId_pelanggan();
            case 9:
                return list.get(rowIndex).getObat().getId_obat();
            case 10:
                return list.get(rowIndex).getId_transaksi();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Tanggal Transaksi";
            case 1:
                return "Nama Apoteker";
            case 2:
                return "Nama Pelanggan";
            case 3:
                return "Nama Obat";
            case 4:
                return "Qty";
            case 5:
                return "Metode Pembayaran";
            case 6:
                return "Total Harga";
            default:
                return null;
        }
    }
}

package appli;
import java.util.List;

import javax.swing.table.AbstractTableModel;
 
public class TableMateriel extends AbstractTableModel {
 
    private final String[] Mateiels = { "ReferenceInterne", "Libelle du Type de Materiel" };
    private final List<Materiel> Matos;
 
    public void addBook(Materiel Materiel) {
        int index = Matos.size();
        Matos.add(Materiel);
        fireTableRowsInserted(index, index);
    }
 
    public Materiel getBookAt(int row) {
        if (row >= Matos.size())
            return null;
        else
            return Matos.get(row);
    }
 
    public void deleteBookAt(int row){
        if (row < Matos.size()){
        	Matos.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }
 
    public TableMateriel(List<Materiel> matos) {
    	Matos = matos;
    }
 
    @Override
    public int getColumnCount() {
        return Mateiels.length;
    }
 
    @Override
    public int getRowCount() {
        return Matos.size();
    }
 
    @Override
    public String getColumnName(int column) {
        return Mateiels[column];
    }
 
    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
        case 0:
            return Matos.get(row).getReferenceInterne();
        case 1:
            return Matos.get(row).getLibelleTypeMateriel();
        default:
            return "";
        }
    }
 
}
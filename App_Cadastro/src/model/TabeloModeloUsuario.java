package model;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TabeloModeloUsuario extends AbstractTableModel{
    private ArrayList linhas = null;
    private String[] colunas = null;

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    
    public int getColumnCount() {
        return colunas.length;
    }
    
    public int getRowCount() {
        return linhas.size();
    }
    
    public Object getValueAt(int numLin, int numCol) {
        Object[]linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
    
    public TabeloModeloUsuario(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }
    
}

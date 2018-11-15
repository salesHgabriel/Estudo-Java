package controller;
import java.sql.*;
import javax.swing.JOptionPane;
public class ConexaoBD {
    
    public Statement stm;
    public ResultSet rs;
    
    private String driver = "org.msq.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/bdcontrole";
    private String usuario = "root";
    private String senha = "";
    
    public Connection con;
    
    public void conectar(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            
            //JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO CONEXÃO !\n" + ex.getMessage());
        }
    }

    public static void main(String[]args){

        ConexaoBD conecta = new ConexaoBD();
        conecta.conectar();

    }
    
    public void executeSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NO SQL DO BANCO" + ex.getMessage());
        }
    }
    
    public void desconectarBanco (){
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FECHAR O BANCO"+e.getMessage());
        }
        
    }
    

}
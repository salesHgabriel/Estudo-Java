package controller;
import java.sql.*;
import controller.ConexaoBD;
import model.UsuarioModel;
import javax.swing.JOptionPane;
    
public class UsuarioController {
    
    ConexaoBD cone = new ConexaoBD();
    UsuarioModel user = new UsuarioModel();
    
    public void salvar(UsuarioModel user){
        cone.conectar();
        
        try {
            PreparedStatement pst = cone.con.prepareStatement("INSERT INTO tbusuario (nome, login, senha)" + "VALUES(?,?,?)");
            
            pst.setString(1, user.getNome());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getSenha());
            //pst.setString(4, user.getPesquisar());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "DADOS INSERIDOS COM SUCESSO!");
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR");
            cone.desconectarBanco();
        }
    }
    
    
     public void excluir(UsuarioModel user){
            cone.conectar();
            try {
                PreparedStatement pst = cone.con.prepareStatement("delete  from tbusuario where idusuario=?");
//                 pst.setString(1, user.getNome());
////                pst.setString(2, user.getLogin());
////                pst.setString(3, user.getSenha());
                pst.setInt(1, user.getIduser());
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso");
                       
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao excluir dados");
            
            }
        
             
        
        
        }
    
    
    
    
    
    
        public UsuarioModel buscarUsuario(UsuarioModel user){
            cone.conectar();
            cone.executeSql("SELECT *FROM tbusuario WHERE NOME LIKE'%"+user.getPesquisa()+"%'");
            try {
                cone.rs.first();
                user.setNome(cone.rs.getString("nome"));
                user.setLogin(cone.rs.getString("login"));
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "USUÁRIO NÃO ENCONTRADO!"+e.getMessage());
            }
        cone.desconectarBanco();
        return user;
        
        }
        
        
        public void editar(UsuarioModel user){
            cone.conectar();
            
            try {
                PreparedStatement pst = cone.con.prepareStatement("update tbusuario set nome = ?, login=?, senha = ? where idusuario = ?");
                
                pst.setString(1, user.getNome());
                pst.setString(2, user.getLogin());
                pst.setString(3, user.getSenha());
                pst.setInt(4, user.getIduser());
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR"+ex);
                
            }
        
        cone.desconectarBanco();
        
        
        
        }
        
        
        
       
}
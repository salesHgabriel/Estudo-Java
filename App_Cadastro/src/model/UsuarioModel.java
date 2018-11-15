package model;
public class UsuarioModel {
    
    private String nome;
    private String login;
    private String senha;
    private String pesquisa;
    private String id; 
    public int Iduser;

    public int getIduser() {
        return Iduser;
    }

    public void setIduser(int Iduser) {
        this.Iduser = Iduser;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
                     
}

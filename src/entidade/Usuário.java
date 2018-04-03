package entidade;

import persistência.BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Cassiano Rogério
 */
public class Usuário {
    private int id;
    private String chave;
    private String usuário;
    private String senha;
    
    public Usuário(int id, String usuário){
        this.id = id;
        this.usuário = usuário;
    }
    
    public Usuário(int id, String chave, String usuário, String senha){
        this.id = id;
        this.chave = chave;
        this.usuário = usuário;
        this.senha = senha;
    }
    
    public Usuário(String chave, String usuário, String senha){
        this.chave = chave;
        this.usuário = usuário;
        this.senha = senha;
    }
    
    public Usuário(int id, String usuário, String senha){
        this.id = id;
        this.usuário = usuário;
        this.senha = senha;
    }
    
    public int getID() {
        return id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getChave() {
        return chave;
    }
    
    public void setChave(String id) {
        this.chave = id;
    }
    
    public String getusuário() {
        return usuário;
    }
    
    public void setusuário(String usuário){
        this.usuário = usuário;
    }
    
    public String getsenha() {
        return senha;
    }
    
    public void setsenha(String senha){
        this.senha = senha;
    }
    
    //Busca se um determinado usuário já esta cadastrado no banco de dados
    public static Usuário buscar_Usuário_Todos_os_dados (String user) {
        String sql = "SELECT id, chave, usuario, senha FROM usuarios WHERE usuario = ?";
        ResultSet lista_resultados = null;
        Usuário usuário = null;
        BD.criaConexãoComando();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, user);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) { 
                usuário = new Usuário (
                    Integer.parseInt(lista_resultados.getString("id")),
                    lista_resultados.getString("chave"),    
                    lista_resultados.getString("usuario"),
                    lista_resultados.getString("senha")    
                );
            }
            lista_resultados.close();
            comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                usuário = null;
                }
        BD.fechaComandoConexão();
    return usuário;
    }
    
    //Busca se um determinado usuário já esta cadastrado no banco de dados
    public static Usuário Checar_Cadastro_de_Usuário_e_PK (String user) {
        //String sql = "SELECT id, nome, usuario, usuário FROM senhas WHERE nome = ?";
        String sql = "SELECT id, usuario FROM usuarios WHERE usuario = ?";
        ResultSet lista_resultados = null;
        Usuário usuário = null;
        BD.criaConexãoComando();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, user);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) { 
                usuário = new Usuário (
                    Integer.parseInt(lista_resultados.getString("id")),
                    lista_resultados.getString("usuario")
                );
            }
            lista_resultados.close();
            comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                usuário = null;
                }
        BD.fechaComandoConexão();
    return usuário;
    }
    
    //Executa a instrução sql responsável por realizar a inserção do cadastro de usauário no banco de dados
    public static String inserirUsuario (Usuário dados) {
        BD.criaConexãoComando();
        String sql = "INSERT INTO usuarios (chave, usuario, senha)"
            + " VALUES (?,?,?)";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, dados.getChave());            
            comando.setString(2, dados.getusuário());
            comando.setString(3, dados.getsenha());
            comando.executeUpdate();
            comando.close();
            BD.fechaComandoConexão();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            BD.fechaComandoConexão();
            return "Erro no cadastro do usuário no banco de dados.\nPor gentileza tente novamente.\n\nCaso o erro persista:\nEncerre o programa e tente novamente ou\nsolicite ajuda ao administrador."; 
        }
    }
    
    //Busca se um determinado usuário já esta cadastrado no banco de dados
    public static Usuário buscar_Usuário_e_PK (String user) {
        //String sql = "SELECT id, nome, usuario, usuário FROM senhas WHERE nome = ?";
        String sql = "SELECT id, usuario, senha FROM usuarios WHERE usuario = ?";
        ResultSet lista_resultados = null;
        Usuário usuário = null;
        BD.criaConexãoComando();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, user);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) { 
                usuário = new Usuário (
                    Integer.parseInt(lista_resultados.getString("id")),
                    lista_resultados.getString("usuario"),
                    lista_resultados.getString("senha")    
                );
            }
            lista_resultados.close();
            comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                usuário = null;
                }
        BD.fechaComandoConexão();
    return usuário;
    }
    
    //Remove o cadastro informado através de sua chave primária(id) do banco de dados
    public static String removerSenha (int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        BD.criaConexãoComando();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, Integer.toString(id));
            comando.executeUpdate();
            comando.close();
            BD.fechaComandoConexão();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            BD.fechaComandoConexão();
            return "Erro na Remoção do usuário";
        }
    }
    
    //Executa a instrução sql responsável por realizar a alteração do cadastro no banco de dados
    public static String alterarSenha (Usuário dados) {
        BD.criaConexãoComando();
        String sql = "UPDATE usuarios SET chave = ?, usuario = ?, senha = ?"
            + " WHERE id = ?";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, dados.getChave());            
            comando.setString(2, dados.getusuário());
            comando.setString(3, dados.getsenha());
            comando.setString(4, Integer.toString(dados.getID()));
            comando.executeUpdate();
            comando.close();
            BD.fechaComandoConexão();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            BD.fechaComandoConexão();
            return "Erro na atualização do usuário"; 
        }
    }
}

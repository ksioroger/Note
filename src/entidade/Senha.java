package entidade;

import persistência.BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Cassiano Rogério
 */

public class Senha {
    
    private int id;
    private String nome;
    private String usuário;
    private String senha;
    
    public Senha(String nome, String usuário, String senha) {
        this.nome = nome;
        this.usuário = usuário;
        this.senha = senha;
    }
    
    public Senha(int id, String nome, String usuário, String senha) {
        this.id = id;
        this.nome = nome;
        this.usuário = usuário;
        this.senha = senha;
    }
    
    public int getID() {
        return id;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
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
    
    //Executa a instrução sql responsável por realizar a alteração do cadastro no banco de dados
    public static String alterarSenha (Senha senha) {
        BD.criaConexãoComando();
        String sql = "UPDATE senhas SET nome = ?, usuario = ?, senha = ?"
            + " WHERE id = ?";
        
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, senha.getNome());            
            comando.setString(2, senha.getusuário());
            comando.setString(3, senha.getsenha());
            comando.setString(4, Integer.toString(senha.getID()));
            comando.executeUpdate();
            comando.close();
            BD.fechaComandoConexão();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            BD.fechaComandoConexão();
            return "Erro na atualização da entrada no BD"; 
        }
    }

    //Executa a instrução sql responsável por realizar a inserção do cadastro no banco de dados
    public static String inserirSenha (Senha senha) {
        BD.criaConexãoComando();
        String sql = "INSERT INTO senhas (nome, usuario, senha)"
            + " VALUES (?,?,?)";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, senha.getNome());            
            comando.setString(2, senha.getusuário());
            comando.setString(3, senha.getsenha());
            comando.executeUpdate();
            comando.close();
            BD.fechaComandoConexão();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            BD.fechaComandoConexão();
            return "Erro na Inserção da entrada no BD"; 
        }
    }
    
    //Cria um vector com os dados de cadastro de senhas cadastradas
    public static Vector<Visão<String>> getVisões () {
        BD.criaConexãoComando();
        // Listar todas as senhas
        String sql = "SELECT * FROM senhas";
        ResultSet lista_resultados = null;
        // Vetor que irá armazenar as senhas do banco
        Vector<Visão<String>> visões = new Vector<Visão<String>> ();
        String nome;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            
            while (lista_resultados.next()){
                //recuperar as chave
                nome = lista_resultados.getString("nome"); 
                // Adiciona os valores recuperados no vetor
                visões.addElement(new Visão<String> (nome, 
                        "Nome: " + nome
                        + " |  Usuário: " + lista_resultados.getString("usuario")
                        + " | Senha: ********"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return visões;
    }
    
    //Cria a visão de um dos cadastros, contendo nome, usuário e senha
    public Visão<String> getVisão () {
        //return new Visão<String> (nome + " - " + usuário);
        return new Visão<String> (nome, 
                        "Nome: " + nome
                        + " |  Usuário: " + usuário
                        + " | Senha: ********");
    }
    
    //Busca dados de um cadastro de senha no banco e retorna suas informações incluindo sua chave primária
    public static Senha buscarSenhaEPK (String nome) {
        String sql = "SELECT id, nome, usuario, senha FROM senhas WHERE nome = ?";
        ResultSet lista_resultados = null;
        Senha senha = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                senha = new Senha (
                    Integer.parseInt(lista_resultados.getString("id")),
                    lista_resultados.getString("nome"),
                    lista_resultados.getString("usuario"),
                    lista_resultados.getString("senha")
                );
            }
            lista_resultados.close();
            comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                senha = null;
                }
    return senha;
    }
    
    //Remove o cadastro informado através de sua chave primária(id) do banco de dados
    public static String removerSenha (int id) {
        String sql = "DELETE FROM senhas WHERE id = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, Integer.toString(id));
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Remoção da senha no BD";
        }
    }
    
    //Busca dados de um cadastro de senha no banco e retorna suas informações exceto sua chave primária
    public static Senha buscarSenha (String nome) {
        String sql = "SELECT nome, usuario, senha FROM senhas WHERE nome = ?";
        ResultSet lista_resultados = null;
        Senha senha = null;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                senha = new Senha (nome,
                lista_resultados.getString("usuario"),
                lista_resultados.getString("senha"));
            }
            lista_resultados.close();
            comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                senha = null;
                }
    return senha;
    }
    
    @Override
    public String toString () {
        return nome + " - " + usuário;
    }  
}

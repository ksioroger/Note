package entidade;

import persistência.BD;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Cassiano Rogério
 */

public class Senha {
    
    private int id;
    private int iduser;
    private String nome;
    private String usuário;
    private String senha;
    static String IV = "F5SENHAACESSO-TI";
    
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
    
    public Senha(int id, int iduser, String nome, String usuário, String senha) {
        this.id = id;
        this.iduser = iduser;
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
    
    public int getIdUser() {
        return iduser;
    }
    
    public void setIdUser(int iduser) {
        this.iduser = iduser;
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
    
    public void set_senha(String senha){
        this.senha = senha;
    }
    
    /**
     *
     * @param passLength
     * @return
     */
    public static String gerador_de_chave_de_criptografia(int passLength){
        java.util.Random r = new java.util.Random();
        char[] goodChar = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'w', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
            '1', '2', '3', '4', '5', '6', '7', '8', '9',
        };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < passLength; i++){
            sb.append(goodChar[r.nextInt(goodChar.length)]);
        }
        return sb.toString();
    }
    
    /**
     *
     * @param passLength
     * @return
     */
    public static String geradorDeSenha(int passLength){
        java.util.Random r = new java.util.Random();
        char[] goodChar = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'w', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 
            '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'ç', 'Ç', 'á', 'à', 'ã', 'Á', 'À', 'Ã', 'é', 'è', 'É', 'È', 'ó',
            'ò', 'õ', 'Ó', 'Ò', 'Õ', 'í', 'ì', 'Í', 'Ì', 'ú', 'ù', 'Ú', 'Ù',
            '!', '"', '#', ':', ';', '<', '=', '>', '?', '@', '[', ']', '^',
            '`', '{', '|', '}', '~', '_',
        };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < passLength; i++){
            sb.append(goodChar[r.nextInt(goodChar.length)]);
        }
        return sb.toString();
    }
    
    //Testa forca da senha
    /**
     *  Caso a senha for fraca retorna 1, regular 2, boa 3 e forte 4
     *      >> Senha FRACA: senha composta apenas por,
     *          letras minúsculas ou 
     *          letras maiúsculas ou 
     *          apenas números ou 
     *          apenas caracteres especiais.
     *  
     *      >> Senha REGULAR: senha composta apenas
     *          por, letras minúsculas e letras maiúsculas ou
     *          por, letras minúsculas e números ou
     *          por, letras minúsculas e caracteres especiais   ou
     * 
     *          por, letras maiúsculas e letras minúsculas ou
     *          por, letras maiúsculas e números ou
     *          por, letras maiúsculas e caracteres especiais   ou
     *
     *          por, números e letras minúsculas ou
     *          por, números e letras maiúsculas ou
     *          por, números e caracteres especiais   ou
     *          
     *          por, caracteres especiais e letras minúsculas ou
     *          por, caracteres especiais e letras maiúsculas ou
     *          por, caracteres especiais e números
     * 
     *      >> Senha BOA: senha composta apenas
     *          por, letras minúsculas e letras maiúsculas e números ou
     *          por, letras minúsculas e letras maiúsculas e caracteres especiais ou
     *
     *          por, letras minúsculas e números e letras maiúsculas ou
     *          por, letras minúsculas e números e caracteres especiais ou 
     * 
     *          por, letras minúsculas e caracteres especiais e letras maiúsculas ou
     *          por, letras minúsculas e caracteres especiais e números ou 
     * 
     *          por, letras maiúsculas e letras minúsculas e números ou
     *          por, letras maiúsculas e letras minúsculas e caracteres especiais ou
     *
     *          por, letras maiúsculas e números e letras minúsculas ou
     *          por, letras maiúsculas e números e caracteres especiais ou 
     * 
     *          por, letras maiúsculas e caracteres especiais e letras minúsculas ou
     *          por, letras maiúsculas e caracteres especiais e números ou 
     * 
     *          por, números e letras minúsculas e letras maiúsculas ou
     *          por, números e letras minúsculas e caracteres especiais ou
     *
     *          por, números e letras maiúsculas e letras minúsculas ou
     *          por, números e letras maiúsculas e caracteres especiais ou 
     * 
     *          por, números e caracteres especiais e letras maiúsculas ou
     *          por, números e caracteres especiais e letras minúsculas ou
     * 
     *          por, caracteres especiais e letras minúsculas e letras maiúsculas ou
     *          por, caracteres especiais e letras minúsculas e números ou
     *
     *          por, caracteres especiais e letras maiúsculas e letras minúsculas ou
     *          por, caracteres especiais e letras maiúsculas e números ou
     *
     *          por, caracteres especiais e números e letras minúsculas ou
     *          por, caracteres especiais e números e letras minúsculas
     * 
     *      >> Senha FORTE: senha composta pela combinação dos quatro tipos de caracteres,
     *          letras minúsculas, letras maiúsculas, números e caracteres especiais.
     * 
     * @param senha
     * @return
     */
    public static int testar_Forca_Da_Senha(String senha) {
        int forca = 0;
        String caracter_string;
        int num = 0, especial = 0, minus = 0, maius = 0;
        /*
         *  Testa a força da senha levando em consideração o uso de quatro tipos de caracteres.
         *  Será o brigatório o uso de um caracter minúsculo, maiúsculo, númerico e especial.
         */
        for (int i = 0; i < senha.length(); i++) {
            caracter_string = Character.toString(senha.charAt(i));
            if(caracter_string.matches("[0-9]+")){
                num +=1;
            }
            if (caracter_string.matches("[^\\w]+")) {
                especial +=1;
            }
            if (caracter_string.matches("[a-z]+")) {
                minus +=1;
            }
            if (caracter_string.matches("[A-Z]+")) {
                maius +=1;
            }
        }
        /*
        if(senha.matches("[a-z]+") || senha.matches("[0-9]+") || senha.matches("[A-Z]+") || senha.matches("W+")){
            forca += 10;
        }
        else if(senha.matches("[a-z0-9]+") || senha.matches("[A-Z0-9]+") || senha.matches("[a-zA-Z]") ) {
            forca += 15;
        }
        else {
            forca += 30;
        }
        */
        if(num>=1){
            forca+=1;
        }
        if (especial>=1){
            forca+=1;
        }
        if (minus>=1){
            forca+=1;
        }
        if (maius>=1){
            forca+=1;
        }
        return forca;
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
    
    public void descriptografa(String senha) {
        try {      
            KeyGenerator keygenerator = KeyGenerator.getInstance("ACESSO");
            SecretKey chaveDES = keygenerator.generateKey();
            
            Cipher cifraDES;
            
            // Cria a cifra 
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");
            
            // Inicializa a cifra para o processo de encriptação
            cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);
            
            System.out.println("Texto Encriptado : " + senha);
            
            // Inicializa a cifra também para o processo de decriptação
            cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);
            
            // Decriptografa o texto
            byte[] textoDecriptografado = cifraDES.doFinal(senha.getBytes());
            System.out.println("Texto Decriptografado : " + new String(textoDecriptografado));
            } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //Executa a instrução sql responsável por realizar a inserção do cadastro no banco de dados
    public static String inserirSenha (Senha senha) {
        BD.criaConexãoComando();
        String sql = "INSERT INTO senhas (iduser, nome, usuario, senha)"
            + " VALUES (?,?,?,?)";
        try{
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, Integer.toString(senha.getIdUser()));
            comando.setString(2, senha.getNome());
            comando.setString(3, senha.getusuário());
            comando.setString(4, senha.getsenha());
            comando.executeUpdate();
            //System.out.println(comando.toString());
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
    /**
     *
     * @return
     */
    public static Vector<Visão<String>> getVisões (int iduser) {
        BD.criaConexãoComando();
        // Listar todas as senhas
        //String sql = "SELECT * FROM senhas";
        String sql = "SELECT * FROM senhas WHERE iduser = ?";
        ResultSet lista_resultados = null;
        // Vetor que irá armazenar as senhas do banco
        Vector<Visão<String>> visões = new Vector<Visão<String>> ();
        String nome;
        try {
            //PreparedStatement comando = BD.conexão.prepareStatement(sql);
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, Integer.toString(iduser));
            lista_resultados = comando.executeQuery();
            
            while (lista_resultados.next()){
                String asteriscoSenha = "";
                int tamanho;
                //Recuperar as chave
                nome = lista_resultados.getString("nome"); 
                //Retorna os asterisco representando a senha no tamanho da senha armazenada
                tamanho = lista_resultados.getString("senha").length();
                for (int i = 0; i < tamanho; i++) {
                    asteriscoSenha +="*";
                }
                // Adiciona os valores recuperados no vetor
                visões.addElement(new Visão<String> (nome, 
                        "Nome: " + nome
                        + " |  Usuário: " + lista_resultados.getString("usuario")
                        + " | Senha: "+ asteriscoSenha));
            }
            lista_resultados.close();
            comando.close();
            BD.fechaComandoConexão();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
        return visões;
    }
    
    //Cria um vector com os dados de cadastro de senhas cadastradas
    /**
     *
     * @return
     */
    public static Vector<Visão<String>> getVisõesParaBusca (int iduser) {
        BD.criaConexãoComando();
        // Listar todas as senhas
        String sql = "SELECT * FROM senhas WHERE iduser = ?";
        ResultSet lista_resultados = null;
        // Vetor que irá armazenar as senhas do banco
        Vector<Visão<String>> visões = new Vector<Visão<String>> ();
        String nome, user;
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, Integer.toString(iduser));
            lista_resultados = comando.executeQuery();
            
            while (lista_resultados.next()){
                String asteriscoSenha = "";
                int tamanho;
                //Recuperar as chave
                nome = lista_resultados.getString("nome");
                user = lista_resultados.getString("usuario");
                //Retorna os asterisco representando a senha no tamanho da senha armazenada
                tamanho = lista_resultados.getString("senha").length();
                for (int i = 0; i < tamanho; i++) {
                    asteriscoSenha +="*";
                }
                // Adiciona os valores recuperados no vetor
                visões.addElement(new Visão<String> (nome, user,
                        "Nome: " + nome
                        + " |  Usuário: " + lista_resultados.getString("usuario")
                        + " | Senha: "+ asteriscoSenha));
            }
            lista_resultados.close();
            comando.close();
            BD.fechaComandoConexão();
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
        BD.criaConexãoComando();
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
            BD.fechaComandoConexão();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                senha = null;
                }
    return senha;
    }
    
    //Remove o cadastro informado através de sua chave primária(id) do banco de dados
    public static String removerSenha (int id) {
        BD.criaConexãoComando();
        String sql = "DELETE FROM senhas WHERE id = ?";
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, Integer.toString(id));
            comando.executeUpdate();
            comando.close();
            BD.fechaComandoConexão();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            return "Erro na Remoção da senha no BD";
        }
    }
    
    //Busca dados de um cadastro de senha no banco e retorna suas informações exceto sua chave primária
    /**
     *
     * @param nome
     * @return
     */
    public static Senha buscarSenha (String nome) {
        BD.criaConexãoComando();
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
            BD.fechaComandoConexão();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace ();
                senha = null;
                }
    return senha;
    }
    
    //Criptografa a senha útilizando o algoritmo AES, retornando a senha cifrada em um byte[]
    public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textopuro.getBytes("UTF-8"));
    }
    
    //Descriptograda a senha, utilizando o algoritmo AEs, retorna a senha descriptografada em uma String
    public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception{
        Cipher decripta=  Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado),"UTF-8");
    }
    
    //Realiza a chamada ao processo que criptografa a senha em um byte[], ao receber esse byte[] codifica-o em uma string
    public static String criptografe_e_codifique(String Senha, String Chaveencripatação){
        String senhaencriptadabase64string = null;
        try {
            //Criptografando
            byte[] senhaencriptada = entidade.Senha.encrypt(Senha, Chaveencripatação);
            
            //Encode
            byte[] senhaEncriptadaBase64 = Base64.getEncoder().encode(senhaencriptada);
            senhaencriptadabase64string = new String(senhaEncriptadaBase64, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return(senhaencriptadabase64string);
    }
    
    //Descodifica o conteúdo da string de base64 para um byte[], e com esse byte[], recupera a chave criptografada
    public static String descriptografe_e_decodifique(String senhaencriptadabase64string, String Chaveencripatação){
        String senhadescriptadaedecodificada = null;
        try {
            // Decode
            byte[] senhaEncriptadaParaRecuperarByte = Base64.getDecoder().decode(senhaencriptadabase64string);
            
            //Descriptografando
            senhadescriptadaedecodificada = entidade.Senha.decrypt(senhaEncriptadaParaRecuperarByte, Chaveencripatação);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return(senhadescriptadaedecodificada);
    }
    
    //Remove o cadastro informado através de sua chave primária(id) do banco de dados
    public static String removerSenha_User_Removido (int idUser) {
        String sql = "DELETE FROM senhas WHERE iduser = ?";
        BD.criaConexãoComando();
        try {
            PreparedStatement comando = BD.conexão.prepareStatement(sql);
            comando.setString(1, Integer.toString(idUser));
            comando.executeUpdate();
            comando.close();
            BD.fechaComandoConexão();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace ();
            BD.fechaComandoConexão();
            return "Usuário removido com sucesso, mas apresentou falha na remoção das senhas do cofre do usuário";
        }
    }
    
    @Override
    public String toString () {
        return nome + " - " + usuário;
    }  
}

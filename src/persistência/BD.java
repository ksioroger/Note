package persistência;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cassiano Rogério
 */

public class BD {
    //static final String URL_BD = "jdbc:mysql://localhost:3306/note?zeroDateTimeBehavior=convertToNull";
    static final String URL_BD = "jdbc:mysql://localhost:3306/note?autoReconnect=true&useSSL=false";
    static final String USUÁRIO = "note";
    static final String SENHA = "note";
    public static Connection conexão = null;
    private static Statement comando = null;

    public static void criaConexão () {
        try {
            conexão = DriverManager.getConnection (URL_BD, USUÁRIO, SENHA);
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
    }
    
    public static void fechaConexão () {
        try {
            conexão.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
    }
    
    public static void criaConexãoComando () {
        try {
            conexão = DriverManager.getConnection (URL_BD, USUÁRIO, SENHA);
            comando = conexão.createStatement ();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
    }
    
    public static void fechaComandoConexão () {
        try {
            comando.close();
            conexão.close();
        } catch (SQLException exceção_sql) {exceção_sql.printStackTrace ();}
    }
}

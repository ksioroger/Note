package entidade;

import persistência.BD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cassi
 */
public class Usuário {
    private String usuário;
    private String senha;
    
    public Usuário(String usuário, String senha) {
        this.usuário = usuário;
        this.senha = senha;
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
}


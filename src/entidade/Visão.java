package entidade;

/**
 *
 * @author Cassiano Rogério
 */

//Tipo que receberá os dados contidos no banco para serem exibidos ou manipulados 
public class Visão<T> {
    T chave;
    String user;
    String info;
    
    public Visão(T chave, String info) {
        this.chave = chave;
        this.info = info;
    }
    
    public Visão(T chave, String user, String info) {
        this.chave = chave;
        this.user = user;
        this.info = info;
    }
    
    public T getChave() {
        return chave;
    }
    
    public void setChave(T chave) {
        this.chave = chave;
    }
    
    public String getUser() {
        return user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public String getInfo() {
        return info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }
    
    @Override
    public String toString () { 
        return info;
    }
}

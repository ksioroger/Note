package entidade;

/**
 *
 * @author Cassiano Rogério
 */

//Tipo que receberá os dados contidos no banco para serem exibidos ou manipulados 
public class Visão<T> {
    T chave;
    String info;
    
    public Visão(T chave, String info) {
        this.chave = chave;
        this.info = info;
    }
    
    public T getChave() {
        return chave;
    }
    
    public void setChave(T chave) {
        this.chave = chave;
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

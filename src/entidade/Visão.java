package entidade;

public class Visão<T> {
    T chave;
    String info;
    
    public Visão(T chave, String info) {
        this.chave = chave;
        this.info = info;
    }

    Visão(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

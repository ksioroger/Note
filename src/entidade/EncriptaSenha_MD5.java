package entidade;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author cassi
 * algoritmo para encriptar com o MD5
 */
public class EncriptaSenha_MD5 {
    /** Creates a new instance of EncriptaSenha */
    public EncriptaSenha_MD5() {        
    
    }
    public static String encripta (String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            BASE64Encoder encoder = new BASE64Encoder (); 
            return encoder.encode(digest.digest()); 
        }catch (NoSuchAlgorithmException ns) {
            ns.printStackTrace();
            return senha;
        }
    }    
}
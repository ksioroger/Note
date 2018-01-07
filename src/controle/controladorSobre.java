package controle;

import interfaces.Sobre;

/**
 *
 * @author cassi
 */
public class controladorSobre {
    public controladorSobre() {
        Sobre janelaSobre =  new Sobre();
        janelaSobre.setLocationRelativeTo(null);
        janelaSobre.setResizable(false);
        janelaSobre.setVisible(true);  
    }
}

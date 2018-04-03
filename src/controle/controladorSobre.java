package controle;

import interfaces.Sobre;

/**
 *
 * @author Cassiano Rogério
 */

//Constroi uma nova janela onde conta as informações sobre o programa
public class controladorSobre {
    public controladorSobre() {
        Sobre janelaSobre =  new Sobre();
        janelaSobre.setLocationRelativeTo(null);
        janelaSobre.setResizable(false);
        janelaSobre.setVisible(true);  
    }
}

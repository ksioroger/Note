package controle;

import interfaces.Atalhos;
/**
 *
 * @author Cassiano Rogério
 */

//Constroi uma nova janela onde conta os atalhos do programa
public class controladorAtalhos {
    public controladorAtalhos() {
        Atalhos janelaAtalhos =  new Atalhos();
        janelaAtalhos.setLocationRelativeTo(null);
        janelaAtalhos.setResizable(false);
        janelaAtalhos.setVisible(true);  
    }
}

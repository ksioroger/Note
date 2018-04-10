package interfaces;

import entidade.Senha;
import entidade.Usuário;
import entidade.Visão;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Cassiano Rogério
 */

//Janela para remoção de senha do banco de dados
public class Excluir extends javax.swing.JDialog {

    private int elemento;
    Vector<Visão<String>> senhas_cadastradas;
    Usuário userLogado;
    
    /** Creates new form Adicionar */
    public Excluir(java.awt.Frame parent, boolean modal, int item, Usuário user, Vector<Visão<String>> senhas) {
        super(parent, modal);
        userLogado = user;
        //Recebe qual foi o cadastro selecionado
        this.elemento = item;
        //Capta os dados dos cadastros de senhas armazenados no banco
        senhas_cadastradas = senhas;
        URL url = this.getClass().getResource("/images/key 20x20.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        initComponents();
        //Setar o botão Okay como botão padrão da janela
        getRootPane().setDefaultButton(jButtonOkay);
        //Janela de solicitação de exclusão do cadastro de senha selecionado
        buscarSenha();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fundo = new javax.swing.JPanel();
        jPanelItens = new javax.swing.JPanel();
        jPanelBotões = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonOkay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelInformaçãoDeRemoção = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Excluir");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jButtonCancelar.setMnemonic('c');
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonOkay.setMnemonic('k');
        jButtonOkay.setText("Okay");
        jButtonOkay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotõesLayout = new javax.swing.GroupLayout(jPanelBotões);
        jPanelBotões.setLayout(jPanelBotõesLayout);
        jPanelBotõesLayout.setHorizontalGroup(
            jPanelBotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotõesLayout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addComponent(jButtonOkay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar))
        );
        jPanelBotõesLayout.setVerticalGroup(
            jPanelBotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotõesLayout.createSequentialGroup()
                .addGroup(jPanelBotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOkay)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        this.dispose();

        jLabel1.setText("Tem certeza que deseja remover a senha:");

        jLabelInformaçãoDeRemoção.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanelItensLayout = new javax.swing.GroupLayout(jPanelItens);
        jPanelItens.setLayout(jPanelItensLayout);
        jPanelItensLayout.setHorizontalGroup(
            jPanelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItensLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelItensLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelBotões, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelItensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInformaçãoDeRemoção, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelItensLayout.setVerticalGroup(
            jPanelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelItensLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelInformaçãoDeRemoção, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanelBotões, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(Fundo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkayActionPerformed
        // TODO add your handling code here:
        //Permite confirmar a exclusão usando a tecla enter
        jButtonOkay.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                    jButtonOkay.doClick();
                }
            }
        });
        removerSenha();
        this.dispose();
    }//GEN-LAST:event_jButtonOkayActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        //Fecha a janela
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    //Permitir fechar a Janela com a tecla Esc
    @Override
    protected JRootPane createRootPane() {
        JRootPane rootPane = new JRootPane();
        KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
        Action actionListener;
        actionListener = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) { 
                setVisible(false);
            } 
        };
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(stroke, "ESCAPE");
        rootPane.getActionMap().put("ESCAPE", actionListener);
        return rootPane;
    }
    
    //Checa o cadastro da senha que foi solicitado para remoção e realiza a remoção do banco
    private void removerSenha(){
        int id= -1;
        String nome = null;
        Senha senha = null;
        String mensagem_erro;
        
        //chegar qual foi a senha solicitada
        Visão<String> visãoSelecionada = senhas_cadastradas.elementAt(elemento);
        
        //Recebe o campo utilizado para realizar a busca
        nome = visãoSelecionada.getChave();
        //Capta os dados da senha e sua chave primária (ID)
        senha = Senha.buscarSenhaEPK(nome);
        
        //Remove o cadastro da senha selecionada do banco
        if (senha != null) {
            mensagem_erro = Senha.removerSenha(senha.getID());
        }
        else {
            mensagem_erro = "Senha não cadastrada!";
	}
        
        //Checa se a remoção ocorreu corretamente e informa ao usuário
        if (mensagem_erro == null){
            mensagem_erro = "Senha " + senha.getNome() + " foi removida!";
            JOptionPane.showMessageDialog(this, mensagem_erro);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, mensagem_erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    //Janela de solicitação de exclusão
    private void buscarSenha(){
        int id= -1;
        String nome = null;
        Senha senha = null;
        
        //chegar qual foi a senha solicitada
        Visão<String> visãoSelecionada = senhas_cadastradas.elementAt(elemento);
        
        //Recebe o campo utilizado para realizar a busca
        nome = visãoSelecionada.getChave();
        //Capta os dados da senha e sua chave primária (ID)
        senha = Senha.buscarSenhaEPK(nome);
        //Imprimir na etiqueta o nome da senha que esta sendo solicitada para ser excluid
        jLabelInformaçãoDeRemoção.setText(senha.getNome());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuário user = null;
                Vector<Visão<String>> senhas = null;
                Excluir dialog = new Excluir(new javax.swing.JFrame(), true, -2, user, senhas);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fundo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOkay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelInformaçãoDeRemoção;
    private javax.swing.JPanel jPanelBotões;
    private javax.swing.JPanel jPanelItens;
    // End of variables declaration//GEN-END:variables

}
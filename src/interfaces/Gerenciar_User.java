package interfaces;

import entidade.Usuário;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import java.net.URL;

import javax.swing.JOptionPane;

/**
 *
 * @author cassi
 */
public class Gerenciar_User extends javax.swing.JFrame {
    Usuário usuário;
    /**
     * Creates new form Gerenciar_User
     * @param nomeUser
     */
    public Gerenciar_User(String nomeUser) {
        //buscar os dados do usuário ativo no sitema
        usuário =  Usuário.buscar_Usuário_Todos_os_dados(nomeUser);
        URL url = this.getClass().getResource("/images/key 20x20.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMuralDados = new javax.swing.JPanel();
        jLabelUser = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jLabelChave = new javax.swing.JLabel();
        jPanelPainel_Etiquetas = new javax.swing.JPanel();
        jLabelBoas_vindas_user = new javax.swing.JLabel();
        jLabelUser_ID = new javax.swing.JLabel();
        jLabelChave_ativa = new javax.swing.JLabel();
        jPanelBotões = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Usuário");

        jLabelUser.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabelUser.setText(usuário.getusuário());

        jLabelID.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabelID.setText(Integer.toString(usuário.getID()));

        jLabelChave.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabelChave.setText(usuário.getChave());

        jLabelBoas_vindas_user.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelBoas_vindas_user.setText("Bem Vindo(a)");

        jLabelUser_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUser_ID.setText("ID de usuário");

        jLabelChave_ativa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelChave_ativa.setText("Chave de encriptação");

        javax.swing.GroupLayout jPanelPainel_EtiquetasLayout = new javax.swing.GroupLayout(jPanelPainel_Etiquetas);
        jPanelPainel_Etiquetas.setLayout(jPanelPainel_EtiquetasLayout);
        jPanelPainel_EtiquetasLayout.setHorizontalGroup(
            jPanelPainel_EtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPainel_EtiquetasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelPainel_EtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBoas_vindas_user, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelUser_ID, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addComponent(jLabelChave_ativa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelPainel_EtiquetasLayout.setVerticalGroup(
            jPanelPainel_EtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPainel_EtiquetasLayout.createSequentialGroup()
                .addComponent(jLabelBoas_vindas_user)
                .addGap(23, 23, 23)
                .addComponent(jLabelUser_ID)
                .addGap(18, 18, 18)
                .addComponent(jLabelChave_ativa, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelMuralDadosLayout = new javax.swing.GroupLayout(jPanelMuralDados);
        jPanelMuralDados.setLayout(jPanelMuralDadosLayout);
        jPanelMuralDadosLayout.setHorizontalGroup(
            jPanelMuralDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMuralDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelPainel_Etiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMuralDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jLabelChave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelMuralDadosLayout.setVerticalGroup(
            jPanelMuralDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMuralDadosLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanelMuralDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelPainel_Etiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelMuralDadosLayout.createSequentialGroup()
                        .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelID)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelChave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir Usuário");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonAtualizar.setText("Atualizar Senha");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo Usuário");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotõesLayout = new javax.swing.GroupLayout(jPanelBotões);
        jPanelBotões.setLayout(jPanelBotõesLayout);
        jPanelBotõesLayout.setHorizontalGroup(
            jPanelBotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotõesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addContainerGap())
        );
        jPanelBotõesLayout.setVerticalGroup(
            jPanelBotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotõesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelBotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonAtualizar)
                    .addComponent(jButtonNovo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelBotões, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMuralDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanelMuralDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotões, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
        Cadastrar();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        String mensagem = null;
        int confirma_Exclusão;
        //Janela que solicita a confirmação de exclusão do usuário
        confirma_Exclusão = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir?","Atenção", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        //Caso tenha escolhido sim, irá solicitar a exclusão
        if(confirma_Exclusão == JOptionPane.YES_OPTION) {
            //Solicita excluir, caso acontece algum erro retornará uma mensagem, caso execute corretamente retornará null
            mensagem = entidade.Usuário.removerSenha(usuário.getID());
            //Testa se a exclusão foi realizada com sucesso
            if(mensagem==null){
                JOptionPane.showMessageDialog(this, "Excluido com sucesso, o sistema será encerrado!", "Atenção",JOptionPane.WARNING_MESSAGE);
                //Encerra o programa
                System.exit(0);
            }
            else{
                JOptionPane.showMessageDialog(this, mensagem, "Atenção",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        //Criar uma nova janela, para adicionar dados
        Atualizar_Senha_User atualizar_Senha_Usuário_Dialogo = new Atualizar_Senha_User(this,true, usuário.getusuário());
        atualizar_Senha_Usuário_Dialogo.setLocationRelativeTo(null);
        atualizar_Senha_Usuário_Dialogo.setResizable(false);
        atualizar_Senha_Usuário_Dialogo.setVisible(true);
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    //Cria a janela de novo cadastro de senha
    private void Cadastrar(){
        //Criar uma nova janela, para adicionar dados
        Cadastrar cadastrardialogo = new Cadastrar(this,true);
        cadastrardialogo.setLocationRelativeTo(null);
        cadastrardialogo.setResizable(false);
        cadastrardialogo.setVisible(true);
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
            java.util.logging.Logger.getLogger(Gerenciar_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerenciar_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerenciar_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerenciar_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String nomeUser = null;
                Gerenciar_User janela_Gerenciamento_Usuário = new Gerenciar_User(nomeUser);
                janela_Gerenciamento_Usuário.setLayout(new BorderLayout());
                janela_Gerenciamento_Usuário.setLocationRelativeTo(null);
                janela_Gerenciamento_Usuário.setResizable(false);
                janela_Gerenciamento_Usuário.setVisible(true);
                janela_Gerenciamento_Usuário.setAlwaysOnTop(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JLabel jLabelBoas_vindas_user;
    private javax.swing.JLabel jLabelChave;
    private javax.swing.JLabel jLabelChave_ativa;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelUser_ID;
    private javax.swing.JPanel jPanelBotões;
    private javax.swing.JPanel jPanelMuralDados;
    private javax.swing.JPanel jPanelPainel_Etiquetas;
    // End of variables declaration//GEN-END:variables

}

package interfaces;

import controle.ControleTamanhoTexto;
import entidade.Senha;
import java.awt.Event;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Integer;
import java.util.Arrays;
import java.util.Base64;
//import javax.crypto.Cipher;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;

/**
 *
 * @author Cassiano Rogério
 */

//Cria uma janela para inserção de nova senha no banco de dados
public class Novobkp extends javax.swing.JDialog {
    /** Creates new form Adicionar */
    
    static String IV = "F5SENHAACESSO-TI";
    static String chaveencriptacao = "F5SENHAACESSO-TI";
    
    public Novobkp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        URL url = this.getClass().getResource("/images/key 20x20.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        initComponents();
        //Setar o botão Okay como botão padrão da janela
        getRootPane().setDefaultButton(jButtonOkay);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Fundo = new javax.swing.JPanel();
        jPanelEtiquetas = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelUsuário = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jPanelTextos = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldUsuário = new javax.swing.JTextField();
        jTextFieldSenha = new javax.swing.JTextField();
        jPanelBotões = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonOkay = new javax.swing.JButton();
        jCheckBoxMúltiplasSenhas = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jLabelNome.setText("Nome");

        jLabelUsuário.setText("Usuário");

        jLabelSenha.setText("Senha");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelUsuário)
                    .addComponent(jLabelSenha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabelNome)
                .addGap(18, 18, 18)
                .addComponent(jLabelUsuário)
                .addGap(18, 18, 18)
                .addComponent(jLabelSenha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldNome.setDocument( new ControleTamanhoTexto(30) );
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jTextFieldUsuário.setDocument( new ControleTamanhoTexto(50) );

        jTextFieldSenha.setDocument( new ControleTamanhoTexto(50) );
        jTextFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTextosLayout = new javax.swing.GroupLayout(jPanelTextos);
        jPanelTextos.setLayout(jPanelTextosLayout);
        jPanelTextosLayout.setHorizontalGroup(
            jPanelTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextFieldSenha)
            .addComponent(jTextFieldUsuário)
            .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelTextosLayout.setVerticalGroup(
            jPanelTextosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTextosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUsuário, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        jCheckBoxMúltiplasSenhas.setMnemonic('p');
        jCheckBoxMúltiplasSenhas.setText("Múltiplas Senhas");
        jCheckBoxMúltiplasSenhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMúltiplasSenhasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotõesLayout = new javax.swing.GroupLayout(jPanelBotões);
        jPanelBotões.setLayout(jPanelBotõesLayout);
        jPanelBotõesLayout.setHorizontalGroup(
            jPanelBotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBotõesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jCheckBoxMúltiplasSenhas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOkay))
        );
        jPanelBotõesLayout.setVerticalGroup(
            jPanelBotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotõesLayout.createSequentialGroup()
                .addGroup(jPanelBotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOkay)
                    .addComponent(jButtonCancelar)
                    .addComponent(jCheckBoxMúltiplasSenhas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        this.dispose();

        javax.swing.GroupLayout jPanelEtiquetasLayout = new javax.swing.GroupLayout(jPanelEtiquetas);
        jPanelEtiquetas.setLayout(jPanelEtiquetasLayout);
        jPanelEtiquetasLayout.setHorizontalGroup(
            jPanelEtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEtiquetasLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTextos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelEtiquetasLayout.createSequentialGroup()
                        .addGap(0, 95, Short.MAX_VALUE)
                        .addComponent(jPanelBotões, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanelEtiquetasLayout.setVerticalGroup(
            jPanelEtiquetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEtiquetasLayout.createSequentialGroup()
                .addComponent(jPanelTextos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotões, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout FundoLayout = new javax.swing.GroupLayout(Fundo);
        Fundo.setLayout(FundoLayout);
        FundoLayout.setHorizontalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addComponent(jPanelEtiquetas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        FundoLayout.setVerticalGroup(
            FundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FundoLayout.createSequentialGroup()
                .addComponent(jPanelEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        getContentPane().add(Fundo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        //Fecha a janela
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonOkayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkayActionPerformed
        try {
            // TODO add your handling code here:
            //Verifica se uma ou mais senha e chama a janela de inserção de dados
            botãoOkayPressionado();
        } catch (Exception ex) {
            Logger.getLogger(Novo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonOkayActionPerformed

    private void jCheckBoxMúltiplasSenhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMúltiplasSenhasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMúltiplasSenhasActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSenhaActionPerformed
        // TODO add your handling code here:
        //Quando estiver no campo de texto da senha permite confirmar usando a tecla enter
        jTextFieldSenha.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke){
                if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                    jButtonOkay.doClick();
                }
            }
        });
    }//GEN-LAST:event_jTextFieldSenhaActionPerformed

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
    
    //Checa se foi selecionada a opção para inserir mais de um cadastro de senha, e chama a janela de cadastro
    private void botãoOkayPressionado() throws Exception{
        if(!jCheckBoxMúltiplasSenhas.isSelected()){
            inserirSenha();
            this.dispose();
        }else{
            // Seta o foco no primeiro campo de texto(nome)
            jTextFieldNome.requestFocus();
            inserirSenha();
        }
    }
    
    //Capta os dados da tela de cadastro e insere no banco de dados
    private void inserirSenha() throws Exception {
        String mensagem_erro = null;
        //recebe os dados digitados pelo usuário na tela de cadastro
        Senha senha = obterSenhaInformada();
        
        //Insere a senha no banco de dados
        if (senha != null){
            mensagem_erro = Senha.inserirSenha(senha);
            //Para caso o usuário for continuar cadastrando ele irá limpar os campos após a confirmação de inserção de cada cadastro
            Limpar();
        }
        else{
            JOptionPane.showMessageDialog(this, "Por gentileza preencher todos os campos", "ERRO",
            JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    //Capta os dados digitados na tela de cadastro
    private Senha obterSenhaInformada() throws Exception{
        entidade.Senha senha = null;
        String chaveencriptacao = "F5SENHAACESSO-TI";
        
        String Nome =  jTextFieldNome.getText();
        if (Nome.isEmpty()) return null;
        String Usuário = jTextFieldUsuário.getText();
        if (Usuário.isEmpty()) return null;
        String Senha = jTextFieldSenha.getText();
        
        int forca = testaForcaDaSenha(Senha);
        if(forca <= 10){
            JOptionPane.showMessageDialog(this,
                    "Sua senha não possui os pré-requisitos de uma senha segura,"
                            + "\n recomendamos que mude o assim que possível. Força: " 
                            + forca, "MENSAGEM", JOptionPane.WARNING_MESSAGE);
        }
        else if(forca <= 25){
            JOptionPane.showMessageDialog(this, 
                    "Sua senha ainda não é tão boa,\n recomendamos que altere asim que possível", 
                    "REGULAR", JOptionPane.WARNING_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(this, "Sua senha é FORTE", 
                    "FORTE", JOptionPane.WARNING_MESSAGE);
        }        
        
        ////////////////////////////////////////////////////
        //      Criptografando senha usando AES         //
        ////////////////////////////////////////////////////
        try {
            //Informação descriptografada
            //System.out.println("Conteúdo Original, antes de criptografar: " + Senha);
            
            //Criptografando
            byte[] senhaencriptada = encrypt(Senha, chaveencriptacao);
            String result = "|";
            System.out.println("senha encriptada inicial: "+senhaencriptada.toString());
            
            String SenhaEncriptadaString;
            SenhaEncriptadaString = senhaencriptada.toString();
            //SenhaEncriptadaString = Arrays.toString(senhaencriptada); //converte no int 
            
            System.out.println("senha encriptada inicial em tostring: "+senhaencriptada.toString());
            System.out.println("senha encriptada inicial em string:"+SenhaEncriptadaString);
            System.out.println("");
            
           //byte[] senhaencriptadaparadecriptar = new byte[SenhaEncriptadaString.to];
            
            //Converter o Byte[] em Integer[]
            Integer SenhaCripto[] = new Integer[senhaencriptada.length];
            String SenhaCriptoS[] = new String[senhaencriptada.length];
            String stringsenha = null;
            for (int i=0; i<senhaencriptada.length; i++){
                SenhaCripto[i] = (new Integer(senhaencriptada[i]));
                SenhaCriptoS[i] = (new String (SenhaCripto[i].toString()));
                result += SenhaCriptoS[i] + "|";
            }
            int tamanho;
            tamanho = result.length();
            String senhaS = result;
            String resultado = "";
            String[] vetSenhaDcript = new String[tamanho];
            byte[] vetSenhaByte = new byte[tamanho];
            int cont = 0;
            int j;
            
            //converter String em Vetor de String 
            for(int i=0;i<tamanho;i++){
                //System.out.println("i: "+i);
                if(senhaS.charAt(i) == '|'){
                    i++;
                    j=i;
                    //System.out.println("j: "+j);
                    if (j==tamanho) {
                        i=j-1;
                    }
                    else{
                        do {
                            resultado +=senhaS.charAt(j);
                            j++;
                        } while (senhaS.charAt(j)!='|');
                    }
                    i=j-1;
                    //System.out.println(resultado);
                    vetSenhaDcript[cont] = resultado;
                    resultado = "";
                    cont++;
                }
            }
            System.out.println("Conteúdo original  : " + Senha);
            for (int i=0; i<senhaencriptada.length; i++){
                System.out.print(new Integer(senhaencriptada[i])+" ");
            }
            System.out.println("");
            for (int i=0;i<senhaencriptada.length;i++){
                System.out.print(vetSenhaDcript[i]+"/");
            }
            
            //vetSenhaDcript[cont]
            int SenhaDCripto[] = new int[vetSenhaDcript.length];
            byte[] senhaDencriptada = new byte[vetSenhaDcript.length];
            for (int i = 0; i < senhaencriptada.length; i++) {
                int flag = Integer.parseInt(vetSenhaDcript[i]);
                SenhaDCripto[i] = flag;
                senhaDencriptada[i] = (byte) SenhaDCripto[i];
                //SenhaDCripto[i] = (new int(vetSenhaDcript[i]));
                //senhaDencriptada[i] = 1;
                //byte olar = SenhaDCripto[i].;
                //System.out.println(SenhaDCripto[i]+" ");
            }
            System.out.println("");
            System.out.println("senha encriptadata" + senhaencriptada);
            System.out.println("senha Dencriptadata" + senhaDencriptada);
            String textodecriptado = decrypt(senhaencriptada, chaveencriptacao);
            System.out.println("");
            System.out.println("Conteúdo Decriptado: " + textodecriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        if (Senha.isEmpty()) return null;
        //Retorna os dados informados pelo usuário
        return new Senha (Nome,Usuário, Senha);
    }
    
    public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textopuro.getBytes("UTF-8"));
    }
    
    public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception{
        Cipher decripta=  Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado),"UTF-8");
    }
    
    //Testa forca da senha
    public int testaForcaDaSenha(String senha) {
        int forca = 0;
        //System.out.println(senha);
        
        if(senha.matches("[a-z]+") || senha.matches("[0-9]+") || senha.matches("[A-Z]+") || senha.matches("W+")){
            forca += 10;
            
            //System.out.println(forca);
        }
        
        else if(senha.matches("[a-z0-9]+") || senha.matches("[A-Z0-9]+") || senha.matches("[a-zA-Z]") ) {
            forca += 15;
        }
        
        else {
            forca += 30;
        }
         
        //System.out.println(forca);
        return forca;
    }
    
    //Limpa os campos de texto da janela de cadastro
    private void Limpar(){
        jTextFieldNome.setText("");
        jTextFieldUsuário.setText("");
        jTextFieldSenha.setText("");
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
            java.util.logging.Logger.getLogger(Novo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Novo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Novo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Novo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Novo dialog = new Novo(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonOkay;
    private javax.swing.JCheckBox jCheckBoxMúltiplasSenhas;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuário;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelBotões;
    private javax.swing.JPanel jPanelEtiquetas;
    private javax.swing.JPanel jPanelTextos;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldUsuário;
    // End of variables declaration//GEN-END:variables

}
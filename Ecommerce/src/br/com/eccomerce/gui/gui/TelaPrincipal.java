/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.eccomerce.gui.gui;

import javax.swing.JPopupMenu;

import br.com.ecommerce.gui.TelaCadastrarProduto;
import br.com.ecommerce.gui.TelaHistoricoVenda;

import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author pc
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());

    /**
     * Creates new form TelaPrincipal
     */
    private JPopupMenu popupProduto;
    private JPopupMenu popupCliente;
    private JPopupMenu popupVendas;

    public TelaPrincipal() {
        initComponents();
       
        //// Cria a instância das telas e adiciona ao painel principal com CardLayout
        TelaBoasVindas telaBoasVindas = new TelaBoasVindas();
        PainelTelas.add(telaBoasVindas, "TelaBoasVindas");

        TelaCadastrarProduto telaCadastrarProduto = new TelaCadastrarProduto();
        PainelTelas.add(telaCadastrarProduto, "TelaCadastrarProduto");
        TelaEditarProduto telaEditarProduto = new TelaEditarProduto();
        PainelTelas.add(telaEditarProduto, "TelaEditarProduto");
        TelaListarProduto telaListarProduto = new TelaListarProduto();
        PainelTelas.add(telaListarProduto, "TelaListarProduto");
        
        TelaCadastrarCliente telaCadastrarCliente = new TelaCadastrarCliente();
        PainelTelas.add(telaCadastrarCliente, "TelaCadastrarCliente");
        TelaEditarCliente telaEditarCliente = new TelaEditarCliente();
        PainelTelas.add(telaEditarCliente, "TelaEditarCliente");
        TelaListarCliente telaListarCliente = new TelaListarCliente();
        PainelTelas.add(telaListarCliente, "TelaListarCliente");
        
        TelaCadastrarVenda telaCadastrarVenda = new TelaCadastrarVenda();
        PainelTelas.add(telaCadastrarVenda, "TelaCadastrarVenda");
        TelaHistoricoVenda telaHistoricoVenda = new TelaHistoricoVenda();
        PainelTelas.add(telaHistoricoVenda, "TelaHistoricoVenda");
        
        CardLayout cl = (CardLayout) PainelTelas.getLayout();
        cl.show(PainelTelas, "TelaBoasVindas");
        
        CriarMenus();
    }
    
    private void CriarMenus(){
        
        //Menu Produtos
        popupProduto = new JPopupMenu();

        JMenuItem itemCadastroProduto = new JMenuItem("Cadastro");
        itemCadastroProduto.addActionListener((e) -> {
            CardLayout cl = (CardLayout) PainelTelas.getLayout();
            cl.show(PainelTelas, "TelaCadastrarProduto");
        });
        
        JMenuItem itemEditarProduto = new JMenuItem("Editar");
        itemEditarProduto.addActionListener((e) -> {
            CardLayout cl = (CardLayout) PainelTelas.getLayout();
            cl.show(PainelTelas, "TelaEditarProduto");
        });
        
        JMenuItem itemListagemProduto = new JMenuItem("Listagem");
        itemListagemProduto.addActionListener((e) -> {
            CardLayout cl = (CardLayout) PainelTelas.getLayout();
            cl.show(PainelTelas, "TelaListarProduto");
        });

        popupProduto.add(itemCadastroProduto);
        popupProduto.add(itemEditarProduto);
        popupProduto.add(itemListagemProduto);
        
        //Menu Clientes
        popupCliente = new JPopupMenu();

        JMenuItem itemCadastroCliente = new JMenuItem("Cadastro");
        itemCadastroCliente.addActionListener((e) -> {
            CardLayout cl = (CardLayout) PainelTelas.getLayout();
            cl.show(PainelTelas, "TelaCadastrarCliente");
        });
        
        JMenuItem itemEditarCliente = new JMenuItem("Editar");
        itemEditarCliente.addActionListener((e) -> {
            CardLayout cl = (CardLayout) PainelTelas.getLayout();
            cl.show(PainelTelas, "TelaEditarCliente");
        });
        
        JMenuItem itemListagemCliente = new JMenuItem("Listagem");
        itemListagemCliente.addActionListener((e) -> {
            CardLayout cl = (CardLayout) PainelTelas.getLayout();
            cl.show(PainelTelas, "TelaListarCliente");
        });
        
        popupCliente.add(itemCadastroCliente);
        popupCliente.add(itemEditarCliente);
        popupCliente.add(itemListagemCliente);
        
        //Menu Vendas
        popupVendas = new JPopupMenu(); 
        
        JMenuItem itemCadastroVenda = new JMenuItem("Cadastro");
        itemCadastroVenda.addActionListener((e) -> {
            CardLayout c1 = (CardLayout) PainelTelas.getLayout();
            c1.show(PainelTelas, "TelaCadastrarVenda");
        });
        
        JMenuItem itemHistoricoVenda = new JMenuItem("Histórico");
        itemHistoricoVenda.addActionListener((e) -> {
            CardLayout c1 = (CardLayout) PainelTelas.getLayout();
            c1.show(PainelTelas, "TelaHistoricoVenda");
        });
        
        popupVendas.add(itemCadastroVenda);
        popupVendas.add(itemHistoricoVenda);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelMenu = new javax.swing.JPanel();
        btnProduto = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnVendas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PainelTelas = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PainelMenu.setBackground(new java.awt.Color(255, 255, 255));
        PainelMenu.setToolTipText("");

        btnProduto.setBackground(new java.awt.Color(0, 0, 0));
        btnProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnProduto.setText("Produto");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnCliente.setBackground(new java.awt.Color(0, 0, 0));
        btnCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        btnVendas.setBackground(new java.awt.Color(0, 0, 0));
        btnVendas.setForeground(new java.awt.Color(255, 255, 255));
        btnVendas.setText("Vendas");
        btnVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasActionPerformed(evt);
            }
        });

        // jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout PainelMenuLayout = new javax.swing.GroupLayout(PainelMenu);
        PainelMenu.setLayout(PainelMenuLayout);
        PainelMenuLayout.setHorizontalGroup(
            PainelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelMenuLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(PainelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        PainelMenuLayout.setVerticalGroup(
            PainelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelMenuLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnProduto)
                .addGap(51, 51, 51)
                .addComponent(btnCliente)
                .addGap(44, 44, 44)
                .addComponent(btnVendas)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        PainelTelas.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PainelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelTelas, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PainelTelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
        popupCliente.show(btnCliente, 0, btnCliente.getHeight());
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        // TODO add your handling code here:
        popupProduto.show(btnProduto, 0, btnProduto.getHeight());
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasActionPerformed
        // TODO add your handling code here:
        popupVendas.show(btnVendas, 0, btnVendas.getHeight());
    }//GEN-LAST:event_btnVendasActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelMenu;
    private javax.swing.JPanel PainelTelas;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnVendas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

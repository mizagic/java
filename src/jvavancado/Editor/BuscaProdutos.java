package jvavancado.Editor;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import jvavancado.CadPedido;
import jvavancado.Produtos.beans.Produtos;
import jvavancado.produtosDao.ProdutosDao;

public class BuscaProdutos extends javax.swing.JFrame {

    JFrame telaDeprodutos;

    public BuscaProdutos(JFrame telaDeProdutos) {
        initComponents();
        this.telaDeprodutos = telaDeProdutos;
    }

    public BuscaProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void montaTabelaProdutos() {
        String[] nomeColuna = {"id", "Descrição", "preço"};
        DefaultTableModel modeloTabela = new DefaultTableModel(nomeColuna, 0);

        ArrayList<Produtos> produtosEncontrados = ProdutosDao.getProdutos("Descrição like '" + jtfDescricao.getText() + "%' and Preço like'"
                + jtfPreco.getText() + "%'");

        for (Produtos pro : produtosEncontrados) {

            String[] linha = {String.valueOf(pro.getId()),
                pro.getDescrição(), String.valueOf(pro.getPreco())};
            modeloTabela.addRow(linha);
        }
        jtbTelaDeProdutos.setModel(modeloTabela);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfPreco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfDescricao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTelaDeProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descriçao");

        jLabel2.setText("Preço");

        jtfDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescricaoActionPerformed(evt);
            }
        });
        jtfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDescricaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescricaoKeyReleased(evt);
            }
        });

        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtbTelaDeProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbTelaDeProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTelaDeProdutosMouseClicked(evt);
            }
        });
        jtbTelaDeProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbTelaDeProdutosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbTelaDeProdutosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtbTelaDeProdutos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        montaTabelaProdutos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescricaoActionPerformed

    }//GEN-LAST:event_jtfDescricaoActionPerformed

    private void jtfDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescricaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            montaTabelaProdutos();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            jtbTelaDeProdutos.requestFocus();
        }
    }//GEN-LAST:event_jtfDescricaoKeyPressed

    private void jtfDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescricaoKeyReleased
      
    }//GEN-LAST:event_jtfDescricaoKeyReleased

    private void jtbTelaDeProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTelaDeProdutosMouseClicked
     int linhaSelecionada = jtbTelaDeProdutos.getSelectedRow();
        String codigoSelecionado = jtbTelaDeProdutos.getValueAt(linhaSelecionada, 0).toString();
       if (telaDeprodutos instanceof jvavancado.CadPedido){
       ((jvavancado.CadPedido)telaDeprodutos).preencheTelaDaBuscaProduto(codigoSelecionado);}
       else if (telaDeprodutos instanceof CadPedido) {
            ((CadPedido) telaDeprodutos).preencheTelaDaBuscaCliente(codigoSelecionado);

    }
        
       this.setVisible(false);
    }//GEN-LAST:event_jtbTelaDeProdutosMouseClicked

    private void jtbTelaDeProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbTelaDeProdutosKeyReleased
          
    }//GEN-LAST:event_jtbTelaDeProdutosKeyReleased

    private void jtbTelaDeProdutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbTelaDeProdutosKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtbTelaDeProdutosMouseClicked(null);
        }
    }//GEN-LAST:event_jtbTelaDeProdutosKeyPressed

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
            java.util.logging.Logger.getLogger(BuscaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
         
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbTelaDeProdutos;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfPreco;
    // End of variables declaration//GEN-END:variables
}

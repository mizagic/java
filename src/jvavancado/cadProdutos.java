
package jvavancado;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jvavancado.Editor.BuscaProdutos;
import jvavancado.Produtos.beans.Produtos;
import jvavancado.produtosDao.ProdutosDao;


public class cadProdutos extends javax.swing.JFrame {

   
    public cadProdutos() {
        initComponents();

    }

    public void preencheTelaProdutos(String idselecionadoNaBusca) {
        jtID.setText(idselecionadoNaBusca);
        jtIDFocusLost(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtID = new javax.swing.JTextField();
        jtDescricao = new javax.swing.JTextField();
        jtPreço = new javax.swing.JTextField();
        jtUnMedida = new javax.swing.JTextField();
        jtEstoque = new javax.swing.JTextField();
        jtGravar = new javax.swing.JButton();
        jtLimpar = new javax.swing.JButton();
        jtExcluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id");

        jLabel2.setText("Descrição");

        jLabel3.setText("Preço");

        jLabel4.setText("Un_medida");

        jLabel5.setText("Estoque");

        jtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtIDFocusLost(evt);
            }
        });

        jtPreço.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPreçoActionPerformed(evt);
            }
        });

        jtEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEstoqueActionPerformed(evt);
            }
        });

        jtGravar.setText("Gravar");
        jtGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtGravarActionPerformed(evt);
            }
        });

        jtLimpar.setText("Limpar");
        jtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtLimparActionPerformed(evt);
            }
        });

        jtExcluir.setText("Excluir");
        jtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtExcluirActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtPreço, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtID, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jtGravar)
                        .addGap(18, 18, 18)
                        .addComponent(jtLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(jtExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtUnMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtPreço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtUnMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtGravar)
                    .addComponent(jtLimpar)
                    .addComponent(jtExcluir))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPreçoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPreçoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPreçoActionPerformed

    private void jtEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEstoqueActionPerformed
    public void preencheTela(Produtos produtos) {
        jtID.setText(String.valueOf(produtos.getId()));
        jtDescricao.setText(produtos.getDescrição());
        jtPreço.setText(String.valueOf(produtos.getPreco()));
        jtUnMedida.setText(produtos.getUn_medida());
        jtEstoque.setText(String.valueOf(produtos.getEstoque()));
    }
    private void jtIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtIDFocusLost
        if (!jtID.getText().trim().equals("")) {
            ResultSet rs = ObjectFactory.buscaNoBanco(
                    "SELECT * FROM Produtos WHERE ID = "
                    + jtID.getText());
            try {
                if (rs.next()) {
                    jtDescricao.setText(rs.getString("descrição"));
                    jtPreço.setText(rs.getString("Preço"));
                    jtUnMedida.setText(rs.getString("Un_medida"));
                    jtEstoque.setText(rs.getString("estoque"));
                } else {

                    JOptionPane.showMessageDialog(this,
                            "Cliente não encontrado");
                    jtID.setText("");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro na busca!");
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jtIDFocusLost

    private void jtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtLimparActionPerformed
        preencheTela(new Produtos());
    }//GEN-LAST:event_jtLimparActionPerformed

    private void jtGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtGravarActionPerformed
        String mensagemErro = "";
        if (jtDescricao.getText().trim().equals("")) {
            mensagemErro += "\n descrição";
        } else if (jtPreço.getText().toString().equals("")) {
            mensagemErro += "\n preço";
        } else if (jtUnMedida.getText().toString().equals("")) {
            mensagemErro += "\n un_medida";
        } else if (jtEstoque.getText().equals("")) {
            mensagemErro += "\n estoque";

        }

        if (!mensagemErro.equals("")) {
            mensagemErro = "Preencha os campos obrigatórios:"
                    + mensagemErro;
            JOptionPane.showMessageDialog(this, mensagemErro);
            return;
        }
 String sql;
        if (jtID.getText().equals("")) {
            sql = "INSERT INTO produtos ( descrição, preço, un_medida, estoque)"
                    + " VALUES ("
                    + "'" + jtDescricao.getText() + "',"+ "'"
                    +  jtPreço.getText() + "',"
                    + "'" + jtUnMedida.getText() + "',"
                    + "'" + jtEstoque.getText() + "')";
                    
         
           
        } else {
            sql = "UPDATE Produtos SET "
                    + "descrição = '" + jtDescricao.getText() + "',"
                    + " preço = '" + jtPreço.getText() + "',"
                    + " un_medida = '" + jtUnMedida.getText() + "',"
                   + " estoque = " + jtEstoque.getText();
                   

           

            sql += " WHERE ID = " + jtID.getText();
        }

       
      System.out.println(sql);
        ObjectFactory.executeSql(sql);
        JOptionPane.showMessageDialog(this, "Registro Gravado!");

    }//GEN-LAST:event_jtGravarActionPerformed

    private void jtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse Produtos");

        if (resposta == 0) {
            ObjectFactory.executeSql("delete from Produtos where id = " + jtID.getText());
            JOptionPane.showMessageDialog(this, "Registro exluido ");
            jtLimparActionPerformed(null);
        }
    }//GEN-LAST:event_jtExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscaProdutos telaBuscaProdutos = new BuscaProdutos(this);
        telaBuscaProdutos.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(cadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jtDescricao;
    private javax.swing.JTextField jtEstoque;
    private javax.swing.JButton jtExcluir;
    private javax.swing.JButton jtGravar;
    private javax.swing.JTextField jtID;
    private javax.swing.JButton jtLimpar;
    private javax.swing.JTextField jtPreço;
    private javax.swing.JTextField jtUnMedida;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvavancado.Editor;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import jvavancado.CadPedido;
import jvavancado.beans.Clientes;
import jvavancado.daos.ClientesDao;

/**
 *
 * @author java01
 */
public class BuscaCliente extends javax.swing.JFrame {

    JFrame telaDeRetorno;

    public BuscaCliente(JFrame telaDeRetorno) {
        initComponents();
        this.telaDeRetorno = telaDeRetorno;
    }

    public void montaTabela() {
        String[] nomeColuna = {"id", "Nome", "Email"};
        DefaultTableModel modeloTabela = new DefaultTableModel(nomeColuna, 0);

        ArrayList<Clientes> clientesEncontrados = ClientesDao.getClientes("nome like '" + jtfNome.getText() + "%' and email like'"
                + jtfEmail.getText() + "%'");

        for (Clientes cli : clientesEncontrados) {
            String[] linha = {String.valueOf(cli.getId()),
                cli.getNome(), cli.getEmail()};
            modeloTabela.addRow(linha);
        }
        jtbResultados.setModel(modeloTabela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbResultados = new javax.swing.JTable();
        jbtnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });
        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNomeKeyReleased(evt);
            }
        });

        jLabel2.setText("Email");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        jtbResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbResultadosMouseClicked(evt);
            }
        });
        jtbResultados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbResultadosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbResultadosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtbResultados);

        jbtnOk.setText("Ok");
        jbtnOk.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        jbtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnOk))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOkActionPerformed
        montaTabela();
    }//GEN-LAST:event_jbtnOkActionPerformed

    private void jtbResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbResultadosMouseClicked
        int linhaSelecionada = jtbResultados.getSelectedRow();
        String codigoSelecionado = jtbResultados.getValueAt(linhaSelecionada, 0).toString();
        if (telaDeRetorno instanceof jvAvancado.CadCliente) {
            ((jvAvancado.CadCliente) telaDeRetorno).preencheTelaDaBusca(codigoSelecionado);

        } else if (telaDeRetorno instanceof CadPedido) {
            ((CadPedido) telaDeRetorno).preencheTelaDaBuscaCliente(codigoSelecionado);

        }
        
        this.setVisible(false);
    }//GEN-LAST:event_jtbResultadosMouseClicked

    private void jtfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            montaTabela();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            jtbResultados.requestFocus();
        }
    }//GEN-LAST:event_jtfNomeKeyPressed

    private void jtfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyReleased


    }//GEN-LAST:event_jtfNomeKeyReleased

    private void jtbResultadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbResultadosKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtbResultadosMouseClicked(null);
        }


    }//GEN-LAST:event_jtbResultadosKeyReleased

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeActionPerformed

    private void jtbResultadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbResultadosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            montaTabela();
        }
    }//GEN-LAST:event_jtbResultadosKeyPressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnOk;
    private javax.swing.JTable jtbResultados;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
}

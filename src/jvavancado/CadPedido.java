package jvavancado;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jvavancado.Editor.BuscaCliente;
import jvavancado.Editor.BuscaProdutos;
import jvavancado.Produtos.beans.Produtos;
import jvavancado.beans.Clientes;
import jvavancado.beans.Pedido;
import jvavancado.beans.PedidoItens;
import jvavancado.daos.ClientesDao;
import jvavancado.daos.PedidoDao;
import jvavancado.daos.PedidoItensDao;
import jvavancado.produtosDao.ProdutosDao;

public class CadPedido extends javax.swing.JFrame {

    ArrayList<PedidoItens> pedidoItens = new ArrayList<>();

    public CadPedido() {
        initComponents();
    }

    public void montaGrade() {
        double total = 0.0;
        String[] titulos
                = {"Descrição", "Qtde", "Preço", "-$", "SbTotal"};
        DefaultTableModel dft
                = new DefaultTableModel(titulos, 0);
        for (PedidoItens it : pedidoItens) {
            double subTotalItem = it.getQtde()
                    * it.getProdutos().getPreco();
            subTotalItem = subTotalItem
                    - ((subTotalItem / 100)
                    * it.getPercdesconto());
            String[] linha = {
                it.getProdutos().getDescrição(),
                String.valueOf(it.getQtde()),
                String.valueOf(it.getProdutos().getPreco()),
                String.valueOf(it.getPercdesconto()),
                String.valueOf(subTotalItem)
            };
            dft.addRow(linha);
            total += subTotalItem;
        }
        jtbItens.setModel(dft);
        jlbTotal.setText("Total: R$ " + total);
    }

    public void preencheTelaDaBuscaCliente(String idSelecionadonaBusca) {
        Clientes cli = ClientesDao.getClienteById(Integer.parseInt(idSelecionadonaBusca));
        jtfIdCliente.setText(idSelecionadonaBusca);
        jtfNomeCliente.setText(cli.getNome());
    }

    public void preencheTelaDaBuscaProduto(String idSelecionadonaBusca) {
        Produtos prod = ProdutosDao.getProdutosById(Integer.parseInt(idSelecionadonaBusca));
        jtfDescricaoProduto.setText(prod.getDescrição());
        jtfQtd.setText("0");
        jtfDesconto.setText("0");
        PedidoItens pedit = new PedidoItens();
        pedit.setProdutos(prod);
        pedidoItens.add(pedit);

    }

    public Pedido getPedidoFromtela() {
        Pedido ped = new Pedido();
        ped.setCliente(ClientesDao.getClienteById(Integer.parseInt(jtfIdCliente.getText())));
        if (jckEntregue.isSelected()) {
            ped.setEntregue("sim");
        } else {
            ped.setEntregue("nao");
        }
        return ped;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopExcluir = new javax.swing.JPopupMenu();
        jMiExcluir = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jtfIdCliente = new javax.swing.JTextField();
        jtfNomeCliente = new javax.swing.JTextField();
        jbtnBuscarCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfDescricaoProduto = new javax.swing.JTextField();
        jtfDesconto = new javax.swing.JTextField();
        jbtnBuscar2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jtfQtd = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbItens = new javax.swing.JTable();
        jbtnAdicionar = new javax.swing.JButton();
        jbtnGravar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jlbTotal = new javax.swing.JLabel();
        jckEntregue = new javax.swing.JCheckBox();

        jMiExcluir.setLabel("Excluir\n");
        jMiExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiExcluirActionPerformed(evt);
            }
        });
        jPopExcluir.add(jMiExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente");

        jtfNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeClienteActionPerformed(evt);
            }
        });

        jbtnBuscarCliente.setText("Buscar");
        jbtnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Produtos");

        jtfDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescontoActionPerformed(evt);
            }
        });

        jbtnBuscar2.setText("Buscar");
        jbtnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscar2ActionPerformed(evt);
            }
        });

        jButton3.setText("-%");

        jButton4.setText("Qtde");

        jtfQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQtdActionPerformed(evt);
            }
        });

        jtbItens.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbItens.setComponentPopupMenu(jPopExcluir);
        jScrollPane1.setViewportView(jtbItens);

        jbtnAdicionar.setText("Adicionar");
        jbtnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAdicionarActionPerformed(evt);
            }
        });

        jbtnGravar.setText("Gravar");
        jbtnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGravarActionPerformed(evt);
            }
        });

        jbtnLimpar.setText("Limpar");
        jbtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimparActionPerformed(evt);
            }
        });

        jlbTotal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jlbTotal.setText("Total: R$ 0.00");

        jckEntregue.setText("Entregue");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfNomeCliente)
                                .addGap(32, 32, 32)
                                .addComponent(jbtnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jckEntregue))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jlbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(jbtnGravar)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnLimpar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(156, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscarCliente)
                    .addComponent(jckEntregue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jtfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnAdicionar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnGravar)
                            .addComponent(jbtnLimpar))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeClienteActionPerformed

    private void jtfDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescontoActionPerformed

    private void jtfQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfQtdActionPerformed

    private void jbtnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAdicionarActionPerformed
        int numeroDeItensNoPedido = pedidoItens.size();
        int posicaoUltimoItem = numeroDeItensNoPedido - 1;
        PedidoItens ultimoItem = pedidoItens.get(posicaoUltimoItem);
        ultimoItem.setQtde(Double.parseDouble(jtfQtd.getText()));
        ultimoItem.setPercdesconto(Double.parseDouble(jtfDesconto.getText()));
        Double.parseDouble(jtfDesconto.getText());
        montaGrade();
         if (jtfQtd.getText().equals("0") ){
             JOptionPane.showMessageDialog(this, "Por Favor digite uma quantidade");
         } else {return;
        }
    }//GEN-LAST:event_jbtnAdicionarActionPerformed

    private void jbtnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarClienteActionPerformed
        BuscaCliente buscarCliente = new BuscaCliente(this);
        buscarCliente.setVisible(true);
    }//GEN-LAST:event_jbtnBuscarClienteActionPerformed

    private void jbtnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscar2ActionPerformed
        BuscaProdutos buscarProdutos = new BuscaProdutos(this);
        buscarProdutos.setVisible(true);
    }//GEN-LAST:event_jbtnBuscar2ActionPerformed

    private void jbtnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGravarActionPerformed
        Pedido ped = new Pedido();
        Clientes cliDoPedido  = ClientesDao.getClienteById(Integer.parseInt(jtfIdCliente.getText()));
      
        ped.setCliente(cliDoPedido);
        ped.setData(new Date());
        if (jckEntregue.isSelected())
        {ped.setEntregue("SIM");
        }else{
        ped.setEntregue("NÂO");}
        
        PedidoDao.gravar(ped);
         
        for (PedidoItens pi : pedidoItens){
         pi.setPedido(ped);
         PedidoItensDao.gravar(pi);}
    }//GEN-LAST:event_jbtnGravarActionPerformed

    private void jbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparActionPerformed
        jtfIdCliente.setText("");
        jtfQtd.setText("0");
        jtfNomeCliente.setText("");
        jtfDescricaoProduto.setText("");
        jckEntregue.setSelected(false);
        jtfDesconto.setText("0");
        pedidoItens = new ArrayList<>();
        montaGrade();
    }//GEN-LAST:event_jbtnLimparActionPerformed

    private void jMiExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiExcluirActionPerformed
        int linhaSelecionada = jtbItens.getSelectedRow();
        if (linhaSelecionada >= 0) {
            pedidoItens.remove(linhaSelecionada);
            montaGrade();
        } else {
            JOptionPane.showMessageDialog(this, "selecione uma linha");
    }//GEN-LAST:event_jMiExcluirActionPerformed
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
            java.util.logging.Logger.getLogger(CadPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMiExcluir;
    private javax.swing.JPopupMenu jPopExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAdicionar;
    private javax.swing.JButton jbtnBuscar2;
    private javax.swing.JButton jbtnBuscarCliente;
    private javax.swing.JButton jbtnGravar;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JCheckBox jckEntregue;
    private javax.swing.JLabel jlbTotal;
    private javax.swing.JTable jtbItens;
    private javax.swing.JTextField jtfDesconto;
    private javax.swing.JTextField jtfDescricaoProduto;
    private javax.swing.JTextField jtfIdCliente;
    private javax.swing.JTextField jtfNomeCliente;
    private javax.swing.JTextField jtfQtd;
    // End of variables declaration//GEN-END:variables
}

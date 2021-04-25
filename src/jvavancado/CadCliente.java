package jvAvancado;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jvavancado.Editor.BuscaCliente;
import jvavancado.ObjectFactory;

public class CadCliente extends javax.swing.JFrame {

    public CadCliente() {
        initComponents();
        jbtnLimparActionPerformed(null);
    }

    public void preencheTelaDaBusca(String idselecionadoNaBusca) {
        jtfId.setText(idselecionadoNaBusca);
        jtfIdFocusLost(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrSexo = new javax.swing.ButtonGroup();
        jtfN = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfS = new javax.swing.JLabel();
        jtfTelefone = new javax.swing.JTextField();
        jtfEm = new javax.swing.JLabel();
        jtfT = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jtfSalario = new javax.swing.JTextField();
        jbtnGravar = new javax.swing.JButton();
        jbtnExcluir = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jtf = new javax.swing.JLabel();
        jtfIdade = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfProfissao = new javax.swing.JList();
        jtfP = new javax.swing.JLabel();
        jtfEstadoCivil = new javax.swing.JComboBox();
        jtfE = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFeminino = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jbtnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtfN.setText("Nome");

        jtfS.setText("Salario");

        jtfEm.setText("Email");

        jtfT.setText("Telefone");

        jtfSalario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfSalarioFocusLost(evt);
            }
        });
        jtfSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSalarioActionPerformed(evt);
            }
        });

        jbtnGravar.setText("Gravar");
        jbtnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGravarActionPerformed(evt);
            }
        });

        jbtnExcluir.setText("Excluir");
        jbtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExcluirActionPerformed(evt);
            }
        });

        jbtnLimpar.setText("Limpar");
        jbtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimparActionPerformed(evt);
            }
        });

        jtf.setText("Idade");

        jtfProfissao.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Programador", "Engenheiro", "Motorista", "Vendedor" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jtfProfissao);

        jtfP.setText("Selecione a profissão :");

        jtfEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione:", "Casado", "Divorciado", "Solteiro" }));
        jtfEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEstadoCivilActionPerformed(evt);
            }
        });

        jtfE.setText("Estado Civil");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        btnGrSexo.add(jrbMasculino);
        jrbMasculino.setSelected(true);
        jrbMasculino.setText("Masculino");

        btnGrSexo.add(jrbFeminino);
        jrbFeminino.setText("Feminino");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbFeminino)
                    .addComponent(jrbMasculino))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jrbMasculino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbFeminino)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jLabel2.setText("Id");

        jtfId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfIdFocusLost(evt);
            }
        });
        jtfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIdActionPerformed(evt);
            }
        });

        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnGravar)
                        .addGap(32, 32, 32)
                        .addComponent(jbtnExcluir)
                        .addGap(24, 24, 24)
                        .addComponent(jbtnLimpar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfEm, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfS, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jtfSalario))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jtfT, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfE, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jtf, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfN, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addComponent(jtfId)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jtfP, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(87, Short.MAX_VALUE)
                        .addComponent(jtfP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnBuscar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfEm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnGravar)
                    .addComponent(jbtnExcluir)
                    .addComponent(jbtnLimpar))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esse cliente");

        if (resposta == 0) {
            ObjectFactory.executeSql("delete from clientes where id = " + jtfId.getText());
            JOptionPane.showMessageDialog(this, "Registro exluido ");
            jbtnLimparActionPerformed(null);
        }
    }//GEN-LAST:event_jbtnExcluirActionPerformed

    private void jbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparActionPerformed
        jtfNome.setText("");
        jtfEmail.setText("");
        jtfIdade.setValue(0);
        jtfEstadoCivil.setSelectedIndex(0);
        jtfTelefone.setText("");
        jrbMasculino.setSelected(true);
        jtfProfissao.setSelectedIndex(-1);
        jtfSalario.setText("");
        jtfId.setText("");
    }//GEN-LAST:event_jbtnLimparActionPerformed

    private void jtfSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSalarioActionPerformed

    private void jtfEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEstadoCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEstadoCivilActionPerformed

    private void jtfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIdActionPerformed

    }//GEN-LAST:event_jtfIdActionPerformed

    private void jtfIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfIdFocusLost
        if (!jtfId.getText().trim().equals("")) {
            ResultSet rs = ObjectFactory.buscaNoBanco(
                    "SELECT * FROM CLIENTES WHERE ID = "
                    + jtfId.getText());
            try {
                if (rs.next()) {
                    jtfNome.setText(rs.getString("nome"));
                    jtfSalario.setText(rs.getString("salario"));
                    jtfTelefone.setText(rs.getString("telefone"));
                    jtfEstadoCivil.setSelectedItem(rs.getString("estado_civil"));
                    jtfProfissao.setSelectedValue(rs.getString("profissao"), true);
                    jtfEmail.setText(rs.getString("email"));
                    jtfIdade.setValue(rs.getInt("idade"));
                    if (rs.getString("sexo").equals("FEMININO")) {
                        jrbFeminino.setSelected(true);
                    } else {
                        jrbMasculino.setSelected(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Cliente não encontrado");
                    jtfId.setText("");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro na busca!");
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_jtfIdFocusLost

    private void jbtnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGravarActionPerformed
        String mensagemErro = "";
        if (jtfNome.getText().trim().equals("")) {
            mensagemErro += "\n Nome";
        } else if (jtfTelefone.getText().trim().equals("")) {
            mensagemErro += "\n Telefone";
        } else if (jtfIdade.getValue().toString().equals("0")) {
            mensagemErro += "\n Idade";
        } else if (jtfEstadoCivil.getSelectedIndex() < 1) {
            mensagemErro += "\n Estado Civil";
        } else if (jtfProfissao.getSelectedIndex() < 0) {
            mensagemErro += "\n Profissão";
        } else if (jtfEmail.getText().trim().equals("")) {
            mensagemErro += "\n Email";
        } else if (jtfSalario.getText().trim().equals("")) {
            mensagemErro += "\n Salario";
        }

        if (!mensagemErro.equals("")) {
            mensagemErro = "Preencha os campos obrigatórios:"
                    + mensagemErro;
            JOptionPane.showMessageDialog(this, mensagemErro);
            return;
        }
        String sql;
        if (jtfId.getText().equals("")) {
            sql = "INSERT INTO CLIENTES (NOME, SALARIO, TELEFONE, "
                    + "EMAIL, IDADE, ESTADO_CIVIL, SEXO, PROFISSAO)"
                    + " VALUES ("
                    + "'" + jtfNome.getText() + "',"
                    + jtfSalario.getText() + ","
                    + "'" + jtfTelefone.getText() + "',"
                    + "'" + jtfEmail.getText() + "',"
                    + jtfIdade.getValue() + ","
                    + "'" + jtfEstadoCivil.getSelectedItem() + "',";
            if (jrbFeminino.isSelected()) {
                sql += "'Feminino',";
            } else {
                sql += "'Masculino',";
            }
            sql += "'" + jtfProfissao.getSelectedValue() + "')";
        } else {
            sql = "UPDATE CLIENTES SET "
                    + "NOME = '" + jtfNome.getText() + "',"
                    + " EMAIL = '" + jtfEmail.getText() + "',"
                    + " TELEFONE = '" + jtfTelefone.getText() + "',"
                    + " ESTADO_CIVIL = '" + jtfEstadoCivil.getSelectedItem() + "',"
                    + " PROFISSAO = '" + jtfProfissao.getSelectedValue() + "',"
                    + " SALARIO = " + jtfSalario.getText() + ","
                    + " IDADE = " + jtfIdade.getValue() + ",";

            if (jrbFeminino.isSelected()) {
                sql += "SEXO ='Feminino'";
            } else {
                sql += " SEXO = 'Masculino'";
            }

            sql += " WHERE ID = " + jtfId.getText();
        }

        System.out.println(sql);
        ObjectFactory.executeSql(sql);
        JOptionPane.showMessageDialog(this, "Registro Gravado!");

    }//GEN-LAST:event_jbtnGravarActionPerformed

    private void jtfSalarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfSalarioFocusLost
        try {
            Double.parseDouble(jtfSalario.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Digite somente numeros");
            jtfSalario.setText("0");
        }
    }//GEN-LAST:event_jtfSalarioFocusLost

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
          BuscaCliente telaBusca = new BuscaCliente(this);
        telaBusca.setVisible(true);
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrSexo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnExcluir;
    private javax.swing.JButton jbtnGravar;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JRadioButton jrbFeminino;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JLabel jtf;
    private javax.swing.JLabel jtfE;
    private javax.swing.JLabel jtfEm;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JComboBox jtfEstadoCivil;
    private javax.swing.JTextField jtfId;
    private javax.swing.JSpinner jtfIdade;
    private javax.swing.JLabel jtfN;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JLabel jtfP;
    private javax.swing.JList jtfProfissao;
    private javax.swing.JLabel jtfS;
    private javax.swing.JTextField jtfSalario;
    private javax.swing.JLabel jtfT;
    private javax.swing.JTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables
}

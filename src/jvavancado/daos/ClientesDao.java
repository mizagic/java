
package jvavancado.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jvavancado.ObjectFactory;
import jvavancado.beans.Clientes;

public class ClientesDao {

  
    public static Clientes getClienteById(int id) {
        String sql = "SELECT * FROM CLIENTES WHERE ID = " + id;
        ResultSet rs = ObjectFactory.buscaNoBanco(sql);
        try {
            if (rs.next()) {
                return preencheClienteFromResultSet(rs);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Cliente!");
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param condicao
     * @return ArrayList de clientes localizados
     */
    public static ArrayList<Clientes> getClientes(String condicao) {
        String sql = "SELECT * FROM CLIENTES WHERE " + condicao;
        System.out.println(sql);
        ResultSet rs = ObjectFactory.buscaNoBanco(sql);
        ArrayList<Clientes> listaDeClientes = new ArrayList<>();
        try {
            while (rs.next()) {
                listaDeClientes.add(preencheClienteFromResultSet(rs));
            }
            return listaDeClientes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Cliente!");
            ex.printStackTrace();
        }
        return null;
    }

    public static void excluirCliente(int id) {
        String sql = "DELETE FROM CLIENTES WHERE ID = " + id;
        ObjectFactory.executeSql(sql);
    }

    public static void gravar(Clientes cli) {
        String sql;
        if (cli.getId() == 0) {
            sql = "INSERT INTO CLIENTES (NOME, SALARIO, TELEFONE, "
                    + "EMAIL, IDADE, ESTADO_CIVIL, SEXO, PROFISSAO)"
                    + " VALUES ("
                    + "'" + cli.getNome() + "',"
                    + cli.getSalario() + ","
                    + "'" + cli.getTelefone() + "',"
                    + "'" + cli.getEmail() + "',"
                    + cli.getIdade() + ","
                    + "'" + cli.getEstadoCivil() + "',"
                    + "'" + cli.getSexo() + "',"
                    + "'" + cli.getProfissão() + "'";
        } else {
            sql = "UPDATE CLIENTES SET "
                    + "NOME = '" + cli.getNome() + "',"
                    + " EMAIL = '" + cli.getEmail() + "',"
                    + " TELEFONE = '" + cli.getTelefone() + "',"
                    + " ESTADO_CIVIL = '" + cli.getEstadoCivil() + "',"
                    + " PROFISSAO = '" + cli.getProfissão() + "',"
                    + " SALARIO = " + cli.getSalario() + ","
                    + " IDADE = " + cli.getIdade() + ","
                    + " SEXO = '" + cli.getSexo() + "',"
                    + " WHERE ID = " + cli.getId();
        }

        ObjectFactory.executeSql(sql);
    }

    /**
     * Esse método foi criado para automatizar o preenchimento de um novo
     * cliente a partir de um resultset, pois precisaremos preencher clientes de
     * varios pontos como do metodo getClienteById e do GetClientes
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Clientes preencheClienteFromResultSet(ResultSet rs) throws SQLException {
        Clientes cli = new Clientes();
        cli.setId(rs.getInt("id"));
        cli.setEmail(rs.getString("email"));
        cli.setEstadoCivil(rs.getString("estado_civil"));
        cli.setIdade(rs.getInt("idade"));
        cli.setNome(rs.getString("nome"));
        cli.setProfissão(rs.getString("profissao"));
        cli.setSalario(rs.getDouble("salario"));
        cli.setSexo(rs.getString("sexo"));
        cli.setTelefone("telefone");
        return cli;

    }

}


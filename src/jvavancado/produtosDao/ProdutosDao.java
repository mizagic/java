package jvavancado.produtosDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jvavancado.ObjectFactory;
import jvavancado.Produtos.beans.Produtos;

public class ProdutosDao {

    public static Produtos getProdutosById(int id) {
        String sql = "SELECT * FROM Produtos WHERE ID = " + id;
        ResultSet rs = ObjectFactory.buscaNoBanco(sql);
        try {
            if (rs.next()) {
                return preencheProdutosFromResultSet(rs);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produto!");
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param condicao
     * @return ArrayList de clientes localizados
     */
    public static ArrayList<Produtos> getProdutos(String condicao) {
        String sql = "SELECT * FROM Produtos WHERE " + condicao;
        ResultSet rs = ObjectFactory.buscaNoBanco(sql);
        ArrayList<Produtos> listaDeProdutos = new ArrayList<>();
        try {
            while (rs.next()) {
                listaDeProdutos.add(preencheProdutosFromResultSet(rs));
            }
            return listaDeProdutos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produto!");
            ex.printStackTrace();
        }
        return null;
    }

    public static void excluirProduto(int id) {
        String sql = "DELETE FROM Produtos WHERE ID = " + id;
        ObjectFactory.executeSql(sql);
    }

    public static void gravar(Produtos pro) {
        String sql;
        if (pro.getId() == 0) {
            sql = "INSERT INTO Produtos (Descrição, preço, un_medida, estoque)"
                    + " VALUES ("
                    + "'" + pro.getDescrição() + "',"
                    +"'" + pro.getPreco() + "'"+ ","
                    + "'" + pro.getUn_medida() + "',"
                    + "'" + pro.getEstoque() + "')";
        } else {
            sql = "UPDATE produtos SET "
                    + "Descrição = '" + pro.getDescrição() + "',"
                    + "Preço  = '" + pro.getPreco() + "',"
                    + " Un_medida = '" + pro.getUn_medida()+ "',"
                    + " estoque = '" + pro.getEstoque()+ "',"
                    + " WHERE ID = " + pro.getId();
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
    public static Produtos preencheProdutosFromResultSet(ResultSet rs) throws SQLException {
        Produtos pro = new Produtos();
        pro.setId(rs.getInt("id"));
        pro.setDescrição(rs.getString("descrição"));
        pro.setPreco(rs.getDouble("Preço"));
        pro.setUn_medida(rs.getString("Un_medida"));
        pro.setEstoque(rs.getInt("estoque"));
        return pro;

    }

}

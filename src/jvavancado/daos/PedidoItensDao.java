
package jvavancado.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jvavancado.ObjectFactory;
import jvavancado.beans.Pedido;
import jvavancado.beans.PedidoItens;
import jvavancado.produtosDao.ProdutosDao;

public class PedidoItensDao {

    public static void gravar(PedidoItens item) {
        String sql;
        if (item.getId() == 0) {
            sql = "INSERT INTO PEDIDO_ITENS (ID_PEDIDO, ID_PRODUTO, "
                    + "QTDE, PERC_DESCONTO)"
                    + " VALUES ("
                    + item.getPedido().getId()
                    + "," + item.getProdutos().getId()
                    + "," + item.getQtde()
                    + "," + item.getPercdesconto()+ ")";
        } else {
            sql = "UPDATE PEDIDO_ITENS SET "
                    + "ID_PEDIDO =" + item.getPedido().getId()
                    + ", ID_PRODUTO = " + item.getProdutos().getId()
                    + ", QTDE = " + item.getQtde()
                    + ", PERC_DESCONTO = " + item.getPercdesconto()
                    + " WHERE ID = " + item.getId();
        }

        ObjectFactory.executeSql(sql);
    }

    public static ArrayList<PedidoItens> getPedidoItensByPedido(Pedido pedido) {
        String sql = "SELECT * FROM PEDIDO_ITENS WHERE ID_PEDIDO =" + pedido.getId();
        System.out.println(sql);
        ResultSet rs = ObjectFactory.buscaNoBanco(sql);
        ArrayList<PedidoItens> listaDeItens = new ArrayList<>();
        try {
            while (rs.next()) {
                PedidoItens itemTemporario = preenchePedidoItensFromResultSet(rs);
                itemTemporario.setPedido(pedido);
                listaDeItens.add(itemTemporario);
            }
            return listaDeItens;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Itens!");
            ex.printStackTrace();
        }
        return null;
    }

    public static PedidoItens preenchePedidoItensFromResultSet(ResultSet rs) throws SQLException {
        PedidoItens item = new PedidoItens();
        item.setId(rs.getInt("id"));
        item.setProdutos(ProdutosDao.getProdutosById(rs.getInt("id_produto")));
        item.setPercdesconto(rs.getDouble("perc_desconto"));
        item.setQtde(rs.getDouble("qtde"));
        return item;

    }
}

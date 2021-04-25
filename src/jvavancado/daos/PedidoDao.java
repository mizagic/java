package jvavancado.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jvavancado.Datas;
import jvavancado.ObjectFactory;
import jvavancado.beans.Pedido;

public class PedidoDao {

    public static ArrayList<Pedido> getPedidos(String condicao) {
        String sql = "SELECT * FROM PEDIDOS WHERE " + condicao;
        System.out.println(sql);
        ResultSet rs = ObjectFactory.buscaNoBanco(sql);
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        try {
            while (rs.next()) {
                listaDePedidos.add(preenchePedidoFromResultSet(rs));
            }
            return listaDePedidos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Cliente!");
            ex.printStackTrace();
        }
        return null;
    }

    public static void gravar(Pedido ped) {
        String sql;
        if (ped.getId() == 0) {
            sql = "SELECT MAX(ID)as maiorId FROM PEDIDO";
            ResultSet retorno = ObjectFactory.buscaNoBanco(sql);
            int novoId = 0;
            try {
                retorno.next();
                novoId = retorno.getInt("maiorId");
                novoId = novoId + 1;
                ped.setId(novoId);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao buscar novo id do Pedido!");
            }
            sql = "INSERT INTO PEDIDO (ID, ID_CLIENTE, DATA, ENTREGUE)"
                    + " VALUES ("
                    + ped.getId()
                    + "," + ped.getCliente().getId()
                    + ", '" + Datas.Formatar("yyyy-MM-dd", ped.getData())
                    + "','" + ped.getEntregue() + "')";
        } else {
            sql = "UPDATE PEDIDO SET "
                    + " ID_CLIENTE = " + ped.getCliente().getId()
                    + ", DATA = '" + Datas.Formatar("yyyy-MM-dd", ped.getData())
                    + "', '" + ped.getEntregue() + "'"
                    + " WHERE ID = " + ped.getId();
        }
        System.out.println(sql);
        ObjectFactory.executeSql(sql);
    }

    public static Pedido preenchePedidoFromResultSet(ResultSet rs) throws SQLException {
        Pedido ped = new Pedido();
        ped.setCliente(ClientesDao.getClienteById(rs.getInt("id_cliente")));
        ped.setData(rs.getDate("data"));
        ped.setEntregue(rs.getString("entregue"));
        ped.setId(rs.getInt("id"));
        return ped;

    }
}

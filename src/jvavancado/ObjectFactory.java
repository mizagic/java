package jvavancado;

import bancodedados.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ObjectFactory {

    static conexao conexao;

    public static conexao getConexao() {
        if (conexao == null) {
            conexao = new conexao();
            conexao.setUrl("jdbc:mysql://localhost:3306/vendas");
            conexao.setUsuario("root");
            conexao.setSenha("");
            conexao.getConnection();
        }
        return conexao;
    }

    public static ResultSet buscaNoBanco(String sql) {
        Statement stm;
        try {
            stm = getConexao().getConnection().createStatement();
            ResultSet resultados = stm.executeQuery(sql);
            return resultados;
        } catch (Exception ex) {
            System.out.println("Erro ao executar consulta!");
            ex.printStackTrace();
        }
        return null;

    }

    public static void executeSql(String sql) {
        try {
            PreparedStatement prs = getConexao().getConnection().prepareStatement(sql);
            prs.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

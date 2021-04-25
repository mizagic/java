package bancodedados;

import java.sql.ResultSet;
import java.sql.Statement;

public class Testes {

    public static void main(String[] args) {
        conexao cnx = new conexao();
        cnx.setUrl("jdbc:mysql://localhost:3306/vendas");
        cnx.setUsuario("root");
        cnx.setSenha("");
        cnx.getConnection();

        String sql = "select * from clientes";

        Statement stm;
        try {
            stm = cnx.getConnection().createStatement();
            ResultSet resultados = stm.executeQuery(sql);

            while (resultados.next()) {
                System.out.println("Id = "
                        + resultados.getInt("id"));
                System.out.println("Nome = "
                        + resultados.getString("nome"));
                System.out.println("Telefone ="
                        + resultados.getString("telefone"));
                System.out.println("Salario ="
                        + resultados.getDouble("salario"));
                System.out.println("---------------------------");

            }
        } catch (Exception ex) {
            System.out.println("Erro ao executar consulta!");
            ex.printStackTrace();
        }

    }
}

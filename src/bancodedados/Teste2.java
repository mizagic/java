
package bancodedados;

import java.sql.ResultSet;
import java.sql.Statement;


public class Teste2 {
    public static void main(String[] args) {
        
  
    conexao cnx = new conexao();
        cnx.setUrl("jdbc:mysql://localhost:3306/vendas");
        cnx.setUsuario("root");
        cnx.setSenha("");
        cnx.getConnection();
         String sql = "select * from produtos";
         
          Statement stm;
        try {
            stm = cnx.getConnection().createStatement();
            ResultSet resultados = stm.executeQuery(sql);

            while (resultados.next()) {
                System.out.println("Id = "
                        + resultados.getInt("id"));
                System.out.println("descrição = "
                        + resultados.getString("descrição"));
                System.out.println("preço = "
                        + resultados.getDouble("preço"));
                System.out.println("un_medida ="
                        + resultados.getString("un_medida"));
                System.out.println("Estoque = " 
                        + resultados.getInt("estoque"));}

            
        } catch (Exception ex) {
            System.out.println("Erro ao executar consulta!");
            ex.printStackTrace();
        }
         
}
}
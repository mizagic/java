
package bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexao {
    
    private Connection conn;
    String user, password,  url;

    public static void main(String[] args) {
        conexao cnx = new conexao();
        cnx.setUrl("jdbc:mysql://localhost:3306/vendas");
        cnx.setUsuario("");
        cnx.setSenha("");
        cnx.getConnection();
    }

    public Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("MySql Conectado!");
            } catch (ClassNotFoundException e) {
                System.out.println("Impossivel registrar driver!");
            } catch (SQLException e) {
                System.out.println("Erro ao conectar MySql!!" + e);
            }
        }

        return conn;
    }

    public void setConnection(Connection cnx) {
        conn = cnx;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsuario(String usuario) {
        this.user = usuario;
    }

    public void setSenha(String senha) {
        this.password = senha;
    }

    public void reconecta() {
        conn = null;
        getConnection();
    }

}


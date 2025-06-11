package pi_1sem.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactoryTest {
    Dotenv dotenv = Dotenv.load();
    private String host= "localhost";
    private String port= "3306";
    private String db= "inteligencia_em_jogo";
    private String user= "root";
    private String password= dotenv.get("senhaTeste");
    
    public Connection obterConexao() throws Exception{
        var s= String.format("jdbc:mysql://%s:%s/%s", host, port, db);
        Connection c= DriverManager.getConnection(s, user, password);
        return c;
    }
}

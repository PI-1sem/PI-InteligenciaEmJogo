package pi_1sem.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactoryTest {
    Dotenv dotenv = Dotenv.load();
    private String host= "mysql-pi-pi1sem.l.aivencloud.com";
    private String port= "24011";
    private String db= "jogo_do_milhao";
    private String user= "avnadmin";
    private String password= dotenv.get("senhaTeste");
    
    public Connection obterConexao() throws Exception{
        var s= String.format("jdbc:mysql://%s:%s/%s", host, port, db);
        Connection c= DriverManager.getConnection(s, user, password);
        return c;
    }
}

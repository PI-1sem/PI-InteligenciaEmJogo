package pi_1sem.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;


public class ConnectionFactory {

    Dotenv dotenv = Dotenv.load();
    private String host= "pi1sem-inteligenciaemjogopi-3060.l.aivencloud.com";
    private String port= "28398";
    private String db= "inteligencia_em_jogo";
    private String user= "avnadmin";
    private String password= dotenv.get("passwordDb");
    
    public Connection obterConexao() throws Exception{
        var s= String.format("jdbc:mysql://%s:%s/%s", host, port, db);
        Connection c= DriverManager.getConnection(s, user, password);
        return c;
    }
}


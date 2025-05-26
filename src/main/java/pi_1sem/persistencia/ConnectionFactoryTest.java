package pi_1sem.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryTest {
    private String host= "mysql-pi-pi1sem.l.aivencloud.com";
    private String port= "24011";
    private String db= "jogo_do_milhao";
    private String user= "avnadmin";
    private String password= "AVNS_e3x0Ojk8nuXbJtiJx7U";
    
    public Connection obterConexao() throws Exception{
        var s= String.format("jdbc:mysql://%s:%s/%s", host, port, db);
        Connection c= DriverManager.getConnection(s, user, password);
        return c;
    }
}

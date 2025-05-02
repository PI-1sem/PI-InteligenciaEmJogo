package pi_1sem.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionFactory {
    
    private String host= "pi-1-sem-pi1sem.c.aivencloud.com";
    private String port= "24011";
    private String db= "defaultdb";
    private String user= "avnadmin";
    private String password= "";
    
    public Connection obterConexão() throws Exception{
        var s= String.format("jdbc:mysql://%s:%s/%s", host, port, db);
        Connection c= DriverManager.getConnection(s, user, password);
        return c;
    }
    
    public static void main(String[] args) throws Exception{
        var fabricaDeConexoes= new ConectionFactory();
        Connection conexao= fabricaDeConexoes.obterConexão();
        if(conexao != null){
            System.out.println("Conectou");
        }
        else{
            System.out.println("Não conectou");
        }
    }
}


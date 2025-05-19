package pi_1sem.persistencia.usuarios;

import pi_1sem.classes.participantes.Administrador;
import pi_1sem.persistencia.ConnectionFactory;

public class AdministradorDAO {
    public boolean cadastrar(Administrador administrador){
        var conectionFactory= new ConnectionFactory();
        var sql= "INSERT INTO usuarios(nome, email, senha, nivel_acesso) VALUES(?, ?, ?, administrador)";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getEmail());
            ps.setString(3, administrador.getSenha());
            
            ps.execute();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean remover(Administrador administrador){
        var conectionFactory= new ConnectionFactory();
        var sql= "DELETE FROM usuarios WHERE id_usuario= ? and nivel_acesso= administrador";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
           ps.setInt(1, administrador.getId());
           
           ps.execute();
           return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean atualizar(Administrador administrador){
        var conectionFactory= new ConnectionFactory();
        var sql= "UPDATE usuarios SET nome= ? email= ? senha= ? WHERE id_usuario= ? and nivel_acesso= administrador";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getEmail());
            ps.setString(3, administrador.getSenha());
            ps.setInt(4, administrador.getId());
            
            ps.execute();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean listar(){
        var conectionFactory= new ConnectionFactory();
        var sql= "SELECT (id_usuario, nome, email, senha) FROM usuarios WHERE nivel_acesso= administrador";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
            var rs= ps.executeQuery();
        ){
            while(rs.next()){
                var id= rs.getInt("id");
                var nome= rs.getString("nome");
                var email= rs.getString("email");
                var senha= rs.getString("senha");
                System.out.printf("\n%s %s %s\n", id, nome, email, senha);
            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
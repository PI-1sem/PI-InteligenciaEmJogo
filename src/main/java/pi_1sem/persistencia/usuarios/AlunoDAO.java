package pi_1sem.persistencia.usuarios;

import pi_1sem.classes.participantes.Aluno;
import pi_1sem.persistencia.ConnectionFactory;

public class AlunoDAO {
    public boolean cadastrar(Aluno aluno){
        var conectionFactory= new ConnectionFactory();
        var sql= "INSERT INTO usuarios(nome, email, senha, nivel_acesso) VALUES(?, ?, ?, aluno)";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getEmail());
            ps.setString(3, aluno.getSenha());
            
            ps.execute();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean remover(Aluno aluno){
        var conectionFactory= new ConnectionFactory();
        var sql= "DELETE FROM usuarios WHERE id_usuario= ? and nivel_acesso= aluno";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
           ps.setInt(1, aluno.getId());
           
           ps.execute();
           return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean atualizar(Aluno aluno){
        var conectionFactory= new ConnectionFactory();
        var sql= "UPDATE usuarios SET nome= ? email= ? senha= ? WHERE id_aluno= ? and nivel_acesso= aluno";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getEmail());
            ps.setString(3, aluno.getSenha());
            ps.setInt(4, aluno.getId());
            
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
        var sql= "SELECT (id_usuario, nome, email, senha) FROM usuarios WHERE nivel_acesso= aluno";
        
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
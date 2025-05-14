package pi_1sem.conexao;

public class AlunoDAO {
    public boolean cadastrar(Aluno aluno){
        var conectionFactory= new ConectionFactory();
        var sql= "INSERT INTO tb_usuario(nome, email, senha, tipo) VALUES(?, ?, ?, aluno)";

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
        var conectionFactory= new ConectionFactory();
        var sql= "DELETE FROM tb_usuario WHERE id_usuario= ? and tipo= aluno";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
           ps.setInt(1, aluno.getCod());
           
           ps.execute();
           return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean atualizar(Aluno aluno){
        var conectionFactory= new ConectionFactory();
        var sql= "UPDATE tb_usuario SET nome= ? email= ? senha= ? WHERE id_aluno= ? and tipo= aluno";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getEmail());
            ps.setString(3, aluno.getSenha());
            ps.setInt(4, aluno.getCod());
            
            ps.execute();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean listar(){
        var conectionFactory= new ConectionFactory();
        var sql= "SELECT (id_usuario, nome, email, senha) FROM tb_usuario WHERE tipo= aluno";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
            var rs= ps.executeQuery();
        ){
            while(rs.next()){
                var id= rs.getInt("id");
                var nome= rs.getString("nome");
                var email= rs.getString("fone");
                var senha= rs.getString("email");
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
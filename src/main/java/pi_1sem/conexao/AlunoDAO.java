package pi_1sem.conexao;

public class AlunoDAO {
    public boolean cadastrar(Aluno aluno){
        var conectionFactory= new ConectionFactory();
        var sql= "INSERT INTO tb_aluno(nome, fone, email) VALUES(?, ?, ?)";

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
            return false;
        }
    }
    public boolean remover(Aluno aluno){
        var conectionFactory= new ConectionFactory();
        var sql= "DELETE FROM tb_aluno WHERE cod_aluno= ?";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
           ps.setInt(1, aluno.getCod());
           
           ps.execute();
           return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public boolean atualizar(Aluno aluno){
        var conectionFactory= new ConectionFactory();
        var sql= "UPDATE tb_aluno SET nome= ? fone= ? email= ? WHERE cod_aluno= ? ";
        
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
            return false;
        }
    }
    public boolean listar(){
        var conectionFactory= new ConectionFactory();
        var sql= "SELECT * FROM tb_aluno";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
            var rs= ps.executeQuery();
        ){
            while(rs.next()){
                var nome= rs.getString("nome");
                var email= rs.getString("fone");
                var senha= rs.getString("email");
                System.out.printf("\n%s %s %s\n", nome, email, senha);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
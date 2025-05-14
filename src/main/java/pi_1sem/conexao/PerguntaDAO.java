package pi_1sem.conexao;

public class PerguntaDAO {
    public boolean adicionar(Pergunta pergunta){
        var conectionFactory= new ConectionFactory();
        var sql= "INSERT INTO tb_pergunta(enunciado, materia, nivel) VALUES(?, ?, ?)";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, pergunta.getEnunciado());
            ps.setString(2, pergunta.getMateria());
            ps.setString(3, pergunta.getNivel());
            
            ps.execute();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean remover(Pergunta pergunta){
        var conectionFactory= new ConectionFactory();
        var sql= "DELETE FROM tb_pergunta WHERE id_pergunta= ?";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
           ps.setInt(1, pergunta.getId());
           
           ps.execute();
           return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean atualizar(Pergunta pergunta){
        var conectionFactory= new ConectionFactory();
        var sql= "UPDATE tb_pergunta SET enunciado= ? materia= ? nivel= ? WHERE id_pergunta= ? ";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, pergunta.getEnunciado());
            ps.setString(2, pergunta.getMateria());
            ps.setString(3, pergunta.getNivel());
            ps.setInt(4, pergunta.getId());
            
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
        var sql= "SELECT (id_pergunta, enunciado, materia, nivel) FROM tb_pergunta";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
            var rs= ps.executeQuery();
        ){
            while(rs.next()){
                var id= rs.getInt("id");
                var enunciado= rs.getString("enunciado");
                var materia= rs.getString("materia");
                var nivel= rs.getString("nivel");
                System.out.printf("\n%d %s %s %s\n", id, enunciado, materia, nivel);
            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

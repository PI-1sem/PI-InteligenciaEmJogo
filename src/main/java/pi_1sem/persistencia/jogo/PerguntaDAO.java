package pi_1sem.persistencia.jogo;

import pi_1sem.persistencia.ConnectionFactory;

public class PerguntaDAO {
    public boolean cadastrar(Pergunta pergunta){
        var conectionFactory= new ConnectionFactory();
        var sql= "INSERT INTO perguntas(enunciado, materia, nivel_dificuldade) VALUES(?, ?, ?)";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, pergunta.getEnunciado());
            ps.setString(2, pergunta.getMateria());
            ps.setString(3, pergunta.getNivelDificuldade());
            
            ps.execute();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean remover(Pergunta pergunta){
        var conectionFactory= new ConnectionFactory();
        var sql= "DELETE FROM perguntas WHERE id_pergunta= ?";
        
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
        var conectionFactory= new ConnectionFactory();
        var sql= "UPDATE perguntas SET enunciado= ? materia= ? nivel_dificuldade= ? WHERE id_pergunta= ?";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, pergunta.getEnunciado());
            ps.setString(2, pergunta.getMateria());
            ps.setString(3, pergunta.getNivelDificuldade());
            ps.setInt(4, pergunta.getIdperguntDAO());
            
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
        var sql= "SELECT (id_pergunta, enunciado, materia, nivel_dificuldade) FROM pergunta WHERE tipo= perguntDAO";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
            var rs= ps.executeQuery();
        ){
            while(rs.next()){
                var id= rs.getInt("id_pergunta");
                var enunciado= rs.getString("enunciado");
                var materia= rs.getString("materia");
                var nivelDificuldade= rs.getString("nivel_dificuldade");
                System.out.printf("\n%s %s %s\n", id, enunciado, materia, nivelDificuldade);
            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

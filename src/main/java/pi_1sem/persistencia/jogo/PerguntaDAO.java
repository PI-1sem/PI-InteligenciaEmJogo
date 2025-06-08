package pi_1sem.persistencia.jogo;

import java.util.ArrayList;
import java.util.List;
import pi_1sem.modelo.jogo.Alternativa;
import pi_1sem.modelo.jogo.Materia;
import pi_1sem.modelo.jogo.Pergunta;
import pi_1sem.modelo.jogo.PerguntaAlternativa;
import pi_1sem.persistencia.ConnectionFactoryTest;
import pi_1sem.persistencia.ConnectionFactory;

public class PerguntaDAO {
   public List<PerguntaAlternativa> bancoDeQuestoes(String nivel, Materia materia) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();
        var sql= "SELECT p.enunciado, p.nivel_dificuldade, m.nome as materia, a.letra, a.texto, pa.correta FROM pergunta_alternativa pa JOIN pergunta p ON pa.id_pergunta= p.id_pergunta JOIN materia m ON p.id_materia = m.id_materia JOIN alternativa a ON pa.id_alternativa= a.id_alternativa WHERE p.nivel_dificuldade=? AND m.nome=?";
        var todasPerguntas= new ArrayList<PerguntaAlternativa>();
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, nivel);
            ps.setString(2, materia.getNome());
            var rs= ps.executeQuery();
            while(rs.next()){
                var enunciado= rs.getString("p.enunciado");
                var letra=rs.getString("a.letra");
                var texto=rs.getString("a.texto");
                var certa=rs.getInt("pa.correta");
                var correta= (certa == 1) ? true : false;
                
                var alternativa= new Alternativa(letra, texto);
                var pergunta= new Pergunta(enunciado, materia,  nivel);
                var perguntaAlternativa= new PerguntaAlternativa(pergunta, alternativa, correta);

                todasPerguntas.add(perguntaAlternativa);
            }
            return todasPerguntas;
        }
    }

    public void editarPergunta(String enunciado, int idPergunta) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();

        var sql= "UPDATE pergunta p JOIN pergunta_alternativa USING (id_pergunta) JOIN alternativa a USING (id_alternativa) SET p.enunciado=? WHERE p.id_pergunta=?";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, enunciado);
            ps.setInt(2, idPergunta);
            ps.execute();
        }
    }
    public void excluirPergunta(int idPergunta) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();

        var sql= "DELETE FROM pergunta WHERE id_pergunta=?";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setInt(1, idPergunta);
            ps.execute();
        }
    }
    public void adicionarPergunta(Pergunta pergunta)throws Exception{
        var conectionFactory= new ConnectionFactoryTest();

        var sql= "INSERT INTO pergunta (enunciado, id_materia, nivel_dificuldade) VALUES (?, ?, ?)";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, pergunta.getEnunciado());
            ps.setInt(2, pergunta.getMateria().getId());
            ps.setString(3, pergunta.getNivel());
        }

    }
    public void editarDificuldade(String dificuldade, int idPergunta) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();

        var sql= "UPDATE pergunta SET nivel_dificuldade=? WHERE id_pergunta=?";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, dificuldade);
            ps.setInt(2, idPergunta);
            ps.execute();
        }
    }
}

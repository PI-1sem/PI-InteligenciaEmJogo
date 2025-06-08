package pi_1sem.persistencia.jogo;

import java.util.ArrayList;
import java.util.List;

import pi_1sem.modelo.jogo.Alternativa;
import pi_1sem.modelo.jogo.Materia;
import pi_1sem.modelo.jogo.Pergunta;
import pi_1sem.modelo.jogo.PerguntaAlternativa;
import pi_1sem.persistencia.ConnectionFactoryTest;
import pi_1sem.persistencia.ConnectionFactory;


public class PerguntaAlternativaDAO {
    public  List<PerguntaAlternativa> listarPerguntasAlternativas() throws Exception{
        var conectionFactory= new ConnectionFactoryTest();
        var sql="SELECT p.id_pergunta, p.enunciado, p.nivel_dificuldade, m.nome as materia, a.id_alternativa, a.letra, a.texto, pa.correta FROM pergunta_alternativa pa JOIN pergunta p ON pa.id_pergunta= p.id_pergunta JOIN materia m ON p.id_materia = m.id_materia JOIN alternativa a ON pa.id_alternativa= a.id_alternativa ORDER BY p.nivel_dificuldade, p.id_pergunta, a.letra";
        var todasPerguntasAlternativas= new ArrayList<PerguntaAlternativa>();
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            var rs= ps.executeQuery();
            while(rs.next()){
                var id= rs.getInt("p.id_pergunta");
                var enunciado= rs.getString("p.enunciado");
                var letra=rs.getString("a.letra");
                var materia=rs.getString("materia");
                var idAlternativa=rs.getInt("a.id_alternativa");
                var texto=rs.getString("a.texto");
                var nivel=rs.getString("p.nivel_dificuldade");
                var certa=rs.getInt("pa.correta");
                var correta= (certa == 1) ? true : false;
                
                var alternativa= new Alternativa(idAlternativa, letra, texto);
                var pergunta= new Pergunta(id, enunciado, new Materia(materia), nivel);
                var perguntaAlternativa= new PerguntaAlternativa(pergunta, alternativa, correta);

                todasPerguntasAlternativas.add(perguntaAlternativa);
            }
            return todasPerguntasAlternativas;
        }
    }
    public  List<PerguntaAlternativa> listarPerguntasAlternativasExpecificas(String nomeMateria) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();
        var sql="SELECT p.id_pergunta, p.enunciado, p.nivel_dificuldade, m.nome as materia, a.id_alternativa, a.letra, a.texto, pa.correta FROM pergunta_alternativa pa JOIN pergunta p ON pa.id_pergunta= p.id_pergunta JOIN materia m ON p.id_materia = m.id_materia JOIN alternativa a ON pa.id_alternativa= a.id_alternativa WHERE m.nome = ? ORDER BY p.nivel_dificuldade, p.id_pergunta, a.letra";
        var todasPerguntasAlternativas= new ArrayList<PerguntaAlternativa>();
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, nomeMateria);
            var rs= ps.executeQuery();
            while(rs.next()){
                var id= rs.getInt("p.id_pergunta");
                var enunciado= rs.getString("p.enunciado");
                var letra=rs.getString("a.letra");
                var materia=rs.getString("materia");
                var idAlternativa=rs.getInt("a.id_alternativa");
                var texto=rs.getString("a.texto");
                var nivel=rs.getString("p.nivel_dificuldade");
                var certa=rs.getInt("pa.correta");
                var correta= (certa == 1) ? true : false;
                
                var alternativa= new Alternativa(idAlternativa, letra, texto);
                var pergunta= new Pergunta(id, enunciado, new Materia(materia), nivel);
                var perguntaAlternativa= new PerguntaAlternativa(pergunta, alternativa, correta);

                todasPerguntasAlternativas.add(perguntaAlternativa);
            }
            return todasPerguntasAlternativas;
        }
    }
    public void removerAlternativaCorreta(int idPergunta, int idAntigaAlternativaCorreta) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();

        var sql="UPDATE pergunta_alternativa SET correta= 0 WHERE id_pergunta= ? AND id_alternativa= ?";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setInt(1, idPergunta);
            ps.setInt(2, idAntigaAlternativaCorreta);
            ps.execute();
        }
    }
    public void adicionarAlternativaCorreta(int idPergunta, int idNovaAlternativaCorreta) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();

        var sql="UPDATE pergunta_alternativa SET correta= 1 WHERE id_pergunta= ? AND id_alternativa= ?";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setInt(1, idPergunta);
            ps.setInt(2, idNovaAlternativaCorreta);
            ps.execute();
        }
    }
    public void adicionarPerguntaAlternativa(List<PerguntaAlternativa> perguntaAlternativasNovas) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();

        var sql="INSERT INTO pergunta_alternativa (id_pergunta, id_alternativa, correta) VALUES (?, ?, ?)";

        for (PerguntaAlternativa perguntaAlterantivaNova : perguntaAlternativasNovas) {
            try(
                
                var conexao= conectionFactory.obterConexao();
                var ps= conexao.prepareStatement(sql);
            ){
                ps.setInt(1, perguntaAlterantivaNova.getPergunta().getId());
                ps.setInt(2, perguntaAlterantivaNova.getAlternativa().getId());
                ps.setInt(3, perguntaAlterantivaNova.isCorreta() ? 1 : 0);
                ps.execute();
            }
        }   
    }
}
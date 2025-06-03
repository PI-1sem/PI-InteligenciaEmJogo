package pi_1sem.persistencia.jogo;

import java.util.ArrayList;
import java.util.List;

import pi_1sem.modelo.jogo.Alternativa;
import pi_1sem.modelo.jogo.Materia;
import pi_1sem.modelo.jogo.Pergunta;
import pi_1sem.modelo.jogo.PerguntaAlternativa;
import pi_1sem.persistencia.ConnectionFactoryTest;

public class PerguntaAlternativaDAO {
    public static List<PerguntaAlternativa> listarPerguntasAlternativas() throws Exception{
        var conectionFactory= new ConnectionFactoryTest();
        var sql="SELECT p.id_pergunta, p.enunciado, p.nivel_dificuldade, m.nome as materia, a.letra, a.texto, pa.correta FROM pergunta_alternativa pa JOIN pergunta p ON pa.id_pergunta= p.id_pergunta JOIN materia m ON p.id_materia = m.id_materia JOIN alternativa a ON pa.id_alternativa= a.id_alternativa ORDER BY p.id_pergunta, a.letra";
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
                var texto=rs.getString("a.texto");
                var nivel=rs.getString("p.nivel_dificuldade");
                var certa=rs.getInt("pa.correta");
                var correta= (certa == 1) ? true : false;
                
                var alternativa= new Alternativa(letra, texto);
                var pergunta= new Pergunta(id, enunciado, new Materia(materia), nivel);
                var perguntaAlternativa= new PerguntaAlternativa(pergunta, alternativa, correta);

                todasPerguntasAlternativas.add(perguntaAlternativa);
            }
            return todasPerguntasAlternativas;
        }
    }
}
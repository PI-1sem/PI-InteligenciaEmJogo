package pi_1sem.persistencia.jogo;

import pi_1sem.persistencia.ConnectionFactoryTest;

import java.util.List;

import pi_1sem.modelo.jogo.Alternativa;
import pi_1sem.persistencia.ConnectionFactory;

public class AlternativaDAO {
    public void editarAlternativa(Alternativa alternativa, int idPergunta) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();

        var sql= "UPDATE alternativa a JOIN pergunta_alternativa pa USING (id_alternativa) JOIN pergunta p USING (id_pergunta) SET a.texto=? WHERE pa.id_pergunta= ? AND pa.id_alternativa=?";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, alternativa.getTexto());
            ps.setInt(2, idPergunta);
            ps.setInt(3, alternativa.getId());
            ps.execute();
        }
    }
    public void adicionarAlternativa(List<Alternativa> alternativas) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();
        var sql= "INSERT INTO alternativa (letra, texto) VALUES (?, ?)";

        for(var alternativa: alternativas){
            try(
                    var conexao= conectionFactory.obterConexao();
                    var ps= conexao.prepareStatement(sql);
                ){
                    ps.setString(1, alternativa.getLetra());
                    ps.setString(2, alternativa.getTexto());
                    ps.execute();
                }
        }
    }
    public void excluirAlternativas(List<Integer> idsAlternativa) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();
        var sql= "DELETE FROM alternativa WHERE id_alternativa=?";

        for(int id: idsAlternativa){
            try(
                var conexao= conectionFactory.obterConexao();
                var ps= conexao.prepareStatement(sql);
            ){
                ps.setInt(1, id);
                ps.execute();
            }
        }
    }
}

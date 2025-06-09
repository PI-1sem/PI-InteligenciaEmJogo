package pi_1sem.persistencia.jogo;

import pi_1sem.persistencia.ConnectionFactoryTest;

import java.util.ArrayList;
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
        var sqlFinal= "SELECT LAST_INSERT_ID() AS id_alternativa";
        var conexao= conectionFactory.obterConexao();

        for(var alternativa: alternativas){
            try(
                    var ps= conexao.prepareStatement(sql);
                    var ps2= conexao.prepareStatement(sqlFinal);
                ){
                    ps.setString(1, alternativa.getLetra());
                    ps.setString(2, alternativa.getTexto());
                    ps.execute();

                    var rs= ps2.executeQuery();
                    if(rs.next()){
                        alternativa.setId(rs.getInt("id_alternativa"));
                    }
                }
        }
        conexao.close();
    }
    public void excluirAlternativas(List<Integer> idsAlternativa) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();
        var sql= "DELETE FROM alternativa WHERE id_alternativa=?";
        var conexao= conectionFactory.obterConexao();

        for(int id: idsAlternativa){
            try(
                var ps= conexao.prepareStatement(sql);
            ){
                ps.setInt(1, id);
                ps.execute();
            }
        }
        conexao.close();
    }
}

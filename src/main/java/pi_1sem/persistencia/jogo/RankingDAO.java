package pi_1sem.persistencia.jogo;

import java.util.ArrayList;
import java.util.List;


import pi_1sem.modelo.jogo.Ranking;
import pi_1sem.persistencia.ConnectionFactoryTest;

public class RankingDAO {
    public List<Ranking> exibirRanking() throws Exception{
        var rankingFinal= new ArrayList<Ranking>();
        var conectionFactory= new ConnectionFactoryTest();
        var sql= "select RANK() OVER (ORDER BY pontuacao_total DESC)  as 'Posição', nome, email, pontuacao_total from usuario where nivel_acesso='aluno' ORDER BY 'Posição'";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
            var rs= ps.executeQuery();
        ){
            while(rs.next()){
                var posicao= rs.getInt("Posição");
                var nome= rs.getString("nome");
                var email= rs.getString("email");
                var pontuacao= rs.getInt("pontuacao_total");

                var ranking= new Ranking(posicao, nome, email, pontuacao);
                rankingFinal.add(ranking);
            }
            return rankingFinal;
        }
    }
}

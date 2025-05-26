package pi_1sem.persistencia.ranking;

import pi_1sem.persistencia.ConnectionFactory;

public class RankingDAO {
    public boolean listar() throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "SELECT (codigo de INNerJoin do diego)";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
            var rs= ps.executeQuery();
        ){
            while(rs.next()){
                var posicao= rs.getInt("posicao");
                var nome= rs.getString("nome");
                var pontuacao= rs.getInt("pontuacao");
                // var nivelDificuldade= rs.getString("");
                System.out.printf("\n%s %s %s\n", posicao, nome, pontuacao);
            }
            return true;
        }
    }
}

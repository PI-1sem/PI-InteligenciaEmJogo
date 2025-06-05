package pi_1sem.persistencia.jogo;

import pi_1sem.persistencia.ConnectionFactoryTest;

public class AlternativaDAO {
    public void editarAlternativa(String texto, int idPergunta, int idAlternativa) throws Exception{
        var conectionFactory= new ConnectionFactoryTest();

        var sql= "UPDATE alternativa a JOIN pergunta_alternativa pa USING (id_alternativa) JOIN pergunta p USING (id_pergunta) SET a.texto=? WHERE pa.id_pergunta= ? AND pa.id_alternativa=?";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, texto);
            ps.setInt(2, idPergunta);
            ps.setInt(3, idAlternativa);
            ps.execute();
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
}

package pi_1sem.persistencia.usuarios;

import pi_1sem.modelo.participantes.Usuario;
import pi_1sem.persistencia.ConnectionFactory;

public class UsuarioDAO {
    public Double pegarPontuacao() throws Exception{
        var sql= "SELECT pontuacao FROM usuario WHERE id_usuario=? and nivelAesso=?";
        try(
            var conexao= new ConnectionFactory().obterConexao();
            var ps= conexao.prepareCall(sql);

        ){
            ps.setInt(1, Usuario.usuarioLogado.getId());
            ps.setString(2, Usuario.usuarioLogado.getNivelAcesso());
            try(
                var rs= ps.executeQuery();
             ){
                if (rs.next()){
                    return rs.getDouble("pontuacao");
                }
                else{
                    return null;
                }
            }
        }
    }
    
    public String pegarNome() throws Exception{
        var sql= "SELECT nome FROM usuario WHERE id_usuario=? and nivelAesso=?";
        try(
            var conexao= new ConnectionFactory().obterConexao();
            var ps= conexao.prepareCall(sql);
        ){
            ps.setInt(1, Usuario.usuarioLogado.getId());
            ps.setString(2, Usuario.usuarioLogado.getNivelAcesso());
            try(
                var rs= ps.executeQuery();
             ){
                if (rs.next()){
                    return rs.getString("nome");
                }
                else{
                    return null;
                }
            }
        }
    }

    public void atualizarPontuacao(Double pontuacao) throws Exception{
        var sql= "UPDATE usuario SET pontuacao=? WHERE id_usuario=? and nivelAesso=?";
        try(
            var conexao= new ConnectionFactory().obterConexao();
            var ps= conexao.prepareCall(sql);
        ){
            ps.setDouble(1, pontuacao);
            ps.setInt(2, Usuario.usuarioLogado.getId());
            ps.setString(3, Usuario.usuarioLogado.getNivelAcesso());
            ps.execute();
        }
    }
}

package pi_1sem.persistencia.usuarios;

import javax.swing.JOptionPane;

import pi_1sem.modelo.participantes.Usuario;
import pi_1sem.persistencia.ConnectionFactoryTest;

public class LoginDAO {

    public Usuario existe (Usuario usuario) throws Exception{
        var sql= "SELECT id_usuario, nivel_acesso, pontuacao_total FROM usuario WHERE email=? AND senha=?";
        try(
            var conexao= new ConnectionFactoryTest().obterConexao();
            var ps= conexao.prepareCall(sql);
            
        ){
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            try(
                var rs= ps.executeQuery();
             ){
                if (rs.next()){
                    String nivelAcesso= rs.getString("nivel_acesso");
                    int id= rs.getInt("id_usuario");
                    int pontuacao= rs.getInt("pontuacao_total");

                    var usuarioLogado= Usuario.usuarioLogado;
                    usuarioLogado.setNivelAcesso(nivelAcesso);
                    usuarioLogado.setId(id);
                    usuarioLogado.setPontuacao(pontuacao);
                    
                    return usuarioLogado;
                }
                else{
                    return null;
                }
            }
        }
    }
}

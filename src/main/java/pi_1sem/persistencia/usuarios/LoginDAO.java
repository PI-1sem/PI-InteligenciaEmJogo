package pi_1sem.persistencia.usuarios;

import pi_1sem.modelo.participantes.Usuario;
import pi_1sem.persistencia.ConnectionFactory;

public class LoginDAO {

    public Usuario existe (Usuario usuario) throws Exception{
        var sql= "SELECT email, senha FROM usuarios WHERE login=? AND senha=?";
        try(
            var conexao= new ConnectionFactory().obterConexao();
            var ps= conexao.prepareCall(sql);
            
        ){
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            try(
                var rs= ps.executeQuery();
             ){
                if (rs.next()){
                    String nivelAcesso= rs.getString("nivelAcesso");
                    int id= rs.getInt("id_usuario");

                    var usuarioLogado= Usuario.usuarioLogado;
                    usuarioLogado.setNivelAcesso(nivelAcesso);
                    usuarioLogado.setId(id);
                    
                    return usuarioLogado;
                }
                else{
                    return null;
                }
            }
        }
    }
}

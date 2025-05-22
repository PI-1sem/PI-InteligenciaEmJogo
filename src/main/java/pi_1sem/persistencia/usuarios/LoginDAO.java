package pi_1sem.persistencia.usuarios;

import pi_1sem.classes.participantes.Usuario;
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
                    return new Usuario(nivelAcesso);
                }
                else{
                    return null;
                }
            }
        }
    }
}

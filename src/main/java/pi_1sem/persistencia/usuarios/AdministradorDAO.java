package pi_1sem.persistencia.usuarios;

import java.util.ArrayList;

import pi_1sem.modelo.participantes.Administrador;
import pi_1sem.persistencia.ConnectionFactory;

public class AdministradorDAO {
    public void cadastrar(Administrador administrador) throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "INSERT INTO usuarios(nome, email, senha, nivel_acesso) VALUES(?, ?, ?, administrador)";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getEmail());
            ps.setString(3, administrador.getSenha());
            
            ps.execute();
        }
    }
    
    public void remover(Integer id) throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "DELETE FROM usuarios WHERE id_usuario= ? and nivel_acesso= administrador";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
           ps.setInt(1, id);
           
           ps.execute();
        }

    }

    public void atualizar(Administrador administrador) throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "UPDATE usuarios SET nome= ? email= ? senha= ? WHERE id_usuario= ? and nivel_acesso= administrador";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getEmail());
            ps.setString(3, administrador.getSenha());
            ps.setInt(4, administrador.getId());
            
            ps.execute();
        }
    }

    public ArrayList<Administrador> listar()throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "SELECT (id_usuario, nome, email, senha) FROM usuarios WHERE nivel_acesso= administrador";
        ArrayList<Administrador> administradores= new ArrayList<>();
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
            var rs= ps.executeQuery();
        ){
            while(rs.next()){
                var id= rs.getInt("id_usuario");
                var nome= rs.getString("nome");
                var email= rs.getString("email");
                var senha= rs.getString("senha");

                administradores.add(new Administrador(id, email, senha, nome));
            }
            return administradores;
        }
    }
}
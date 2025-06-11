package pi_1sem.persistencia.usuarios;

import java.util.ArrayList;

import pi_1sem.modelo.participantes.Aluno;
import pi_1sem.persistencia.ConnectionFactoryTest;
import pi_1sem.persistencia.ConnectionFactory;


public class AlunoDAO {
    public void cadastrar(Aluno aluno) throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "INSERT INTO usuario(nome, email, senha, nivel_acesso) VALUES(?, ?, ?, 'aluno')";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getEmail());
            ps.setString(3, aluno.getSenha());
            
            ps.execute();
        }
    }
    public void remover(Integer id)throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "DELETE FROM usuario WHERE id_usuario= ? and nivel_acesso= 'aluno'";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
           ps.setInt(1, id);
           
           ps.execute();
 
        }
    }
    public void atualizarNome(String nome, int id) throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "UPDATE usuario SET nome= ? WHERE id_usuario= ? and nivel_acesso= 'aluno'";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, nome);
            ps.setInt(2, id);
            ps.execute();
        }
    }
    public void atualizarEmail(String email, int id) throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "UPDATE usuario SET email= ? WHERE id_usuario= ? and nivel_acesso= 'aluno'";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, email);
            ps.setInt(2, id);

            ps.execute();
        }
    }
    public void atualizarSenha(String senha, int id) throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "UPDATE usuario SET senha= ? WHERE id_usuario= ? and nivel_acesso= 'aluno'";
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, senha);
            ps.setInt(2, id);

            ps.execute();
        }
    }
    public ArrayList<Aluno> listar() throws Exception{
        var conectionFactory= new ConnectionFactory();
        var sql= "SELECT id_usuario, nome, email, senha FROM usuario WHERE nivel_acesso= 'aluno'";
        ArrayList<Aluno> alunos= new ArrayList<>();
        
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

                alunos.add(new Aluno(id, email, senha, nome));
            }
            return alunos;
        }
    }
}
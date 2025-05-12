package pi_1sem.conexao;

public class AdministradorDAO {
    public boolean cadastrar(Administrador administrador){
        var conectionFactory= new ConectionFactory();
        var sql= "INSERT INTO tb_Administrador(nome, fone, email) VALUES(?, ?, ?)";

        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getEmail());
            ps.setString(3, administrador.getSenha());
            
            ps.execute();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public boolean remover(Administrador administrador){
        var conectionFactory= new ConectionFactory();
        var sql= "DELETE FROM tb_Administrador WHERE cod_Administrador= ?";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
           ps.setInt(1, administrador.getCod());
           
           ps.execute();
           return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public boolean atualizar(Administrador administrador){
        var conectionFactory= new ConectionFactory();
        var sql= "UPDATE tb_Administrador SET nome= ? fone= ? email= ? WHERE cod_Administrador= ? ";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            ps.setString(1, administrador.getNome());
            ps.setString(2, administrador.getEmail());
            ps.setString(3, administrador.getSenha());
            ps.setInt(4, administrador.getCod());
            
            ps.execute();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public boolean listar(){
        var conectionFactory= new ConectionFactory();
        var sql= "SELECT * FROM tb_Administrador";
        
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
            var rs= ps.executeQuery();
        ){
            while(rs.next()){
                var nome= rs.getString("nome");
                var email= rs.getString("fone");
                var senha= rs.getString("email");
                System.out.printf("\n%s %s %s\n", nome, email, senha);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
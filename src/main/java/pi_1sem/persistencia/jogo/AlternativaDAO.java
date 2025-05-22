//package pi_1sem.persistencia.jogo;
//
//import pi_1sem.persistencia.ConnectionFactory;
//
//public class AlternativaDAO {
//    public boolean adicionar(Alternativa alternativa){
//        var conectionFactory= new ConnectionFactory();
//        var sql= "INSERT INTO alternativas(id_pergunta, texto, correta) VALUES(?, ?, ?)";
//
//        try(
//            var conexao= conectionFactory.obterConexao();
//            var ps= conexao.prepareStatement(sql);
//        ){
//            ps.setString(1, alternativa.getEnunciado());
//            ps.setString(2, alternativa.getMateria());
//            ps.setString(3, alternativa.getNivel());
//            
//            ps.execute();
//            return true;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    public boolean remover(Alternativa alternativa){
//        var conectionFactory= new ConnectionFactory();
//        var sql= "DELETE FROM alternativas WHERE id_alternativa= ?";
//        
//        try(
//            var conexao= conectionFactory.obterConexao();
//            var ps= conexao.prepareStatement(sql);
//        ){
//           ps.setInt(1, alternativa.getId());
//           
//           ps.execute();
//           return true;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    public boolean atualizar(Alternativa alternativa){
//        var conectionFactory= new ConnectionFactory();
//        var sql= "UPDATE alternativas SET texto= ? correta= ? WHERE id_alternativa= ? ";
//        
//        try(
//            var conexao= conectionFactory.obterConexao();
//            var ps= conexao.prepareStatement(sql);
//        ){
//            ps.setString(1, alternativa.getTexto());
//            ps.setString(2, alternativa.getMateria());
//            ps.setString(3, alternativa.getNivel());
//            ps.setInt(4, alternativa.getId());
//            
//            ps.execute();
//            return true;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    public boolean listar(){
//        var conectionFactory= new ConnectionFactory();
//        var sql= "SELECT (id_alternativa, texto, materia, nivel) FROM alternativas";
//        
//        try(
//            var conexao= conectionFactory.obterConexao();
//            var ps= conexao.prepareStatement(sql);
//            var rs= ps.executeQuery();
//        ){
//            while(rs.next()){
//                var id= rs.getInt("id");
//                var texto= rs.getString("texto");
//                var materia= rs.getString("materia");
//                var nivel= rs.getString("nivel");
//                System.out.printf("\n%d %s %s %s\n", id, texto, materia, nivel);
//            }
//            return true;
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}

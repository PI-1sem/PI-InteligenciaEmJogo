package pi_1sem.persistencia.jogo;

import java.util.ArrayList;
import java.util.List;

import pi_1sem.modelo.jogo.Materia;
import pi_1sem.persistencia.ConnectionFactoryTest;
import pi_1sem.persistencia.ConnectionFactory;

public class MateriaDAO {
    public List<Materia> listarMaterias() throws Exception{
        var conectionFactory= new ConnectionFactoryTest();
        var sql= "SELECT nome FROM materia";
        var todasMaterias= new ArrayList<Materia>();
        try(
            var conexao= conectionFactory.obterConexao();
            var ps= conexao.prepareStatement(sql);
        ){
            var rs= ps.executeQuery();
            while(rs.next()){
                var nome= rs.getString("nome");

                var materia= new Materia(nome);
                todasMaterias.add(materia);
            }
            return todasMaterias;
        }
    }
    
}

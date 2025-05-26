package pi_1sem.modelo.jogo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Materia {
    private int id;
    private String nome;
     
    public Materia(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Materia{" + "nome=" + nome +'}';
    }
}
package pi_1sem.classes.jogo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Materia {
    private int id;
    private String nome;
     
    public Materia(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + "nome=" + nome +'}';
    }
}
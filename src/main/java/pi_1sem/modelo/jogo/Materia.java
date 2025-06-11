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
    public void atribuiId(){
        switch (this.nome) {
            case "Matemática" -> {
                this.id= 1;
            } 

            case "Química" ->{
                this.id= 2;
            }

            case "Biologia" -> {
                this.id= 3;
            }
        }
    }
    @Override
    public String toString() {
        return "Materia{" + "nome=" + nome +'}';
    }
}
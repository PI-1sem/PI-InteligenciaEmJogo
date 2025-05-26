package pi_1sem.modelo.jogo;

import lombok.Getter;
import lombok.Setter;
// import java.util.*;

@Getter
@Setter
public class Pergunta {
    private int id;
    private String enunciado;
    private Materia materia;
    private String nivel;
    // private List <PerguntaAlternativa> alternativas;
    
    
    public Pergunta(String enunciado, Materia materia, String nivel){
        this.enunciado= enunciado;
        this.materia= materia;
        this.nivel= nivel;
        // alternativas= new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Pergunta{" + "enunciado=" + enunciado + ", materia="+ materia + ", nivel=" + nivel + "}";
    }
    
}
    


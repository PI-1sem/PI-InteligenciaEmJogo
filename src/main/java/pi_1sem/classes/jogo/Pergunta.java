package pi_1sem.classes.jogo;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
public class Pergunta {
    private int id;
    private String enunciado;
    private Materia materia;
    private List <PerguntaAlternativa> alternativa;
    private String nivel;
    
    public Pergunta(String enunciado){
        this.enunciado= enunciado;
        alternativa= new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Pergunta{" + "enunciado=" + enunciado + ", alternativa=" + alternativa + ", nivel" + nivel + "}";
    }
    
}
    


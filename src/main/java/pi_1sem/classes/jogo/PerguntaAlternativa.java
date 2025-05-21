package pi_1sem.classes.jogo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor 
public class PerguntaAlternativa {
    private Pergunta pergunta;
    private Alternativa alternativa;
    private boolean correta;

    @Override
    public String toString() {
        return "PerguntaAlternativa{" + "pergunta=" + pergunta.getEnunciado() + ", alternativa=" + alternativa.getTexto()
         + ", correta=" + correta + '}';
    }
    
    
}



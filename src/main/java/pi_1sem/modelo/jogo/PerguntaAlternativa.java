package pi_1sem.modelo.jogo;

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
        return "PerguntaAlternativa{" + "id_pergunta=" + pergunta.getId() + ", pergunta=" + pergunta.getEnunciado() + ", nivel="+ pergunta.getNivel() + ", letra=" + alternativa.getLetra() + ", alternativa=" + alternativa.getTexto()
         + ", correta=" + correta + '}';
    }
    
    
    
}



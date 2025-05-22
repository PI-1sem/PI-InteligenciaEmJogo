package pi_1sem.classes.jogo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alternativa {
    private String texto;
    private boolean correta;
    
    public Alternativa(String texto, boolean correta){
        this.texto= texto;
        this.correta = correta;
    }

    @Override
    public String toString() {
        return "Alternativa{" + "texto=" + texto + "correta=" + correta + '}';
    }
    
}

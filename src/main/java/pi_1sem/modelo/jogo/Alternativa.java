package pi_1sem.modelo.jogo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alternativa {
    private int id;
    private String texto;
    private String letra;
    
    public Alternativa(String letra, String texto){
        this.letra= letra;
        this.texto= texto;
    }
    public Alternativa(int id, String letra, String texto){
        this.id= id;
        this.letra= letra;
        this.texto= texto;
    }

    @Override
    public String toString() {
        return "Alternativa{" + "id="+ id + "letra=" + letra + ", texto=" + texto +'}';
    }
    
}

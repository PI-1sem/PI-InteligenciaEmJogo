package pi_1sem.classes.jogo;

import pi_1sem.classes.participantes.Usuario;
import lombok.Getter;
@Getter
public class Partida {
    private int id; 
    private Usuario usuario;
    private Materia materia; 
    private int acertos;
     
    public Partida(int id, Usuario usuario, Materia materia, int acertos){
        this.id= id;
        this.usuario = usuario;
        this.materia = materia;
        this.acertos = acertos;
    }

    @Override
    public String toString() {
        return "Partida{" + "id=" + id + ", usuario=" + usuario + ", materia" + materia + ", acertos" + acertos + "}";
    }
}

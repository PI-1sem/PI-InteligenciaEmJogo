package pi_1sem.modelo.jogo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
@Getter
public class Partida {
    private int id; 
    private Materia materia; 
    private int posicao;
    private int pontuacaoPartida;
    private int pontuacaoUltimaRodada;
    private int pontuacaoSeguro;
    private Object[] opcoesDicas = {"Pular pergunta", "Eliminação por sorte"};
    private List<Integer> perguntasSorteadas;

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public void setOpcoesDicas(Object[] opcoesDicas) {
        this.opcoesDicas = opcoesDicas;
    }
    public void setPontuacaoPartida(int pontuacaoPartida) {
        this.pontuacaoPartida = pontuacaoPartida;
    }

    public void setPontuacaoSeguro(int pontuacaoSeguro) {
        this.pontuacaoSeguro = pontuacaoSeguro;
    }

    public void setPontuacaoUltimaRodada(int pontuacaoUltimaRodada) {
        this.pontuacaoUltimaRodada = pontuacaoUltimaRodada;
    }
     
    public Partida(Materia materia){
        this.materia = materia;
        this.posicao= 1;
        this.pontuacaoPartida = 0;
        this.pontuacaoUltimaRodada = 0;
        this.pontuacaoSeguro = 0;
        this.perguntasSorteadas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Partida{" + "materia" + materia + ", posicao" + posicao + "}";
    }
}

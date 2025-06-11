package pi_1sem.modelo.jogo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ranking {
    private int posicao;
    private String nome;
    private String email;
    private int pontuacao;

    public Ranking(int posicao, String nome, String email, int pontuacao) {
        this.posicao = posicao;
        this.nome = nome;
        this.email = email;
        this.pontuacao = pontuacao;
    }
}

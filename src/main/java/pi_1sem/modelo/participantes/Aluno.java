package pi_1sem.modelo.participantes;

public class Aluno extends Usuario{
    public Aluno(String nome, String email, String senha){
        super(nome, email, senha, "aluno");
    }
    public Aluno(int id, String email, String senha, String nome){
        super(id, email, senha, nome);
    }
}
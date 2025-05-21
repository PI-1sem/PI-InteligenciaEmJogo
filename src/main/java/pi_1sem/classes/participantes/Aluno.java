package pi_1sem.classes.participantes;

public class Aluno extends Usuario{
    public Aluno(String email, String senha, String nome){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.nivelAcesso = "aluno";
    }
    public Aluno(int id, String email, String senha, String nome){
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }
}
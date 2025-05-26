package pi_1sem.modelo.participantes;

public class Aluno extends Usuario{
    public Aluno(String email, String senha, String nome){
        super(nome, email, senha, "aluno");
        // this.email = email;
        // this.senha = senha;
        // this.nome = nome;
        // this.nivelAcesso = "aluno";
    }
    public Aluno(int id, String email, String senha, String nome){
        super(id, email, senha, nome);
        // this.id = id;
        // this.email = email;
        // this.senha = senha;
        // this.nome = nome;
    }
}
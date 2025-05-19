package pi_1sem.classes.participantes;

public class Aluno extends Usuario{
    Aluno(String email, String senha, String nome){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.nivelAcesso = "aluno";
    }
    
}
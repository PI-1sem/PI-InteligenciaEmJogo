package pi_1sem.classes.participantes;

public class Administrador extends Usuario{
    Administrador(String email, String senha, String nome){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.nivelAcesso = "administrador";
    }
    
}
    


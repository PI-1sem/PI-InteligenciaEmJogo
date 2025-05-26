package pi_1sem.modelo.participantes;

public class Administrador extends Usuario{
    public Administrador(String email, String senha, String nome){
        super(nome, email, senha, "administrador");
        // this.email = email;
        // this.senha = senha;
        // this.nome = nome;
        // this.nivelAcesso = "administrador";
    }

    public Administrador(int id, String email, String senha, String nome){
        super(id, email, senha, nome);
        // this.id = id;
        // this.email = email;
        // this.senha = senha;
        // this.nome = nome;
    }
    
}
    


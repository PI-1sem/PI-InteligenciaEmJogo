package pi_1sem.modelo.participantes;

public class Administrador extends Usuario{
    public Administrador(String nome, String email, String senha){
        super(nome, email, senha, "administrador");
    }

    public Administrador(int id, String email, String senha, String nome){
        super(id, email, senha, nome);
    }
    
}
    


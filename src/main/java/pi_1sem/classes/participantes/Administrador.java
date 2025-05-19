package pi_1sem.classes.participantes;
import lombok.Getter;
@Getter
public class Administrador extends Usuario{
    Administrador(String email, String senha, String nome){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }
    
}
    


package pi_1sem.modelo.participantes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario{
   private String email;
   private String senha;
   private String nome;
   private String nivelAcesso;
   private int pontuacao;
   private int id;
   public static Usuario usuarioLogado= new Usuario();

     private Usuario(){          
     }
     protected Usuario(String nome, String email, String senha, String nivelAcesso){
          this.nome = nome;
          this.email = email;
          this.senha = senha;
          this.nivelAcesso = nivelAcesso;
     }
     protected Usuario(int id, String email, String senha, String nome){
          this.id = id;
          this.email = email;
          this.senha = senha;
          this.nome = nome;
     }

     public Usuario(String email, String senha) {
          this.email = email;
          this.senha = senha;
    }
     public Usuario(String nivelAcesso, int id){
          this.nivelAcesso = nivelAcesso;
          this.id = id;
    }

     void setSenha(String senha){
          this.senha = senha;
   }
}

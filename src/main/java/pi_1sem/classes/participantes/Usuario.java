package pi_1sem.classes.participantes;

import lombok.Getter;

@Getter
 abstract public class Usuario{
   protected String email;
   protected String senha;
   protected String nome;
   protected String nivelAcesso;
   protected int pontuacao;
   protected int id;

   void setSenha(String senha){
        this.senha = senha;
        
   }
   

}

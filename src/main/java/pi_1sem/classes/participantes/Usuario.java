package pi_1sem.classes.participantes;


 abstract public class Usuario{
   protected String email;
   protected String senha;
   protected String nome;  
   protected int pontuacao;
   protected int id;

   void setSenha(String senha){
        this.senha = senha;
        
   }
   

}

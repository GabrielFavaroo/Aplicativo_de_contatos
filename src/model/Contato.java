package model;

public class Contato {
    public void setNome(String nome) {
        Nome = nome;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Nome;
private String Telefone;
private String Email;


public Contato(String Nome, String Telefone, String Email){
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;

}


public String getNome(){return Nome;}
public String getTelefone(){return Telefone;}
public String getEmail(){return Email;}

@Override
public String toString(){
        return "Nome: "+ Nome + "Telefone: " + Telefone + "Email: " + Email;

}
}

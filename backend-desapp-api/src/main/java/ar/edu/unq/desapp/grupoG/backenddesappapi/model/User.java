package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

public class User {

    private int idUser;
    private String name;
    private String surname;
    private String nick;
    private String password;
    private String email;

    public User(int idUser, String name, String surname, String nick, String password, String email){
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.password = password;
        this.email = email;
    }

    public int getIdUser(){ return this.idUser; }

    public String getName(){ return this.name; }

    public String getSurname(){
        return this.surname;
    }

    public String getNick(){
        return this.nick;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword() { return this.password; }

}

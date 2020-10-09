package ar.edu.unq.desapp.grupoG.backenddesappapi.controller;

public class UserStats {

    private String name;
    private String surname;
    private String nick;
    private String password;
    private String email;

    public UserStats(String name, String surname, String nick, String password, String email){
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import javax.persistence.*;

@Entity
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReward;

    @Transient
    private User user;

    @Column
    private String description;

    @Column
    private String code;

    @Column
    private int points;

    public Reward(){

    }

    public Reward(Integer idReward, User user, String description, String code, int points){
        this.idReward = idReward;
        this.user = user;
        this.description = description;
        this.code = code;
        this.points = points;
    }

    public Reward(User user, String description, String code, int points){
        this.user = user;
        this.description = description;
        this.code = code;
        this.points = points;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Integer getIdReward() {
        return idReward;
    }

    public User getIdUser() {
        return user;
    }
}

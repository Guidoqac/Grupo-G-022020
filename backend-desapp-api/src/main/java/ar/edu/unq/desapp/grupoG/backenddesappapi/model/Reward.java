package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

public class Reward {

    private Integer idReward;

    private Integer idUser;

    private String description;

    private String code;

    private int points;

    public Reward(Integer idReward, Integer idUser, String description, String code, int points){
        this.idReward = idReward;
        this.idUser = idUser;
        this.description = description;
        this.code = code;
        this.points = points;
    }

    public Reward(Integer idUser, String description, String code, int points){
        this.idUser = idUser;
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

    public Integer getIdUser() {
        return idUser;
    }
}

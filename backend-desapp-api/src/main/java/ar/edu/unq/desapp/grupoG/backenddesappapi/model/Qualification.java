package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

public class Qualification {

    private int idQualification;
    private int idUser;
    private int idLocation;
    private int idDonation;
    private int score;
    private String comment;

    public Qualification(int idQualification, int idUser, int idLocation, int idDonation, int score, String comment){
        this.idQualification = idQualification;
        this.idUser = idUser;
        this.idLocation = idLocation;
        this.idDonation = idDonation;
        this.score = score;
        this.comment = comment;
    }
    
    public Qualification(int idUser, int idLocation, int idDonation, int score, String comment){
        this.idUser = idUser;
        this.idLocation = idLocation;
        this.idDonation = idDonation;
        this.score = score;
        this.comment = comment;
    }
    
    public int getIdQualification(){ return this.idQualification; }

    public int getIdUser(){ return this.idUser; }

    public int getIdLocation(){ return this.idLocation; }

    public int getIdDonation(){ return this.idDonation; }

    public int getScore(){ return this.score; }

    public String getComment(){ return this.comment; }
}

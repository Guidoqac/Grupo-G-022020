package ar.edu.unq.desapp.grupoG.backenddesappapi.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProject;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    @Column
    private int factor;

    @Column
    private Double minPercentProjectClosure;

    @Column
    private String projectFantasyName;

    @Column
    private LocalDate closeProjectDate;

    @Column
    private LocalDate startProjectDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Donation> donations;

    @Column
    private LocalDate lastDonationDate;

    @Column
    private boolean isClosed;

    @Column
    private int participants;

    @Column
    private int budgetCollected;

    @Column
    private double percentCollected;

    public Project(){

    }

    public Project(Location location, Double minPercentProjectClosure, String projectFantasyName, LocalDate closeProjectDate, LocalDate startProjectDate) {
        this.location = location;
        this.factor = 1000;
        this.minPercentProjectClosure = minPercentProjectClosure;
        this.projectFantasyName = projectFantasyName;
        this.closeProjectDate = closeProjectDate;
        this.startProjectDate = startProjectDate;
        this.donations = new ArrayList<Donation>();
        this.isClosed = false;
        this.participants = 0;
        this.budgetCollected = 0;
        this.percentCollected = 0.0;
    }

    public Project(int idProject, Location location, int factor, Double minPercentProjectClosure, String projectFantasyName, LocalDate closeProjectDate, LocalDate startProjectDate) {
        this.idProject = idProject;
        this.location = location;
        this.factor = factor;
        this.minPercentProjectClosure = minPercentProjectClosure;
        this.projectFantasyName = projectFantasyName;
        this.closeProjectDate = closeProjectDate;
        this.startProjectDate = startProjectDate;
        this.lastDonationDate = startProjectDate;
        this.donations = new ArrayList<Donation>();
        this.isClosed = false;
        this.participants = 0;
        this.budgetCollected = 0;
        this.percentCollected = 0.0;
    }

    /* constructor para el factor por default */
    public Project(int idProject, Location location, Double minPercentProjectClosure, String projectFantasyName, LocalDate closeProjectDate, LocalDate startProjectDate) {
        this.idProject = idProject;
        this.location = location;
        this.factor = 1000;
        this.minPercentProjectClosure = minPercentProjectClosure;
        this.projectFantasyName = projectFantasyName;
        this.closeProjectDate = closeProjectDate;
        this.startProjectDate = startProjectDate;
        this.donations = new ArrayList<Donation>();
        this.isClosed = false;
    }

    public int getIdProject() {
        return this.idProject;
    }

    public Location getLocation() {
        return this.location;
    }

    public int getFactor() {
        return this.factor;
    }

    public Double getMinPercentProjectClosure() {
        return this.minPercentProjectClosure;
    }

    public String getProjectFantasyName() {
        return this.projectFantasyName;
    }

    public LocalDate getCloseProjectDate() {
        return this.closeProjectDate;
    }

    public LocalDate getStartProjectDate() {
        return this.startProjectDate;
    }

    public double calculateBudget() {
        int population = this.location.getPopulation();
        int budget = population * this.factor;
        return budget;
    }

    public double calculateMinPercentage(){
        return this.calculateBudget() * this.minPercentProjectClosure / 100;
    }

    public boolean isMinimumCollected(){
		double collected = this.donations.stream().mapToDouble(d -> d.getAmount()).sum();
        return collected >= this.calculateMinPercentage();
    }

    public double actualBudgetCollected(){
        return this.donations.stream().mapToDouble(d -> d.getAmount()).sum();
    }

    public List<Donation> getDonations(){
        return this.donations;
    }

    public void setDonations(ArrayList<Donation> donations){
        this.donations = donations;
    }

    public boolean isOpen(){
        return this.isClosed;
    }

    public void closeProject(){
        this.isClosed = true;
    }

    public void addDonation(Donation donation){
        if(!this.alreadyDonateInAnyMonth(donation.getIdUser())){
            this.participants += 1;
        }
        this.donations.add(donation);
        this.budgetCollected += donation.getAmount();
        this.percentCollected = this.budgetCollected * 100 / this.calculateBudget();
    }

    public LocalDate getLastDonationDate(){
        return this.lastDonationDate;
    }

    public void setLastDonationDate(LocalDate ld){
        this.lastDonationDate = ld;
    }

    public boolean alreadyDonate(int idUser) {
    	boolean donate = false;
    	Iterator<Donation> iteratorDonations = donations.iterator();
    	
    	while (iteratorDonations.hasNext() && !donate) {
    		Donation donation = (Donation) iteratorDonations.next();
    		//SI es el mismo user y SI la donacion tiene como mes el actual
    		//entonces ya se realizo una donacion en el mismo mes de dicho usuario
    		if (donation.getIdUser() == idUser && ( donation.getDonationDate().getMonth() == LocalDate.now().getMonth()) ) {
    			donate = true;
    		}
    	}
    	return donate;
    }

    public boolean alreadyDonateInAnyMonth(int idUser){
        return this.donations.stream().anyMatch(d -> d.getIdUser() == idUser);
    }

    public boolean isClosed() {
        return isClosed;
    }

    public int getParticipants() {
        return participants;
    }

    public int getBudgetCollected() {
        return budgetCollected;
    }

    public double getPercentCollected() {
        return percentCollected;
    }
}

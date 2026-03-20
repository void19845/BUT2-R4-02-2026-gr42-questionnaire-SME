package universite_Paris8.iut.gr42.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Objet métier : QuestionnaireDTO
 */
public class QuestionnaireDTO {

    private int identifiant;
    private String libelle;
    private boolean charge;
    private List<QuestionDTO> questions;
    private long temps; // Temps en millisecondes pour compléter le questionnaire

    public QuestionnaireDTO() {
        this.questions = new ArrayList<>();
        this.charge = false;
    }

    public QuestionnaireDTO(int identifiant, String libelle, long temps) {
        this.identifiant = identifiant;
        this.libelle = libelle;
        this.temps = temps;
        this.questions = new ArrayList<>();
        this.charge = false;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public long getTemps() {
        return temps;
    }

    public void setTemps(long temps) {
        this.temps = temps;
    }

    public void ajouterQuestion(QuestionDTO question) {
        this.questions.add(question);
    }

    public int getNombreQuestions() {
        return this.questions.size();
    }

    @Override
    public String toString() {
        return "QuestionnaireDTO{" +
                "identifiant=" + identifiant +
                ", libelle='" + libelle + '\'' +
                ", charge=" + charge +
                ", questionsCount=" + getNombreQuestions() +
                ", temps=" + temps +
                '}';
    }
}

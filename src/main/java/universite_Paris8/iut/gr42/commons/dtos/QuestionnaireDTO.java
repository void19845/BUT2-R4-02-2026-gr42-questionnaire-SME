package universite_paris8.iut.commons.dtos;

import java.util.List;

public class QuestionnaireDTO {
    private String identifiant;
    private String libelle;
    private List<QuestionDTO> questions;
    private long temps;

    public QuestionnaireDTO() {}

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
}

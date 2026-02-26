package universite_paris8.iut.commons.dtos;

import java.util.List;
import universite_paris8.iut.commons.enums.Difficulte;
import universite_paris8.iut.commons.enums.Langue;

public class QuestionDTO {
    private int numero;
    private Langue langue;
    private String texte;
    private List<PropositionDTO> propositions;
    private Difficulte difficulte;
    private int score;
    private String explication;
    private String reference;

    public QuestionDTO() {}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public List<PropositionDTO> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<PropositionDTO> propositions) {
        this.propositions = propositions;
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getExplication() {
        return explication;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}

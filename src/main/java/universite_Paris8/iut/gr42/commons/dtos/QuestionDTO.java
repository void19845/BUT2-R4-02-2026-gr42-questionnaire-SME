package universite_paris8.iut.commons.dtos;

import java.util.List;

public class QuestionDTO {
    private int numero;
    private String langue;
    private String texte;
    private List<PropositionDTO> propositions;
    private int difficulte;
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

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
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

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
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

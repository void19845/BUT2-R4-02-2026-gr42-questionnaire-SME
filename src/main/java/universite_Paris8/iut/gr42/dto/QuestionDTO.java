package universite_Paris8.iut.gr42.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Objet métier : QuestionDTO
 */
public class QuestionDTO {

    private int numero;
    private String langue;
    private String texte;
    private String reponse;
    private int difficulte; // 1: Simple, 2: Intermédiaire, 3: Expert
    private String explication;
    private String reference;
    private List<PropositionDTO> propositions;

    public QuestionDTO(int numero, String langue, String texte, String reponse, int difficulte, String explication,
            String reference) {
        this.numero = numero;
        this.langue = langue;
        this.texte = texte;
        this.reponse = reponse;
        this.difficulte = difficulte;
        this.explication = explication;
        this.reference = reference;
        this.propositions = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getLangue() {
        return langue;
    }

    public String getTexte() {
        return texte;
    }

    public String getReponse() {
        return reponse;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public String getExplication() {
        return explication;
    }

    public String getReference() {
        return reference;
    }

    public List<PropositionDTO> getPropositionDTOs() {
        return propositions;
    }

    public void ajouterPropositionDTO(PropositionDTO proposition) {
        this.propositions.add(proposition);
    }

    public int getScore() {
        return (this.difficulte == 3) ? 2 : 1;
    }

    public String getDifficulteLibelle() {
        switch (this.difficulte) {
            case 1:
                return "Simple";
            case 2:
                return "Intermédiaire";
            case 3:
                return "Expert";
            default:
                return "Inconnu";
        }
    }

    /**
     * Vérifie si la réponse fournie est correcte (insensible à la casse et sans
     * espaces superflus).
     *
     * @param reponseUtilisateur la réponse donnée par l'utilisateur
     * @return vrai si la réponse est correcte
     */
    public boolean verifierReponse(String reponseUtilisateur) {
        if (reponseUtilisateur == null || this.reponse == null) {
            return false;
        }
        return this.reponse.trim().equalsIgnoreCase(reponseUtilisateur.trim());
    }

    public void afficherTexte() {
        System.out.println("--- Question " + this.numero + " (" + this.getDifficulteLibelle() + ") ---");
        System.out.println("Texte : " + this.texte);
    }

    public void afficherReponse() {
        System.out.println("Réponse : " + this.reponse);
    }

    public void afficherExplication() {
        System.out.println("Explication : " + this.explication);
    }

    public void afficherReference() {
        if (this.reference != null && !this.reference.trim().isEmpty()) {
            System.out.println("Référence : " + this.reference);
        }
    }

    public void afficherQuestion() {
        this.afficherTexte();
        this.afficherReponse();
        this.afficherExplication();
        this.afficherReference();
        if (this.propositions != null && !this.propositions.isEmpty()) {
            System.out.println("Propositions :");
            for (PropositionDTO p : this.propositions) {
                System.out.println("  - " + p.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "numero=" + numero +
                ", texte='" + texte + '\'' +
                ", difficulte=" + getDifficulteLibelle() +
                '}';
    }
}

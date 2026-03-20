package universite_Paris8.iut.gr42.dto;

/**
 * Objet métier : PropositionDTO
 */
public class PropositionDTO {

    private String texte;
    private boolean estCorrecte;

    public PropositionDTO(String texte, boolean estCorrecte) {
        this.texte = texte;
        this.estCorrecte = estCorrecte;
    }

    public String getTexte() {
        return texte;
    }

    public boolean isEstCorrecte() {
        return estCorrecte;
    }

    @Override
    public String toString() {
        return "PropositionDTO{" +
                "texte='" + texte + '\'' +
                ", " + (estCorrecte ? "correcte" : "fausse") +
                '}';
    }
}

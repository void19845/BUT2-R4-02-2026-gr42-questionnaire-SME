package universite_Paris8.iut.gr42.dto;

/**
 * Objet métier : Proposition
 */
public class Proposition {

    private String texte;
    private boolean estCorrecte;

    public Proposition(String texte, boolean estCorrecte) {
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
        return "Proposition{" +
                "texte='" + texte + '\'' +
                ", " + (estCorrecte ? "correcte" : "fausse") +
                '}';
    }
}

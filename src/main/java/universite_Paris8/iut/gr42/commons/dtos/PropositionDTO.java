package universite_paris8.iut.commons.dtos;

public class PropositionDTO {
    private String texte;
    private boolean estCorrecte;

    public PropositionDTO() {}

    public PropositionDTO(String texte, boolean estCorrecte) {
        this.texte = texte;
        this.estCorrecte = estCorrecte;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public boolean isEstCorrecte() {
        return estCorrecte;
    }

    public void setEstCorrecte(boolean estCorrecte) {
        this.estCorrecte = estCorrecte;
    }
}

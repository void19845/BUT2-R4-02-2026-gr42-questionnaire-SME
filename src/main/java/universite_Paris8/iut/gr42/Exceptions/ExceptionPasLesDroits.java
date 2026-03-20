package universite_Paris8.iut.gr42.Exceptions;

/**
 * Exception levée lorsque l'application n'a pas les droits pour lire le fichier CSV.
 */
public class ExceptionPasLesDroits extends Exception {
    public ExceptionPasLesDroits(String message) {
        super(message);
    }
}

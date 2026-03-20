package universite_Paris8.iut.gr42.Exceptions;

/**
 * Exception levée lorsque le format du fichier CSV est incorrect (ex: mauvaise nombre de colonnes).
 */
public class ExceptionFormatIncorrect extends Exception {
    public ExceptionFormatIncorrect(String message) {
        super(message);
    }
}

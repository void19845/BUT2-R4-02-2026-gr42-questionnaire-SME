package universite_Paris8.iut.gr42.Exceptions;

/**
 * Exception levée lorsque le fichier CSV du questionnaire n'est pas trouvé.
 */
public class ExceptionFichierNonTrouve extends Exception {
    public ExceptionFichierNonTrouve(String message) {
        super(message);
    }
}

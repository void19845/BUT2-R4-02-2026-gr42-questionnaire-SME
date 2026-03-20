package universite_Paris8.iut.gr42.Exceptions;

/**
 * Exception levée en cas d'erreur de lecture du fichier CSV (IOException).
 */
public class ExceptionErreurLecture extends Exception {
    public ExceptionErreurLecture(String message) {
        super(message);
    }
    
    public ExceptionErreurLecture(String message, Throwable cause) {
        super(message, cause);
    }
}

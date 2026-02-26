package universite_paris8.iut.services.interfaces;

import universite_paris8.iut.commons.dtos.QuestionnaireDTO;
import universite_paris8.iut.utils.exceptions.*;

public interface IQuestionnaireService {
    
    /**
     * Vérifie l'existence d'un questionnaire et le charge.
     * 
     * @param id L'identifiant du questionnaire (ou chemin du fichier CSV)
     * @return Le QuestionnaireDTO chargé
     * @throws FichierNonTrouveException Si le fichier est introuvable
     * @throws FormatIncorrectException Si le format des données est incorrect
     * @throws PasLesDroitsException Si les droits d'accès sont insuffisants
     * @throws ErreurLectureException Si une erreur survient lors de la lecture (Timeout/IO)
     */
    QuestionnaireDTO chargerQuestionnaire(String id) throws 
        FichierNonTrouveException, 
        FormatIncorrectException, 
        PasLesDroitsException, 
        ErreurLectureException;

    /**
     * Vérifie si le fichier existe pour un identifiant donné.
     * @param id L'identifiant
     * @throws FichierNonTrouveException
     */
    void verifierExistence(String id) throws FichierNonTrouveException;

    /**
     * Vérifie les droits d'accès en lecture.
     * @throws PasLesDroitsException
     */
    void verifierDroitsAcces() throws PasLesDroitsException;
}

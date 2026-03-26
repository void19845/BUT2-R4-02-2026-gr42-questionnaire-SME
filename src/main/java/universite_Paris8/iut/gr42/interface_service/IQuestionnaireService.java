package universite_Paris8.iut.gr42.interface_service;

import universite_Paris8.iut.gr42.Exceptions.*;
import universite_Paris8.iut.gr42.dto.QuestionnaireDTO;

/**
 * Interface définissant les services liés aux questionnaires.
 */
public interface IQuestionnaireService {

    /**
     * Charge un questionnaire à partir d'un fichier CSV.
     * 
     * @param fichier Le chemin vers le fichier CSV.
     * @return L'objet Questionnaire contenant les questions chargées.
     * @throws ExceptionFichierNonTrouve Si le fichier n'existe pas.
     * @throws ExceptionPasLesDroits     Si les droits de lecture sont manquants.
     * @throws ExceptionFormatIncorrect  Si le format CSV est invalide.
     * @throws ExceptionErreurLecture    Si une erreur d'entrée/sortie survient.
     */
    QuestionnaireDTO chargerQuestionnaire(String fichier) 
            throws ExceptionFichierNonTrouve, ExceptionPasLesDroits, ExceptionFormatIncorrect, ExceptionErreurLecture;

    /**
     * Affiche les questions d'un questionnaire donné.
     * 
     * @param questionnaire Le questionnaire dont on souhaite afficher les questions.
     */
    void afficherQuestions(QuestionnaireDTO questionnaire);
}

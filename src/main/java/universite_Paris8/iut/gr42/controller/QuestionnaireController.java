package universite_Paris8.iut.gr42.controller;

import universite_Paris8.iut.gr42.Exceptions.*;
import universite_Paris8.iut.gr42.dto.QuestionnaireDTO;
import universite_Paris8.iut.gr42.interface_service.IQuestionnaireService;
import universite_Paris8.iut.gr42.services.QuestionnaireService;

/**
 * Contrôleur responsable de la gestion du chargement du questionnaire.
 */
public class QuestionnaireController {

    private final IQuestionnaireService questionnaireService;

    public QuestionnaireController() {
        this.questionnaireService = new QuestionnaireService();
    }

    /**
     * Tente de charger un questionnaire depuis un fichier et gère les erreurs potentielles.
     *
     * @param fichier Le chemin vers le fichier CSV.
     * @return L'objet Questionnaire s'il est chargé avec succès, null sinon.
     */
    public QuestionnaireDTO chargerEtValiderQuestionnaire(String fichier) {
        try {
            QuestionnaireDTO questionnaire = questionnaireService.chargerQuestionnaire(fichier);
            System.out.println("Chargement du questionnaire " + questionnaire.getIdentifiant() + " de " + 
                               questionnaire.getNombreQuestions() + " questions... OK");
            return questionnaire;
        } catch (ExceptionFichierNonTrouve e) {
            System.err.println("Erreur : Le fichier CSV est introuvable. Veuillez contacter le service client. (" + e.getMessage() + ")");
        } catch (ExceptionPasLesDroits e) {
            System.err.println("Erreur : Vous n'avez pas les droits de lecture sur le fichier CSV. (" + e.getMessage() + ")");
        } catch (ExceptionFormatIncorrect e) {
            System.err.println("Erreur : Le format du fichier CSV est incorrect ou corrompu. Veuillez contacter le service client. (" + e.getMessage() + ")");
        } catch (ExceptionErreurLecture e) {
            System.err.println("Erreur : Un problème est survenu lors de la lecture du fichier CSV. (" + e.getMessage() + ")");
        }
        return null;
    }
}

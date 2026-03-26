package universite_Paris8.iut.gr42.mock;

import universite_Paris8.iut.gr42.Exceptions.*;
import universite_Paris8.iut.gr42.dto.QuestionDTO;
import universite_Paris8.iut.gr42.dto.QuestionnaireDTO;
import universite_Paris8.iut.gr42.interface_service.IQuestionnaireService;

import static org.mockito.Mockito.*;

/**
 * Mock simulant le cas nominal : fichier CSV valide.
 * chargerQuestionnaire retourne un QuestionnaireDTO avec 2 questions chargées.
 */
public class chargerQuestionnaireOKMock {

    public static final String FICHIER = "questionnaire.csv";

    public static IQuestionnaireService creer() throws Exception {
        IQuestionnaireService mock = mock(IQuestionnaireService.class);

        QuestionDTO q1 = new QuestionDTO(
                1, "fr", "Qu'est-ce qu'une classe ?",
                "Un modèle d'objet", 2, "Une classe définit un objet", "JavaDoc");
        QuestionDTO q2 = new QuestionDTO(
                2, "fr", "Qu'est-ce qu'un objet ?",
                "Instance de classe", 1, "Un objet est une instance", "JavaDoc");

        QuestionnaireDTO questionnaire = new QuestionnaireDTO();
        questionnaire.setIdentifiant(1);
        questionnaire.setLibelle("Java Basics");
        questionnaire.ajouterQuestion(q1);
        questionnaire.ajouterQuestion(q2);
        questionnaire.setCharge(true);

        when(mock.chargerQuestionnaire(FICHIER))
                .thenReturn(questionnaire);

        return mock;
    }
}

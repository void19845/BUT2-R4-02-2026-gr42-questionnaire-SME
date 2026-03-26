package universite_Paris8.iut.gr42.mock;

import universite_Paris8.iut.gr42.Exceptions.*;
import universite_Paris8.iut.gr42.dto.QuestionnaireDTO;
import universite_Paris8.iut.gr42.interface_service.IQuestionnaireService;

import static org.mockito.Mockito.*;

/**
 * Mock simulant le cas où le fichier CSV existe mais n'est pas lisible.
 * chargerQuestionnaire lève ExceptionPasLesDroits.
 */
public class chargerQuestionnaireKOPasLesDroitsMock {

    public static final String FICHIER = "interdit.csv";

    public static IQuestionnaireService creer() throws Exception {
        IQuestionnaireService mock = mock(IQuestionnaireService.class);

        when(mock.chargerQuestionnaire(FICHIER))
                .thenThrow(new ExceptionPasLesDroits(
                        "Lecture non autorisée pour le fichier '" + FICHIER + "'."));

        return mock;
    }
}

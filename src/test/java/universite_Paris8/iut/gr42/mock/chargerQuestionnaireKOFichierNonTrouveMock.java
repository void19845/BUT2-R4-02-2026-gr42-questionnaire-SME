package universite_Paris8.iut.gr42.mock;

import universite_Paris8.iut.gr42.Exceptions.*;
import universite_Paris8.iut.gr42.dto.QuestionnaireDTO;
import universite_Paris8.iut.gr42.interface_service.IQuestionnaireService;

import static org.mockito.Mockito.*;

/**
 * Mock simulant le cas où le fichier CSV est introuvable.
 * chargerQuestionnaire lève ExceptionFichierNonTrouve.
 */
public class chargerQuestionnaireKOFichierNonTrouveMock {

    public static final String FICHIER = "inexistant.csv";

    public static IQuestionnaireService creer() throws Exception {
        IQuestionnaireService mock = mock(IQuestionnaireService.class);

        when(mock.chargerQuestionnaire(FICHIER))
                .thenThrow(new ExceptionFichierNonTrouve(
                        "Le fichier CSV '" + FICHIER + "' est introuvable."));

        return mock;
    }
}

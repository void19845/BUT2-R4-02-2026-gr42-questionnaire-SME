package universite_Paris8.iut.gr42.mock;

import universite_Paris8.iut.gr42.Exceptions.*;
import universite_Paris8.iut.gr42.dto.QuestionnaireDTO;
import universite_Paris8.iut.gr42.interface_service.IQuestionnaireService;

import static org.mockito.Mockito.*;

/**
 * Mock simulant le cas où une erreur d'entrée/sortie survient pendant la lecture.
 * chargerQuestionnaire lève ExceptionErreurLecture.
 */
public class chargerQuestionnaireKOErreurLectureMock {

    public static final String FICHIER = "illisible.csv";

    public static IQuestionnaireService creer() throws Exception {
        IQuestionnaireService mock = mock(IQuestionnaireService.class);

        when(mock.chargerQuestionnaire(FICHIER))
                .thenThrow(new ExceptionErreurLecture(
                        "Erreur lors de la lecture du fichier CSV.",
                        new Exception("Flux interrompu")));

        return mock;
    }
}

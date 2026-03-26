package universite_Paris8.iut.gr42.mock;

import universite_Paris8.iut.gr42.Exceptions.*;
import universite_Paris8.iut.gr42.interface_service.IQuestionnaireService;

import static org.mockito.Mockito.*;

/**
 * Mock simulant le cas où le fichier CSV est mal formaté.
 * Couvre les variantes : 0 colonne, 8 colonnes, 20 colonnes avec champ non numérique.
 * chargerQuestionnaire lève ExceptionFormatIncorrect dans tous les cas.
 */
public class chargerQuestionnaireKOFormatIncorrectMock {

    public static final String FICHIER_0_COLONNES  = "format_vide.csv";
    public static final String FICHIER_8_COLONNES  = "format_8col.csv";
    public static final String FICHIER_20_COLONNES = "format_20col.csv";

    public static IQuestionnaireService creer() throws Exception {
        IQuestionnaireService mock = mock(IQuestionnaireService.class);

        when(mock.chargerQuestionnaire(FICHIER_0_COLONNES))
                .thenThrow(new ExceptionFormatIncorrect(
                        "Le fichier CSV doit contenir au moins 9 colonnes séparées par des points-virgules."));

        when(mock.chargerQuestionnaire(FICHIER_8_COLONNES))
                .thenThrow(new ExceptionFormatIncorrect(
                        "Le fichier CSV doit contenir au moins 9 colonnes séparées par des points-virgules."));

        when(mock.chargerQuestionnaire(FICHIER_20_COLONNES))
                .thenThrow(new ExceptionFormatIncorrect(
                        "Format de nombre incorrect dans le fichier CSV."));

        return mock;
    }
}

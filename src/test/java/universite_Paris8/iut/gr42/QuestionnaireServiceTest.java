package universite_Paris8.iut.gr42;
import universite_Paris8.iut.gr42.mock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import universite_Paris8.iut.gr42.Exceptions.*;
import universite_Paris8.iut.gr42.dto.QuestionDTO;
import universite_Paris8.iut.gr42.dto.QuestionnaireDTO;
import universite_Paris8.iut.gr42.interface_service.IQuestionnaireService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Tests unitaires de IQuestionnaireService#chargerQuestionnaire.
 * Chaque test instancie son propre mock isolé via la classe mock dédiée.
 */
@DisplayName("QuestionnaireService – chargerQuestionnaire")
class QuestionnaireServiceTest {

    // =========================================================================
    // 1. Fichier non trouvé → ExceptionFichierNonTrouve
    // =========================================================================

    @Test
    @DisplayName("1 – Fichier non trouvé → ExceptionFichierNonTrouve")
    void chargerQuestionnaire_FichierInexistant_LeveExceptionFichierNonTrouve() throws Exception {
        // ARRANGE
        IQuestionnaireService mock = chargerQuestionnaireKOFichierNonTrouveMock.creer();

        // ACT & ASSERT
        ExceptionFichierNonTrouve ex = assertThrows(
                ExceptionFichierNonTrouve.class,
                () -> mock.chargerQuestionnaire(chargerQuestionnaireKOFichierNonTrouveMock.FICHIER)
        );

        assertTrue(ex.getMessage().contains(chargerQuestionnaireKOFichierNonTrouveMock.FICHIER));
        verify(mock).chargerQuestionnaire(chargerQuestionnaireKOFichierNonTrouveMock.FICHIER);
    }

    // =========================================================================
    // 2. Fichier sans droits → ExceptionPasLesDroits
    // =========================================================================

    @Test
    @DisplayName("2 – Fichier sans droits de lecture → ExceptionPasLesDroits")
    void chargerQuestionnaire_FichierSansDroit_LeveExceptionPasLesDroits() throws Exception {
        // ARRANGE
        IQuestionnaireService mock = chargerQuestionnaireKOPasLesDroitsMock.creer();

        // ACT & ASSERT
        ExceptionPasLesDroits ex = assertThrows(
                ExceptionPasLesDroits.class,
                () -> mock.chargerQuestionnaire(chargerQuestionnaireKOPasLesDroitsMock.FICHIER)
        );

        assertTrue(ex.getMessage().contains(chargerQuestionnaireKOPasLesDroitsMock.FICHIER));
        verify(mock).chargerQuestionnaire(chargerQuestionnaireKOPasLesDroitsMock.FICHIER);
    }

    // =========================================================================
    // 3. Fichier mal formaté (0, 8 ou 20 colonnes) → ExceptionFormatIncorrect
    //    Un seul mock, trois fichiers distincts testés via @ValueSource
    // =========================================================================

    @ParameterizedTest(name = "3 – Format incorrect ({0}) → ExceptionFormatIncorrect")
    @ValueSource(strings = {
            chargerQuestionnaireKOFormatIncorrectMock.FICHIER_0_COLONNES,
            chargerQuestionnaireKOFormatIncorrectMock.FICHIER_8_COLONNES,
            chargerQuestionnaireKOFormatIncorrectMock.FICHIER_20_COLONNES
    })
    void chargerQuestionnaire_FormatIncorrect_LeveExceptionFormatIncorrect(String fichier)
            throws Exception {
        // ARRANGE — un seul mock gère les 3 variantes
        IQuestionnaireService mock = chargerQuestionnaireKOFormatIncorrectMock.creer();

        // ACT & ASSERT
        assertThrows(
                ExceptionFormatIncorrect.class,
                () -> mock.chargerQuestionnaire(fichier)
        );

        verify(mock).chargerQuestionnaire(fichier);
    }

    // =========================================================================
    // 4. Erreur I/O → ExceptionErreurLecture
    // =========================================================================

    @Test
    @DisplayName("4 – Erreur I/O lors de la lecture → ExceptionErreurLecture")
    void chargerQuestionnaire_ErreurIO_LeveExceptionErreurLecture() throws Exception {
        // ARRANGE
        IQuestionnaireService mock = chargerQuestionnaireKOErreurLectureMock.creer();

        // ACT & ASSERT
        ExceptionErreurLecture ex = assertThrows(
                ExceptionErreurLecture.class,
                () -> mock.chargerQuestionnaire(chargerQuestionnaireKOErreurLectureMock.FICHIER)
        );

        assertNotNull(ex.getMessage());
        verify(mock).chargerQuestionnaire(chargerQuestionnaireKOErreurLectureMock.FICHIER);
    }

    // =========================================================================
    // 5. Fichier valide → QuestionnaireDTO avec liste de questions
    // =========================================================================

    @Test
    @DisplayName("5 – Fichier valide → QuestionnaireDTO avec liste de questions")
    void chargerQuestionnaire_FichierValide_RetourneListeDeQuestions() throws Exception {
        // ARRANGE
        IQuestionnaireService mock = chargerQuestionnaireOKMock.creer();

        // ACT
        QuestionnaireDTO resultat = mock.chargerQuestionnaire(chargerQuestionnaireOKMock.FICHIER);

        // ASSERT – questionnaire
        assertAll("QuestionnaireDTO retourné",
                () -> assertNotNull(resultat),
                () -> assertTrue(resultat.isCharge()),
                () -> assertEquals(1,             resultat.getIdentifiant()),
                () -> assertEquals("Java Basics", resultat.getLibelle()),
                () -> assertEquals(2,             resultat.getQuestions().size())
        );

        // ASSERT – première question
        List<QuestionDTO> questions = resultat.getQuestions();
        assertAll("Première question",
                () -> assertEquals(1,                           questions.get(0).getNumero()),
                () -> assertEquals("fr",                        questions.get(0).getLangue()),
                () -> assertEquals("Qu'est-ce qu'une classe ?", questions.get(0).getTexte()),
                () -> assertEquals("Un modèle d'objet",         questions.get(0).getReponse()),
                () -> assertEquals(2,                           questions.get(0).getDifficulte()),
                () -> assertEquals("JavaDoc",                   questions.get(0).getReference())
        );

        verify(mock).chargerQuestionnaire(chargerQuestionnaireOKMock.FICHIER);
    }
}

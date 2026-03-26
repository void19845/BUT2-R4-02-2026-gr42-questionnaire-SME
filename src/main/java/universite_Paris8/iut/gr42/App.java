package universite_Paris8.iut.gr42;
import universite_Paris8.iut.gr42.dto.QuestionnaireDTO;
import universite_Paris8.iut.gr42.services.QuestionnaireService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        QuestionnaireService q = new QuestionnaireService();
        try {
            QuestionnaireDTO questionnaire = q.chargerQuestionnaire("questionsQuizz_2025_V1.csv");
            q.afficherQuestions(questionnaire);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

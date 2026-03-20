package universite_Paris8.iut.gr42;

import universite_Paris8.iut.gr42.services.QuestionnaireService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        QuestionnaireService q = new QuestionnaireService();
        try {
            q.chargerQuestionnaire("questionsQuizz_2025_V1.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

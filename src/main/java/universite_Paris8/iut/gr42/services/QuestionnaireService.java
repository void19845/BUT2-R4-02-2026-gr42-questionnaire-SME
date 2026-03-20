package universite_Paris8.iut.gr42.services;

import universite_Paris8.iut.gr42.Exceptions.*;
import universite_Paris8.iut.gr42.dto.QuestionDTO;
import universite_Paris8.iut.gr42.dto.QuestionnaireDTO;
import universite_Paris8.iut.gr42.interface_service.IQuestionnaireService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implémentation du service gérant les questionnaires.
 */
public class QuestionnaireService implements IQuestionnaireService {

    @Override
    public QuestionnaireDTO chargerQuestionnaire(String fileName) 
            throws ExceptionFichierNonTrouve, ExceptionPasLesDroits, ExceptionFormatIncorrect, ExceptionErreurLecture {
        
        File fichier = new File(fileName);
        
        if (!fichier.exists()) {
            throw new ExceptionFichierNonTrouve("Le fichier CSV '" + fileName + "' est introuvable.");
        }
        
        if (!fichier.canRead()) {
            throw new ExceptionPasLesDroits("Lecture non autorisée pour le fichier '" + fileName + "'.");
        }
        
        QuestionnaireDTO questionnaire = new QuestionnaireDTO();
        boolean firstLine = true;
        
        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                // Ignore empty lines
                if (ligne.trim().isEmpty()) {
                    continue;
                }
                
                String[] colonnes = ligne.split("\t");
                
                // Le fichier doit avoir au moins 9 colonnes
                if (colonnes.length < 9) {
                    throw new ExceptionFormatIncorrect("Le fichier CSV doit contenir 9 colonnes séparées par des tabulations.");
                }
                
                try {
                    int idQuestionnaire = Integer.parseInt(colonnes[0].trim());
                    String libelleQuestionnaire = colonnes[1].trim();
                    int numQuestion = Integer.parseInt(colonnes[2].trim());
                    String langue = colonnes[3].trim();
                    String libelleQuestion = colonnes[4].trim();
                    String reponse = colonnes[5].trim();
                    int difficulte = Integer.parseInt(colonnes[6].trim());
                    String explication = colonnes[7].trim();
                    String reference = colonnes[8].trim();
                    
                    if (firstLine) {
                        questionnaire.setIdentifiant(idQuestionnaire);
                        questionnaire.setLibelle(libelleQuestionnaire);
                        firstLine = false;
                    }
                    
                    QuestionDTO question = new QuestionDTO(
                            numQuestion, langue, libelleQuestion, reponse, difficulte, explication, reference
                    );
                    
                    questionnaire.ajouterQuestion(question);
                    
                } catch (NumberFormatException e) {
                    throw new ExceptionFormatIncorrect("Format de nombre incorrect dans le fichier CSV : " + e.getMessage());
                }
            }
            
            questionnaire.setCharge(true);
            return questionnaire;
            
        } catch (IOException e) {
            throw new ExceptionErreurLecture("Erreur lors de la lecture du fichier CSV.", e);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

/**
 *
 * @author AJC
 */
public class FXMLDocumentController implements Initializable {

    public String mydirectory = System.getProperty("user.dir");

    @FXML
    private Label label;
    @FXML
    private MenuItem openItem;
    @FXML
    private MenuItem saveItem;
    @FXML
    private MenuItem exitItem;
    @FXML
    private MenuItem spellCheckerItem;
    @FXML
    private TextArea textAreaID;
    @FXML
    private ListView fileNameList;

    public boolean wordCorrect;
    public Set<String> dict = new HashSet<>();
    @FXML
    private TextArea suggestion;

    public Set<String> dict() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("Words.txt"));

        while (scanner.hasNext()) {
            dict.add(scanner.next());
        }
        return dict;
    }

    public boolean isCorrect(String myWord) {
        myWord = myWord.replaceAll("[^a-zA-Z]", ""); // gets rid of special chars

        if (dict.contains(myWord)) {
            return true;
        } else {
            return false;
        }
    }

    FileChooser fc = new FileChooser();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dict();
        } catch (FileNotFoundException ex) {

        }
    }

    @FXML
    private void exitApp(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void openApp(ActionEvent event) throws FileNotFoundException {
        fc.setInitialDirectory(new File(mydirectory));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            fileNameList.getItems().add(selectedFile.getName());
        } else {
            System.out.println("no file");
        }

        try {
            Scanner s = new Scanner(new File(selectedFile.getName())).useDelimiter("\\s+");
            while (s.hasNext()) {
                if (s.hasNextInt()) {
                    textAreaID.appendText(s.nextInt() + " ");
                } else {
                    textAreaID.appendText(s.next() + " ");
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

    @FXML
    private void saveApp(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(mydirectory));
        File selectedFile = fc.showSaveDialog(null);
        FileWriter writer = new FileWriter(selectedFile.getName());
        writer.write(textAreaID.getText().toString());
        writer.close();

    }

    @FXML
    private void check(javafx.event.ActionEvent event) {

        String myWords = textAreaID.getText();
        String[] words = myWords.split("\\s+"); //splits words
        ArrayList<String> tempWords;
        String wordT;
        int hasSuggested = 0;

        for (int i = 0; i < words.length; i++) {
            wordCorrect = isCorrect(words[i].toLowerCase()); // sets boolean for correct spelling
            if (wordCorrect == true) {
                System.out.println(words[i] + ": is correctly spelled");
            } else {
                System.out.println(words[i] + ":  is incorrectly spelled");
                wordT = words[i];
                suggestion.setText(wordT + "\n");
                suggestion.appendText("Suggested Corrections:" + "\n");

                tempWords = oneLetterIsMissing(wordT);
                for (int j = 0; j < tempWords.size(); j++) {
                    suggestion.appendText(tempWords.get(0) + "\n");
                    hasSuggested++;
                }
                tempWords = oneLetterSwapped(wordT);
                for (int j = 0; j < tempWords.size(); j++) {
                    suggestion.appendText(tempWords.get(0) + "\n");
                    hasSuggested++;
                }

                tempWords = oneLetterAdded(wordT);
                for (int j = 0; j < tempWords.size(); j++) {
                    suggestion.appendText(tempWords.get(0) + "\n");
                    hasSuggested++;
                }
                if (hasSuggested == 0) {
                    suggestion.appendText("No suggestions");
                }
                i = words.length; //stops program until correction of the first word
            }
        }

    }

    public ArrayList<String> oneLetterIsMissing(String word) {
        ArrayList<String> suggestedCorrect = new ArrayList(); // creates word list

        int lengthOfWord = word.length() - 1;
        if (isCorrect(word.substring(1).toLowerCase())) {
            suggestedCorrect.add(word.substring(1));
        }
        for (int i = 1; i < lengthOfWord; i++) {
            String working = word.substring(0, i);
            working = working.concat(word.substring((i + 1), word.length()));
            if (isCorrect(working)) {
                suggestedCorrect.add(working);
            }
        }
        if (isCorrect(word.substring(0, lengthOfWord))) {
            suggestedCorrect.add(word.substring(0, lengthOfWord));
        }
        return suggestedCorrect;
    }

    public ArrayList<String> oneLetterSwapped(String word) {
        ArrayList<String> suggestedCorrect = new ArrayList();   // creates word list

        for (int i = 0; i < word.length() - 1; i++) {
            String working = word.substring(0, i);
            working = working + word.charAt(i + 1);
            working = working + word.charAt(i);
            working = working.concat(word.substring((i + 2)));
            if (isCorrect(working)) {
                suggestedCorrect.add(working);
            }
        }
        return suggestedCorrect;
    }

    public ArrayList<String> oneLetterAdded(String word) {
        ArrayList<String> suggestedCorrect = new ArrayList(); // creates word list
        String tempSuggest;

        for (int i = 0; i <= word.length(); ++i) {
            for (char j = 'a'; j <= 'z'; ++j) {
                tempSuggest = (word.substring(0, i) + String.valueOf(j) + word.substring(i));
                if (isCorrect(tempSuggest.toLowerCase())) {
                    suggestedCorrect.add(tempSuggest);
                }
            }
        }
        return suggestedCorrect;
    }

}

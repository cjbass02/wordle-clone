import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private Rectangle box1 = new Rectangle();
    @FXML
    private Rectangle box2 = new Rectangle();
    @FXML
    private Rectangle box3 = new Rectangle();
    @FXML
    private Rectangle box4 = new Rectangle();
    @FXML
    private Rectangle box5 = new Rectangle();
    @FXML
    private Rectangle box6 = new Rectangle();
    @FXML
    private Rectangle box7 = new Rectangle();
    @FXML
    private Rectangle box8 = new Rectangle();
    @FXML
    private Rectangle box9 = new Rectangle();
    @FXML
    private Rectangle box10 = new Rectangle();
    @FXML
    private Rectangle box11 = new Rectangle();
    @FXML
    private Rectangle box12 = new Rectangle();
    @FXML
    private Rectangle box13 = new Rectangle();
    @FXML
    private Rectangle box14 = new Rectangle();
    @FXML
    private Rectangle box15 = new Rectangle();
    @FXML
    private Rectangle box16 = new Rectangle();
    @FXML
    private Rectangle box17 = new Rectangle();
    @FXML
    private Rectangle box18 = new Rectangle();
    @FXML
    private Rectangle box19 = new Rectangle();
    @FXML
    private Rectangle box20 = new Rectangle();
    @FXML
    private Rectangle box21 = new Rectangle();
    @FXML
    private Rectangle box22 = new Rectangle();
    @FXML
    private Rectangle box23 = new Rectangle();
    @FXML
    private Rectangle box24 = new Rectangle();
    @FXML
    private Rectangle box0 = new Rectangle();
    @FXML
    private Rectangle box25 = new Rectangle();
    @FXML
    private Rectangle box26 = new Rectangle();
    @FXML
    private Rectangle box27 = new Rectangle();
    @FXML
    private Rectangle box28 = new Rectangle();
    @FXML
    private Rectangle box29 = new Rectangle();

    @FXML
    private TextField L1 = new TextField();
    @FXML
    private TextField L2 = new TextField();
    @FXML
    private TextField L3 = new TextField();
    @FXML
    private TextField L4 = new TextField();
    @FXML
    private TextField L5 = new TextField();
    @FXML
    private TextField L6 = new TextField();
    @FXML
    private TextField L7 = new TextField();
    @FXML
    private TextField L8 = new TextField();
    @FXML
    private TextField L9 = new TextField();
    @FXML
    private TextField L10 = new TextField();
    @FXML
    private TextField L11 = new TextField();
    @FXML
    private TextField L12 = new TextField();
    @FXML
    private TextField L13 = new TextField();
    @FXML
    private TextField L14 = new TextField();
    @FXML
    private TextField L15 = new TextField();
    @FXML
    private TextField L16 = new TextField();
    @FXML
    private TextField L17 = new TextField();
    @FXML
    private TextField L18 = new TextField();
    @FXML
    private TextField L19 = new TextField();
    @FXML
    private TextField L20 = new TextField();
    @FXML
    private TextField L21 = new TextField();
    @FXML
    private TextField L22 = new TextField();
    @FXML
    private TextField L23 = new TextField();
    @FXML
    private TextField L24 = new TextField();
    @FXML
    private TextField L0 = new TextField();
    @FXML
    private TextField L25 = new TextField();
    @FXML
    private TextField L26 = new TextField();
    @FXML
    private TextField L27 = new TextField();
    @FXML
    private TextField L28 = new TextField();
    @FXML
    private TextField L29 = new TextField();
    @FXML
    private TextField L30 = new TextField();

    private ArrayList<Rectangle> listOfBoxes = new ArrayList<>();
    private ArrayList<TextField> listOfTextFields = new ArrayList<>();
    private int boardOffset = 0;
    @FXML
    private Button barGraph;
    @FXML
    private Button playAgain;
    @FXML
    private Button submitButton;
    @FXML
    private Label hintLabel;
    @FXML
    private Button hintButton;
    @FXML
    private ImageView background = new ImageView();

    MenuItem pixel = new MenuItem("Pixel");
    MenuItem two = new MenuItem("test");
    MenuItem three = new MenuItem("test");
    @FXML
    MenuButton backgroundPicker = new MenuButton("Background", null, pixel, two, three);

    @FXML
    TextArea commonLettersArea = new TextArea();

    @FXML
    TextArea commonWordArea = new TextArea();

    MenuItem commonLetters = new MenuItem("Show/Hide Commonly Guess Letters");
    MenuItem commonGuessedWords = new MenuItem("Show/Hide Commonly Guess Words");
    @FXML
    MenuButton guessPicker = new MenuButton("Common Guesses", null, commonLetters, commonGuessedWords);

    @FXML
    Label remainingTargetWords = new Label();

    private String hint;
    private Boolean isDone = false;
    private Boolean gameLost = true;
    private String referenceWord;
    private int numGuesses = 0;
    private int cursorIndex = 0;
    private double averageGuesses = 0;
    private List<Integer> gameGuesses = new ArrayList<>();
    private int remainingGuesses = 6;
    private int difficulty = 3;
    private String dictPath = "Dictionaries/wordle-official.txt";

    private int start = 0;
    private int numBoxes = 5;
    Paint originalFill;
    private HashSet<String> dictionary = new HashSet<>();
    private int indexCounter = 0;

    private int winStreak = 0;
    private int maxStreak = 0;
    private double gamesPlayed = 0;
    private double gamesWon = 0;
    private int sixDist = 0;
    private int oneDist = 0;
    private int twoDist = 0;
    private int threeDist = 0;
    private int fourDist = 0;
    private int fiveDist = 0;

    ArrayList<String> guesses = new ArrayList<>();
    ArrayList<Character> letters = new ArrayList<>();
    HashMap<Character, Integer> letterFrequency = new HashMap<>();
    Map<String, Integer> commonWords = new HashMap<>();

    HashMap<Character, Integer> greenLetters = new HashMap<>();
    HashMap<Character, Integer> yellowLetters = new HashMap<>();
    ArrayList<Character> greyLetters = new ArrayList<>();
    HashSet<String> availableTargetWords = new HashSet<>();
    String currentGuess;
    boolean isTesting = false;

    public void setGuess(String guess) {
        currentGuess = guess;
    }

    public void setTesting(boolean testing) {
        isTesting = testing;
    }

    public HashSet<String> getAvailableTargetWords() {
        return availableTargetWords;
    }

    public void setReferenceWord(String word) {
        referenceWord = word;
    }


    @FXML
    public boolean submit() {
        if(!isTesting) {
            currentGuess = getGuess();
        }
        boolean ret = false;
        if (numGuesses < 6 && !isDone) {
            if (currentGuess.length() == 5) {
                if (dictionary.contains(currentGuess)) {
                    if (!guesses.contains(currentGuess)) {
                        populateLetterFrequency(currentGuess);
                        printMostCommonWords(currentGuess);
                        printMostGuessedLetters();
                        checkGuess(currentGuess);
                        addLetters(currentGuess);
                        guesses.add(currentGuess);
                        setEditable();
                        boardOffset += 5;
                        if (boardOffset < listOfTextFields.size())
                            listOfTextFields.get(boardOffset).requestFocus();
                        numGuesses++;
                        remainingGuesses--;
                        if(numGuesses > 1){
                            hintButton.setVisible(true);
                        }
                        start += 5;
                        numBoxes += 5;
                        ret = true;
                        updateAvailableTargetWords();
                    } else {
                        // alertLabel.setText(currentGuess +" is already used");
                    }
                } else {
                    //alertLabel.setText(currentGuess+ " is not a valid word");
                    //Makes the boxes red and displays a visual when invalid word is entered
                    for (int i = start; i < numBoxes; i++) {
                        originalFill = listOfBoxes.get(i).getFill();
                        listOfBoxes.get(i).setFill(Color.RED);
                        Timeline timeline = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(listOfBoxes.get(i).fillProperty(), Color.RED),
                                        new KeyValue(listOfBoxes.get(i).xProperty(), 50)),
                                new KeyFrame(Duration.seconds(1), new KeyValue(listOfBoxes.get(i).fillProperty(), originalFill),
                                        new KeyValue(listOfBoxes.get(i).xProperty(), 400))
                        );
                        timeline.setAutoReverse(true);
                        timeline.play();
                        listOfTextFields.get(boardOffset + 5).requestFocus();
                    }
                    listOfTextFields.get(cursorIndex).requestFocus();
                    listOfTextFields.get(cursorIndex).positionCaret(listOfTextFields.get(cursorIndex).getText().length());
                    for (int i = start; i < numBoxes; i++) {
                        listOfBoxes.get(i).setFill(originalFill);
                    }
                    listOfTextFields.get(boardOffset + 5).requestFocus();
                }

            } else {
                //alertLabel.setText("Word must be 5 letters long. " + currentGuess + " is " +
                //       currentGuess.length() + " letters long.");
            }

            if (currentGuess.equals(referenceWord)) {
                //alertLabel.setText("You guessed the word! Great job!");
                playAgain.setVisible(true);
                for (TextField tf : listOfTextFields) {
                    tf.setEditable(false);
                }
                gameLost = false;
                winStreak++;
                gamesPlayed++;
                gamesWon++;
                if (winStreak > maxStreak) {
                    maxStreak++;
                }
                if (start == 5 && numBoxes == 10) {
                    oneDist++;
                } else if (start == 10 && numBoxes == 15) {
                    twoDist++;
                } else if (start == 15 && numBoxes == 20) {
                    threeDist++;
                } else if (start == 20 && numBoxes == 25) {
                    fourDist++;
                } else if (start == 25 && numBoxes == 30) {
                    fiveDist++;
                } else {
                    sixDist++;
                }
                showStatistics();
            }
        } else {
            //alertLabel.setText("Game over! You ran out of guesses! The word was " + referenceWord + ".");
            playAgain.setVisible(true);
            for (TextField tf : listOfTextFields) {
                tf.setEditable(false);
            }
            if (gameLost) {
                numGuesses = 0;
            }

            start = 0;
            numBoxes = 5;
            winStreak = 0;
            gamesPlayed++;
            if (gameLost) {
                showStatistics();
            }
        }
        return ret;
    }

    @FXML
    private void updateAvailableTargetWords() {
        HashSet<String> temp = new HashSet<>(availableTargetWords);
        for(String str : temp) {
            eliminateGrey(str);
            eliminateGreen(str);
            eliminateYellow(str);
        }
        remainingTargetWords.setText("Possible Target Words: " + availableTargetWords.size());
    }

    private void eliminateGrey(String str) {
        for(char c : greyLetters) {
            if(str.contains(String.valueOf(c))) {
                availableTargetWords.remove(str);
            }
        }
    }

    private void eliminateGreen(String str) {
        for(Map.Entry<Character, Integer> entry : greenLetters.entrySet()) {
            char c = entry.getKey();
            Integer index = entry.getValue();
            if(str.charAt(index) != c) {
                availableTargetWords.remove(str);
            }
        }
    }

    private void eliminateYellow(String str) {
        for(Map.Entry<Character, Integer> entry : yellowLetters.entrySet()) {
            char c = entry.getKey();
            Integer index = entry.getValue();
            if(str.charAt(index) == c) {
                availableTargetWords.remove(str);
            } else if(!str.contains(String.valueOf(c))) {
                availableTargetWords.remove(str);
            }
        }
    }

    private void populateLetterFrequency(String guess) {
        Character cur;
        for(int i = 0; i < guess.length(); i++) {
            cur = guess.charAt(i);
            if(!letterFrequency.containsKey(cur)) {
                letterFrequency.put(cur, 1);
            } else {
                letterFrequency.put(cur,letterFrequency.get(cur) + 1);
            }
        }
    }

    private void printMostGuessedLetters() {
        // Sort the entries by value in descending order
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(letterFrequency.entrySet());
        entries.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        // Retrieve the keys with the top 5 highest values
        List<Character> keysWithTop5HighestValues = new ArrayList<>();
        for (int i = 0; i < Math.min(5, entries.size()); i++) {
            keysWithTop5HighestValues.add(entries.get(i).getKey());
        }

        // Print the keys with the top 5 highest values
        String displayCommonLetters = "Letter | Frequency\n";
        for(int i = 0; i < keysWithTop5HighestValues.size(); i++) {
            displayCommonLetters += keysWithTop5HighestValues.get(i) + "        |       " + letterFrequency.get(keysWithTop5HighestValues.get(i)) + "\n";
        }
        commonLettersArea.setText(displayCommonLetters);

    }

    @FXML
    private void toggleCommonLetters() {
        commonLettersArea.setVisible(!commonLettersArea.isVisible());
    }

    @FXML
    private void toggleCommonWords() {
        commonWordArea.setVisible(!commonWordArea.isVisible());
    }


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createLists();
        loadDictionary();
        availableTargetWords.addAll(dictionary);
        remainingTargetWords.setText(remainingTargetWords.getText() + " " + dictionary.size());
        createHint();
        commonLettersArea.setVisible(false);
        commonWordArea.setVisible(false);
        playAgain.setVisible(false);
        hintButton.setVisible(false);
        submitButton.setDefaultButton(true);
        hintButton.setVisible(false);
        submitButton.setOnKeyPressed(event -> {
                    if (event.getCode().equals(KeyCode.ENTER)) {
                        submitButton.fire();
                    }
                }
        );
        listOfTextFields.get(0).requestFocus();
        barGraph.setFocusTraversable(false);
        barGraph.setVisible(false);
    }

    @FXML
    private void hint() {
        hintLabel.setText(hint);
    }

    private void createHint() {
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        hint = String.valueOf(referenceWord.charAt(randomNumber)).toUpperCase();
    }

    private void setEditable() {
        for (int i = 0; i < 5; i++) {
            listOfTextFields.get(i + boardOffset).setEditable(false);
        }
    }

    private String getGuess() {
        String builder = "";
        for (int i = 0; i < 5; i++) {
            if (i + boardOffset < listOfTextFields.size())
                builder += listOfTextFields.get(i + boardOffset).getText().toLowerCase();
        }
        return builder;
    }

    @FXML
    private void restart() {
        indexCounter = 0;
        calcAverage();
        barGraph.setVisible(true);
        listOfTextFields.clear();
        listOfBoxes.clear();
        yellowLetters.clear();
        greenLetters.clear();
        greyLetters.clear();
        availableTargetWords.clear();
        availableTargetWords.addAll(dictionary);
        remainingTargetWords.setText("Possible Target Words: " + dictionary.size());
        selectTarget();
        createLists();
        createHint();
        guesses.clear();
        letters.clear();
        gameLost = true;
        Color startColor = Color.web("a8bca0");
        for (TextField tf : listOfTextFields) {
            tf.setText("");
            tf.setEditable(true);
        }
        listOfTextFields.get(0).requestFocus();
        for (Rectangle rect : listOfBoxes) {
            rect.setFill(startColor);
        }
        boardOffset = 0;
        playAgain.setVisible(false);
        hintButton.setVisible(false);
        numGuesses = 0;
        isDone = false;
        hintButton.setVisible(false);
        hintLabel.setText("");

        start = 0;
        numBoxes = 5;

    }


    private void checkGuess(String guess) {
        Guess guess1 = new Guess(guess);
        String correctPlace = guess1.correctSpot(referenceWord);
        String wrongPlace = guess1.wrongSpot(referenceWord);


        String builder = "";
        for (int i = 0; i < guess.length(); i++) {
            if (wrongPlace.charAt(i) == guess.charAt(i) && wrongPlace.charAt(i) != guess.charAt(i)) {
                builder += correctPlace.charAt(i);

            } else {
                builder += "*";
            }
        }

        for (int i = 0; i < 5; ++i) {
            if (wrongPlace.charAt(i) != '*') {
                listOfBoxes.get(i + boardOffset).setFill(Color.YELLOW);
                if(wrongPlace.charAt(i) != referenceWord.charAt(i)) {
                    yellowLetters.put(wrongPlace.charAt(i), i);
                }


            }else {
                listOfBoxes.get(i + boardOffset).setFill(Color.GREY);
                if(!yellowLetters.containsKey(guess1.getStringGuess().charAt(i))) {
                    greyLetters.add(guess1.getStringGuess().charAt(i));
                }

            }
            listOfTextFields.get(i + boardOffset).setText((guess.charAt(i) + "").toUpperCase());
        }

        for (int i = 0; i < 5; ++i) {
            if (correctPlace.charAt(i) != '*') {
                listOfBoxes.get(i + boardOffset).setFill(Color.GREEN);
                greenLetters.put(correctPlace.charAt(i), i);
            }
        }
    }

    private void loadDictionary() {
        dictionary = new HashSet<>();
        int randomReferenceInt = (int) Math.floor(Math.random() * (2315 + 1));
        File listOfWords = new File(dictPath);
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(listOfWords));
            String cur = br.readLine();
            int counter = 0;
            while (cur != null) {
                dictionary.add(cur);
                cur = br.readLine();
                if (counter == randomReferenceInt) {
                    referenceWord = cur;
                }
                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        System.out.println(referenceWord);
    }

    private void addLetters(String word) {
        for (int i = 0; i < word.length(); i++) {
            letters.add(word.charAt(i));
        }
    }

    private void createLists() {
        listOfBoxes.addAll(Arrays.asList(box0, box1, box2, box3, box4, box5,
                box6, box7, box8, box9, box10, box11, box12, box13, box14, box15,
                box16, box17, box18, box19, box20, box21, box22, box23, box24,
                box25, box26, box27, box28, box29));

        listOfTextFields.addAll(Arrays.asList(L0, L1, L2, L3, L4, L5, L6, L7, L8,
                L9, L10, L11, L12, L13, L14, L15, L16, L17, L18, L19, L20, L21, L22,
                L23, L24, L25, L26, L27, L28, L29, L30));

        setUpTextFields();
    }

    @FXML
    private void setBackgroundMoon() {
        Image newBackground = new Image("BackgroundImage4.jpg");
        background.setImage(newBackground);
        background.setPreserveRatio(false);
        background.setFitWidth(550);
        background.setFitHeight(550);
    }

    @FXML
    private void setBackgroundSpace() {
        Image newBackground = new Image("BackgroundImage5.jpg");
        background.setImage(newBackground);
        background.setPreserveRatio(false);
        background.setFitWidth(550);
        background.setFitHeight(550);
    }

    @FXML
    private void setBackgroundPixel() {
        Image newBackground = new Image("BackgroundImage.jpg");
        background.setImage(newBackground);
    }

    @FXML
    private void setBackgroundSquidward() {
        Image newBackground = new Image("BackgroundImage6.jpg");
        background.setImage(newBackground);
    }

    @FXML
    private void setBackgroundCustom() {
        // Create a FileChooser object
        FileChooser fileChooser = new FileChooser();

        // Set the title of the dialog
        fileChooser.setTitle("Open Image File");

        // Set the file filter to only allow .jpg files
//        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg");
//        fileChooser.getExtensionFilters().add(extFilter);

        Stage stage = new Stage();
        stage.setWidth(400);
        stage.setHeight(400);
        File file = fileChooser.showOpenDialog(stage);
        Image image = new Image(file.toURI().toString());
        background.setImage(image);

    }

    @FXML
    private void spanishDict() {
        dictPath = "Dictionaries/spanish.txt";
        loadDictionary();
        restart();
    }
    @FXML
    private void englishDict() {
        dictPath = "Dictionaries/wordle-official.txt";
        loadDictionary();
        restart();
    }

    public void setDictionary(String path) {
        dictPath = path;
        loadDictionary();
        restart();
    }

    @FXML
    private void customDict() {
        // Create a FileChooser object
        FileChooser fileChooser = new FileChooser();

        // Set the title of the dialog
        fileChooser.setTitle("Open Dictionary File .txt file");

        // Set the file filter to only allow .jpg files
        //FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
        //fileChooser.getExtensionFilters().add(extFilter);

        Stage stage = new Stage();
        stage.setWidth(400);
        stage.setHeight(400);
        File file = fileChooser.showOpenDialog(stage);
        try {
            dictPath = file.getPath();
            loadDictionary();
            restart();
        } catch (NullPointerException e) {

        }
    }

    private void setUpTextFields() {
        for (TextField t : listOfTextFields) {
            t.setBackground(Background.EMPTY);
            t.setTextFormatter(new TextFormatter<String>(change -> {
                String newText = change.getControlNewText();
                if (newText.length() > 1) {
                    return null; // reject change
                } else {
                    return change; // accept change.
                }
            }));
            t.textProperty().addListener((observable, oldValue, newValue) -> {
                t.setText(newValue.toUpperCase());
                if (newValue.length() > 0) {
                    cursorIndex = listOfTextFields.indexOf(t);
                    if (cursorIndex < boardOffset + 4) {
                        listOfTextFields.get(++cursorIndex).requestFocus();
                    } else if (cursorIndex == boardOffset + 4){
                        listOfTextFields.get(cursorIndex + 1).requestFocus();
                        listOfTextFields.get(cursorIndex +1).setEditable(false);
                    }
                }
            });

            int finalIndexCounter = indexCounter;
            t.setOnKeyPressed(event -> {
                        if (event.getCode().equals(KeyCode.ENTER)) {
                            if (submit() && gameLost) {
                                listOfTextFields.get(finalIndexCounter).setEditable(true);
                                for (int i = boardOffset; i < 5; i++) {
                                    listOfTextFields.get(i).setEditable(false);
                                }
                            } else {
                                if (finalIndexCounter > boardOffset) {
                                    listOfTextFields.get(finalIndexCounter - 1).requestFocus();
                                }
                            }
                            //Backspace functionality
                        } else if (event.getCode().equals(KeyCode.BACK_SPACE)) {
                            //System.out.println(finalIndexCounter);
                            if(finalIndexCounter % 5 != 0 || finalIndexCounter == boardOffset + 5) {
                                TextField temp = listOfTextFields.get(finalIndexCounter - 1);
                                if(listOfTextFields.get(finalIndexCounter).getText().isEmpty()) {
                                    temp.clear();
                                }
                                temp.requestFocus();

                                //seperate case for last box
                            }
                        }
            });
            indexCounter++;
        }
    }

    private void calcAverage() {
        double sum = 0;
        double retSum = 0;
        if (numGuesses != 0) {
            DecimalFormat format = new DecimalFormat("##.000");
            gameGuesses.add(numGuesses);
            if (gameGuesses.size() > 1) {
                for (int num : gameGuesses) {
                    sum += num;
                }
                retSum = sum / gameGuesses.size();
            } else {
                retSum = gameGuesses.get(0);
            }
            averageGuesses = Double.parseDouble(format.format(retSum));
        }

    }

    @FXML
    private void barGraphClick() {
        VBox vBox = new VBox();
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Average Guesses: " + averageGuesses));
        hbox.setAlignment(Pos.CENTER);

        NumberAxis numberAxis = new NumberAxis();
        CategoryAxis categoryAxis = new CategoryAxis();
        BarChart<Number, String> barChart = new BarChart<Number, String>(numberAxis, categoryAxis);
        numberAxis.setLabel("Times Guessed");
        categoryAxis.setLabel("Number of Guesses Used");

        int[] guessTotal = new int[6];

        for (Integer gameGuess : gameGuesses) {
            guessTotal[gameGuess - 1] += 1;
        }

        XYChart.Series<Number, String> s1 = new XYChart.Series<>();
        s1.getData().add(new XYChart.Data<Number, String>(guessTotal[0], "1"));
        s1.getData().add(new XYChart.Data<Number, String>(guessTotal[1], "2"));
        s1.getData().add(new XYChart.Data<Number, String>(guessTotal[2], "3"));
        s1.getData().add(new XYChart.Data<Number, String>(guessTotal[3], "4"));
        s1.getData().add(new XYChart.Data<Number, String>(guessTotal[4], "5"));
        s1.getData().add(new XYChart.Data<Number, String>(guessTotal[5], "6"));

        Stage stage = new Stage();
        vBox.getChildren().addAll(hbox, barChart);
        Scene scene = new Scene(vBox, 500, 500);
        barChart.getData().add(s1);

        barChart.setLegendVisible(false);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        dropShadow.setColor(Color.GRAY);

        for (XYChart.Data<Number, String> data : s1.getData()) {
            Node bar = data.getNode().lookup(".chart-bar");

            bar.setStyle("-fx-bar-fill: #24BB05;");
            bar.setEffect(dropShadow);
        }

        stage.setScene(scene);
        stage.setTitle("Guesses");

        stage.show();
    }

    private void showStatistics() {
        int winPercent = (int) ((gamesWon/gamesPlayed) * 100);
        int games = (int)gamesPlayed;
        Stage stage = new Stage();
        VBox root = new VBox();

        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));
        Label value = new Label("Difficulty: ");
        buttonBox.getChildren().add(value);


        HBox box = new HBox();
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        Button easy = new Button();
        easy.setText("Easy");
        easy.setMinWidth(20);
        box.getChildren().add(easy);

        Button medium = new Button();
        medium.setText("Medium");
        box.getChildren().add(medium);


        Button hard = new Button();
        hard.setText("Hard");
        box.getChildren().add(hard);

        buttonBox.getChildren().add(box);


        easy.setOnAction(e -> {
            difficulty = 5;
            stage.close();
            restart();
        });
        medium.setOnAction(e -> {
            difficulty = 3;
            stage.close();
            restart();
        });
        hard.setOnAction(e -> {
            difficulty = 0;
            stage.close();
            restart();
        });


        Label title = new Label("STATISTICS");
        title.setFont(new Font(16));
        title.setPadding(new Insets(10, 0, 30, 0));
        Label titleTwo = new Label("GUESS DISTRIBUTION");
        titleTwo.setFont(new Font(16));
        titleTwo.setPadding(new Insets(35, 0, 30, 0));
        root.setAlignment(Pos.TOP_CENTER);

        Label label1 = new Label("" + games);
        label1.setFont(new Font(35));

        Label label2 = new Label("" + winPercent);
        label2.setFont(new Font(35));
        if (games >= 10) {
            label1.setPadding(new Insets(0, 0, 0, 65));
            label2.setPadding(new Insets(0, 0, 0, 10));
        } else {
            label1.setPadding(new Insets(0, 0, 0, 75));
        }
        if (winPercent == 100) {
            label2.setPadding(new Insets(0, 0, 0, 15));
        } else {
            label2.setPadding(new Insets(0, 10, 0, 25));
        }

        Label label3 = new Label("" + winStreak);
        label3.setFont(new Font(35));
        label3.setPadding(new Insets(0, 0, 0, 38));
        Label label4 = new Label("" + maxStreak);
        label4.setFont(new Font(35));
        label4.setPadding(new Insets(0, 0, 0, 70));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.add(label1, 0, 0);
        grid.add(label2, 1, 0);
        grid.add(label3, 2, 0);
        grid.add(label4, 3, 0);

        Label gamesPlayedLabel = new Label("Played");
        Label winPercentageLabel = new Label("Win %");
        Label currentStreakLabel = new Label("Current Streak");
        Label maxStreakLabel = new Label("Max Streak");

        HBox statsHBox = new HBox();
        statsHBox.setAlignment(Pos.CENTER);
        statsHBox.setSpacing(20);
        statsHBox.getChildren().addAll(gamesPlayedLabel, winPercentageLabel, currentStreakLabel, maxStreakLabel);

        ObservableList<XYChart.Data<String, Number>> series1Data = FXCollections.observableArrayList(
                new XYChart.Data<>("1", oneDist),
                new XYChart.Data<>("2", twoDist),
                new XYChart.Data<>("3", threeDist),
                new XYChart.Data<>("4", fourDist),
                new XYChart.Data<>("5", fiveDist),
                new XYChart.Data<>("6", sixDist)
        );

        XYChart.Series<String, Number> series1 = new XYChart.Series<>("Series 1", series1Data);

        StackedBarChart<String, Number> chart = new StackedBarChart<>(new CategoryAxis(), new NumberAxis());
        chart.getData().addAll(series1);

        HBox graph = new HBox();
        graph.getChildren().add(chart);

        root.getChildren().add(buttonBox);
        root.getChildren().add(title);
        root.getChildren().add(grid);
        root.getChildren().add(statsHBox);
        root.getChildren().add(titleTwo);
        root.getChildren().add(graph);
        Scene scene = new Scene(root, 400, 475);
        stage.setScene(scene);
        stage.getIcons().add(new Image("icon.jpg"));
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> stage.show());
        delay.play();
    }



    void selectTarget() {
        // Sort the entries by value in descending order
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(letterFrequency.entrySet());
        entries.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        // Retrieve the keys with the top 5 highest values
        List<Character> keysWithTop5HighestValues = new ArrayList<>();
        for (int i = 0; i < Math.min(5, entries.size()); i++) {
            keysWithTop5HighestValues.add(entries.get(i).getKey());
        }

        String oldWord = referenceWord;
        while(referenceWord == oldWord) {
            for (String s : dictionary) {
                int numLetters = 0;
                for (int i = 0; i < keysWithTop5HighestValues.size(); i++)
                    if (s.contains("" + keysWithTop5HighestValues.get(i))) {
                        numLetters++;
                    }
                if (numLetters == difficulty && s != referenceWord) {
                    referenceWord = s;
                    break;
                }
            }
            difficulty--;
        }


        System.out.println(referenceWord);
    }


    private void printMostCommonWords(String word){
        if(!commonWords.containsKey(word)){
            commonWords.put(word,1);
        } else{
            commonWords.put(word, commonWords.get(word) + 1);
        }

        List<Map.Entry<String, Integer>> values = new ArrayList<>(commonWords.entrySet());
        values.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        List<String> top5Words = new ArrayList<>();
        for (int i = 0; i < Math.min(5, values.size()); i++) {
            top5Words.add(values.get(i).getKey());
        }

        StringBuilder displayCommonWords = new StringBuilder("Word: Frequency\n");
        for(int i = 0; i < top5Words.size(); i++) {
            displayCommonWords.append(top5Words.get(i)).append(": ").append(commonWords.get(top5Words.get(i))).append("\n");
        }

        commonWordArea.setText(displayCommonWords.toString());
    }








}


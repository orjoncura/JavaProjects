package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.RED;

public class Controller
{
    public Button btn1;
    public Button btn2;
    public Button btn9;
    public Button btn8;
    public Button btn7;
    public Button btn6;
    public Button btn5;
    public Button btn4;
    public Button btn3;
    public Button start;
    public Pane mainPane;
    public GridPane gridPane;
    public Pane instructionsPane;
    public Pane finalPanel;
    public String Turn = "user1";
    public Label finalLabel;
    public TextField User1;
    public TextField User2;
    public Button startAgain;

    public void btn1(MouseEvent mouseEvent)
    {
        if(Turn == "user1")
        {
            btn1.setText("X");
            btn1.setTextFill(RED);
            Turn = "user2";
        }
        else
        {
            btn1.setText("O");
            btn1.setTextFill(BLUE);
            Turn = "user1";
        }
        btn1.setDisable(true);
    }

    public void btn2(MouseEvent mouseEvent) {
        if(Turn == "user1")
        {
            btn2.setText("X");
            btn2.setTextFill(RED);
            Turn = "user2";

        }
        else
        {
            btn2.setText("O");
            btn2.setTextFill(BLUE);
            Turn = "user1";
        }
        btn2.setDisable(true);
        turn();
    }

    public void btn3(MouseEvent mouseEvent) {
        if(Turn == "user1")
        {
            btn3.setText("X");
            btn3.setTextFill(RED);
            Turn = "user2";
        }
        else
        {
            btn3.setText("O");
            btn3.setTextFill(BLUE);
            Turn = "user1";
        }
        btn3.setDisable(true);
        turn();
    }

    public void btn4(MouseEvent mouseEvent) {
        if(Turn == "user1")
        {
            btn4.setText("X");
            btn4.setTextFill(RED);
            Turn = "user2";
        }
        else
        {
            btn4.setText("O");
            btn4.setTextFill(BLUE);
            Turn = "user1";
        }
        btn4.setDisable(true);
        turn();
    }

    public void btn5(MouseEvent mouseEvent) {
        if(Turn == "user1")
        {
            btn5.setText("X");
            btn5.setTextFill(RED);
            Turn = "user2";
        }
        else
        {
            btn5.setText("O");
            btn5.setTextFill(BLUE);
            Turn = "user1";
        }
        btn5.setDisable(true);
        turn();
    }

    public void btn6(MouseEvent mouseEvent) {
        if(Turn == "user1")
        {
            btn6.setText("X");
            btn6.setTextFill(RED);
            Turn = "user2";
        }
        else
        {
            btn6.setText("O");
            btn6.setTextFill(BLUE);
            Turn = "user1";
        }
        btn6.setDisable(true);
        turn();
    }

    public void btn7(MouseEvent mouseEvent) {
        if(Turn == "user1")
        {
            btn7.setText("X");
            btn7.setTextFill(RED);
            Turn = "user2";
        }
        else
        {
            btn7.setText("O");
            btn7.setTextFill(BLUE);
            Turn = "user1";
        }
        btn7.setDisable(true);
        turn();
    }

    public void btn8(MouseEvent mouseEvent) {
        if(Turn == "user1")
        {
            btn8.setText("X");
            btn8.setTextFill(RED);
            Turn = "user2";
        }
        else
        {
            btn8.setText("O");
            btn8.setTextFill(BLUE);
            Turn = "user1";
        }
        btn8.setDisable(true);
        turn();
    }

    public void btn9(MouseEvent mouseEvent) {
        if(Turn == "user1")
        {
            btn9.setText("X");
            btn9.setTextFill(RED);
            Turn = "user2";
        }
        else
        {
            btn9.setText("O");
            btn9.setTextFill(BLUE);
            Turn = "user1";
        }
        btn9.setDisable(true);
        turn();
    }

    public void start(MouseEvent mouseEvent)
    {
        mainPane.setVisible(false);
        gridPane.setVisible(true);
        instructionsPane.setVisible(false);
        finalPanel.setVisible(false);
    }

    public void instructions(MouseEvent mouseEvent)
    {
        mainPane.setVisible(false);
        gridPane.setVisible(false);
        instructionsPane.setVisible(true);
        finalPanel.setVisible(false);
    }

    void turn()
    {
        if(
                (btn1.getText() == btn2.getText() && (btn2.getText() == btn3.getText())) && (btn2.getText()  != "") ||
                        (btn4.getText() == btn5.getText() && (btn4.getText() == btn6.getText())) && (btn6.getText()  != "") ||
                        (btn7.getText() == btn8.getText() && (btn7.getText() == btn9.getText())) && (btn9.getText()  != "") ||

                        (btn1.getText() == btn4.getText() && (btn1.getText() == btn7.getText())) && (btn7.getText()  != "") ||
                        (btn2.getText() == btn5.getText() && (btn5.getText() == btn8.getText())) && (btn8.getText()  != "") ||
                        (btn3.getText() == btn6.getText() && (btn3.getText() == btn9.getText())) && (btn9.getText()  != "") ||

                        (btn7.getText() == btn5.getText() && (btn7.getText() == btn3.getText())) && (btn3.getText()  != "") ||
                        (btn1.getText() == btn5.getText() && (btn1.getText() == btn9.getText())) && (btn9.getText()  != "")
                )
        {
            mainPane.setVisible(false);
            gridPane.setVisible(false);
            instructionsPane.setVisible(false);
            finalPanel.setVisible(true);
            if(Turn == "user1")
            {
                finalLabel.setText(User2.getText() + " Won");
            }
            else
            {
                finalLabel.setText(User1.getText() + " Won");
            }
        }
    }

    public void home(MouseEvent mouseEvent)
    {
        mainPane.setVisible(true);
        gridPane.setVisible(false);
        instructionsPane.setVisible(false);
        finalPanel.setVisible(false);
    }

    public void startAgain(MouseEvent mouseEvent)
    {
        mainPane.setVisible(true);
        gridPane.setVisible(false);
        instructionsPane.setVisible(false);
        finalPanel.setVisible(false);

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);
        btn6.setDisable(false);
        btn7.setDisable(false);
        btn8.setDisable(false);
        btn9.setDisable(false);
    }
}

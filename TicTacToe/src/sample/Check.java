package sample;

/**
 * Created by Orion on 6/26/2017.
 */
public class Check
{
    public Check(String Turn)
    {
        if(Turn == "X")
        {
            Turn = "O";
           // jLabel1.setText(User2.getText());
        }
        else
        {
            Turn = "X";
           // jLabel1.setText(User1.getText());
        }
    }

}

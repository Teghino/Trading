import javax.swing.*;

public class Info extends JFrame {

    private JPanel infoPanel;
    private JTextArea autoreFrancescoTacchinoDataTextArea;

    public Info(){
        setTitle("info");
        setContentPane(infoPanel);
        setSize(600, 500);
        setVisible(true);
        setLocation(700, 10);
    }

    public static void main(String[] args) {
        Info mioInfo = new Info();
    }

}

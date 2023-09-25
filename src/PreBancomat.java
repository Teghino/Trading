import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreBancomat extends JFrame {
    private JPanel prePanel;
    private JTextField textFieldPreConto;
    private JButton buttonFinePre;
    private JPasswordField textFieldPassword;
    private JButton buttonInfo;
    private JLabel AbBanca;


    public PreBancomat(Banca miaBanca) {
        setTitle("Benvenuto");
        setContentPane(prePanel);
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        AbBanca.setText(miaBanca.getNomeBanca());

        //bottone per verificare la password e cambiare pagina
        buttonFinePre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=0;
                for(i=0; i<miaBanca.getNumConti(); i++){
                    if(textFieldPreConto.getText().equals(miaBanca.getNumeroConto(i))) {
                        break;
                    }
                }
                if(textFieldPassword.getText().equals(miaBanca.getPassword(miaBanca.getNumeroConto(i)))){
                    Bancomat mioBancomat = new Bancomat(miaBanca.getContoCorrente(i), miaBanca);
                }
            }
        });

        //bottone per aprire la pagina di info
        buttonInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Info mioInfo = new Info();
            }
        });
    }
}

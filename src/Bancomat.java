import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bancomat extends JFrame {
    private JPanel myPanel;
    private JButton buttonGiroConto;
    private JButton buttonChiudi;
    private JButton buttonPreleva;
    private JButton buttonVersa;
    private JTextField textFieldImporto;
    private JLabel AbSaldo;
    private JLabel AbNumero;
    private JButton button1;
    private Bancomat bancomat;
    private Borsa b = new Borsa();


    public Bancomat(ContoCorrente mioConto, Banca miaBanca) {
        setContentPane(myPanel);
        setTitle("Conto numero " + mioConto.getConto());
        setSize(800, 500);
        setVisible(true);
        AbSaldo.setText(Double.toString(mioConto.getSaldo()) + " $");
        AbNumero.setText(mioConto.getConto());
        this.bancomat=this;


        /*Funzione che si avvia quando si schiaccia il bottone preleva */
        buttonPreleva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mioConto.preleva(Double.parseDouble(textFieldImporto.getText()));
                AbSaldo.setText(Double.toString(mioConto.getSaldo()) + " $");
            }
        });

        /*Funzione che si avvia quando si schiaccia il bottone versa */
        buttonVersa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mioConto.deposita(Double.parseDouble(textFieldImporto.getText()));
                AbSaldo.setText(Double.toString(mioConto.getSaldo()) + " $");
            }
        });

        //Funzione che si avvia quando si schiaccia il bottone chiudi conto
        buttonChiudi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mioConto.chiudiConto();
                setSize(0, 0);
            }
        });

        //Funzione che si avvia quando si schiaccia il bottone giro conto
        buttonGiroConto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaginaGiroConto giro = new PaginaGiroConto(miaBanca, mioConto, bancomat);
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Azioni a = new Azioni(mioConto, b, bancomat);
            }
        });
    }

    public void setAbSaldo(String importo){
        AbSaldo.setText(importo);
    }
}




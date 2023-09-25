import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Azioni extends JFrame{

    private JPanel myPanel;
    private JButton buttonFerrari;
    private JButton buttonApple;
    private JButton buttonMicrosoft;
    private JButton buttonHP;
    private JLabel costof;
    private JLabel costoa;
    private JLabel costom;
    private JLabel costoh;
    private JLabel saldo;
    private JLabel numh;
    private JLabel numf;
    private JLabel numa;
    private JLabel numm;

    public Azioni(ContoCorrente conto, Borsa b, Bancomat mioBancomat) {
        setContentPane(myPanel);
        setSize(800, 500);
        setVisible(true);
        saldo.setText(Double.toString(conto.getSaldo()) + " $");
        numa.setText(Integer.toString(conto.getAzioni(buttonApple.getText())));
        numm.setText(Integer.toString(conto.getAzioni(buttonMicrosoft.getText())));
        numh.setText(Integer.toString(conto.getAzioni(buttonHP.getText())));
        numf.setText(Integer.toString(conto.getAzioni(buttonFerrari.getText())));
        buttonFerrari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double costo = b.getAzione(buttonFerrari.getText());
                if(conto.getSaldo() > costo){
                   conto.compraAzioni(buttonFerrari.getText());
                   numf.setText(Integer.toString(conto.getAzioni(buttonFerrari.getText())));
                   conto.addebita(costo);
                   saldo.setText(Double.toString(conto.getSaldo()) + " $");
                   mioBancomat.setAbSaldo(Double.toString(conto.getSaldo()) + " $");
                }
            }
        });
        buttonApple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double costo = b.getAzione(buttonApple.getText());
                if(conto.getSaldo() > costo){
                    conto.compraAzioni(buttonApple.getText());
                    numa.setText(Integer.toString(conto.getAzioni(buttonApple.getText())));
                    conto.addebita(costo);
                    saldo.setText(Double.toString(conto.getSaldo()) + " $");
                    mioBancomat.setAbSaldo(Double.toString(conto.getSaldo()) + " $");
                }
            }
        });
        buttonMicrosoft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double costo = b.getAzione(buttonMicrosoft.getText());
                if(conto.getSaldo() > costo){
                    conto.compraAzioni(buttonMicrosoft.getText());
                    numm.setText(Integer.toString(conto.getAzioni(buttonMicrosoft.getText())));
                    conto.addebita(costo);
                    saldo.setText(Double.toString(conto.getSaldo()) + " $");
                    mioBancomat.setAbSaldo(Double.toString(conto.getSaldo()) + " $");
                }
            }
        });
        buttonHP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double costo = b.getAzione(buttonHP.getText());
                if(conto.getSaldo() > costo){
                    conto.compraAzioni(buttonHP.getText());
                    numh.setText(Integer.toString(conto.getAzioni(buttonHP.getText())));
                    conto.addebita(costo);
                    saldo.setText(Double.toString(conto.getSaldo()) + " $");
                    mioBancomat.setAbSaldo(Double.toString(conto.getSaldo()) + " $");
                }
            }
        });
    }

}

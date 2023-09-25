import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaGiroConto extends JFrame {
    private JPanel prePanel;
    private JTextField textFieldPreConto;
    private JTextField textFieldImporto;
    private JButton buttonFineGiro;

    public PaginaGiroConto(Banca miaBanca, ContoCorrente mioConto, Bancomat mioBancomat){
        setContentPane(prePanel);
        setSize(600, 400);
        setVisible(true);

        ////Funzione che si avvia quando si schiaccia il bottone Ok
        buttonFineGiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=0;
                for(i=0; i<miaBanca.getNumConti(); i++){
                    if(textFieldPreConto.getText().equals(miaBanca.getNumeroConto(i))) {
                        miaBanca.giroConto(mioConto.getConto(), miaBanca.getNumeroConto(i), Double.parseDouble(textFieldImporto.getText()));
                        mioBancomat.setAbSaldo(Double.toString(mioConto.getSaldo()));
                        setVisible(false);

                    }
                }

            }
        });
    }
}

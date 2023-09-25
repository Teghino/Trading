
/**
 * Aggiungi qui una descrizione della classe banca
 *
 * @author (il tuo nome)
 * @version (un numero di versione o una data)
 */
public class Banca{
    private String nomeBanca;
    private int filiale;
    private ContoCorrente[] conti;
    private int numConti = 0;

    public Banca(String nome, int numAgenzia, int maxConti){
        nomeBanca = nome;
        filiale = numAgenzia;
        conti = new ContoCorrente[maxConti];
        numConti = 0;
    }

    public String getNomeBanca(){
        return nomeBanca;
    }
    public Banca(String nome, int numAgenzia){
        this(nome, numAgenzia, 100);
    }

    public double getSaldo(String conto){
        return conti[Integer.parseInt(conto)].getSaldo();
    }
    public ContoCorrente getContoCorrente(int pos){
        return conti[pos];
    }
    public String getPassword(String conto){
        return conti[Integer.parseInt(conto)].getPassword();
    }

    public int getNumConti(){
        return numConti;
    }

    public String getNumeroConto(int posizione){
        return conti[posizione].getConto();
    }


    /** apre un conto corrente presso la banca,
     @param nome nome dell’intestatario del conto
     @param importoIniziale saldo all’apertura del conto
     @return il numero del contoCorrente (numero di 6 cifre con zeri iniziali)
     Usare String.format */
    public String apriConto(String nome,  double importoIniziale, String password){
        ContoCorrente cc = new ContoCorrente(importoIniziale, nome, String.format("%06d",numConti), password);
        conti[numConti]=  cc;
        String ris=String.format("%06d",numConti);
        numConti ++;
        return ris;
    }

    /** versa soldi su un conto
     *@param conto è il numero del contoCorrente (numero di 6 cifre con zeri iniziali)
     *@param importo importo da versare
     */
    public void versamento(String conto, double importo){
        conti[Integer.parseInt(conto)].deposita(importo);
    }

    /** fai un prelievo da un conto
     * @param conto numero del conto
     * @return true se il prelievo viene effettuato
     * @return false se il prelievo non viene effettuato
     */
    public boolean prelievo(String conto, double importo){
        if (conti[Integer.parseInt(conto)].preleva(importo)==false){
            return false;
        }
        return true;
    }

    /**chiudi un conto mettendo il numero a "0"
     * @param conto il numero del conto
     * @return il saldo presente nel conto
     */
    public double chiudiConto(String conto){
        conti[Integer.parseInt(conto)].chiudiConto();
        return conti[Integer.parseInt(conto)].getSaldo();
    }

    /**aggiunge gli interessi ad ogni conto
     * @param tasso la quantità di interessi
     */
    public void addInteressi(double tasso){
        for(int i=0; i<numConti; i+=1){
            if (conti[i].getConto()!="0") {
                versamento(conti[i].getConto(), conti[i].getSaldo()*tasso);
            }
        }
    }

    /** togli le spese da tutti i conti, se il saldo è minore delle spese non fa niente
     * @param importo importo da levare
     */
    public void addSpese(double importo){
        for(int i=0; i<numConti; i+=1){
            if (conti[i].getConto()!="0") {
                prelievo(conti[i].getConto(), importo);
            }
        }
    }

    /** togli le spese da tutti i conti che hanno un importo inferiore alla soglia
     * @param importo importo da togliere
     * @param soglia soglia
     */
    public void addSpese(double importo, double soglia){
        for(int i=0; i<numConti; i+=1){
            if (conti[i].getConto()!="0") {
                if(conti[i].getSaldo()>=soglia){
                    prelievo(conti[i].getConto(), importo);
                }
            }
        }
    }

    /** sposta i soldi da un conto all'altro se possibile
     * @param dalConto conto da cui prendere i soldi
     * @param alConto conto in cui mettere i soldi
     * @param importo importo da spostare
     */
    public void giroConto(String dalConto, String alConto, double importo){
        if(prelievo(dalConto, importo) == true){
            versamento(alConto, importo);
        }
    }
}





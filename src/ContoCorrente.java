import java.util.HashMap;
import java.util.Map;

/**
 * Aggiungi qui una descrizione della classe contoCorrente
 *
 * @author (il tuo nome)
 * @version (un numero di versione o una data)
 */
public class ContoCorrente
{
    private final String password;
    private double saldo;
    private final String intestatario;
    private String numeroConto;
    private Map<String, Integer> contoDesposito = new HashMap<>();

    /**
     * Costruttore degli oggetti di classe  contoCorrente
     */
    public ContoCorrente(double saldo, String intestatario, String numeroConto, String password)
    {
        this.password=password;
        this.saldo=saldo;
        this.intestatario=intestatario;
        this.numeroConto=numeroConto;
    }

    /**
     * Un esempio di metodo - aggiungi i tuoi commenti
     *
     * @return  saldo
     */
    public double getSaldo()
    {
        return saldo;
    }
    public String getPassword()
    {
        return password;
    }

    /**
     * preleva un importo
     * @param importo importo da prelevare
     * casi particolari: se l'importo è maggiore del saldo non fa niente
     */
    public boolean preleva(double importo)
    {
        if(importo<=saldo)
        {
            saldo-=importo;
            return true;
        }
        return false;
    }


    /**
     * deposita un importo
     * @param importo importo da depositare
     * casi particolari: se l'importo è negativo non fa niente
     */
    public void deposita(double importo)
    {
        saldo=saldo+importo;
    }

    public String getConto(){
        return numeroConto;
    }

    public void chiudiConto(){
        numeroConto="0";
    }
    public void compraAzioni(String nome){
        if (contoDesposito.containsKey(nome)){
            contoDesposito.put(nome, contoDesposito.get(nome) + 1);
        }else{
            contoDesposito.put(nome, 1);
        }
    }
    public int getAzioni(String nome) {
        if(contoDesposito.get(nome) == null){
            return 0;
        }
        return contoDesposito.get(nome);
    }
    public void addebita(double n){ saldo -= n; }
}
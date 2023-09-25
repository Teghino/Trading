import java.util.HashMap;
import java.util.Map;

public class Borsa {
    private Map<String, Double> azioni = new HashMap<>();

    public Borsa(){
        azioni.put("Ferrari", 255.0);
        azioni.put("Apple", 123.0);
        azioni.put("Microsoft", 168.0);
        azioni.put("HP", 95.0);
    }
    public double getAzione(String nome) {
        return azioni.get(nome);
    }
}

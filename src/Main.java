public class Main {
    public static void main(String[] args) {
        Banca miaBanca = new Banca("Carige", 1);;
        miaBanca.apriConto("Francesco", 1000, "ciccio");
        miaBanca.apriConto("Paolo", 2000, "napoli");
        miaBanca.apriConto("Filippo", 100, "pippo");
        PreBancomat mioBancomat = new PreBancomat(miaBanca);
    }
}
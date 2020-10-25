import com.dev.ProcessaBoletos;

public class Principal {
    public static void main(String[] args) {
    ProcessaBoletos processarBoleto = new ProcessaBoletos();
    String nomeArquivo = "banco-brasil-1.csv";
    //nomeArquivo = "bradesco-1.csv"
    processarBoleto.processar(nomeArquivo);
    }
}

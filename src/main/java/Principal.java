import com.dev.ProcessaBoletos;
import com.dev.Processar;

public class Principal {
    public static void main(String[] args) {
    ProcessaBoletos processarBoleto = new Processar();
    String nomeArquivo = "banco-brasil-1.csv";
    //nomeArquivo = "bradesco-1.csv"
    processarBoleto.processar(nomeArquivo);
    }
}

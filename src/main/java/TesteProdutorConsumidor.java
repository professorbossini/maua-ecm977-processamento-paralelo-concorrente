import java.util.ArrayList;
import java.util.List;

public class TesteProdutorConsumidor {

    public static void main(String[] args) {
        List<Integer> itens = new ArrayList<>();
        Produtor p = new Produtor(itens);
        Consumidor c = new Consumidor(itens);
        new Thread(c).start();
        new Thread(p).start();
    }
}

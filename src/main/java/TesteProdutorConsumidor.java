import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TesteProdutorConsumidor {

    public static void main(String[] args) {
        List<Integer> itens = new ArrayList<>();
        //Produtor p = new Produtor(itens);
        //Consumidor c = new Consumidor(itens);
        ExecutorService poolThreads = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 50; i++){
            poolThreads.submit(new Produtor(itens));
            poolThreads.submit(new Consumidor(itens));
        }
        //new Thread(c).start();
        //new Thread(p).start();
    }
}

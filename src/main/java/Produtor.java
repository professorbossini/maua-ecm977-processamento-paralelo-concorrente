import java.util.List;
import java.util.Random;

public class Produtor implements Runnable{
    private List<Integer> itens;
    private int maximo = 10;
    private Random gerador = new Random();

    public Produtor (List <Integer> itens){
        this.itens = itens;
    }

    @Override
    public void run() {
        while (true){
            System.out.println ("Produtor tentando pegar a trava...");
            synchronized (itens){
                while(itens.size() >= maximo); //NO-OP
                int item = gerador.nextInt(6) + 1;
                //System.out.println("Produzido: " + item);
                itens.add(item);
            }
            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

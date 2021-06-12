import java.util.List;
import java.util.Random;

public class Produtor implements Runnable{
    private List<Integer> itens;
    private int maximo = 100;
    private Random gerador = new Random();

    public Produtor (List <Integer> itens){
        this.itens = itens;
    }

    @Override
    public void run()   {
        while (true){
            //System.out.println ("Produtor tentando pegar a trava...");
            synchronized (itens){
               while (itens.size() >= maximo){
                   try {
                       itens.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               int item = gerador.nextInt(6) + 1;
               System.out.printf("Item produzido(%s): %d\n", Thread.currentThread().getName(), item);
               itens.add(item);
               itens.notify();
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

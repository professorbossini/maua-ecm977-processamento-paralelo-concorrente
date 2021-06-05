import java.util.List;

public class Consumidor implements Runnable{

    private List<Integer> itens;
    private int total;
    public Consumidor (List <Integer> itens){
        this.itens = itens;
    }
    @Override
    public void run() {
        while (true){
            synchronized (itens){
                while (itens.isEmpty()){
                    System.out.println ("lista ainda esta vazia...");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int item = itens.get(0);
                total += item;
                itens.remove(0);
                System.out.println("Consumido: " +  item);
                System.out.println("Total: " + total);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

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
                    try {
                        itens.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                total += itens.get(0);
                itens.remove(0);
                itens.notify();
                System.out.printf ("Total consumido:(%s) %d\n", Thread.currentThread().getName(), total);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

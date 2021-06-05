public class Atualizador implements Runnable{

    static int variavel = 0;

    @Override
    public  void run() {

        for (int i = 0; i < 100000; i++){
            synchronized (this){
                //System.out.println ("Thread: " + Thread.currentThread().getName());
                variavel = variavel + 1;
            }
        }
    }
}

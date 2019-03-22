package sample.Componentes;



public class Vengadores extends Thread {

    public Vengadores(String nombre){
        super(nombre);
    }

    @Override
    public void run() {
        super.run();

        try {
            System.out.println("Sale el vengador "+getName());
            for (int i = 1; i <= 10; i++) {
                sleep((long) (Math.random() * 1000));
                System.out.println("Km "+i+": "+getName());
            }
            System.out.println("Llegó a la meta "+getName());
        }
        catch(InterruptedException ie){}
    }
}

import java.util.Random;

class Hilos extends Thread {
    public String nombre;

    int contador;


    public Hilos(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run() {
        do {


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contador++;
        }while(getRandomSleep()==1);
        System.out.println("Soy el hilo nº " + nombre + " y me he repetido: " + contador + " veces");


    }
    public static Integer getRandomSleep() {
        Random r = new Random();
        return (r.nextInt(2));
    }
}
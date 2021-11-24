import java.util.ArrayList;



public class Main {

    static ArrayList<Hilos> resul = new ArrayList<>();

    public static void main(String[] args) {



        for (int i = 1; i < 100; i++) {
            Hilos h1 = new Hilos("Hilos" + i);
            h1.start();
            resul.add(h1);

        }


        for (Hilos h1 : resul) {
            try {
                h1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(escribirFinalistas());
        System.out.println(escribirSubCampeones());
    }





    public static String escribirFinalistas()  {
        int max=0;
        String finals="Hilos finalistas\n";
        for(Hilos hilo : resul){
            if(hilo.contador>max)
                max=hilo.contador;
        }
        for(Hilos hilo : resul){
            if(hilo.contador==max)
                finals+= hilo.nombre + " se ha ejecutado " + hilo.contador + " veces\n";
        }


        return finals;

    }
    public static String escribirSubCampeones()  {
        int maximo1=0, maximo2=0;
        String subcampeon="Hilos Subcampeones\n";
        for(Hilos hilo : resul){
            if(hilo.contador>maximo1)
                maximo1=hilo.contador;
        }
        for(Hilos hilo : resul){
            if(hilo.contador<maximo1 && hilo.contador>maximo2)
                maximo2=hilo.contador;
        }
        for(Hilos hilo : resul){
            if(hilo.contador==maximo2)
                subcampeon+= hilo.nombre + " se ha ejecutado " + hilo.contador + " veces\n";
        }

        return subcampeon;

    }
}
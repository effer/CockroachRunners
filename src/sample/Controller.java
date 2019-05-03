package sample;
import java.util.Random;
public class Controller {
    public static void init(){
        Random random=new Random();
        for(int i=0;i<Main.count;i++){
            Model.containers.add(new CockroachContainer(new Cockroach("tarakan "+i,40+i*30,1+random.nextInt(6))));
        }
    }
    public static void start(){
        for(AnimalContainer t:Model.containers) t.start();
    }
    public static void abort(){
        for(AnimalContainer t:Model.containers)t.abort();
    }

}

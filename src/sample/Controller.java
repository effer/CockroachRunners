package sample;
import java.util.Random;
public class Controller {
    public static void init(){
        abort();
        Random random=new Random();
        for(int i=0;i<Model.count;i++){
            Model.containers.add(new CockroachContainer(new Cockroach("tarakan "+i,40+i*30,2+random.nextInt(9))));
        }
        View.init();
    }
    public static void start(){
        for(AnimalContainer t:Model.containers) t.start();
    }
    public static void abort(){
        for(AnimalContainer t:Model.containers)t.abort();
        Model.abortFlag=false;
    }

}

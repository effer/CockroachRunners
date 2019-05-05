package sample;
import java.util.Random;
public class Controller {
    public static void init(){
        abort();
        Random random=new Random();
        for(int i=0;i<Model.count;i++){
            Model.containers.add(new CockroachContainer(new Cockroach("tarakan "+i,40+i*30,10+random.nextInt(35))));
        }
        View.init();

    }
    public static void start(){
        for(int i=0;i<Model.count;i++)if(!View.tfs[i].getText().equals(""))Model.containers.get(i).getAnimal().setName(View.tfs[i].getText());
        Model.abortFlag=true;
        for(AnimalContainer t:Model.containers) t.start();
    }
    public static void abort(){
        for(AnimalContainer t:Model.containers)t.abort();
        Model.abortFlag=false;

    }
    public static void printResult(){
        for(String t:Model.statusMap.keySet())System.out.println(t+"  "+Model.statusMap.get(t));
    }

}

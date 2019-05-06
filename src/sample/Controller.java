package sample;
import java.util.Random;
public class Controller {
    private static Observer obs;
    public static void init(){
        abort();
        Random random=new Random();
        for(int i=0;i<Model.count;i++){
            Model.containers.add(new CockroachContainer(i,new Cockroach("таракан "+i,40+i*30,15+random.nextInt(35))));
        }
        for(AnimalContainer t:Model.containers )Model.nameSet.add(t.getAnimal().getName());
        View.init();
        View.at.start();
    }
    public static void start(){
        if(!Model.abortFlag) {
            System.out.println("старт забега "+Model.runNumber);
            obs=new Observer();
            obs.start();
        }

        for(int i=0;i<Model.count;i++)if(!View.tfs[i].getText().equals(""))Model.containers.get(i).getAnimal().setName(View.tfs[i].getText());
        Model.abortFlag=true;
        for(AnimalContainer t:Model.containers) t.start();
    }
    public static void abort(){
        for(AnimalContainer t:Model.containers)t.abort();
        if(obs!=null)obs.abort();
        Model.abortFlag=false;

    }
    public static void printResult(){

    }

}

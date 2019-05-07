package sample;
import java.util.Random;
public class Controller {
    public static Observer obs;
    public static boolean readyToStart=false;
    public static void init(){
        Model.resetLeader();
        Model.nameSet.clear();
        readyToStart=true;
        abort();
        Random random=new Random();
        Model.containers.clear();
        for(int i=0;i<Model.count;i++){
            Model.containers.add(new CockroachContainer(i,new Cockroach("таракан "+(i+1),40+i*30,15+random.nextInt(35))));
        }
        for(AnimalContainer t:Model.containers )Model.nameSet.add(t.getAnimal().getName());
        View.init();
        View.at.start();
    }
    public static void start(){
        if(readyToStart){
            if(!Model.abortFlag) {
                System.out.println("старт забега "+Model.runNumber);
                obs=new Observer();
                obs.start();
            }

            for(int i=0;i<Model.count;i++)if(!View.tfs[i].getText().equals(""))Model.containers.get(i).getAnimal().setName(View.tfs[i].getText());
            Model.abortFlag=true;
            for(AnimalContainer t:Model.containers) t.start();
        }
    }
    public static void abort(){
        for(AnimalContainer t:Model.containers)t.abort();
        if(obs!=null)obs.abort();
        Model.abortFlag=false;

    }


}

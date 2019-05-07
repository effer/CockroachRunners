package sample;
import java.util.List;
import java.util.ArrayList;
public class Observer implements Runnable {
    private List<String>result =new ArrayList<>();
    private boolean flag=false;
    private boolean stopFlag=false;
    public void run(){
        while(this.flag){
            try{
                for(AnimalContainer t:Model.containers){
                    if((t.isFinished())&&!this.result.contains(t.getAnimal().getName())){
                        this.result.add(t.getAnimal().getName());
                    }
                }
            }
            catch(Exception ex){this.result.clear();}
            if(this.result.size()==Model.count) printResult();
            if(this.stopFlag)break;
        }
    }
    private Thread thread;
    public void start(){
        if(this.thread==null){
            this.thread=new Thread(this);
            this.flag=true;
            thread.start();
        }
    }
    public void printResult(){
        for(int i=0;i<Model.count;i++)System.out.println(i+1+" prishel "+this.result.get(i));
        this.flag=false;
        this.result=null;
        Model.abortFlag=false;
        Model.runNumber++;
        Controller.readyToStart=false;
    }
    public void abort(){
        this.stopFlag=true;
    }

}

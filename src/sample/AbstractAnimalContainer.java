package sample;
import javafx.scene.Group;
abstract public class AbstractAnimalContainer implements AnimalContainer {
    private Thread thread;
    protected boolean abortFlag=false;
    protected Animal animal;
    protected AnimalDrawer drawer;
    protected boolean finished=false;
    protected boolean running=false;
    protected int step;
    protected int distance;
    protected int index;
    protected int boostCoefficient;
    public int getIndex(){return this.index;}
    abstract public void run();
    public void start(){
        this.running=true;
        if(thread==null){
            thread=new Thread(this);
            this.finished=false;
            thread.start();
        }
    }
    abstract public void boost();
    public void draw(){
        drawer.draw(animal);
    }
    public boolean isFinished(){return this.finished;}
    public boolean isRunning(){return this.running;}
    public Animal getAnimal(){return this.animal;}
    public void abort(){
        this.finished=false;
        this.abortFlag=true;
        this.drawer.abort();
    }

}

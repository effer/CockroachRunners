package sample;
import javafx.scene.Group;
abstract public class AbstractAnimalContainer implements AnimalContainer {
    private Thread thread;
    protected Animal animal;
    protected AnimalDrawer drawer;
    protected boolean finished=false;
    protected boolean running=false;
    protected int step;
    protected int distance;
    abstract public void run();
    public void start(){
        this.running=true;
        if(thread==null){
            thread=new Thread(this);
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
        this.finished=true;
        this.animal.setX(0);
    }
}

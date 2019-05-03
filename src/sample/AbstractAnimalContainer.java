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
        thread=new Thread(this);
    }
    abstract public void boost();
    public void draw(){
        drawer.draw(animal);
    }
    public boolean isFinished(){return this.finished;}
    public boolean isRunning(){return this.running;}
}
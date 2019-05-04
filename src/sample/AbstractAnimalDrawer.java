package sample;
import javafx.scene.Group;

abstract public class AbstractAnimalDrawer implements AnimalDrawer{
    abstract public void draw(Animal animal);
    protected static Group root;
    public static void setContext(Group group){
        root=group;
    }
    abstract public void abort();
}

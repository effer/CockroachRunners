package sample;
import javafx.scene.Group;

abstract public class AbstractAnimalDrawer implements AnimalDrawer{
    abstract public void draw(Animal animal);
    protected Group root;
    public AbstractAnimalDrawer(Group group){
        this.root=group;
    }
}

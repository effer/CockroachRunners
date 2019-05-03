package sample;
import javafx.scene.Group;
import javafx.scene.shape.Ellipse;
public class CockroachDrawer extends AbstractAnimalDrawer {
    protected Ellipse el=new Ellipse(0,0);
    public CockroachDrawer(Group group){
        super(group);
    }

    public void draw(Animal animal){
        el.setCenterX(animal.getX()+20);
        el.setCenterY(animal.getY()+50);;
        el.setRadiusX(20);
        el.setRadiusY(15);
    }
}

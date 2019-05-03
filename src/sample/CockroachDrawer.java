package sample;
import javafx.scene.shape.Ellipse;
public class CockroachDrawer extends AbstractAnimalDrawer {
    protected Ellipse el=new Ellipse();
    public CockroachDrawer(){
        root.getChildren().add(this.el);
    }

    public void draw(Animal animal){
        el.setCenterX(animal.getX()+20);
        el.setCenterY(animal.getY()+50);;
        el.setRadiusX(20);
        el.setRadiusY(15);
    }
}

package sample;
import javafx.scene.shape.Ellipse;
public class CockroachDrawer extends AbstractAnimalDrawer {
    protected Ellipse el=new Ellipse();
    public CockroachDrawer(){
        root.getChildren().add(this.el);
    }

    public void draw(Animal animal){
        el.setCenterX(animal.getX()+120);
        el.setCenterY(animal.getY()+50);;
        el.setRadiusX(20);
        el.setRadiusY(13);
    }
    public void abort(){
        root.getChildren().remove(this.el);
    }
}

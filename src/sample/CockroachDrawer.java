package sample;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Ellipse;

public class CockroachDrawer extends AbstractAnimalDrawer {
    protected Ellipse el=new Ellipse();
    public CockroachDrawer(){
        root.getChildren().add(this.el);
    }
    private int click=0;
    public void draw(Animal animal){
        el.setCenterX(animal.getX()+120);
        el.setCenterY(animal.getY()+50);;
        el.setRadiusX(20);
        el.setRadiusY(13);
        el.setOnMouseClicked(event->{
            this.click++;
        });
    }
    public void abort(){
        root.getChildren().remove(this.el);
    }
    public boolean boostFlag(){
        if(this.click==2){
            this.click=0;
            return true;
        }
        return false;
    }
}

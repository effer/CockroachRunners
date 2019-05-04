package sample;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
public class View {
    public static void draw(){
        if(Model.containers!=null)for(AnimalContainer t:Model.containers)t.draw();
    }
    private static TextField[] tfs;
    private static Label[] lbs;
    public static void init(){
        tfs=new TextField[Model.count];
        lbs=new Label[Model.count];
        System.gc();
        for(int i=0;i<Model.count;i++){
            tfs[i]=new TextField();
            lbs[i]=new Label();
            tfs[i].setLayoutX(650);
            tfs[i].setLayoutY(80+i*30);
            lbs[i].setLayoutX(10);
            lbs[i].setLayoutY(80+i*30);
            lbs[i].setText(Model.containers.get(i).getAnimal().getName());
        }
        Main.root.getChildren().addAll(tfs);
        Main.root.getChildren().addAll(lbs);

    }
}

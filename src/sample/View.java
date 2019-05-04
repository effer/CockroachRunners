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
        for(int i=0;i<Model.count;)
        Main.root.getChildren().addAll(tfs);
        Main.root.getChildren().addAll(lbs);

    }
}

package sample;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import java.util.Set;
import java.util.TreeSet;
public class View {
    private static int i;
    public static Set<String> result=new TreeSet<>();
    public static void draw(){
        if(Model.containers!=null)for(AnimalContainer t:Model.containers){
            t.draw();
            if(t.isFinished()){result.add(i+"прибежал "+t.getAnimal().getName());i++;}
        }
    }
    public static TextField[] tfs;
    private static Label[] lbs;
    private static Line[] lines;
    public static void init(){
        i=1;
        tfs=new TextField[Model.count];
        lbs=new Label[Model.count];
        lines=new Line[Model.count];
        System.gc();
        for(int i=0;i<Model.count;i++){
            lines[i]=new Line(90,75+i*30,650,75+i*30);
            tfs[i]=new TextField();
            lbs[i]=new Label();
            tfs[i].setLayoutX(655);
            tfs[i].setLayoutY(80+i*30);
            lbs[i].setLayoutX(10);
            lbs[i].setLayoutY(80+i*30);
            lbs[i].setText(Model.containers.get(i).getAnimal().getName());

        }
        Line line1=new Line(90,75+(Model.count)*30,650,75+(Model.count)*30);
        Line line2=new Line(650,75,650,75+Model.count*30);
        Main.root.getChildren().add(line1);
        Main.root.getChildren().add(line2);
        Main.root.getChildren().addAll(lines);
        Main.root.getChildren().addAll(tfs);
        Main.root.getChildren().addAll(lbs);

    }
}

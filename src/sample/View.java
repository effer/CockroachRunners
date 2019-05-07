package sample;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import java.util.Set;
import java.util.TreeSet;
import javafx.animation.AnimationTimer;
public class View {
    public static AnimationTimer at=new AnimationTimer() {
        @Override
        public void handle(long now) {
            if(Model.isAllFinished()){
                stop();
                Model.abortFlag=false;
                Model.runNumber++;
            }
            View.draw();
        }
    };;
    private static int i=1;
    public static void resetI(){i=1;}
    public static Set<String> result=new TreeSet<>();
    public static void draw(){
        Main.lead.setText("Лидер "+Model.getLeaderName());

        if(Model.containers!=null)for(AnimalContainer t:Model.containers){
            t.draw();
            if((!tfs[t.getIndex()].getText().equals("")&&!Model.nameSet.contains(tfs[t.getIndex()].getText()))){//тут переименовываются тараканы, которым ввели новое имя в тесктовое поле
                Model.nameSet.remove(t.getAnimal().getName());//удаляем старое имя таракана из множества имен
                t.getAnimal().setName(tfs[t.getIndex()].getText());
                Model.nameSet.add(tfs[t.getIndex()].getText());//добавляем новое имя в множество имен
                lbs[t.getIndex()].setText(t.getAnimal().getName());
            }


        }
    }
    public static TextField[] tfs;
    private static Label[] lbs;
    private static Line[] lines;
    private static final int textFieldsLayoutX=655;
    private static final int controlsLayoutMinY=80;
    private static final int controlsLayoutYStep=30;
    private static final int startRoadX=90;
    private static final int roadMinY=75;
    private static final int roadEndX=650;
    public static void init(){
        i=1;
        if(tfs!=null) {
            //удаляем текстовые поля и лейблы с именами тараканов предыдущего забега
            Main.root.getChildren().removeAll(tfs);
            Main.root.getChildren().removeAll(lbs);
            System.gc();
        }
        tfs=new TextField[Model.count];
        lbs=new Label[Model.count];
        lines=new Line[Model.count];
        System.gc();
        for(int i=0;i<Model.count;i++){//тут создаются лейблы и текстовые поля для нового забега
            lines[i]=new Line(startRoadX,roadMinY+i*controlsLayoutYStep,roadEndX,roadMinY+i*controlsLayoutYStep);
            tfs[i]=new TextField();
            lbs[i]=new Label();
            tfs[i].setLayoutX(textFieldsLayoutX);
            tfs[i].setLayoutY(controlsLayoutMinY+i*controlsLayoutYStep);
            lbs[i].setLayoutX(10);
            lbs[i].setLayoutY(controlsLayoutMinY+i*controlsLayoutYStep);
            lbs[i].setText(Model.containers.get(i).getAnimal().getName());

        }
        Line line1=new Line(startRoadX,roadMinY+(Model.count)*controlsLayoutYStep,roadEndX,roadMinY+(Model.count)*controlsLayoutYStep);
        Line line2=new Line(roadEndX,roadMinY,roadEndX,roadMinY+Model.count*controlsLayoutYStep);
        Main.root.getChildren().add(line1);
        Main.root.getChildren().add(line2);
        Main.root.getChildren().addAll(lines);
        Main.root.getChildren().addAll(tfs);
        Main.root.getChildren().addAll(lbs);

    }
}

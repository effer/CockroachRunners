package sample;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
public class Main extends Application {
    public static Group root=new Group();
    public static Label lead=new Label("Лидер  ");

    @Override
    public void start(Stage primaryStage) throws Exception{
        CockroachDrawer.setContext(root);
        Controller.init();
        Button btn=new Button("Create");
        Button startBtn=new Button("start");
        startBtn.setLayoutX(150);
        lead.setLayoutX(300);
        lead.setLayoutY(10);
        startBtn.setOnAction(event->{
            Controller.start();
       //     Model.abortFlag=true;
        });

        btn.setOnAction(event->{
            if(Model.abortFlag){
                System.out.println("забег "+Model.runNumber+" прерван");
                Model.runNumber++;
            }
            Controller.init();


        });
        ScrollPane sc=new ScrollPane(root);
        Scene scene=new Scene(sc,900,875);
        root.getChildren().add(lead);
        root.getChildren().add(btn);
        root.getChildren().add(startBtn);
        primaryStage.setTitle("cockroach runners");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        if(args.length<1){
            System.out.println("nuzhen argument");
            System.exit(0);
        }
        try{Model.count=Integer.parseInt(args[0]);}
        catch(Exception ex){
            System.out.println("Nado vvesti chislo");
        }
        if(Model.count==0)System.exit(0);
        launch(args);
    }
}

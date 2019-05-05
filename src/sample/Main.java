package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;
import javafx.scene.control.ScrollPane;
public class Main extends Application {
    private AnimationTimer at;
    public static Group root=new Group();

    @Override
    public void start(Stage primaryStage) throws Exception{
        CockroachDrawer.setContext(root);
        Controller.init();
        at=new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(Model.isAllFinished()){
                    stop();
                    Model.abortFlag=false;
                    Controller.printResult();
                    Model.runNumber++;
                }
                View.draw();
            }
        };
        at.start();
        Button btn=new Button("Create");
        Button startBtn=new Button("start");
        startBtn.setLayoutX(150);
        startBtn.setOnAction(event->{
            Controller.start();
            Model.abortFlag=true;
        });

        btn.setOnAction(event->{

            if(Model.abortFlag){
                System.out.println("забег "+Model.runNumber+" прерван");
                Model.runNumber++;
            }
            Controller.init();
        /*    at=new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if(Model.isAllFinished()){
                        stop();
                        Model.abortFlag=false;
                        Controller.printResult();
                    }
                    View.draw();
                }
            };*/
            at.start();

        });
        ScrollPane sc=new ScrollPane(root);
        Scene scene=new Scene(sc,900,875);
        scene.setOnMouseClicked(event->{
            System.out.println("цлицк");
        });
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

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;
public class Main extends Application {
    public static int count=15;
    private AnimationTimer at;
    public static Group root=new Group();

    @Override
    public void start(Stage primaryStage) throws Exception{
        CockroachDrawer.setContext(root);

        Button btn=new Button("Create");
        Button startBtn=new Button("start");
        Button abort=new Button("abort");
        abort.setLayoutX(220);
        startBtn.setLayoutX(150);
        startBtn.setOnAction(event->{

            Controller.start();
        });
        btn.setOnAction(event->{

            Controller.init();
            at=new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if(Model.isAllFinished())stop();
                    View.draw();
                }
            };
            at.start();

        });
        abort.setOnAction(event->{
            Controller.abort();
        });
        root.getChildren().add(btn);
        root.getChildren().add(startBtn);
        root.getChildren().add(abort);
        primaryStage.setTitle("cockroach runners");
        primaryStage.setScene(new Scene(root, 900, 875));
        primaryStage.show();
    }


    public static void main(String[] args) {
        try{count=Integer.parseInt(args[0]);}
        catch(Exception ex){
            System.out.println("Nado vvesti chislo");
        }
        if(count==0)System.exit(0);
        launch(args);
    }
}

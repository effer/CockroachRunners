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

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root=new Group();
        CockroachDrawer.setContext(root);

        Button btn=new Button("TEST");
        btn.setOnAction(event->{
            at=new AnimationTimer() {
                @Override
                public void handle(long now) {
                    View.draw();
                    if(Model.isAllFinished())stop();
                }
             };
            Controller.init();
            Controller.start();
            at.start();

        });
        root.getChildren().add(btn);
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

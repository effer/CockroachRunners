package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Main extends Application {
    private static int count;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root=new Group();
        primaryStage.setTitle("cockroach runners");
        primaryStage.setScene(new Scene(root, 300, 275));
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

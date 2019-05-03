package sample;

public class View {
    public static void draw(){
        for(AnimalContainer t:Model.containers)t.draw();
    }
}

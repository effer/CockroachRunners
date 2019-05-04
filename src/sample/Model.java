package sample;
import java.util.List;
import java.util.ArrayList;

public class Model {
    public static int count;
    public static List<AnimalContainer> containers=new ArrayList<>();
    public static boolean isAllFinished(){
        boolean res=true;
        for(AnimalContainer t:containers)res=res&&t.isFinished();
        return res;
    }
    public static boolean abortFlag=false;
}

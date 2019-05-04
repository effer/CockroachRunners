package sample;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Model {
    public static int count;
    public static List<AnimalContainer> containers=new ArrayList<>();
    public static boolean isAllFinished(){
        boolean res=true;
        for(AnimalContainer t:containers)res=res&&t.isFinished();
        return res;
    }
    public static boolean abortFlag=false;
    public static Map<String,Integer> statusMap =new TreeMap<>();
}

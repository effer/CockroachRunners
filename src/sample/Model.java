package sample;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;

public class Model {
    public static Set<String> nameSet=new TreeSet<>();
    public static int runNumber=1;
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

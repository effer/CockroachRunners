package sample;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;


public class Model {
    public static Set<String> nameSet=new TreeSet<>();//множество имен тараканов
    public static int runNumber=1;//номер забега
    public static int count;//количество тараканов в забеге
    public static List<AnimalContainer> containers=new ArrayList<>();//список контейнеров тараканов
    public static boolean isAllFinished(){
        boolean res=true;
        for(AnimalContainer t:containers)res=res&&t.isFinished();
        return res;
    }
    public static boolean abortFlag=false;//флаг работы кнопки create, влияет на поведение Controller.start. если true, то при нажатии на create гонка сбросится
}

package sample;

abstract public class AbstractAnimal implements Animal{
    protected int x=0;
    protected int y=0;
    protected int delay=1;
    protected String name;
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getDelay(){return this.delay;}
    public String getName(){return this.name;}
    public void setX(int x){this.x=x;}
    public AbstractAnimal(String name, int y, int delay){
        this.y=y;
        this.delay=delay;
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }
}

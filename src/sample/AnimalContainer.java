package sample;

public interface AnimalContainer extends Runnable{
    public void run();
    public void start();
    public void boost();
    public boolean isRunning();
    public boolean isFinished();
    public void draw();
    public Animal getAnimal();
    public void abort();
}

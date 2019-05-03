package sample;

public class CockroachContainer extends AbstractAnimalContainer {
    public CockroachContainer(Animal animal){
        this.animal=animal;
        this.drawer=new CockroachDrawer();
        this.distance=500;
        this.step=1;
    }
    public void run(){
        while((this.animal.getX()<this.distance)&&!this.finished){
            if(this.animal.getX()+this.step<this.distance)this.animal.setX(this.animal.getX()+this.step);
            else this.animal.setX(this.distance);
            try{
                Thread.sleep(this.animal.getDelay());
            }
            catch (Exception ex){
                System.out.println("oshibka timera");
            }
        }
        this.finished=true;

    }
    public void boost(){
        if(this.animal.getX()+7*this.step<this.distance)this.animal.setX(this.animal.getX()+7*this.step);
        else this.animal.setX(this.animal.getX()+7*this.step);
    }

}

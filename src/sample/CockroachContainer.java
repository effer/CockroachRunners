package sample;

public class CockroachContainer extends AbstractAnimalContainer {
    public CockroachContainer(int index,Animal animal){
        this.index=index;
        this.animal=animal;
        this.drawer=new CockroachDrawer();
        this.distance=500;
        this.step=2;
        this.finished=false;
        this.boostCoefficient=100;
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
            if(this.drawer.boostFlag())this.boost();//если 2 раза кликнули, ускорить
        }
        if(!this.abortFlag)this.finished=true;

    }
    public void boost(){
        if(this.animal.getX()+this.boostCoefficient*this.step<this.distance)this.animal.setX(this.animal.getX()+this.boostCoefficient*this.step);
        else this.animal.setX(this.distance);
    }

}

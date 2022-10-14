public class ballObserver implements Observer{

    private Ball theBall;

    private Double xPos;
    private Double yPos;


    public ballObserver(Ball ball){
        this.theBall = ball;
    }

    @Override
    public void update(){
        xPos = theBall.getxPos();
        yPos = theBall.getyPos();
    }

    @Override
    public void observe(){
        String s1 = "The xPos is "+ xPos.toString();
        String s2 = "The yPos is "+ yPos.toString();
        System.out.print(s1 + "\n"+ s2);

    }

}

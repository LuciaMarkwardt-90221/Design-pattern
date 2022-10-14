package Balls;

import Balls.Observer;

public interface Subject{

    public void attach(Observer o);

    public void detach(Observer o);

    public void notifyObserver();

}
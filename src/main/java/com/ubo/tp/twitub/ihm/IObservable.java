package main.java.com.ubo.tp.twitub.ihm;

public interface IObservable {
	void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
}

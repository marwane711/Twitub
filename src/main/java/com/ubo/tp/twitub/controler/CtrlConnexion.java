package main.java.com.ubo.tp.twitub.controler;

import java.util.ArrayList;
import java.util.List;

import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.ihm.IObservable;
import main.java.com.ubo.tp.twitub.ihm.IObserver;

public class CtrlConnexion implements IObservable {
	
	private IDatabase mDatabase;
	private User user;
	private List<IObserver> observers;
	
	public CtrlConnexion(IDatabase mDatabase){
		this.mDatabase = mDatabase;
		this.user = null;
		this.observers = new ArrayList<>();
	}
	
	public void checkConnexion(String name, String password){
		User user = null;
    	for(User u : this.mDatabase.getUsers()) {
    		if(u.getUserTag().equals(name) && u.getUserPassword().equals(password)) {
    			user = u;
    			this.user = u;
    			System.out.println("Connecte");
    			notifyObservers();
    		}
    	}
    	if(user == null) {
    		System.out.println("Utilisateur introuvable");
    	}
    }

	@Override
	public void notifyObservers() {
		System.out.println("notify");
		for(IObserver o : this.observers) {
			o.update(this);
		}
	}

	@Override
	public void addObserver(IObserver observer) {
        this.observers.add(observer);
    }
	
    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }
    
    public boolean getEtatConnex() {
    	return this.user != null;
    }
    
    public User getUser() {
    	return this.user;
    }
}

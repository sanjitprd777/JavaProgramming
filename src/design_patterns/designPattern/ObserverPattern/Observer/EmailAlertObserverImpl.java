package ObserverPattern.Observer;

import ObserverPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    StockObservable stockObservable;
    String email;

    public EmailAlertObserverImpl(String email, StockObservable stockObservable) {
        this.stockObservable = stockObservable;
        this.email = email;
        this.stockObservable.add(this);
    }

    @Override
    public void update() {
        System.out.println("Notifying user on their email id: " + email
                + " for the product " + stockObservable.getName());
    }
}

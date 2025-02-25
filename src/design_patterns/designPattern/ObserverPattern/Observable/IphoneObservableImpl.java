package ObserverPattern.Observable;

import ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {

    List<NotificationAlertObserver> notificationAlertObserverList = new ArrayList<>();
    public int stockCount = 0;
    final String name = "Iphone";

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        notificationAlertObserverList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubs() {
        for(NotificationAlertObserver notificationAlertObserver : notificationAlertObserverList) {
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        if (stockCount == 0 && newStockCount > 0) {
            notifySubs();
        }
        stockCount = stockCount + newStockCount;
    }

    @Override
    public int getCount() {
        return stockCount;
    }
    
    public String getName() {
        return name;
    }
}

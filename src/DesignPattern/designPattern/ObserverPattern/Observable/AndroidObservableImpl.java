package ObserverPattern.Observable;

import ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class AndroidObservableImpl implements StockObservable {

    String name = "Android";
    int stockCount=0;
    List<NotificationAlertObserver> notificationAlertObserverList = new ArrayList<>();

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
        for (NotificationAlertObserver notificationAlertObserver : notificationAlertObserverList) {
            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        if (stockCount == 0 && newStockCount>0) {
            notifySubs();
        }
        stockCount = stockCount + newStockCount;
    }

    @Override
    public int getCount() {
        return stockCount;
    }

    @Override
    public String getName() {
        return name;
    }
}

import controller.Observable;
import view.Window;


public class AppInitializer {
    public static void main(String[] args) {
        Observable observable = Observable.getInstance();
        observable.SetOb(new Window("Sender 1", 50));
        observable.SetOb(new Window("Sender 2", 350));
        observable.SetOb(new Window("Sender 3",650));

    }
}

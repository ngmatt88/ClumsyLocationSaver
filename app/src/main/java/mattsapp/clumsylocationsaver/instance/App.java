package mattsapp.clumsylocationsaver.instance;

import android.app.Application;

/**
 * Created by Matt on 4/24/2017.
 */

public class App extends Application {
    private static App instance;
    public static App getAppContext() { return instance; }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
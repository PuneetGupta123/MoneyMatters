package dell.moneymatters;

import com.firebase.client.Firebase;

/**
 * Created by vineet on 10/1/16.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}

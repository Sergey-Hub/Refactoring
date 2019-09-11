package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.MyListsPageObject;
import lib.ui.android.AndroidMyListPageObject;
import lib.ui.ios.iOSMyListPageObject;

public class MyListPageObjectFactory {

    public static MyListsPageObject get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMyListPageObject(driver);
        } else {
            return new iOSMyListPageObject(driver);
        }
    }

}
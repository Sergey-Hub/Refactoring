package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class iOSMyListPageObject extends MyListsPageObject {

    static {
        ARTICLE_BY_TITLE_TMP = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
    }

    public iOSMyListPageObject(AppiumDriver driver) {
        super(driver);
    }

}

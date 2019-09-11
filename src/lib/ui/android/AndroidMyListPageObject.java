package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListPageObject extends MyListsPageObject {

    static {
        FOLDER_BY_NAME_TMP = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TMP = "xpath://*[@text='{TITLE}']";
    }

    public AndroidMyListPageObject(AppiumDriver driver) {
        super(driver);
    }

}
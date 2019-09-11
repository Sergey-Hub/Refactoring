package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
            FOLDER_BY_NAME_TMP,
            ARTICLE_BY_TITLE_TMP;

    private static String getFolderXpathByName(String name_of_folder) {
        return FOLDER_BY_NAME_TMP.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE_TMP.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openFolderByName(String name_of_folder) {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name: " + name_of_folder,
                5
        );
    }

    public void swipeByArticleToDelete(String article_title) {
        waitForArticleToAppearByTitle(article_title);
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                article_title_xpath,
                "Cannot find saved article"
        );

        if (Platform.getInstance().isIOS()) {
            clickElementToTheRightUpperCorner(article_title_xpath, "Cannot find saved article");
        }

        waitForArticleToDisappearByTitle(article_title);
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(
                article_title_xpath, "Cannot find saved article with title: " + article_title,
                10);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_title_xpath, "Saved article still present with title: " + article_title,
                10);
    }

}

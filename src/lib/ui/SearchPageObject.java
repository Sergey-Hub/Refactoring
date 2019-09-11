package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class SearchPageObject extends MainPageObject {

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_STRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT,
            SEARCH_LIST_ITEM_TITLE,
            SEARCH_RESULT_BY_STRING_AND_DESCRIPTION_TPL;

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    /* TEMPLATES METHODS*/
    private static String getResultsSearchElement(String substring) {
        return SEARCH_RESULT_BY_STRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultsSearchElementByTitleAndDescription(String title, String description) {
        return SEARCH_RESULT_BY_STRING_AND_DESCRIPTION_TPL.replace("{SUBSTRING}", title).replace("{DESCRIPTION}", description);
    }
    /* TEMPLATES METHODS*/

    public void waitForElementByTitleAndDescription(String title, String description) {
        String xpath = getResultsSearchElementByTitleAndDescription(title, description);
        this.waitForElementPresent(xpath, "Cannot find search result with title: " + title + " and description: " + description);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 10);
        this.waitForElementPresent(SEARCH_INPUT, "Cannot find search input after clicking search init element");
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line,"Cannot find and type into search input", 10);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultsSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultsSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring: " + substring, 15);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find cancel search button", 10);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 10);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click cancel search button", 10);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the given request",
                15
        );
        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel() {
        this.waitForElementPresent(
                SEARCH_EMPTY_RESULT_ELEMENT,
                "Cannot find empty result label",
                15
        );
    }

    public void assertThereIsNoResultOfSearch() {
        this.assertElementNotPresent(SEARCH_EMPTY_RESULT_ELEMENT, "We are supposed to not find any results");
    }

    public void waitForListItemTitleToAppear() {
        this.waitForElementPresent(
                SEARCH_LIST_ITEM_TITLE,
                "Can't find item titles",
                15
        );
    }

    public void checkIfItemTitleHasSpecifiedWord(String word, int howManyItemTitlesToCheck) {
        this.ifTitlesHaveSpecificWord(
                SEARCH_LIST_ITEM_TITLE,
                word,
                howManyItemTitlesToCheck
        );
    }

    public void checkIfAllItemTitlesHaveSpecifiedWord(String word) {
        this.ifTitlesHaveSpecificWord(
                SEARCH_LIST_ITEM_TITLE,
                word,
                this.sizeOfTitles(SEARCH_LIST_ITEM_TITLE)
        );
    }

}
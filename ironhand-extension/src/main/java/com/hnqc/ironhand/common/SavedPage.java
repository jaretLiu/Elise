package com.hnqc.ironhand.common;

import com.hnqc.ironhand.Page;

/**
 * SavedPage
 *
 * @author zido
 * @date 2018 /04/27
 */
public class SavedPage {
    private String url;
    private Page page;

    /**
     * The interface Saved listener.
     */
    public interface SavedListener {

        /**
         * On save string.
         *
         * @param rawText the raw text
         * @return the url
         */
        String onSave(byte[] rawText);
    }

    /**
     * The interface Read listener.
     */
    public interface ReadListener {
        /**
         * Read string.
         *
         * @param url the url
         * @return the string
         */
        String read(String url);
    }

    /**
     * Resolve page saved page.
     *
     * @param page     the page
     * @param listener the listener
     * @return the saved page
     */
    public static SavedPage resolvePage(Page page, SavedListener listener) {
        byte[] rawText = page.getBytes();
        page.setRawText(null);
        page.setBytes(null);
        SavedPage savedPage = new SavedPage();
        savedPage.url = listener.onSave(rawText);
        savedPage.page = page;
        return savedPage;
    }

    /**
     * Gets page.
     *
     * @param savedPage the saved page
     * @param listener  the listener
     * @return the page
     */
    public static Page resolvePage(SavedPage savedPage, ReadListener listener) {
        String rawTest = listener.read(savedPage.url);
        Page page = savedPage.page;
        page.setRawText(rawTest);
        return page;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets page.
     *
     * @return the page
     */
    public Page getPage() {
        return page;
    }

    /**
     * Sets page.
     *
     * @param page the page
     */
    public void setPage(Page page) {
        this.page = page;
    }
}

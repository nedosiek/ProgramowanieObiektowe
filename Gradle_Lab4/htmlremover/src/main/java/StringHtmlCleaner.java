//package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class StringHtmlCleaner {
    public static String cleanHtml(String textToClean) {
        Document document = Jsoup.parse(textToClean);
        return document.text();
    }
}

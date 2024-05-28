//package org.example;
import java.io.IOException;
import org.jsoup.*;

public class PageDownloadingUtility {
    private PageDownloadingUtility() {
    }
    public static String download(String url) {
        try {
            return Jsoup.connect(url).get().html();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
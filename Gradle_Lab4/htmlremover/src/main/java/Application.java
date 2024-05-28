public class Application {
    public static void main(String[] args){
        String html_text = PageDownloadingUtility.download(args[0]);
        String clean_html = StringHtmlCleaner.cleanHtml(html_text);
        System.out.println(clean_html);
    }
}

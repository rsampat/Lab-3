import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int wordScanner(final String url) {
        return (urlToString(url).split(" ")).length;
    }
    public static int uniqueWord(final String url) {
        Set set = new HashSet<String>();
        String[] words = urlToString(url).split(" ");
        for(String str: words) {
            set.add(str);
        }
        return set.size();
    }
    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordScanner("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(uniqueWord("http://erdani.com/tdpl/hamlet.txt"));

    }
}

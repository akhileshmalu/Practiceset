import java.util.HashMap;

/**
 *
 * Idea is to store long url with some id and convert this id into base 62 number.
 * Store all long urls into a hashmap / database
 *
 * long to short  => create new id & create shorturl by converting id into base 62 string
 *
 * short to long => find id number by converting base62 string to decimal number and fetch from map/ dictionary
 *
 * @author: Akhilesh Maloo
 * @date: 2/7/18.
 */
public class TinyUrl {

    HashMap<Integer, String> longUrlDictionary;
    private int count;
    private String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    TinyUrl() {
        longUrlDictionary = new HashMap<>();
        count = 0;
    }

    public String getShortUrl(String longUrl) {
        count++;
        longUrlDictionary.put(count, longUrl);
        return numToShortUrl(count);
    }

    public String getLongUrl(String shortUrl) {
        int key = shortUrltoInt(shortUrl);
        return longUrlDictionary.get(key);
    }

    /**
     * Base 62 conversion
     * @param num
     * @return
     */
    public String numToShortUrl(int num) {

        StringBuilder shortUrl = new StringBuilder();

        while(num > 0) {
            shortUrl.append(chars.charAt(num % 62));
            num /= 62;
        }
        return shortUrl.reverse().toString();
    }

    public int shortUrltoInt(String shortUrl) {
        int num = 0;

        for (char c: shortUrl.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                num = num * 62 + (c - 'a');
            }
            if(c >= 'A' && c <= 'Z') {
                num = (num * 62) + (c - 'A') + 26;
            }
            if(c >= '0' && c <= '9') {
                num = (num * 62) + (c - '0') + 52;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        TinyUrl tinyUrl = new TinyUrl();
        String gShort = tinyUrl.getShortUrl("www.google.com");
        String g1Short = tinyUrl.getShortUrl("www.google.com/123/abc.php");
        String yShort = tinyUrl.getShortUrl("www.yahoo.com");
        String rShort = tinyUrl.getShortUrl("www.rediffmail.com");

        System.out.println(gShort + " " + g1Short + " " + yShort + " " + rShort);

        System.out.println(tinyUrl.longUrlDictionary);


    }

}

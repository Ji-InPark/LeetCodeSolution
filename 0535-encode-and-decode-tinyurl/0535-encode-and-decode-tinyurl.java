public class Codec {
    HashMap<Integer, String> encodeMap = new HashMap<>();
    HashMap<String, Integer> decodeMap = new HashMap<>();
    int index = 0;

    public String encode(String longUrl) {
        if(!decodeMap.containsKey(longUrl)) {
            encodeMap.put(index, longUrl);
            decodeMap.put(longUrl, index++);
        }

        return "http://tinyurl.com/" + decodeMap.get(longUrl);
    }

    public String decode(String shortUrl) {
        int input = Integer.parseInt(shortUrl.substring(19));
        
        return encodeMap.get(input);
    }
}

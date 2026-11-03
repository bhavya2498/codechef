// Problem: Encode and Decode TinyURL
// Platform: leetcode
// Rating/Difficulty: Unrated
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/encode-and-decode-tinyurl/
// Solved on: 2026-11-03T17:54:46.253Z


import java.util.*;

public class Codec {

    private Map<String, String> map = new HashMap<>();
    private int id = 1;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String shortUrl = "http://tinyurl.com/" + id;

        map.put(shortUrl, longUrl);

        id++;

        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        return map.get(shortUrl);
    }
}

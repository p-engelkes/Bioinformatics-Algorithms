package week9;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 13.01.14
 * Time: 12:00
 */
public class ConstructSuffixTrie {

    private String text;
    private List<String> patterns;

    public ConstructSuffixTrie(String text) {
        this.text = text;
        patterns = constructPatterns(this.text);
    }

    public List<String> constructPatterns(String text) {
        List<String> patterns = new ArrayList<String>();
        for (int i = 0; i < text.length(); i++) {
            String pattern = text.substring(i);
            patterns.add(pattern);
        }

        return patterns;
    }
}

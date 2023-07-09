package System.Book;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWord {
    protected List<String> replaceWord(ArrayList<String> separate, String originalWord, String replacementWord) {

        for (int i = 0; i < separate.size(); i++) {
            if (separate.get(i).equals(originalWord)) {
                separate.set(i, replacementWord);

            }

        } return separate;
    }
}

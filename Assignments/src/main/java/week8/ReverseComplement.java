package week8;

/**
 * Date: 07.01.14
 * Time: 09:33
 */
public class ReverseComplement {

    private String string;

    public ReverseComplement(String string) {
        this.string = string;
    }

    public String getReverseComplement() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            char charAt = string.charAt(i);
            switch (charAt) {
                case 'A':
                    stringBuilder.append("T");
                    break;
                case 'C':
                    stringBuilder.append("G");
                    break;
                case 'G':
                    stringBuilder.append("C");
                    break;
                case 'T':
                    stringBuilder.append("A");
                    break;
            }
        }

        return stringBuilder.reverse().toString();
    }
}

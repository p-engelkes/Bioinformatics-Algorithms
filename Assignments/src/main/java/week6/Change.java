package week6;

import java.util.HashMap;
import java.util.List;

/**
 * Date: 11.12.13
 * Time: 15:29
 */
public class Change {

    int money;
    List<Integer> denominations;

    public Change(int money, List<Integer> denominations) {
        this.money = money;
        this.denominations = denominations;
    }

    public int getMinNumCoins() {
        HashMap<Integer, Integer> minNumCoins = new HashMap<Integer, Integer>();
        minNumCoins.put(0, 0);

        for (int money = 1; money <= this.money; money++) {
            int minNumber = 100000000;
            for (int j = 0; j < denominations.size(); j++) {
                if ((money - denominations.get(j)) == 0) {
                    minNumber = 1;
                } else if (money - denominations.get(j) > 0) {
                    if (minNumber > minNumCoins.get(money - denominations.get(j))) {
                        minNumber = minNumCoins.get(money - denominations.get(j)) + 1;
                    }
                }
            }
            minNumCoins.put(money, minNumber);
        }

        return minNumCoins.get(money);
    }
}

package utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    public static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream().sorted().toList();
    }
}

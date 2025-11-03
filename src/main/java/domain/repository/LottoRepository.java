package domain.repository;

import domain.model.Lotto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {
    private static final List<Lotto> issuedLottos = new ArrayList<>();

    public static void save(Lotto lotto) {
        issuedLottos.add(lotto);
    }

    public static List<Lotto> findAll() {
        return Collections.unmodifiableList(issuedLottos);
    }

    public static void clear() {
        issuedLottos.clear();
    }
}

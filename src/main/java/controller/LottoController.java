package controller;

import domain.model.LottoTicket;
import domain.model.WinningLotto;
import domain.repository.LottoRepository;
import domain.service.LottoMachine;
import domain.service.LottoResultCalculator;
import domain.service.ProfitCalculator;
import domain.value.Rank; 
import utils.Validator;
import views.InputView;
import views.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoMachine lottoMachine = new LottoMachine();
    private final LottoResultCalculator resultCalculator = new LottoResultCalculator();
    private final ProfitCalculator profitCalculator = new ProfitCalculator();

    public void run() {
        try {
            int purchaseAmount = inputView.readPurchaseAmount();
            Validator.validatePurchaseAmount(purchaseAmount);

            LottoTicket ticket = lottoMachine.purchase(purchaseAmount);
            ticket.getTickets().forEach(LottoRepository::save);

            outputView.printPurchasedLottos(ticket);

            List<Integer> winningNumbers = inputView.readWinningNumbers();
            int bonusNumber = inputView.readBonusNumber();
            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

            Map<Rank, Integer> results = resultCalculator.calculate(ticket, winningLotto);
            double profitRate = profitCalculator.calculateProfitRate(results, purchaseAmount);

            outputView.printStatistics(results, profitRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            LottoRepository.clear(); // 재시작 시 데이터 초기화
            run(); // 재입력 루프
        }
    }
}

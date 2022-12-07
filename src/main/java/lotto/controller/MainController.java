package lotto.controller;

import lotto.enums.Ranking;
import lotto.service.LottoCalculator;
import lotto.service.LottoComparator;
import lotto.service.LottoGenerator;
import lotto.model.Lotto;
import lotto.view.OutputView;
import lotto.utils.DataExtractor;

import java.util.List;

public class MainController {

    private final InputController inputController = new InputController();
    private LottoCalculator lottoCalculator;
    private LottoComparator lottoComparator;
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final OutputView outputView = new OutputView();
    private final DataExtractor dataExtractor = new DataExtractor();

    public void start() {
        issueLotto();
    }

    public void issueLotto() {
        int amount = inputController.inputAmount();
        lottoCalculator = new LottoCalculator(amount);

        List<Lotto> lottos = lottoGenerator.createLottos(lottoCalculator.count());
        lottoComparator = new LottoComparator(lottos);

        outputView.printIssuedLottoCount(lottoCalculator.count(), lottoComparator.getLottos());

        compareLotto();
    }

    public void compareLotto() {
        List<Integer> winningNumbers = inputController.inputWinningNumbers();
        int bonusNumber = inputController.inputBonutNumbers(winningNumbers);

        List<Ranking> resultComparingLotto = lottoComparator.compareLottoNumbers(winningNumbers, bonusNumber);
        lottoCalculator.calResultLotto(resultComparingLotto);
        outputView.printResultStatistics(lottoCalculator.getResultStatistics());

        calRateOfReturn();
    }

    public void calRateOfReturn() {
        double totalPrize = lottoCalculator.calTotalPrize();
        double rateOfReturn = lottoCalculator.calRateOfReturn(totalPrize);

        String integerPart = dataExtractor.extractIntegerPart(rateOfReturn);
        String decimalPart = dataExtractor.extractDecimalPart(rateOfReturn);

        outputView.printRateOfReturn(integerPart, decimalPart);
    }
}

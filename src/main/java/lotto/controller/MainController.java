package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.util.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private LottoResult result;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public MainController() {
        inputView = new InputView();
        outputView = new OutputView();
        this.lottos = new ArrayList<>();
    }

    public void issueLotto() {
        result = inputView.readCost();

        for (int iter = 0; iter < result.count(); iter++) {
            lottos.add(new Lotto(RandomGenerator.createLottoNumbers()));
        }
        outputView.printLottos(result.count(), lottos);

        decideWinningLotto();
    }

    public void decideWinningLotto() {
        winningLotto = inputView.readWinningLotto();

        List<LottoPrize> prizes = lottos.stream()
                .map(winningLotto::draw)
                .collect(Collectors.toList());

        outputView.printLottoResult(prizes);

        calYield(prizes);
    }

    public void calYield(List<LottoPrize> prizes) {
        int totalPrize = result.calTotalPrize(prizes);
        String yield = result.yield(totalPrize);
        outputView.printYield(yield);
    }
}

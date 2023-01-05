package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.util.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private LottoResult result;
    private List<Lotto> lottos;

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
    }
}

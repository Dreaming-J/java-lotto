package lotto.controller;

import lotto.model.LottoResult;
import lotto.view.InputView;

public class MainController {

    InputView inputView = new InputView();

    public void start() {
        LottoResult result = inputView.readCost();
    }
}

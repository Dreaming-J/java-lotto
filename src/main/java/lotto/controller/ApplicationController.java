package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Player;
import lotto.model.Seller;
import lotto.model.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationController {
    Seller seller = new Seller();
    Player player = new Player();
    Validator validator = new Validator();
    InputView inputView = new InputView();

    public void startApplication() {
        int purchaseAmount = validator.convertStringIntoInt(inputView.inputPurchaseAmount());
        player.setPurchaseAmount(purchaseAmount);
        if (validator.isPurchaseAmountValidate(player.getPurchaseAmount())) {
            controlIssueingLotto();
        }
    }

    public void controlIssueingLotto() {
        // TODO
        //  - [x] 발행할 로또 개수 계산
        //  - [x] 구입한 로또 개수 저장
        //  - [ ] 로또 개수만큼 발행
        //  - [ ] 구매한 로또 번호 저장
        //  - [ ] 당첨 번호, 보너스 번호 정하는 과정 제어 기능 호출
        int lottocount = seller.countIssueingLotto(player.getPurchaseAmount());
        player.setLottoCount(lottocount);
    }
}

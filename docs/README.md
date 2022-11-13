# 기능 목록

[기능 목록 설계 과정](./subdocs/ATTACHMENT.md)

---

## 🧩기능 목록

### model

1. Lotto
    - [ ]  발행할 로또 개수 계산 기능 → countIssueingLotto
    - [ ]  로또 개수만큼 발행 기능 → issueLotto
    - [ ]  당첨 번호 저장 기능 → setWinningNumber
    - [ ]  보너스 번호 저장 기능 → setBonusNumber
    - [ ]  로또와 당첨 번호 비교 기능 → compareLotto_WinningNumber
2. Player
    - [ ]  로또 구입 금액 저장 기능 → setPurchaseAmount
    - [ ]  구입한 로또 개수 저장 기능 → setLottoCount
    - [ ]  구매한 로또 번호 저장 기능 → setLottoNumber
    - [ ]  당첨 내역 저장 기능 → setWinningResult
    - [ ]  수익률 저장 기능 → setLottoYield
3. Validator
    - [ ]  로또 구입 금액이 1,000원으로 나누어 떨어지는지 검증 기능 → validatePurchaseAmount
    - [ ]  당첨 번호를 쉼표 기준으로 입력했는지 검증 기능 → validateWinningNumber_Diveded_Comma
    - [ ]  당첨 번호 6개를 입력했는지 검증 기능 → validateNumberOfWinningNumbers
    - [ ]  각 당첨 번호 및 보너스 번호가 1~45 사이의 숫자로 이루어졌는지 검증 기능 → isBetween1And45
    - [ ]  각 당첨 번호 및 보너스 번호가 숫자 형식인지 검증 기능 → isCorrectTypeOfInput

### view

1. InputView
    - [ ]  로또를 구입할 금액 입력 기능 → inputPurchaseAmount
    - [ ]  당첨 번호 입력 기능 → inputWinningNumber
    - [ ]  보너스 번호 입력 기능 → inputBonusNumber
2. OutputView
    - [ ]  구입한 로또 개수 출력 기능 → printLottoCount
    - [ ]  구매한 로또 번호 출력 기능 → printLottoNumber
    - [ ]  당첨 내역 출력 기능 → printWinningResult
    - [ ]  수익률 출력 기능 → printLottoYield

### controller

1. ApplicationController
    - [ ]  ...

---

## ⌨입출력 요구 사항

1. 입력
    1. 로또 구입 금액 입력
        
        구입 금액은 1,000원 단위로 입력
        
        1,000원으로 나누어 떨어지지 않는 경우 **예외 처리**
        
        ```java
        구입금액을 입력해 주세요.
        8000
        ```
        
    2. 당첨 번호 입력
        
        번호는 쉼표(,)를 기준으로 구분
        
        ```java
        당첨 번호를 입력해 주세요.
        1,2,3,4,5,6
        ```
        
    3. 보너스 번호 입력
        
        ```java
        보너스 번호를 입력해 주세요.
        7
        ```
        
2. 출력
    1. 발행한 로또 수량 및 번호 출력
        
        로또 번호는 오름차순으로 정렬
        
        ```java
        3개를 구매했습니다.
        [8, 21, 23, 41, 42, 43]
        [3, 5, 11, 16, 32, 38]
        [7, 11, 16, 35, 36, 44]
        ```
        
    2. 당첨 내역 출력
        
        ```java
        당첨 통계
        ---
        3개 일치 (5,000원) - 1개
        4개 일치 (50,000원) - 0개
        5개 일치 (1,500,000원) - 0개
        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        6개 일치 (2,000,000,000원) - 0개
        ```
        
    3. 수익률 출력
        
        소수점 둘째 자리에서 반올림 (ex. 100.0%, 51.5%, 1,000,000.%)
        
        ```java
        총 수익률은 62.5%입니다.
        ```
        
3. 예외 처리
    
    사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생
    
    “[ERROR]”로 시작하는 에러 메시지를 출력 후 종료
    
    ```java
    [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
    ```
    

---

## ✅ 최종 체크 리스트

- [ ]  JDK 11 버전에서 실행 가능한가?
- [ ]  Java 코드 컨벤션 가이드를 준수하였는가?
- [ ]  indent depth가 2를 넘지 않았는가?
- [ ]  메서드는 한 가지 일만 하도록 작성하였는가?
- [ ]  3항 연산자를 사용하지 않았는가?
- [ ]  테스트 코드를 작성해서 확인해보았는가?
- [ ]  Random.pickUniqueNumbersInRange() 및 Console.readLine() API를 사용하여 구현하였는가?
- [ ]  메서드의 길이가 15라인을 넘지 않았는가?
- [ ]  else 예약어와 switch/case를 사용하지 않았는가?
- [ ]  Java Enum을 적용했는가?
- [ ]  도메인 로직에 단위 테스트를 구현했는가?
- [ ]  Lotto 클래스에 주어진 제한 사항을 지켰는가?

---

## ✅ 개인 체크 리스트

- [ ]  실행 결과 예시와 동일한 출력을 내는가?
- [ ]  하드 코딩하진 않았는가?
- [ ]  구현 순서를 잘 지켰는가?
- [ ]  변수 이름에 자료형이 들어가지 않았는가?
- [ ]  MVC패턴의 규칙을 지켰는가?
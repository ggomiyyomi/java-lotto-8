# 🎯 로또 (Lotto)

## 🧩 프로젝트 개요
간단한 로또 발매기 프로그램입니다.  
사용자가 구입 금액을 입력하면 해당 금액만큼 로또를 발행하고,  
입력한 당첨 번호 및 보너스 번호와 비교하여 **당첨 내역과 수익률을 계산**합니다.

---

## 💡 학습 목표
- 관련 기능을 클래스로 분리하고 객체 간 협력을 학습한다.  
- 단위 테스트(JUnit5, AssertJ)를 통해 기능의 정확성을 검증한다.  
- 예외 처리와 입력 검증을 통해 안정적인 프로그램을 구현한다.

---

## 🏗️ 기능 목록

### 1️⃣ 입력 기능
- [ ] 구입 금액을 입력받는다.  
  - [ ] 1,000원 단위가 아닐 경우 예외 발생 (`IllegalArgumentException`)  
- [ ] 당첨 번호를 입력받는다. (쉼표로 구분된 6개의 정수)  
  - [ ] 중복되거나 범위를 벗어날 경우 예외 발생 (1~45)  
- [ ] 보너스 번호를 입력받는다.  
  - [ ] 당첨 번호와 중복되면 예외 발생  

---

### 2️⃣ 로또 발행 기능
- [ ] 구입 금액 / 1,000 계산을 통해 구매 개수 산출  
- [ ] `Randoms.pickUniqueNumbersInRange(1, 45, 6)`을 사용해 로또 번호 생성  
- [ ] 번호는 오름차순 정렬  
- [ ] 구매한 모든 로또 번호를 출력  

---

### 3️⃣ 당첨 확인 기능
- [ ] 사용자 로또와 당첨 번호를 비교  
- [ ] 일치 개수에 따라 등수 판정  
- [ ] 보너스 번호 일치 여부 확인  

| 등수 | 조건 | 상금 |
|------|------|------|
| 1등 | 6개 번호 일치 | 2,000,000,000원 |
| 2등 | 5개 번호 + 보너스 번호 일치 | 30,000,000원 |
| 3등 | 5개 번호 일치 | 1,500,000원 |
| 4등 | 4개 번호 일치 | 50,000원 |
| 5등 | 3개 번호 일치 | 5,000원 |

---

### 4️⃣ 결과 출력 기능
- [ ] 각 등수별 당첨 개수 출력  
- [ ] 총 수익률 계산 및 소수점 둘째 자리 반올림  
- [ ] 출력 형식 준수 (`총 수익률은 62.5%입니다.`)  

---

### 5️⃣ 예외 처리
- [ ] `[ERROR]`로 시작하는 에러 메시지를 출력하고 재입력 요청  
- [ ] `IllegalArgumentException`과 `IllegalStateException`만 사용  

---

## 🧪 테스트 목록
- [ ] 로또 번호 생성 시 중복 확인  
- [ ] 번호 개수가 6개인지 검증  
- [ ] 당첨 번호 비교 로직 테스트  
- [ ] 수익률 계산 테스트  
- [ ] 예외 입력 테스트  

---

## ⚙️ 실행 방법
```bash
# 테스트 실행
./gradlew clean test      # Mac/Linux
gradlew.bat clean test    # Windows
```

---

## 🧱 패키지 구조
```
└── src
    ├── main
    │   └── java
    │       ├── controller
    │       │   └── LottoController.java
    │       ├── domain
    │       │   ├── model
    │       │   │   ├── Lotto.java
    │       │   │   ├── LottoTicket.java
    │       │   │   └── WinningLotto.java
    │       │   ├── repository
    │       │   │   └── LottoRepository.java
    │       │   ├── service
    │       │   │   ├── LottoMachine.java
    │       │   │   ├── LottoResultCalculator.java
    │       │   │   └── ProfitCalculator.java
    │       │   └── value
    │       │       ├── Money.java
    │       │       └── Rank.java
    │       ├── exception
    │       │   ├── DuplicateNumberException.java
    │       │   ├── InvalidInputException.java
    │       │   └── LottoNumberOutOfRangeException.java
    │       ├── lotto
    │       │   └── Application.java
    │       ├── utils
    │       │   ├── Formatter.java
    │       │   ├── LottoNumberGenerator.java
    │       │   └── Validator.java
    │       └── views
    │           ├── InputView.java
    │           └── OutputView.java
    └── test
        └── java
            ├── controller
            │   └── LottoControllerTest.java
            ├── domain
            │   ├── model
            │   │   ├── LottoTest.java
            │   │   ├── LottoTicketTest.java
            │   │   └── WinningLottoTest.java
            │   ├── service
            │   │   ├── LottoMachineTest.java
            │   │   ├── LottoResultCalculatorTest.java
            │   │   └── ProfitCalculatorTest.java
            │   └── value
            │       └── RankTest.java
            ├── lotto
            │   ├── ApplicationTest.java
            │   └── LottoIntegrationTest.java
            ├── utils
            │   ├── FormatterTest.java
            │   └── ValidatorTest.java
            └── views
                ├── InputViewTest.java
                └── OutputViewTest.java
```

---

## 회고
이번 과제는 이전보다 훨씬 복잡한 구조로 되어 있어서 처음엔 많이 헷갈렸다.
패키지를 어떻게 나누고, 클래스끼리 어떤 관계를 만들어야 할지 고민이 많았다. 그래도 객체마다 역할을 분리하고 서로 협력하도록 설계하면서 점점 구조가 잡혀갔다. 예외 처리와 입력 검증을 따로 분리해 보니 코드가 훨씬 읽기 쉬워졌고, Formatter나 Repository 같은 계층을 추가하면서 확장성과 테스트하기 좋은 구조가 되었다.
과정을 진행하면서 단순히 동작하는 코드를 넘어서, “왜 이런 구조가 필요한가”를 고민하게 된 점이 가장 큰 배움이었다.

또한 이번 과제도 실무 반영을 위해 테스트를 패키지 미러링으로 진행하였다.이런 프로젝트 같은 작은 규모의 미션은 불필요하게 복잡해지지만 자세하게 진행해보고싶었다. 
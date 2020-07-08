# Lotto Program
- ### 실제 로또처럼 자동으로 뽑아서 그 뽑은 숫자들과 실제 나왔었던 로또 번호를 맞춰보는 로또 프로그램

## 화면 구현 및 설명

![image](https://user-images.githubusercontent.com/62640232/86867585-0a04a180-c10e-11ea-9912-b9b40cb90b6a.png)

- mbt : 해당회차로의 로또 번호
- checkBtn : 해당회차로 버튼
- turnTxt : 해당회차로 입력텍스트
- titleLbl : 로또번호 라벨
- turnLbl : 회차 라벨
- turnLbl : 날짜
- turnFirstAcc : 1등 당첨금
- turnFirstPrzCo : 1등 당첨 명 수
- plusLbl : 플러스 이미지
- turnUserNum : 당첨된 번호
- turnUser : 당첨된 등수
- rdcom : 자동뽑기의 번호
- randomBtn : 자동뽑기 버튼

### 테스트
__처음 화면__
- 로또번호와 자동뽑기의 초기값은 1,2,3,4,5,6,7 나머지는 공백으로 설정된다.

![image](https://user-images.githubusercontent.com/62640232/86868041-e1c97280-c10e-11ea-80b6-af4a84205717.png)

__자동뽑기__
- 자동뽑기 버튼을 입력했을 시 랜덤으로 번호가 뽑힌다.
- 번호들은 구간마다 색이 다르도록 설정하였다.

![image](https://user-images.githubusercontent.com/62640232/86868141-21905a00-c10f-11ea-945c-4b8fe8755e20.png)

__해당회차로 조회 당첨 등수 출력__
- 자동뽑기한 값을 가지고 해당회차로의 번호와 비교한다.
- 1개=6등, 2개=5등, 3개=4등, 4개=3등, 5개=2등, 6개=1등 으로 설정하였다.
- 해당회차로의 날짜, 1등한 사람 수, 1등 당첨금액을 출력한다.

![image](https://user-images.githubusercontent.com/62640232/86868176-32d96680-c10f-11ea-9362-ff36ae42598e.png)

![image](https://user-images.githubusercontent.com/62640232/86868451-a8ddcd80-c10f-11ea-8a34-41153eaf770d.png)












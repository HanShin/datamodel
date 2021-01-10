# 데이터모델링 퀴즈

## 셋팅법
### 개발환경
1. 작업환경은 OSX 11.1(Bigsur) 기반으로 작업하였습니다.
2. 개발 툴은 Intellij IDEA (2020.3.1) 로 작업하였습니다. 

### 개발셋팅
개발관련 패키지는 homebrew 로 설치하였습니다.
1. homebrew 설치 
```
$ /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```
2. docker 설치
```
$ brew cask install docker
// application 에 docker.app 이 생기고나서 한번 실행하고난 후 정상적으로 사용가능합니다.
// 설치후 버전 확인
$ docker --version
```
3. java 설치
Intellij IDEA 에서 제공되는 jdk 설치기능으로 작업했지만, 다른 ide를 사용하는 경우도 있으니, homebrew 로 설치하는 방법 작성하겠습니다.
```
$ brew tap AdoptOpenJDK/openjdk
// openjdk는 adoptopenjdk 로 개발하였습니다. 다른 벤더의 jdk를 사용하여도 지장은 없습니다.
$ brew cask install adoptopenjdk11
```
4. mysql 설치
mysql 은 따로 설치하지 않고 docker로 docker-compose 하여 작업하였습니다.
## 테스트 및 Run
최신 소스를 pull 받으신 이후에(master 브랜치 기준입니다, 물론 다른 브랜치는 생성하지는 않았습니다.)
1. 실행방법
```
// 프로젝트 경로에서
$ ./gradlew clean build && docker-compose up  
```
2. 테스트 코드 실행방법
```
// 프로젝트 경로에서
$ ./gradlew test
```
테스트 코드가 실패한 경우 실패한 정보가 터미널에 노출되도록 되어있습니다.
3. 실행후 테스트
```
// 프로젝트 경로에서
$ ./gradlew clean build && docker-compose up 
```
으로 소스 실행후 
1. localhost:8080/test (임의로 릴레이션 데이터가 저장되도록 하드코딩한 api 입니다.)
2. localhost:8080/moving-companies (이사업체 리스트)
3. localhost:8080/customers (고객정보 리스트)
4. localhost:8080/home-moving-requests (가정이사 요청정보 리스트)
## 사용한 패키지
소스에서 사용한 라이브러리들의 경우 버전을 특정하지는 않았습니다. 작업시점에서 최신버전을 이용하였습니다.(2021.01.10 기준)
1. java 11(adoptopenjdk-11)
2. mysql-8.0.22
3. docker 20.10.0
4. Spring boot 2.4.1
5. Gradle 6.7.1
6. Spring boot data-jpa
7. lombok
8. h2 (테스트 코드를 위해 추가하였습니다. 테스트 코드에서는 h2 기반으로 작업되고 실제 실행시에는 mysql 로 작업됩니다.)
9. undertow (기본 내장 tomcat 보다 더 빠르고 경량화된 was 여서 undertow 로 변경하였습니다.)
10. junit 5

## 그외
1. Data_model quiz 로 되어있어서 ORM 관련 문제로 판단하여 쿼리를 직접 작성하진 않고 data-jpa 에서 객체단에서 데이터 저장등 처리하였습니다.

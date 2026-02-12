# sample-rest-basic

# 📑 목차

1. [**프로젝트 생성**](#1-프로젝트-생성)
2. [**Maven 프로젝트 + Docker 컨테이너 실행 (세미나 이전)**](#2-maven-프로젝트--docker-컨테이너-실행-세미나-이전)
3. [**Maven 프로젝트 + Docker 컨테이너 실행 (세미나 이후)**](#3-maven-프로젝트--docker-컨테이너-실행-세미나-이후)
4. [**Maven 프로젝트 + Docker 컨테이너 종료**](#4-maven-프로젝트--docker-컨테이너-종료docker-composeyml-사용하는-경우)

---

## 1. 프로젝트 생성

1. `Visual Studio Code` 실행

2. `Ctrl`+`Shift`+`P` 입력

3. `Spring Initializr: Create a Maven Project` 클릭

4. 계속 엔터

5. `dependencies` 선택
    - Lombok
    - Rest Repositories
    - HyperSQL Database SQL
    - Spring Data JPA

---

## 2. Maven 프로젝트 + Docker 컨테이너 실행 (세미나 이전)

1. `docker Desktop` 실행

2. Git Clone
``` bash
git clone https://github.com/ParkJinwon1025/sample-rest-basic.git
```

3. `.jar` 파일 생성 명령어 실행
``` bash
.\mvnw clean package -DskipTests 
```

4. `docker-compose` 프로그램 실행
```bash
# DB 결과 확인하려면 DBeaver도 켜야함.
docker-compose up -d
```

---

## 3. Maven 프로젝트 + Docker 컨테이너 실행 (세미나 이후)

1. `docker Desktop` 실행

2. 터미널에서 Docker 실행 (**버전은 이미지 마다 다를 수 있음.**)

**MySQL**
```bash
# 이미지 다운로드
docker pull mysql:9.5.0

# 컨테이너 실행
# --name: 컨테이너 이름
# -p: 포트 매핑 (호스트:컨테이너)
# -e: 환경변수 설정
# -v: 볼륨 마운트 (호스트 경로:컨테이너 경로)
# -d: 백그라운드 실행
docker run --name mydata -p 3306:3306 -e MYSQL_ROOT_PASSWORD=docker123 -v C:/Users/USER/Documents/dockerdata/mysqldata:/var/lib/mysql -d mysql:9.5.0
```

**PostgreSQL**
```bash
# 이미지 다운로드
docker pull postgres:latest

# 컨테이너 실행 (postgres 버전 <= 17)
# --name: 컨테이너 이름
# -p: 포트 매핑 (호스트:컨테이너)
# -e: 환경변수 설정
# -v: 볼륨 마운트 (호스트 경로:컨테이너 경로)
# -d: 백그라운드 실행
docker run --name postgres-db -p 5432:5432 -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=rest -v C:/Users/USER/Documents/dockerdata/postgres:/var/lib/postgresql/data -d postgres:latest

# 컨테이너 실행 (postgres 버전 >= 18)
# 볼륨 마운트 경로가 다름
docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=1234 -v C:/Users/USER/Documents/dockerdata/postgres:/var/lib/postgresql -d postgres:latest
``` 

**MSSQL**
```bash
# 이미지 다운로드
docker pull mcr.microsoft.com/mssql/server:2025-latest

# 컨테이너 실행 (기본 설정)
docker run --name mssql2025 -p 1433:1433 -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=Test1234!" -v C:/Users/USER/Documents/dockerdata/mssql:/var/opt/mssql/data -d mcr.microsoft.com/mssql/server:2022-latest
```

**MariaDb**
```bash
# 이미지 다운로드 
docker pull mariadb:noble

# 컨테이너 실행
docker run --name maria -p 3306:3306 -v C:/Users/USER/Documents/dockerdata/maria:/var/lib/mysql:Z -e MARIADB_ROOT_PASSWORD=Test1234! -d mariadb:latest
```

3. 터미널에서 Spring Boot 애플리케이션 실행
```bash
# test 폴더에서는 '>' 화살표 클릭과 동일함.
.\mvnw spring-boot:run
```

---

## 4. Maven 프로젝트 + Docker 컨테이너 종료(docker-compose.yml 사용하는 경우)
```bash
docker-compose down 
```

---
# sample-rest-basic

## 1. 프로젝트 생성

1. `Visual Studio Code` 실행

2. `Ctrl`+`Shift`+`P` 입력

3. `Spring Initializr: Create a Maven Project` 클릭

4. 계속 엔터

5. `dependencies` 선택
    - Lombok
    - Rest Repositories
    - HYperSQL Database SQL
    - Spring Data JPA


## 2-1. Maven 프로젝트 + Docker 컨테이너 실행 (세미나 이전)

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

## 2. Maven 프로젝트 + Docker 컨테이너 종료
```bash
docker-compose down 
```
---
---
---
---
---
---
---
---
---
---
---

## 2-2. Maven 프로젝트 + Docker 컨테이너 실행 (세미나 이후)

1. `docker Desktop` 실행

2. 터미널에서 Docker 실행 (**버전은 이미지 마다 다를 수 있음.**)
```bash
# MySQL
docker pull mysql:9.5.0

# 컨테이너 실행
docker run --name=mydata -p 3306:3306 -v C:/Users/USER/Documents/dockerdata/mysql1:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=docker123 -d mysql:9.5.0
```

```bash
# PostgreSQL
docker pull postgres:latest

# 컨테이너 실행(postgres 버전 =< 17)
docker run --name postgres-db -p 5432:5432 -v C:/Users/USER/Documents/dockerdata/mysql1:/var/lib/postgresql/data -e POSTGRES_PASSWORD=1234 -e POSTGRES_DB=rest -d postgres:latest

# 컨테이너 실행(postgres 버전 <= 18)
docker run --name postgres -p 5432:5432 -v C:/Users/USER/Documents/dockerdata/postsend:/var/lib/postgresql -e POSTGRES_PASSWORD=1234 -d postgres:latest
``` 

```bash
# MSSQL
docker pull mcr.microsoft.com/mssql/server:2025-latest

# 컨테이너 실행
docker run -d --name mssql -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=msSQL1234!" -p 14330:1433 -v C:\workspace\hello-docker\backup:/var/opt/mssql/backup ` mcr.microsoft.com/mssql/server:2022-latest

# BackUp 파일 만들기
docker exec -it mssql /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P "msSQL1234!" -Q "BACKUP DATABASE [MyDb] TO DISK = N'/var/opt/mssql/backup/MyDb.bak' WITH INIT, COMPRESSION" -C

# 컨테이너 실행
docker run -d --name mssql2025 -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=Test1234!" -p 1433:1433 -v C:/Users/USER/Documents/dockerdata/mssqlsend:/var/opt/mssql mcr.microsoft.com/mssql/server:2025-latest


3. 터미널에서 Spring Boot 애플리케이션 실행
```bash
# test 폴더에서는 '>' 화살표 클릭과 동일함.
.\mvnw spring-boot:run
```


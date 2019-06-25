# Error

## Unable to load authentication plugin 'caching_sha2_password'
mysql > ALTER USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';

## Unknown system variable 'query_cache_size'
mysql-connector-java 버전을 8.0.11로 바꿔줌

# 한글 깨짐
브라우저 -> 서버 -> DBMS 로 같은 내용의 한글이 서비스를 처리하는데 매번 다른 문자코드를 사용하여 재표현되기 때문에 한글이 깨지는 경우가 생긴다. GET과 POST 방식에서 한글을 푠현하는 방식이 다르기 때문에 두 가지 경우를 고려해야 한다.

## GET
1. Tomcat 서버의 환경 설정 파일 server.xml에 UTF-8 설정
2. .html 파일에 UTF-8 설정

## POST
- web.xml에 UTF-8 설정
- .jsp 파일에 UTF-8 설정

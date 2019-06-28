# Error

## The server time zone value '´ëÇÑ¹Î±¹ Ç¥ÁØ½Ã' is unrecognized
MySQL Connector java 5.1.x 버전 이상으로 나타나는 에러

```xml
jdbc:mysql://localhost:3306/binsin?serverTimezone=UTC
```
serverTimezone=UTF 를 추가한다.

# security0804
# Spring Security2 List
<details>
<summary># Spring Security2 List</summary>

````
1. 프로젝트 생성
2. gradle 설정
3. yml 설정
4. 프로젝트 실행
````
</details>

## 1.프로젝트 생성

<details>
<summary> 프로젝트</summary>
````
1. 프로젝트 생성
````
</details>

<details>
<summary> gradle</summary>
````
2. gradle 설정
dependencies {
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
implementation 'org.springframework.boot:spring-boot-starter-validation'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
compileOnly 'org.projectlombok:lombok'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
runtimeOnly 'com.mysql:mysql-connector-j'
annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
annotationProcessor 'org.projectlombok:lombok'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
testImplementation 'org.springframework.security:spring-security-test'
implementation group: 'nz.net.ultraq.thymeleaf', name: 'thymeleaf-layout-dialect'
implementation group: 'org.thymeleaf.extras', name: 'thymeleaf-extras-springsecurity5'
}
````

</details>


<details>
<summary> yml</summary>>
````
3. yml 설정

server:
port: ****

spring:
datasource:
driver-class-name: com.mysql.cj.jdbc.Driver
url: jdbc:mysql://***
username: ****
password: ****

jpa:
database-platform: org.hibernate.dialect.MySQL8Dialect
hibernate:
ddl-auto: update  # DDL?? ??
properties:
hibernate:
show_sql: true
format_sql: true

thymeleaf:
cache: false
check-template-location: true
prefix: classpath:/templates/
suffix: .html
enabled: true

filepath: file:///C:/saveFile0801/

</details>

<details>

<summary> 프로젝트 실행</summary>>
````
4. 프로젝트 실행
````

</details>

<details>
## Entity 생성

<summary> base entity</summary>


</details>
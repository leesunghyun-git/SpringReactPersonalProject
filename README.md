# SpringReactPersonalProject

Spring Boot(백엔드) + React(프론트엔드) 기반의 지역별 여행 정보 제공 개인 프로젝트입니다. 서울, 부산, 경주, 제주 지역의 관광지, 문화시설, 축제, 숙박, 쇼핑, 음식점 정보를 조회할 수 있으며, 소셜 로그인(OAuth2) 및 자체 로그인을 지원합니다.

## 기술 스택

- **Backend**: Spring Boot 3.5, Spring Data JPA, Spring Security, OAuth2 Client
- **Auth**: JWT (Access/Refresh Token), OAuth2 소셜 로그인 (카카오 등)
- **DB**: MySQL
- **기타**: Kafka, Spring AMQP, WebSocket, Mail
- **Build**: Gradle
- **Frontend**: React (별도 디렉토리/리포지토리 또는 추후 통합)

## 프로젝트 구조

```
src/main/java/com/sist/web
├── SpringReactPersonalProjectApplication.java   # 애플리케이션 진입점
├── config
│   ├── SecurityConfig.java       # Spring Security 설정 (CORS, JWT, OAuth2, 로그인/로그아웃)
│   └── CustomOAuth2User.java     # OAuth2User 커스텀 구현
├── controller
│   └── TravelRestController.java # 여행 정보 REST API
├── dto                            # 응답용 데이터 전송 객체
│   ├── AttractionDTO / CultureDTO / FestivalDTO
│   ├── FoodStoreDTO / ShoppingDTO / StayDTO
│   └── TravelListDTO / TravelDetailDTO
├── entity                          # JPA 엔티티
│   ├── SeoulTravel / BusanTravel / GyeongjuTravel / JejuTravel
│   ├── Member / Role_perm / UserRole
├── repository                      # JPA Repository
│   ├── SeoulTravelRepository 등 지역별 여행 정보 Repository
│   ├── MemberRepository / RoleRepository / UserRoleRepository
├── security                        # JWT 및 로그인 핸들러
│   ├── JwtFilter / JwtProvider / JwtProperties
│   └── LoginSuccessHandler / LoginFailuerHandler
└── service                          # 비즈니스 로직
    ├── TravelService / TravelServiceImpl
    ├── MemberService / MemberServiceImpl
    ├── CustomOAuth2UserService / CustomUsersDetailService
```

## 주요 기능

### 여행 정보 API (`TravelRestController`)

- `GET /{region}/list/{contenttype}/{page}` — 지역(`seoul`, `busan`, `gyeongju`, `jeju`)별, 콘텐츠 타입별 여행 정보 목록을 페이지네이션하여 조회
- `GET /{region}/detail/{contenttype}/{contentid}` — 콘텐츠 타입에 따라 관광지/문화시설/축제/숙박/쇼핑/음식점 상세 정보 조회
- `GET /home/data` — 각 지역별 인기(조회수 기준) 여행 정보 4건씩 조회

#### Content Type 코드

| 코드 | 의미 |
| --- | --- |
| 12 | 관광명소 (Attraction) |
| 14 | 문화시설 (Culture) |
| 15 | 축제/행사 (Festival) |
| 32 | 숙박 (Stay) |
| 38 | 쇼핑 (Shopping) |
| 39 | 음식점 (FoodStore) |

### 인증 및 회원 관리

- 자체 로그인(`/member/local/login`)과 소셜 로그인(`/mebmer/social/login`) 지원
- 로그인 성공 시 JWT Access/Refresh Token 발급
- 신규 소셜 로그인 사용자는 별도 회원가입 플로우로 안내 (`status: "NOTUSER"`)
- `JwtFilter`를 통해 요청 헤더의 `Authorization: Bearer {token}`을 검증하고 SecurityContext에 인증 정보 설정

> **참고**: 현재 인가(Authorization) 설정은 개발 편의를 위해 모든 요청을 허용(`permitAll`)하도록 되어 있습니다. 추후 역할(Role) 기반 접근 제어를 적용할 예정입니다.

## 실행 방법

### 사전 준비
- JDK 17
- MySQL 데이터베이스 및 관련 테이블(`member`, `seoultravel`, `busantravel`, `gyeongjutravel`, `jejutravel`, `attraction`, `culture`, `festival`, `shopping`, `stay`, `foodstore` 등)
- `application.yml` 또는 `application.properties`에 다음 설정 필요
  - DB 접속 정보 (`spring.datasource.*`)
  - JWT 시크릿 및 만료 시간 (`jwt.secret`, `jwt.access-token-expiration`, `jwt.refresh-token-expiration` 등)
  - OAuth2 클라이언트 정보 (카카오 등 소셜 로그인 client-id/secret)

### 빌드 및 실행

```bash
./gradlew bootRun
```

Windows의 경우:

```bash
gradlew.bat bootRun
```

기본적으로 프론트엔드(React, `http://localhost:3000`)와 연동되도록 CORS가 설정되어 있습니다.

## 향후 개선 계획

- Spring Security 인가 설정 세분화 (역할 기반 접근 제어 적용)
- 지역별로 중복된 Repository/Service 로직 통합
- 환경 변수 및 시크릿 관리 방식 개선

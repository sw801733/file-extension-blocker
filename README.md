
# 구현 내용
- 고정 확장자 추가 및 삭제 기능
- 커스텀 확장자 추가 및 삭제 기능
  - 커스텀 확장자 글자 수 20자로 제한 
  - 커스텀 확장자 중복 입력 시 Alert / 추가 X
  - 입력 없이 추가 시 Alert / 추가 X
  - 확장자 추가 개수 초과 시 Alert / 추가 X

# 개발 일지
https://sprinkle-random-ca4.notion.site/44835d4da09d46e9b12cefe2dc18e9fe?pvs=4

# 구현 방법
- `JQuery` 와 Github Page 를 활용한 **Frontend** 사이트 개발
- `Spring Boot` 와 AWS EC2 를 활용한 **Backend** 서버 개발
- `AWS RDS` MySQL 을 활용한 **Database** 구축
- `AWS Route 53` 과 `AWS ALB` 를 통한 백엔드 서버 HTTPS 설정

## 구현 방법 다이어그램
![구현 다이어그램](https://github.com/sw801733/file-extension-blocker/assets/84767822/f90086bc-0650-4c79-995c-8dbd5b22f681)


## 아키텍처
![아키텍처](https://github.com/sw801733/file-extension-blocker/assets/84767822/3ea57c2d-6947-41dd-836d-d47cf6af42ca)

## ERD
![ERD](https://github.com/sw801733/file-extension-blocker/assets/84767822/523cce5b-9902-49f7-a65d-c44e5e8f4470)

- **`id`** : 확장자의 고유 식별자 (Primary Key) [int]
- **`extension`** : 확장자 문자열 (ex : "exe", "sh") [text]
- **`type`** : 확장자 유형 ("fixed" 또는 "custom") [text]
- **`is_checked`** : 확장자가 활성화(차단) 상태인지 여부 [tinyint]

## API 명세

- `POST`
    - api/fix-extension/{extension} : 고정 확장자 **추가** 메서드
    - api/custom-extension/{extension} : 커스텀 확장자 **추가** 메서드
- `DELETE`
    - api/fix-extension/{extension} : 고정 확장자 **삭제** 메서드
    - api/custom-extension/{extension} : 커스텀 확장자 **삭제** 메서드
- `GET`
    - api/fix-extension : 추가한 고정 확장자 **조회** 메서드
    - api/custom-extension : 추가한 커스텀 확장자 **조회** 메서드


# 고려사항

**과제 설계와 구현 상에서 고려해야할 사항**

- 면접 가능일까지 접근이 가능해야 하므로 위의 모든 서비스가 **접근 가능하도록 유지**되어야 한다.
- Backend 의 EC2 **VPC** 설정으로 Github Page 에서만 접근이 가능하도록 설정한다.
    - Github Page 는 VPC 에서 고정으로 접근제어를 할 수는 없으므로 우선은 CORS 설정으로 Github Page 도메인만 등록한다.
    - Github Page 는 HTTPS 이며 EC2는 기본적으로 HTTP 이므로 EC2 서버를 HTTPS 로 설정해야 한다. (ACM & ALB)
- EC2 와 RDS 를 통해 연결이 가능하도록 **VPC 를 설정**한다. 단, RDS 는 EC2 에서만 접근하도록 **Private subnet** 으로 설정한다.

# 결과
![Animation](https://github.com/sw801733/file-extension-blocker/assets/84767822/29a209cf-89e1-45dc-8861-3882b218483b)

# 추후 수정 및 개선 필요 사항
- 테스트 코드 작성
- 서버와의 통신, SQL문 수행 등 다양한 경우에 대한 예외 처리 추가 
- `EC2` 와 `RDS` VPC 보안 검토

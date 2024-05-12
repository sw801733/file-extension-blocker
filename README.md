# file-extension-blocker

# 개발 일지
https://sprinkle-random-ca4.notion.site/44835d4da09d46e9b12cefe2dc18e9fe?pvs=4

# 구현 방법
- `React` 와 Github Page 를 활용한 **Frontend** 사이트 개발
- `Spring Boot` 와 AWS EC2 를 활용한 **Backend** 서버 개발
- `AWS RDS` MySQL 을 활용한 **Database** 구축

## 구현 방법 다이어그램
![구현 다이어그램](https://github.com/sw801733/file-extension-blocker/assets/84767822/5cfbbb69-2d29-47f4-a597-dc4253aa1640)

## 아키텍처
![아키텍처](https://github.com/sw801733/file-extension-blocker/assets/84767822/3ea57c2d-6947-41dd-836d-d47cf6af42ca)

## ERD
![ERD](https://github.com/sw801733/file-extension-blocker/assets/84767822/523cce5b-9902-49f7-a65d-c44e5e8f4470)

- **`id`** : 확장자의 고유 식별자 (Primary Key) [int]
- **`extension`** : 확장자 문자열 (ex : "exe", "sh") [text]
- **`type`** : 확장자 유형 ("fixed" 또는 "custom") [text]
- **`is_checked`** : 확장자가 활성화(차단) 상태인지 여부 [tinyint]


## 고려사항

**과제 설계와 구현 상에서 고려해야할 사항**

- 면접 가능일까지 접근이 가능해야 하므로 위의 모든 서비스가 **접근 가능하도록 유지**되어야 한다.
- Backend 의 EC2 **VPC** 설정으로 Github Page 에서만 접근이 가능하도록 설정한다.
    - Github Page 는 VPC 에서 고정으로 접근제어를 할 수는 없으므로 **8080 포트** 접근 추가
- Frontend 와 Backend 사이의 **CORS** 설정을 하고 Github Page 도메인에 대해서만 접근이 가능하도록 설정한다.
- EC2 와 RDS 를 통해 연결이 가능하도록 **VPC 를 설정**한다. 단, RDS 는 EC2 에서만 접근하도록 **Private subnet** 으로 설정한다.

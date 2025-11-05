<img width="622" height="726" alt="image" src="https://github.com/user-attachments/assets/fc5c2bad-8e90-41e8-b0df-77ac69376de8" />

👤 User 기능
사용자 생성 (POST /user)

사용자 조회 (GET /user/{userId})

이메일 수정 (PATCH /user/Email/{userId}/{newEmail})

이름 수정 (PATCH /user/Name/{userId}/{newName})

사용자 삭제 (DELETE /user/{userId})

📝 Text 기능
텍스트 생성 (POST /text)

특정 텍스트 조회 (GET /text/textId/{textId})

사용자의 모든 텍스트 조회 (GET /text/userTexts/{userId})

제목 수정 (PATCH /text/title/{textId}/{newTitle})

내용 수정 (PATCH /text/body/{textId}/{newBody})

텍스트 삭제 (DELETE /text/{textId})

-jpa 추상 클래스

1.공통 필드와 로직 재사용
모든 엔티티가 공유하는 필드(id, createdAt, updatedAt 등)을
추상 클래스에 넣고 상속받아서 코드 중복을 없앰.

2.직접 인스턴스화되지 않도록 하기 위함
공통 속성만 가지고 있고, 구체적 엔티티는 각 하위 클래스에서 정의하도록 하기 위해.

3.JPA의 상속 매핑 전략(@Inheritance)과 함께 사용
추상 클래스는 실제 테이블과 직접 연결되지 않을 수도 있고,
하위 클래스들이 각각 테이블로 매핑되도록 할 수 있음.

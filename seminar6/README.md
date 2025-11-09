## API 명세서

### 1. 상품 등록 (POST)

**Endpoint:** `POST /product`  

**Request Body:**
```json
{
  "name": "String",
  "color": "String",
  "price": 0,
  "count": 0
}
````

**Response:**

* `200` : 성공
* `409` : 중복값 입력
* 기타 : 오류

**특징:**

* count 값에 따라 sellable 자동 수정
* 같은 `{name, color}` 조합은 중복 입력 불가

---

### 2. 색상 일괄 변경 (PATCH)

**Endpoint:** `PATCH /product/allColor`

**Request Body:**

```json
{
  "color": "String",
  "count": 0
}
```

**Response:**

* `200` : 수정 완료
* 기타 : 실패

---

### 3. 선택 수정 (PATCH)

**Endpoint:** `PATCH /product/update`

**Request Body:**

```json
{
  "id": 0,
  "name": "String",
  "color": "String",
  "price": 0,
  "count": 0
}
```

**Response:**

* `200` : 성공
* `409` : 수정하려는 `{name, color}`가 이미 존재하면 기존 ID에 count 합산 후 현재 ID 삭제
* 기타 : 오류

---

### 4. 상품 일괄 출력 (GET)

**Endpoint:** `GET /product/getAll`

**Response Body:**

```json
[
  {
    "name": "String",
    "price": 0,
    "count": 0,
    "sellable": true
  }
]
```

**Response Codes:**

* `200` : 성공
* 기타 : 실패

> 모든 GET 요청은 `@PathVariable`을 통해 parameter 전달

---

### 5. 특정 색상 상품 출력 (GET)

**Endpoint:** `GET /product/getColor/{color}`

**Path Variable:**

* `color` : String

**Response Body:**

```json
[
  {
    "id": 0,
    "name": "String",
    "color": "String",
    "price": 0,
    "count": 0,
    "sellable": true
  }
]
```

**Response Codes:**

* `200` : 성공
* 기타 : 실패

---

### 6. 특정 상품 색상 출력 (GET)

**Endpoint:** `GET /product/getPrdColor/{name}`

**Path Variable:**

* `name` : String

**Response Body:**

```json
[
  {
    "color": "String",
    "count": 0
  }
]
```

**Response Codes:**

* `200` : 성공
* 기타 : 실패

---

### 7. 특정 상품 출력 (GET)

**Endpoint:** `GET /product/getPrd/{name}/{color}`

**Path Variables:**

* `name` : String
* `color` : String

**Response Body:**

```json
{
  "id": 0,
  "name": "String",
  "color": "String",
  "price": 0,
  "count": 0,
  "sellable": true
}
```

**Response Codes:**

* `200` : 성공
* 기타 : 실패

---

### [추가 과제] 색깔별 전체 수량 (GET)

**Endpoint:** `GET /product/getAllColor`

**Response Body:**

```json
[
  {
    "color": "String",
    "count": 0
  }
]
```

**Response Codes:**

* `200` : 성공
* 기타 : 실패


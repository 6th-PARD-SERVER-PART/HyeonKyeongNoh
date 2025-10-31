📝 Text API (/text)
텍스트 생성 (POST /text)
Request Body: TextInfo
JSON
{
"userId": 0,
"textId": 0,
"textTitle": "string",
"textBody": "string"
}

텍스트 제목 수정 (PATCH /text/title/{textId}/{newTitle})
Path Variables: textId (Long), newTitle (String)

텍스트 내용 수정 (PATCH /text/body/{textId}/{newBody})
Path Variables: textId (Long), newBody (String)

사용자별 텍스트 목록 조회 (GET /text/userTexts/{userId})
Path Variable: userId (Long)

특정 텍스트 조회 (GET /text/textId/{textId})
Path Variable: textId (Long)

텍스트 삭제 (DELETE /text/{textId})
Path Variable: textId (Long)

❤️ Like API (/like)
좋아요 추가 (POST /like)

Request Body: LikeInfo
JSON
{
"userId": 0,
"textId": 0
}
📦 Schemas (데이터 모델)
UserInfo:
id (Long)
name (String)
email (String)
TextInfo:
userId (Long)
textId (Long)
textTitle (String)
textBody (String)
LikeInfo:
userId (Long)
textId (Long)
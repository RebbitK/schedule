# API 명세서
| 기능 | Method    | URL | request              |  response |
|----------|---------|-----|---------------------|---------------|
| 일정 작성 | POST | /api/schedules  | {"title":"테스트", <br/> "contents":"내용", <br/> "manager":"매니저", <br/> "password":"1234"}    | 비밀번호를 제외한 등록한 일정의 정보 |
| 선택한 일정 조회  | GET | /api/schedules/{id}  |     | 비밀번호를 제외한 선택한 일정의 정보 |
| 일정 목록 조회  | GET  | /api/schedules  |     | 비밀번호를 제외한 일정들의 목록 작성일기준 내림차순 |
| 선택한 일정 수정 | PUT | /api/schedules/{id}/{password} | {"title":"테스트변경", <br/> "contents":"내용변경", <br/> "manager":"매니저변경"} | 비밀번호가 맞다면 비밀번호를 제외한 수정된 정보 반환 |
| 선택한 일정 삭제   | DELETE |/api/schedules/{id}/{password} | |비밀번호가 맞다면 선택한 일정 삭제 |

# ERD

![다이어그램2](https://github.com/RebbitK/schedule/assets/154823447/cca75769-7162-4444-a49a-6a0215e28362)

# Use Case Diagram



## JAVA 알고리즘 문제 풀이
|파일명|문제|키워드|주제|
|:------|:---:|:---:|:---:|
|Prob1_1|문자 찾기|`char.toCharArray()`, `Character.toupperCase()`|구현|
|Prob1_2|대소문자 변환|`StringBuilder`, `ASCII`|구현|
|Prob1_3|문장 속 단어|`Integer.MIN_VALUE` |구현|
|Prob1_4|단어 뒤집기|`stringBuilder.reverse()`, `string.valueOf()`|구현|
|Prob1_5|특정 문자 뒤집기|`Character.isAlphabetic()`|구현|
|Prob1_6|중복 문자 제거|`Set`|구현|
|Prob1_7|회문 문자열|`string.equalsIgnoreCase()`|구현|
|Prob1_8|유효한 팰린드롬|`정규표현식`, `string.replaceAll()` |구현|
|Prob1_9|숫자만 추출|`Character.isDigit()` `ASCII Code`|구현|
|Prob1_10|가장 짧은 문자 거리|`Math.abs()`|구현|
|Prob1_11|문자열 압축|-|구현
|Prob1_12|암호|`Integer.parseInt(String형 진수, 1번째파라미터의 진수)`, `Character.toChars()`|구현|
|Prob2_1|큰 수 출력하기|`StringTokenizer`|구현|
|Prob2_2|보이는 학생|-|구현|
|Prob2_3|가위바위보|-|구현|
|Prob2_4|피보나치 수열|-|구현|
|Prob2_5|소수(에토테네스 체)|-|구현|
|Prob2_6|뒤집은 소수|-|구현|
|Prob2_7|점수 계산|-|구현|
|Prob2_8|등수 구하기|`System.arraycopy(arr, 0, reverse, 0, N)`|구현|
|Prob2_9|격자판 최대합|-|구현|
|Prob2_10|봉우리|-|구현|
|Prob2_11|임시반장 정하기|-|구현|
|Prob2_12|멘토링|-|구현|
|Prob3_1|두 배열 합치기|-|Two Pointer|
|Prob3_2|공통 원소 구하기|`Arrays.sort()`<br> `arrayList.sort(Comparator.naturalOrder())`|Two Pointer|
|Prob3_3|최대 매출|-|Sliding Window|
|Prob3_4|연속 부분수열|-|Two Pointer|
|Prob3_5|연속된 자연수의 합|-|Two Pointer, Math|
|Prob3_6|최대 길이 연속부분수열|-|Two Pointer|
|Prob4_1|학급 회장|`hashMap.getorDefault(key, value)`|구현|
|Prob4_2|아나그램|`hashMap.containsKey`|구현|
|Prob4_3|매출액의 종류|-|구현|
|Prob4_4|모든 아나그램 찾기|-|구현|
|Prob4_5|K번째 큰 수|`TreeSet`, `Collections.reverseOrder()`|구현|
|Prob5_1|올바른 괄호|`Stack`|Stack|
|Prob5_2|괄호문자제거|-|Stack|
|Prob5_3|크레인 인형뽑기|`stack.peek()`|Stack|
|Prob5_4|후위식 연산(postfix)|-|Stack|
|Prob5_5|쇠막대기|-|Stack|
|Prob5_6|공주구하기|`Queue`, `queue.offer()`, `queue.poll()`|Queue|
|Prob5_7|교육과정설계|-|Queue|
|Prob5_8|응급실|-|Queue|
|Prob6_1|선택 정렬|-|선택 정렬|
|Prob6_2|버블 정렬|-|버블 정렬|
|Prob6_3|삽입 정렬|-|삽입 정렬|
|Prob6_4|LRU(캐시, 카카오 변형)|-|구현|
|Prob6_5|중복확인|-|구현|
|Prob6_6|장난꾸러기|`deep copy-array.clone()`|구현|
|Prob6_7|좌표 정렬|`Comparable`|정렬|
|Prob6_8|이분검색|-|이분 검색|
|Prob6_9|뮤직비디오|`Arrays.stream(array).max().getAsInt()`|결정 알고리즘|
|Prob6_10|마구간 정하기|-|결정 알고리즘|
|Prob7_1|재귀함수(스택 프레임)|-|재귀함수|
|Prob7_2|이진수 출력|-|재귀함수|
|Prob7_3|팩토리얼|-|재귀함수|
|Prob7_4|피보나치 재귀|-|DP|
|Prob7_5|이진트리 순회|-|DFS|
|Prob7_6|부분집합 구하기|-|DFS|
|Prob7_7|이진트리 레벨 탐색|`Queue`|BFS|
|Prob7_8|송아지 찾기|-|BFS|
|Prob7_9|Tree 말단노드까지 최단 경로|-|DFS|
|Prob7_10|Tree 말단노드까지 최단 경로|-|BFS|
|Prob7_12|경로 탐색|-|DFS, 인접 행렬|
|Prob7_13|경로 탐색|-|BFS, 인접 리스트|
|Prob7_14|그래프 최단거리|-|BFS|
|Prob8_1|합이 같은 부분집합|-|DFS|
|Prob8_2|바둑이 승차|-|DFS|
|Prob8_3|최대점수 구하기|-|Greedy,DFS|
|Prob8_4|중복순열|-|DFS|
|Prob8_5|동전교환|-|DFS|
|Prob8_6|순열 구하기|-|DFS|
|Prob8_7|조합수(메모이제이션)|-|DP|
|Prob8_8|수열 추측하기|-|DFS|
|Prob8_9|조합 구하기|-|DFS|
|Prob8_10|미로탐색|-|DFS|
|Prob8_11|미로의 최단거리 통로|-|BFS|
|Prob8_12|토마토|-|BFS|
|Prob8_13|섬나라 아일랜드|-|DFS|
|Prob8_14|섬나라 아일랜드|-|BFS|
|Prob8_15|피자배달거리|-|DFS, 조합|
|Prob9_1|씨름선수|-|Greedy|
|Prob9_2|회의실 배정|-|Greedy|
|Prob9_3|결혼식|-|Greedy|
|Prob9_4|최대수입스케줄|`PriorityQueue<>(Collections.reverseOrder())`|Greedy|
|Prob9_5|최단경로|-|다익스트라|
|Prob9_6|친구인가|-|Union&Find|
|Prob9_7|원더랜드|-|크루스칼|
|Prob9_8|원더랜드|-|프림|
|Prob10_1|계단오르기|-|DP|
|Prob10_2|돌다리 건너기|-|DP|
|Prob10_3|최대부분증가수열|-|DP|
|Prob10_4|가장 높은 탑 쌓기|-|DP|
|Prob10_5|동전 교환|-|DP|
|Prob10_6|최대점수 구하기|-|DP, DFS|

## 백준
|파일명|문제|키워드|주제|
|:------|:---:|:---:|:---:|
|Baek2504|괄호의 값|-|스택|
|Baek11723|집합|-|비트마스킹|
|Baek2064|IP 주소|-|비트마스킹|
|Baek1152|단어의 개수|-|구현|
|Baek11047|동전 0|-|Greedy|
|Baek11720|숫자의 합|-|구현|
|Baek11659|구간 합 구하기4|-|구현|
|Baek2018|수들의 합5|-|Two Pointer|
|Baek1940|주몽|-|구현|
|Baek11724|연결 요소의 개수|-|DFS|
|Baek2178|미로 탐색|-|BFS|
|Baek2252|줄 세우기|-|위상 정렬|

## 프로그래머스
|파일명|문제|키워드|주제
|:------|:---:|:---:|:---:
|Kakao2023Blind_1|개인정보 수집 유효기간|-|구현|
|Kakao2023Blind_2|택배배달과 수거하기|`Stack`|구현|
|Kakao2023Blind_3|이모티콘 할인행사|-|구현|
|DevMatching2021_2|행렬 테두리 회전하기|-|DFS|
|FoodFightContest|푸드 파이트 대회|-|구현|
|PhoneBookList|전화번호 목록|-|해시|
|PartialSequenceSum|연속된 부분 수열의 합|-|Two Pointer|
|Immigration|입국 심사|-|이진 탐색|
|MoreSpicy|더 맵게|-|Heap|
|Pokemon|포켓몬|-|해시|
|Camouflage|위장|-|조합|
|BiggestNumber|가장 큰  수|-|정렬|
|HateSameNum|같은 숫자는 싫어|-|구현|
|MockExam|모의고사|-|구현|
|TargetNumber|타겟 넘버|-|DFS|
|Network|네트워크|-|UNF|
|KNumber|K번째 수|-|정렬|
|SearchPrime|소수 찾기|-|DFS|
|IntegerTriangle|정수 삼각형|-|DP|
|PaintOver|덧칠하기|-|구현|
|NearestLetter|가장 가까운 글자|-|구현|
|BestAlbum|베스트 앨범|-|해시|
|FeatureDevelopment|기능 개발|-|구현|
|MinimalRectangle|최소 직사각형|-|구현|
|DiskController|디스크 컨트롤러|-|해시|
|HIndex|H-Index|-|구현|
|CorrectParentheses|올바른 괄호|-|Stack|
|Process|프로세스|-|Queue|
|GameMapShortestDistance|게임 맵 최단거리|-|BFS|
|FurthestNode|가장 먼 노드|-|그래프|
|Rank|순위|-|플로이드 와샬|
|NoFinishPlayer|완주하지 못한 선수|-|구현|
|StockPrice|주식 가격|-|구현|
|DoublePriorityQueue|이중우선순위큐|-|구현|
|WordTranslation|단어 변환|-|DFS|
|TravelPath|여행 경로|-|DFS|

## 소프티어
|파일명|문제|키워드|주제|
|:------|:---:|:---:|:---:|
|Gearbox8Level|8단 변속기|-|구현|
|DriveDistance|주행거리 비교하기|-|구현|
|ObstacleProgram|장애물 인식 프로그램|-|DFS|
|SafeCracker|금고털이|`Colleections.sort(target, 람다)`|Greedy|
|GradeEvaluation|성적 평가|`PriorityQueue`|구현|
|ClassroomAssignment|강의실 배정|-|Greedy|

## SW Expert Academy
|파일명|문제|키워드|주제|
|:------|:---:|:---:|:---:|
|SWEA1206|View|-|구현|
|SWEA1244|최대 상금|-|DFS|
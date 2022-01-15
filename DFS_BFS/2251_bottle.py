from collections import deque

def pour(x, y):
    if not visited[x][y]:
        visited[x][y] = True
        q.append((x, y))

def bfs():

    while q:
        a1, b1 = q.popleft()
        c1 = c - a1 - b1

        if a1 == 0:
            res.append(c1)

        # a -> b
        water = min(a1, b-b1)
        pour(a1 - water, b1 + water)

        # a -> c
        water = min(a1, c-c1)
        pour(a1 - water, b1)

        # b -> a
        water = min(b1, a-a1)
        pour(a1 + water, b1 - water)

        # b -> c
        water = min(b1, c-c1)
        pour(a1, b1 - water)

        # c -> a
        water = min(c1, a-a1)
        pour(a1 + water, b1)

        # c -> b
        water = min(c1, b-b1)
        pour(a1, b1 + water)


a, b, c = map(int, input().split())

q = deque()
q.append((0, 0)) # a 물통과 b 물통의 물의 양이 0일때부터 탐색

visited = [[False] * 201 for _ in range(201)]
visited[0][0] = True

# a 물통의 양이 0일 때 c 물통의 양
res = []

bfs()

# 오름차순 정렬 후 출력
res.sort()
print(*res)
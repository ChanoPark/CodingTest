def DFS(n):
    visited[n]=1
    for i in node[n]:
        if(visited[i]==0):
            visited[i]=1
            DFS(i)


N, M = map(int, input().split())
node = [[]*(M+1) for _ in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    node[a].append(b)
    node[b].append(a)

visited = [0]*(N+1)

result = 0
for i in range(1, N+1):
    if(visited[i]==0):
        DFS(i)
        result+=1

print(result)

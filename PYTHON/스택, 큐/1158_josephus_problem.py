class Queue:
    def __init__(self):
        self.item = []
        self.front_index = 0
    def enqueue(self, val):
        self.item.append(val)
    def dequeue(self):
        x = self.item[self.front_index]
        self.front_index += 1
        return x
    def front(self):
        return self.item[self.front_index]
    def lenQ(self):
        return len(self.item) - self.front_index

n, k = map(int, input().split())
cnt = 1

Q = Queue()
Str = "<"

for i in range(1,n+1):
    Q.enqueue(i)

while(Q.lenQ() != 1):
    if(cnt%k == 0):
        Str += str(Q.dequeue())
        Str += ", "
    else:
        Q.enqueue(Q.dequeue())
    cnt+=1
Str += str(Q.dequeue())
Str += ">"

print(Str)
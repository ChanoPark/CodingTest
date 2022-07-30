class Stack:
    def __init__(self):
        self.item = []
    def push(self, X):
        self.item.append(X)
    def pop(self):
        try:
            self.item.pop()
        except IndexError:
            print("Index Error!")
            exit(0)
    def top(self):
        try:
            return self.item[-1]
        except IndexError:
            print("Index Error!!")
            exit(0)
    def len_stack(self):
        return len(self.item)

    def check(self):
        for i in self.item:
            if (i == "(" or i == "["):
                print(0)
                exit(0)

def prob(S, paren):
    for p in paren:
        temp = 0
        if p == "(" or p == "[":
            S.push(p)
        elif p == ")": # 닫는 소괄호가 들어왔을 때
            while(S.len_stack()):
                if S.top() == "(":
                    S.pop()
                    if (temp == 0):
                        S.push(2)
                    else:
                        S.push(temp*2)
                    break 
                elif (S.top() == "]" or S.top() == "[" or S.top() == ")"): #잘못된 종류의 괄호가 있을 때
                    print("0")
                    exit(0)
                else:
                    temp += S.top()
                    S.pop()
        elif p == "]": # 닫는 대괄호가 들어왔을 때
           while(S.len_stack()):
                if S.top() == "[":
                    S.pop()
                    if (temp == 0):
                        S.push(3)
                    else:
                        S.push(temp*3)
                    break
                elif (S.top() == ")" or S.top() == "("): #잘못된 종류의 괄호가 있을 때
                    print("0")
                    exit(0)
                else:
                    temp += S.top()
                    S.pop()


    S.check()
    while(S.len_stack() != 1):
        temp = S.top()
        S.pop()
        temp += S.top()
        S.pop()
        S.push(temp)
    print(S.top())

### MAIN ###
S = Stack()
paren = input()
prob(S, paren)
import sys

##체크리스트 만들어서 sum을 활용하는 법!
def check(sudoku):
    for i in range(9):
        checkRow = [0]*10
        checkCol = [0]*10
        
        for j in range(9):
            checkRow[sudoku[i][j]]=1
            checkCol[sudoku[j][i]]=1
        
        if(sum(checkRow) != 9 or sum(checkCol) != 9): #행, 열 동시에 검사하니까 한 행 끝날때마다 체크
            return False
    
    for i in range(0,7,3):
        for j in range(0,7,3):
            checkThree = [0]*10

            for r in range(0,3):
                for c in range(0,3):
                    checkThree[sudoku[r+i][c+j]]=1
                
            if(sum(checkThree)!=9):
                return False
    
    return True


    ### 일일히 반복문을 돌면서 count 함수 활용한 것...
    # for a in range(10):
    #     for i in range(0,9):
    #         tmp = []
    #         #가로 검사
    #         if (sudoku[i].count(a) > 1):
    #             return False
    #         #세로 검사
    #         for m in range(0,9):
    #             if (sudoku[m][i] not in tmp):
    #                 tmp.append(sudoku[m][i])
    #             else:
    #                 return False
    #         else:
    #             del tmp
    
    # #3X3 검사
    # for j in range(0, 7, 3): #가로 (3X3 검사의 시작점 잡기)
    #     for k in range(0, 7, 3): #세로
    #         tmp = []

    #         #3X3 한바퀴 돌기
    #         for r in range(0,3):
    #             for c in range(0,3):
    #                 if (sudoku[r+j][c+k] not in tmp):
    #                     tmp.append(sudoku[r+j][c+k])
    #                 else:
    #                     return False
    #         else:
    #             del tmp
    # return True

sudoku = [list(map(int,sys.stdin.readline().split())) for _ in range(9)]

if(check(sudoku)):
    print("YES")
else:
    print("NO")
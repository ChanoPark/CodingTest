import sys

N, M = map(int, sys.stdin.readline().split())

numbers = list(map(int,sys.stdin.readline().split()))

numbers.sort()

print(numbers.index(M)+1)
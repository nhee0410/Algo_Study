#a b c 세개의 합이 M과 일치하거나 가까운거 찾기
#일치한거 찾으면 반복문 탈출
#일치한게 없으면 가장 가까운 값 출력


import itertools
from math import remainder

N,M=map(int, input().split())
number=list(input().split())

array = list(itertools.combinations(number,3))

value=9
remain=400000
flag=False

for i in range(len(array)):
    sum=int(array[i][0])+int(array[i][1])+int(array[i][2])

    if(sum==M):
        print(sum)
        flag=True
        break
    elif(M-sum<remain and (M-sum)>0):
        remain=M-sum
        value=sum

if(flag!=True):
    print(value)

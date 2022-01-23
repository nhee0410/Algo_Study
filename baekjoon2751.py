import sys
"""
def DNC_sort(array):
    if len(array)<=1:
        return array
    mid=int(len(array)/2)

    left=DNC_sort(array[:mid])
    right=DNC_sort(array[mid:])

    i=0
    j=0
    a=[]

    while i < len(left) and j < len(right): 
        if left[i] < right[j]: 
            a.append(left[i]) 
            i+=1 
        else: 
            a.append(right[j]) 
            j+=1

    a += left[i:] 
    a += right[j:] 
    
    return a
"""


N=int(input())
number=[]
for i in range(0,N):
    number.append(int(sys.stdin.readline()))

number.sort()

for i in number:
    sys.stdout.write(str(i)+'\n')
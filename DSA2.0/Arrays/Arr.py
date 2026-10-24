# import array as arr
from array import *

""" # val = arr.array('i', [1, 2, 3, 4, 5, 6])
val = array('i', [1, 2, 3, 4, 5, 6, 7, 8, 9])
# val = array('u', ['a', 'b', 'c', 'd'])

for i in range(0, len(val)):
    print(val[i], end=" ")

print("\n")

for x in val:
    print(x, end=', ')

print(val.typecode)

val.reverse()

val.insert(1, 50)
val.append(100)
val[2] = 200

copyArr = array(val.typecode, (x for x in val))

copyArr.pop(3)
copyArr.remove(5)

# a = val[2 : -3]
a = val[::-1] """

arr = array('i', [12, 25, 625, 54, 89, 56])

""" n = int(input('Enter a number: '))

for i in range(0, n):
    arr.append(int(input('Enter next input')))

for x in arr:
    print(x, end=" ") """

i = arr.index(25)

print(i)
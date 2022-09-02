import sys
import string
import math

N = 182755680224874988969105090392374859247
a = 286458106491124997002528249079664631375
P = 231980187997634794246138521723892165531

def allchar():
    return [char for char in string.printable]

def pulv(A, B):
    Q , R = divmod(A, B)
    x1 = 1
    y1 = 0
    x2 = 0
    y2 = 1
    while (R != 0):
        A = B
        B = R
        tempx2 = x2
        tempy2 = y2
        x2 = x1 - (Q * x2)
        y2 = y1 - (Q * y2)
        x1 = tempx2
        y1 = tempy2
        Q , R = divmod(A, B)
    if (y2 < 0):
        return P - abs(y2)
    return y2

# Point doubling works
def pointdoubling(newpoints):
    d = 2*newpoints[1]
    if d > P:
        d = d % P
    m = (((3 * (newpoints[0]**2)) + a) * (pulv(P, d))) % P
    xp = ((m**2) - (2 * newpoints[0])) % P
    yp = (newpoints[1] + (m * (xp - newpoints[0]))) % P
    return [xp, P - yp]

# Adding points works
def addpoints(x1, y1, points):
    d = x1 - points[0]
    if d < 0:
        d = d + P
    m = ((y1 - points[1]) * pulv(P, d)) % P
    x3 = ((m**2) - (x1 + points[0])) % P
    y3 = (y1 + (m * (x3 - x1))) % P
    return [x3, P - y3]

def findfullmask(n, hm):
    if (n == 1):
        return hm
    elif(n == 2):
        return pointdoubling(hm)
    elif (n % 2 == 1):
        return addpoints(hm[0], hm[1], findfullmask(n-1, hm))
    else:
        return pointdoubling(findfullmask(n/2, hm))

file1 = open('ellipticCipher2021.txt', 'r')
file2 = open('MyElliptic.txt', 'w')
count = 0
while True:
    line = file1.readline()
    if not line:
        break

    count = count + 1
    parts = line.split(' ')
    cipher = [long(parts[0]), long(parts[1])]
    halfmask = [long(parts[2]), long(parts[3])]
    fm = findfullmask(N, halfmask)
    fm[1] = P - fm[1]
    msg = addpoints(cipher[0], cipher[1], fm)
    print chr(int(msg[0]))
    file2.write(chr(int(msg[0])))


print("Is done")
file1.close()
file2.close()
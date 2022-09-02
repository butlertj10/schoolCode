import random
import string
import math
import sys

# Given Variables
n = 501131490825910275522812288218612956164577816083973169746903604353226984992937440229212071122485933375147208985799822891260291199336623060458430678947003757375066403403028604452413899359443157869010155446194212350852238381703832074004018217147542045711753654236220028168528971734507968350148295291368804218783857684634851269416386402693370685523187849164561614148580179773161019326569306064863780950851184444436755464634217528202328367766428205101686713669754857877990280613316979170141958750683048269331035991088038146553350434952162831926693280223813149811541364777419147135453256050103463343066331561611100341655643878388284784369694888546542157082074309445602877118625799443345156977607985937896004683027094991738234045494550424449165022839208746326936572513796469350086684800201428823979335253184348099469409541500448041823590470287137465734676949475028317128038000393156901037654009954675774113563807430653632118527551628858071534488318046950268205833664323070566072846238778983281754449988699535212414717416522829057230912776803219800960647272089035265255381163810563604540454437185711425924314155698367876154434712603070428963965653947223089685973961466324067584083036692469456672568975727136389523024480634853954614965347589
e = 607

def gcd(a,b):
    if(b==0):
        return a
    else:
        return gcd(b,a%b)

def split(word):
    return [ord(char)**e % n for char in word]

def split2(word):
    return [char for char in word]

def power(x, y, p):
     
    # Initialize result
    res = 1;
     
    # Update x if it is more than or
    # equal to p
    x = x % p;
    while (y > 0):
         
        # If y is odd, multiply
        # x with result
        if (y & 1):
            res = (res * x) % p;
 
        # y must be even now
        y = y>>1; # y = y/2
        x = (x * x) % p;
     
    return res;
 
def miillerTest(d, n):
     
    # Pick a random number in [2..n-2]
    # Corner cases make sure that n > 4
    a = 2 + random.randint(1, n - 4);
 
    # Compute a^d % n
    x = power(a, d, n);
 
    if (x == 1 or x == n - 1):
        return True;
 
    while (d != n - 1):
        x = (x * x) % n;
        d *= 2;
 
        if (x == 1):
            return False;
        if (x == n - 1):
            return True;
 
    return False;

def isPrime(n, k):
     
    # Corner cases
    if (n <= 1 or n == 4):
        return False;
    if (n <= 3):
        return True;

    d = n - 1;
    while (d % 2 == 0):
        d //= 2;
 
    # Iterate given nber of 'k' times
    for i in range(k):
        if (miillerTest(d, n) == False):
            return False;
 
    return True;
 
# Driver Code
# Number of iterations
k = 4;

P = random.getrandbits(1024)
Q = random.getrandbits(1024)
while isPrime(P, k) == False:
    P = random.getrandbits(1024)
print("p = ", P)

while isPrime(Q, k) == False:
    Q = random.getrandbits(1024)
print("q = ", Q)

def getModInverse(a, m):
    if math.gcd(a, m) != 1:
        return None
    u1, u2, u3 = 1, 0, a
    v1, v2, v3 = 0, 1, m

    while v3 != 0:
        q = u3 // v3
        v1, v2, v3, u1, u2, u3 = (
            u1 - q * v1), (u2 - q * v2), (u3 - q * v3), v1, v2, v3
    return u1 % m

# Variables
N = P * Q
phi = (P-1)*(Q-1)
E = 2
D = getModInverse(e, phi)

while(gcd(phi, E) != 1):
    if gcd(phi, E) != 1:
        E = E + 1
    else:
        E = 1


word = string.printable

file1 = open('rsacipher_S21.txt', 'r')
file2 = open('RSA-Cipher.txt', 'w+')
file3 = open('RSA-Values.txt', 'w+')

myP = ("This is my P: ") 
file3.write(myP)
file3.write(str(P))
file3.write("\n")
file3.write("\n")
myQ = ("This is my Q: ") 
file3.write(myQ)
file3.write(str(Q))
file3.write("\n")
file3.write("\n")
myN = ("This is my N: ") 
file3.write(myN)
file3.write(str(N))
file3.write("\n")
file3.write("\n")
myE = ("This is my E: ")
file3.write(myE)
file3.write(str(E))
file3.write("\n")
file3.write("\n")
myPhi = ("This is my Phi: ")
file3.write(myPhi)
file3.write(str(phi))
file3.write("\n")
file3.write("\n")
myD = ("This is my D: ")
file3.write(myD)
file3.write(str(D))
file3.write("\n")
file3.write("\n")


while True: 
 


    line = file1.readline()

    if not line:
        break

    asc = (str((split(word).index(int(line.strip()))**E) % N), "\n")
    print(asc)
    file2.writelines(asc)

file1.close()
file2.close()





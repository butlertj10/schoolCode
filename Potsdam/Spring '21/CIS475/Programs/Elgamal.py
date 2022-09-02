import sys
import string
import math
import random
from random import randrange, getrandbits

p = 103875884360103211991897586898037781183899818694169088324836118209929355028883
g = 19337813427646184739424464459107629746680173987835432904634899380776619812079
a = 46434048098888938362095095444967125024438409723853932409707374167548736061787
H = 6343087477697406215547913137244545421914737047273749624341349833379509687087
q = (p-1)/2

def allchar():
    return [char for char in string.printable]

# Pulverizer algorithm
def pulverizer(A, B):
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
        return p - abs(y2)
    return y2

def is_prime(n, k=128):
    # Test if n is not even.
    # But care, 2 is prime !
    if n == 2 or n == 3:
        return True
    if n <= 1 or n % 2 == 0:
        return False
    # find r and s
    s = 0
    r = n - 1
    while r & 1 == 0:
        s += 1
        r //= 2
    # do k tests
    for _ in range(k):
        a = randrange(2, n - 1)
        x = pow(a, r, n)
        if x != 1 and x != n - 1:
            j = 1
            while j < s and x != n - 1:
                x = pow(x, 2, n)
                if x == 1:
                    return False
                j += 1
            if x != n - 1:
                return False
    return True

def generate_prime_candidate(length):
    # generate random bits
    n = getrandbits(length)
    # apply a mask to set MSB and LSB to 1
    n |= (1 << length - 1) | 1
    return n

def generate_prime_number(length=256):
    n = 4
    # keep generating while the primality test fail
    while not is_prime(n, 128):
        n = generate_prime_candidate(length)
    return n

# To be able to speed up the exponentiation modulos process
def fastExponentiation(x, e, m):
    X = x
    E = e
    Y = 1
    while E > 0:
        if E % 2 == 0:
            X = (X * X) % m
            E = E/2
        else:
            Y = (X * Y) % m
            E = E - 1
    return Y

def findgen(blen, p):
    gen = random.getrandbits(blen)
    x = 1
    while(gen**x % p != 1):
        if x == q:
            return gen
        x = x + 1
    findgen(blen, p)

def find_primitive_root( p ):
        if p == 2:
                return 1
        #the prime divisors of p-1 are 2 and (p-1)/2 because
        #p = 2x + 1 where x is a prime
        p1 = 2
        p2 = (p-1) // p1

        #test random g's until one is found that is a primitive root mod p
        while( 1 ):
                g = random.randint( 2, p-1 )
                #g is a primitive root if for all prime factors of p-1, p[i]
                #g^((p-1)/p[i]) (mod p) is not congruent to 1
                if not (fastExponentiation( g, (p-1)//p1, p ) == 1):
                        if not fastExponentiation( g, (p-1)//p2, p ) == 1:
                                return g



file1 = open('elgamal_cipher_2021.txt', 'r')
file2 = open('ElgamalMessage.txt', 'w')
file3 = open('EncryptedElgamalMessage.txt', 'w')
file4 = open('TestingElgamal.txt', 'w')

newp = 70986872155624008682377098920892850852355880691249373970753559486100073966693
newg = 11115223512899637920997199430744302112675162692786853173478630019933781690659
newa = randrange(1, (newp - 2))
newb = randrange(1, (newp - 2))
newHalfMask = fastExponentiation(newg, newb, newp)
while True:
    line = file1.readline()
    if not line:
        break

    parts = line.split(' ')
    cipher = long(parts[3])
    halfmask = long(parts[0])

    # Calculating full mask
    # F = halfmask**b % p
    F = fastExponentiation(halfmask, a, p)
    m = cipher * pulverizer(p, F) % p
    print(chr(m))
    file2.write(chr(m))

    # create half mask with m

    newCipher = (m * fastExponentiation(newHalfMask, newa, newp)) % newp
    file3.write(str(newHalfMask))
    file3.write("  ")
    file3.write(str(newCipher))
    file3.write("\n")

    newFullMask = fastExponentiation(newHalfMask, newa, newp)
    #newFullMask = pulverizer(newp, fastExponentiation(newA, newb, newp))
    #newFullMask = fastExponentiation(pulverizer(newp, newA), newb, newp)
    newm = (newCipher * pulverizer(newp, newFullMask)) % newp
    print(newm)
    file4.write(chr(newm))
    

print("g = ", int(newg))
print("p = ", int(newp))

file1.close()
file2.close()
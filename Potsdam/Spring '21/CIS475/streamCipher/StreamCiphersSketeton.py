import sys

def strxor(a, b):
    if len(a) > len(b):
        return "".join([chr(ord(x) ^ ord(y)) for (x, y) in zip(a[:len(b)], b)])
    else:
        return "".join([chr(ord(x) ^ ord(y)) for (x, y) in zip(a, b[:len(a)])])

        zip("0010".decode("hex"), "0104".decode("hex"))

def encrypt(key, msg):
    c = strxor(key,msg)
    return c

if __name__=='__main__':
    cipher1 = "57fa34eb8e267b3d055506961969dadadbb1e84054f08449da40805c92ff10c37e8b19251749a7f326eb37af8a179a7002ff049c6e417063de39283862f5732b8859487df53553b136"#string.strip().decode('hex')
    cipher2 = "52f960b894383e3c0444069f1a75d4dadab1e50b06ec8449da5c855094ad1ec327cd1538044df5f868a220e09900db614df0019d3a4570208b3e383862e87324904c1a41d40572e27b45b831d18e97a752ae0a4a25a7356df6"#.decode('hex')
    cipher3 = "4cf725a5db3c2f73094e4b9f0526c59599a0f94202f889109b4f895dc0be1cd231981823014abcfb6ff620a3cc029e6d52f114c82f4c756dd2246c7c6ef632249b184e70fe7046ad6a47b033849c9da752bb0c5625bb2264ae7d797d18b2897dbe8d948022475f54add90aa9d0f4fed4c1cc16cc64c1cccdbf78304b14"#.decode('hex')
    cipher4 = "52f960b294207b210f57439b1a26c895cca2ab5811fa980ccf5dc74d8fff0bd93bcd013e0e4cf9b77fed2caf9f1a94774ef951862154226ec736217d2bef3b2fdf4f5376ff7046ad6a0aa724d29f93b91ba103133ca02265f86c657d0db4887dbe9794c53d08"#.decode('hex')
    cipher5 = "4ff725eb983a353703554f951826de9c99b1e55254fb8b0ad05b971989ac5fc4308618381746f5e268f630e3cc13db7047ee05873c452265d8772d6c7ffe3e3a8b5d5e36"#.decode('hex')
    cipher6 = "42f035eb9834353d05550692196ad5dadfb9f94e03f88605c80e865784ff16df2a9f03240947bbb762e72dea8f06926d4cbd02913d546761d8772d7b68f426248b595874fe7e009b775ff522c594d2ba1ca31d1320a72b6cf8686f3209b0887dab8692cf3b485f41aac74fe1"#.decode('hex')
    cipher7 = "55f034eb9a332932034506951026d99fd0b7e35f07b98b0fc94f8e5dc0b0199129841223085bfb"#.decode('hex')
    cipher8 = "52eb60a288753626094906971974d4dacab5e85e06fcca1dd40e855cc0b91ad02c8812771440b4f926f636af8e17db6e4deb148c60"#.decode('hex')
    cipher9 = "59fa34bf9e277b310f01429f0576d889dcb4ab4d1bebca1dd441c7588ea716de2b9e56361058a7f26ee737fc851d95710ebd05802f4e227ede3e227d6fbb3133df4c5577bb334fac7e43b124ca8ed2a617ac114121bc3e26"#.decode ('hex')
    cipher10 = "5aec60aa952c7b350b534b9f0426c693d5bcab5f11f58649c2419215c0b011dd27cd17770647bafb26ee3cfb9f529a2244f209c82955637ecf7738706ebb3b2f9150556de83500a67745a76f"#.decode('hex')

    xorcipher = encrypt(cipher1,cipher2)
    print ("xorcipher : " , xorcipher)

    xorcrib1 = encrypt(xorcipher, "the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the the")
    print ("xorcrib1 : ", xorcrib1)
    xorcrib2 = encrypt(xorcipher, "and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and and")
    print ("xorcrib2 : ", xorcrib2)
    xorcrib3 = encrypt(xorcipher, "from from from from from from from from from from from from from from from from from")
    print ("xorcrib3 : ", xorcrib3)
    xorcrib4 = encrypt(xorcipher, "but but but but but but but but but but but but but but but but but but but but but")
    print ("xorcrib4 : ", xorcrib4)
    xorcrib5 = encrypt(xorcipher, "with with with with with with with with with with with with with with with with with")
    print ("xorcrib5 : ", xorcrib5)
    xorcrib6 = encrypt(xorcipher, "have have have have have have have have have have have have have have have have have")
    print ("xorcrib6 : ", xorcrib6)
    xorcrib7 = encrypt(xorcipher, "you you you you you you you you you you you you you you you you you you you you you")
    print ("xorcrib7 : ", xorcrib7)
    xorcrib8 = encrypt(xorcipher, "will will will will will will will will will will will will will will will will will")
    print ("xorcrib8 : ", xorcrib8)
    xorcrib9 = encrypt(xorcipher, "can can can can can can can can can can canc can can can can can can can can can can")
    print ("xorcrib9 : ", xorcrib9)
    xorcrib10 = encrypt(xorcipher, "first first first first first first first first first first first first first first")
    print ("xorcrib10 : ", xorcrib10)

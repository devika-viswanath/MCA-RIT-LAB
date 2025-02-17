import math
print("Quaderatic equation ax^2 + bx + c")
a = float(input())
b = float(input())
c = float(input())
descr = (b*b) - (4*a*c)
if(descr == 0):
        print("Only one root value")
        ans = -b / (2 * a)
        print("x : ", ans)
elif descr > 0:
        sqrtValue = math.sqrt(descr)
        ansOne = (-b + sqrtValue) / (2 * a)
        ansTwo = (-b - sqrtValue) / (2 * a)
        print("X1 = ", ansOne)
        print("X2 = ", ansTwo)
else:
        print("Complex root")
        sqrtValue = math.sqrt(abs(descr)) / (2 * a)
        print(-b/(2*a), "+i", sqrtValue)
        print(-b/(2*a), "-i", sqrtValue)

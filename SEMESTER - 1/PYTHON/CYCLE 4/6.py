# terms = int(input("Enter the number of terms : "))
# result = list(map(lambda x: 3 * x, range(1 ,terms + 1)))

# for i in range(1, terms + 1):
#    print("3 *",i," = ",result[i - 1])


lst = []
size = int(input("Enter no of elements : "))
for i in range(0, size):
    a = int(input("Enter the values : "))
    lst.append(a)
ans = lambda x : 3 * x
for i in range(0, size):
        print(ans(lst[i]), end = " ")
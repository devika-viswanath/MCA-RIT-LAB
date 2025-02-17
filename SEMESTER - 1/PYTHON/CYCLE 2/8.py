color = input("Enter list of color names seperated by comma : ")
colorList =  color.split(",")
for i in range(0, len(colorList)):
    colorList[i] = colorList[i].replace(" ","")
    print(colorList[i])
print("First color : ", colorList[0])
print("Last color : ", colorList[-1])

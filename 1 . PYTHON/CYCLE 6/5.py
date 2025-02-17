class Time:
    def __init__(self, hour=0, minute=0, second=0):
        self.__hour = 0
        self.__minute = 0 
        self.__second = 0
        self.set_time(hour, minute, second)
    
    def set_time(self, hour, minute, second):
        if (0 <= hour < 24 and 
            0 <= minute < 60 and 
            0 <= second < 60):
            self.__hour = hour
            self.__minute = minute
            self.__second = second
        else:
            raise ValueError("Invalid time values")
    
    def __add__(self, other):
        total_seconds1 = (self.__hour * 3600 + 
                          self.__minute * 60 + 
                          self.__second)
        total_seconds2 = (other.__hour * 3600 + 
                          other.__minute * 60 + 
                          other.__second)
        
        total_seconds = total_seconds1 + total_seconds2
        
        new_hour = total_seconds // 3600
        remaining_seconds = total_seconds % 3600
        new_minute = remaining_seconds // 60
        new_second = remaining_seconds % 60
        
        new_hour %= 24
        
        return Time(new_hour, new_minute, new_second)
    
    def display(self):
        print(f"{self.__hour:02d}:{self.__minute:02d}:{self.__second:02d}")

print("Enter first time:")
hour1 = int(input("Hour: "))
minute1 = int(input("Minute: "))
second1 = int(input("Second: "))
    
time1 = Time(hour1, minute1, second1)
print("First Time: ", end="")
time1.display()
    
print("\nEnter second time:")
hour2 = int(input("Hour: "))
minute2 = int(input("Minute: "))
second2 = int(input("Second: "))
    
time2 = Time(hour2, minute2, second2)
print("Second Time: ", end="")
time2.display()
    
result_time = time1 + time2
print("\nSum of Times: ", end="")
result_time.display()

import java.util.Scanner;
class Student{
    int id;
    String name;
    int mark1;
    int mark2;
    int mark3;
    int totalMaxMark;
    Student(int id,String name,int mark1,int mark2,int mark3,int totalMaxMark){
        this.id=id;
        this.name=name;
        this.mark1=mark1;
        this.mark2=mark2;
        this.mark3=mark3;
        this.totalMaxMark=totalMaxMark;

    }
    void display(){
        System.out.println("Student id:"+id);
        System.out.println("Student name:"+name);
        System.out.println("Student markin sub1:"+mark1);
        System.out.println("Student markin sub2:"+mark2);
        System.out.println("Student markin sub3:"+mark3);

    }
    double calculateMark(){
        return mark1+mark2+mark3;
    }
    double calculateMarkPer(){
        return ((mark1+mark2+mark3)*100/totalMaxMark);

    }
}
public class StudentDetail{
    public static void main(String arg[]){
        Scanner obj=new Scanner(System.in);
       
        System.out.println("Enter the id:");
        int id=obj.nextInt();
        obj.nextLine();
        System.out.println("Enter the name:");
        String name=obj.nextLine();
        System.out.println("Enter the mark1:");
        int mark1=obj.nextInt();
        obj.nextLine();
        System.out.println("Enter the mark2:");
        int mark2=obj.nextInt();
        obj.nextLine();
        System.out.println("Enter the mark3:");
        int mark3=obj.nextInt();
        obj.nextLine();
        System.out.println("Enter the total max mark of 3 subject:");
        int totalMaxMark=obj.nextInt();
        obj.nextLine();
        
        Student students=new Student(id,name,mark1,mark2,mark3,totalMaxMark);
        students.display();
        System.out.println("Total mark out of Student:"+students.calculateMark());
        System.out.println("percentage of mark:"+students.calculateMarkPer()+"%");
        
    }
}

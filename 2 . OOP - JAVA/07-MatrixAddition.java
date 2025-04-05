//method 1
import java.util.Scanner;

class Matrix {
    private int rows, columns;
    private int[][] data;

    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        data = new int[rows][columns];
    }

    void fillMatrix(Scanner scanner) {
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
    }

    Matrix add(Matrix other) {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    void display() {
        for (int[] row : data) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();

        Matrix matrix1 = new Matrix(rows, columns);
        Matrix matrix2 = new Matrix(rows, columns);

        matrix1.fillMatrix(scanner);
        matrix2.fillMatrix(scanner);

        Matrix sumMatrix = matrix1.add(matrix2);

        System.out.println("Resultant Matrix after Addition:");
        sumMatrix.display();

        scanner.close();
    }
}

//method 2

import java.util.Scanner;
class Matrix{
    int rows;
    int columns;
    int[][] data;
    Matrix(int rows,int columns){
        this.rows=rows;
        this.columns=columns;
        data=new int[rows][columns];
    }
    Matrix fillmatrix(Scanner obj){
       // System.out.println("enter the elements in the matrix:");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                data[i][j]=obj.nextInt();
            }
        }
        return this;
    }
    Matrix add( Matrix other){
        Matrix result=new Matrix(rows,columns);
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                result.data[i][j]=this.data[i][j]+other.data[i][j];

            }
            
        }
        return result;
    }
    void display(){
        System.out.println("result:");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(data[i][j]+ " ");
            }
            System.out.println();
        }
    }

}
public class MatrixAddition{
    public static void main(String arg[]){
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows=obj.nextInt();
        
        System.out.println("Enter the number of columns:");
        int columns=obj.nextInt();
        
        Matrix matrix1=new Matrix(rows,columns);
        Matrix matrix2=new Matrix(rows,columns);
        System.out.println("enter the elements in the matrix1:");
        matrix1.fillmatrix(obj);
        System.out.println("enter the elements in the matrix2");
        matrix2.fillmatrix(obj);
        Matrix sum=matrix1.add(matrix2);
        sum.display();
    }
}

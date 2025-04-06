import java.io.*;
import java.util.Scanner;
public class FileOperation{
    public static void main(String[] arg){
        Scanner obj=new Scanner(System.in);
        String filename="file.txt";
        System.out.println("Menu for file");
        System.out.println("1.Write the file:");
        System.out.println("2.Read the file:");
        System.out.println("3.append the file:");
        System.out.println("4.number of lines:");
        System.out.println("5.character in the file:");
        System.out.println("6.words in the file:");
        System.out.println("Enter the choice:");
        int choice=obj.nextInt();
        obj.nextLine();
        if(choice==1){
            try{
                FileWriter filewriter=new FileWriter(filename);
                System.out.println("Enter the text:");
                String text=obj.nextLine();
                filewriter.write(text);
                filewriter.close();
                System.out.println("writed SuccessFully");
            }catch(IOException e){
                System.out.println("something went wrong:");
            }
            
        }
        else if(choice==2){
            try{
                FileReader filereader=new FileReader(filename);
                BufferedReader bufferedreader=new BufferedReader(filereader);
                String line;
                while((line=bufferedreader.readLine())!=null){
                    System.out.println(line);
                }
                bufferedreader.close();
                System.out.println("reading Succesfully");
            }catch(IOException e){
                System.out.println("something went wrong!!");

            }

        }
        else if(choice==3){
            try{
                FileWriter filewriter=new FileWriter(filename,true);
                System.out.println("Enter the txt to append:");
                String text=obj.nextLine();
                filewriter.write(text);
                filewriter.close();
                System.out.println("appending successfully");

            }
            catch(IOException e){
                System.out.println("Something went wrong:");
            }
            
        }
        else if(choice==4){
            try{
                FileReader filereader=new FileReader(filename);
                BufferedReader bufferedreader=new BufferedReader(filereader);
                String line;
                int linecount=0;
                while((line=bufferedreader.readLine())!=null){
                    linecount++;
                    
                }
                System.out.println("LineCount"+linecount);
                bufferedreader.close();

            }catch(IOException e){
                System.out.println("Error");
            }
        }   
         else if(choice==5){
            try{
                FileReader filereader=new FileReader(filename);
                BufferedReader bufferedreader=new BufferedReader(filereader);
                String line;
                int chars=0;
                while((line=bufferedreader.readLine())!=null){
                    chars=chars+line.length();
                    
                }
                System.out.println("character"+chars);
                bufferedreader.close();

            }catch(IOException e){
                System.out.println("Error");
            }
        }
        else if(choice==6){
            try{
                FileReader filereader=new FileReader(filename);
                BufferedReader bufferedreader=new BufferedReader(filereader);
                String line;
                int words=0;
                while((line=bufferedreader.readLine())!=null){
                    String[] w=line.split("\\s+");
                    words=words+w.length;
                    
                }
                System.out.println("words"+words);
                bufferedreader.close();

            }catch(IOException e){
                System.out.println("Error");
            }
        }        
        else{
            System.out.println("invalid choice:");
        }
        System.out.println("programme end !!");
    }
}

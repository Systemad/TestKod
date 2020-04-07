package filestream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
/*
public class streamdemo {

    public static void main(String [] args){
        String templine;

        try(BufferedReader bufIn = new BufferedReader(new FileReader("./src/temp.txt"));){
            while((templine = bufIn.readLine()) != null){
                System.out.println(templine);
            }

        }
        catch(Exception e){
            System.out.println("File not found");
        }


    }
}
*/

public class streamdemo {

    public static void main(String [] args){
        String templine;

        try(BufferedReader bufIn = new BufferedReader(new FileReader("./src/temp.txt"));){
            while((templine = bufIn.readLine()) != null){
                System.out.println(templine);
            }

        }
        catch(Exception e){
            System.out.println("File not found");
        }


    }
}
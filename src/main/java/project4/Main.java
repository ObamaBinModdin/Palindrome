/**
 * Project: Project4
 * Completion Time: 5 hours
 * 
 * Honor Code: “I pledge that I have neither given nor received help from anyone
 * other than the instructor or the TAs for all program components included here.”
 */

package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import package1.MyVector;

/**
 *
 * @author oscar
 */
public class Main 
{

    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Main main=new Main();
        
        //expected to be a palindrome
        LinkedList<MyVector> vectorListOne=main.vectorFileReader(new File("vectorsOne.txt"));

        System.out.println(vectorListOne.get(0));
        System.out.println(vectorListOne.get(1));
        System.out.println(vectorListOne.get(2));
        System.out.println(vectorListOne.get(3));
        System.out.println(vectorListOne.get(4));
        
        if(main.palindrome(vectorListOne))
        {
            System.out.println("Palindrome");
        }
        else
        {
            System.out.println("Not palindrome");
        }
        
        System.out.println();
        
        
        //expected not to be a palindrome
        LinkedList<MyVector> vectorListTwo=main.vectorFileReader(new File("vectorsTwo.txt"));
        
        System.out.println(vectorListTwo.get(0));
        System.out.println(vectorListTwo.get(1));
        System.out.println(vectorListTwo.get(2));
        System.out.println(vectorListTwo.get(3));
        System.out.println(vectorListTwo.get(4));
        
        if(main.palindrome(vectorListTwo))
        {
            System.out.println("Palindrome");
        }
        else
        {
            System.out.println("Not palindrome");
        }
    }//main method

    
    public LinkedList<MyVector> vectorFileReader(File file) throws FileNotFoundException
    {
        Scanner scanner =new Scanner(file);  
        LinkedList<MyVector> vectorList=new LinkedList<MyVector>();
        
        while(scanner.hasNextLine())
        {
            ArrayList<Double> holder=new ArrayList<Double>();
            
            String[] stringConvertor=scanner.nextLine().split(" ");
            for(int x=0;x<stringConvertor.length;x++)
            {
                holder.add(Double.parseDouble(stringConvertor[x]));
            }
            
            double[] vectorAsDouble=new double[holder.size()];
            
            for(int x=0;x<vectorAsDouble.length;x++)
            {
                vectorAsDouble[x]=(double)holder.get(x);
            }
            
            MyVector vector=new MyVector(vectorAsDouble);            
            
            vectorList.add(vector);    
        }
        
        scanner.close();
        
        return vectorList;
    }//vectorFileReader method. Parameter is a File object. Returns a LinkedList of MyVector Objects. Reads a file and returns multiple MyVectors in a LinkedList.
    
    public boolean equalVectors(MyVector vectorListOne, MyVector vectorListTwo)
    {
        return vectorListOne.equals(vectorListTwo);
    }//equalsVectors method. Takes in two MyVectors and returns true if both are equal.
    
    public boolean palindrome(LinkedList<MyVector> vectorList)
    {
        Iterator forward=vectorList.iterator();
        Iterator reverse=vectorList.descendingIterator();
        
        while(forward.hasNext() && reverse.hasNext())
        {
            MyVector vectorOne=(MyVector)forward.next();
            MyVector vectorTwo=(MyVector)reverse.next();
            
            if(!equalVectors(vectorOne, vectorTwo))
            {
                return false;
            }
        }
        
        return true;
    }//palindrome method. Takes in a LinkedList of a MyVector object and returns boolean if the list is a palindrome.
}//main class

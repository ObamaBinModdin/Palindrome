/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import package1.MyVector;

/**
 *
 * @author oscar
 */
public class MainTest {

    @Test
    @DisplayName("vectorFileReader() test")
    public void testVectorFileReader() throws FileNotFoundException
    {
        System.out.println("vectorFileReader");
        Main main=new Main();
        LinkedList<MyVector> vectorList=main.vectorFileReader(new File("vectorsOne.txt"));
        assertNotNull(vectorList);
    }

    @Test
    @DisplayName("equalVectors() test")
    public void testEqualVectors()
    {
        System.out.println("equalVectors");
        Main main=new Main();
        double list1[]={1,2,3,4,5};
        double list2[]={1,2,3,4,5};
        MyVector vectorOne=new MyVector(list1);
        MyVector vectorTwo=new MyVector(list2);
        assertTrue(main.equalVectors(vectorOne, vectorTwo));
    }
    
    @Test
    @DisplayName("palindrome() test")
    public void testPalindrome() throws FileNotFoundException
    {
        System.out.println("palindrome");
        Main main=new Main();
        LinkedList<MyVector> vectorListOne=main.vectorFileReader(new File("vectorsOne.txt"));
        assertTrue(main.palindrome(vectorListOne));
    }
}

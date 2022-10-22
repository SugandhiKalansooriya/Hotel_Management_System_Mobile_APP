package com.example.grandhotel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private  MainActivity4 cateringbill;

    public void setup(){
        cateringbill=new MainActivity4();
    }
    @Test
    public void testCateringbill(){
        int result=cateringbill.Totalbill(1,3,2,5,4,6,7);
        assertEquals(6270,result);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}
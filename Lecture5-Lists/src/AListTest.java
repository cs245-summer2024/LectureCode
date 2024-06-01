import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AListTest {

    @Test
    void testInsertEmpty(){
        AList myList = new AList<Integer>(4);
        myList.insertElement(0, 10);
        assertTrue(myList.toString().equals("10"));
    }

    @Test
    void testInsertMiddle(){
        AList myList = new AList<Integer>(4);
        myList.insertElement(0, 10);
        myList.insertElement(1, 20);
        myList.insertElement(2, 30);
        myList.insertElement(3, 40);
        myList.insertElement(1, 55);
        assertTrue(myList.toString().equals("10,55,20,30,40"));
    }

    @Test
    void testInsertBack(){
        AList myList = new AList<Integer>(4);
        myList.insertElement(0, 10);
        myList.insertElement(1, 20);
        myList.insertElement(2, 30);
        myList.insertElement(3, 40);
        myList.insertElement(4, 55);
        assertTrue(myList.toString().equals("10,20,30,40,55"));
    }

    @Test
    void testRemoveFront(){
        AList myList = new AList<Integer>(4);
        myList.insertElement(0, 10);
        myList.insertElement(1, 20);
        myList.insertElement(2, 30);
        myList.insertElement(3, 40);
        myList.insertElement(1, 55);
        myList.removeElement(0);
        assertTrue(myList.toString().equals("55,20,30,40"));
    }

    @Test
    void testRemoveMiddle(){
        AList myList = new AList<Integer>(4);
        myList.insertElement(0, 10);
        myList.insertElement(1, 20);
        myList.insertElement(2, 30);
        myList.insertElement(3, 40);
        myList.insertElement(1, 55); //10,55,20,30,40
        myList.removeElement(2);
        assertTrue(myList.toString().equals("10,55,30,40"));
    }

    @Test
    void testRemoveBack(){
        AList myList = new AList<Integer>(4);
        myList.insertElement(0, 10);
        myList.insertElement(1, 20);
        myList.insertElement(2, 30);
        myList.insertElement(3, 40);
        myList.insertElement(1, 55); //10,55,20,30,40
        myList.removeElement(4);
        assertTrue(myList.toString().equals("10,55,20,30"));
    }

    @Test
    void testRemoveException(){
        AList myList = new AList<Integer>(4);
        boolean exceptionIsThrown = false;
        myList.insertElement(0, 10);
        myList.removeElement(0);
        try {
            myList.removeElement(0);
        } catch (ArrayIndexOutOfBoundsException a){
            exceptionIsThrown = true;
        }
        assertTrue(exceptionIsThrown);
    }

}
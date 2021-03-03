import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList = new CircularListImpl();

    @BeforeEach
    void testEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testAdd(){
        circularList.add(2);
        assertEquals(1, circularList.size());
    }

    @Test
    void testSize(){
        this.addThreeElements();
        assertEquals(3,circularList.size());
    }

    @Test
    void testNext(){
        this.addThreeElements();
        assertEquals( Optional.of(1), circularList.next());
        assertEquals( Optional.of(2), circularList.next());
        assertEquals( Optional.of(3), circularList.next());
    }

    @Test
    void testNextLastElement(){
        this.testNext();
        assertEquals( Optional.of(1), circularList.next());
    }

    @Test
    void testPrevious(){
        this.addThreeElements();
        assertEquals( Optional.of(3), circularList.previous());
        assertEquals( Optional.of(2), circularList.previous());
        assertEquals( Optional.of(1), circularList.previous());
        assertEquals( Optional.of(3), circularList.previous());
    }

    @Test
    void testReset(){
        this.addThreeElements();
        circularList.next();
        circularList.reset();
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(3), circularList.next());
    }

    void addThreeElements(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
    }

}

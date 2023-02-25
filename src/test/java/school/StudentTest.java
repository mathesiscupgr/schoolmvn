package school;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author John
 */
public class StudentTest {

    private static final ClassRoom[] classRooms = {
        new ClassRoom("Α1"),
        new ClassRoom("Α2", 28),
        new ClassRoom("Α3", 25),
        new ClassRoom("Β1"),
        new ClassRoom("Β2", 28),
        new ClassRoom("Β3", 25),
        new ClassRoom("Γ1"),
        new ClassRoom("Γ2", 26),
        new ClassRoom("Γ3", 22)};

    private final Student instance = new Student("Γιάννης", "Αντεκοτούμπο", 16);

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of getAm method, of class Student.
     */
//    @DisplayName("getAm")
//    @Test
//    public void testGetAm() {
//        assertEquals(1, instance.getAm());
//    }

    /**
     * Test of getAge method, of class Student.
     */
    @DisplayName("getAge/setAge")
    @Test()
    public void testGetAge() {
        assertEquals(16, instance.getAge());
        instance.setAge(17);
        assertEquals(17, instance.getAge());
        Exception e = assertThrows(IllegalArgumentException.class, () -> instance.setAge(20));
        assertEquals("Η ηλικία πρέπει να είναι μεταξύ 15 και 18", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> instance.setAge(-1));
        assertEquals("Η ηλικία πρέπει να είναι μεταξύ 15 και 18", e.getMessage());
    }

    /**
     * Test of getClassRoom/setClassRoom method, of class Student.
     */
    @DisplayName("getClassRoom/setClassRoom")
    @Test
    public void testGetClassRoom() {
        assertEquals(null, instance.getClassRoom());
        instance.setClassRoom(classRooms[3]);
        assertEquals(classRooms[3], instance.getClassRoom());
    }

    /**
     * Test of equals method, of class Student.
     */
    @DisplayName("equals")
    @Test
    public void testEquals() {
        Student student = instance;
        assertTrue(instance.equals(student));
    }

    /**
     * Test of toString method, of class Student.
     */
    @DisplayName("toString")
    @Test
    public void testToString() {
        String expResult = "Student{am="+instance.getAm()+", firstName=Γιάννης, lastName=Αντεκοτούμπο, age=16, classRoom=null}";
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of hashCode method, of class Student.
     */
    @DisplayName("hashCode")
    @Test
    public void testHashCode() {
        Student otherStudent = instance;
        assertEquals(otherStudent.hashCode(), instance.hashCode());
        otherStudent = new Student("Νίκος", "Γκάλης", 18);
        assertNotEquals(otherStudent.hashCode(), instance.hashCode());
    }
}

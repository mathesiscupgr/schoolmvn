package school;

import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class TeacherTest {

    private Teacher instance;

    @BeforeEach
    public void setUp() {
        instance = new Teacher("AB123456", "Σωκράτης", "Σωκράτης");
        instance.addLesson("Φιλοσοφία");
        instance.addLesson("Αρχαία Ελληνικά");
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId/setId methods, of class Teacher.
     */
    @DisplayName("getId/setId")
    @Test
    public void testId() {
        assertEquals("AB123456", instance.getId());
        instance.setId("ΧΥ123456");
        assertEquals("ΧΥ123456", instance.getId());

    }

    /**
     * Test of addLesson/removeLesson methods, of class Teacher.
     */
    @DisplayName("addLesson/removeLesson")
    @Test
    public void testAddRemoveLesson() {
        Set<String> lessons1 = Set.of("Αρχαία Ελληνικά","Φιλοσοφία");
        assertTrue(lessons1.size() == instance.getLessons().size() &&
                lessons1.containsAll(instance.getLessons()) &&
                instance.getLessons().containsAll(lessons1));
        String lesson1 = "Γραμματική";
        instance.addLesson(lesson1);
        assertTrue(instance.contains(lesson1));
        String lesson2 = "Χημεία";
        instance.addLesson(lesson2);
        assertFalse(instance.contains(lesson2));
        Set<String> lessons2 = Set.of("Φιλοσοφία", "Αρχαία Ελληνικά", lesson1);
        assertTrue(lessons2.size() == instance.getLessons().size() &&
                lessons2.containsAll(instance.getLessons()) &&
                instance.getLessons().containsAll(lessons2));
        instance.removeLesson(lesson2);
        assertTrue(lessons2.size() == instance.getLessons().size() &&
                lessons2.containsAll(instance.getLessons()) &&
                instance.getLessons().containsAll(lessons2));
        instance.removeLesson(lesson1);
        assertTrue(lessons1.size() == instance.getLessons().size() &&
                lessons1.containsAll(instance.getLessons()) &&
                instance.getLessons().containsAll(lessons1));
        assertFalse(instance.contains(lesson1));
        assertFalse(instance.contains(lesson2));
        instance.addLesson(null);
    }

    /**
     * Test of hashCode method, of class Teacher.
     */
    @DisplayName("hashCode")
    @Test
    public void testHashCode() {
        Teacher newInstance = new Teacher("AB123456", "Σωκράτης", "Μάλαμας");
        assertEquals(newInstance.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method, of class Teacher.
     */
    @DisplayName("equals")
    @Test
    public void testEquals() {
        Teacher newInstance = new Teacher("AB123456", "Σωκράτης", "Μάλαμας");
        assertTrue(instance.equals(newInstance));
    }

    /**
     * Test of toString method, of class Teacher.
     */
    @DisplayName("toString")
    @Test
    public void testToString() {
        String expResult = "Teacher{id=AB123456, firstName=Σωκράτης, lastName=Σωκράτης, lessons=[Φιλοσοφία, Αρχαία Ελληνικά]}";
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of contains method, of class Teacher.
     */
    @DisplayName("contains")
    @Test
    public void testContains() {
        assertTrue(instance.contains("Φιλοσοφία"));
        assertFalse(instance.contains("Μαθηματικά"));
        assertFalse(instance.contains(null));
        assertFalse(instance.contains(""));
    }

}
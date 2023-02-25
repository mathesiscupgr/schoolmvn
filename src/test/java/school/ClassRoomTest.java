package school;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class ClassRoomTest {
    
    private ClassRoom instance;
    private Student student1, student2;
    
    @BeforeEach
    public void setUp() {
        instance = new ClassRoom("Α1", 28);
        student1 = new Student("Γιάννης", "Αντεκοτούμπο", 16);
        student2 = new Student("Νίκος", "Γκάλης", 17);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getName method, of class ClassRoom.
     */
    @DisplayName("getName")
    @Test
    public void testGetName() {
        assertEquals("Α1", instance.getName());
    }

    /**
     * Test of getSize method, of class ClassRoom.
     */
    @DisplayName("getSize")
    @Test
    public void testGetSize() {
        assertEquals(28, instance.getSize());
    }

    /**
     * Test of addStudent method, of class ClassRoom.
     */
    @DisplayName("addStudent/removeStudent")
    @Test
    public void testAddRemoveStudent() {
        instance.addStudent(student1);
        assertEquals(student1, instance.contains(student1.getAm()));
        assertEquals(1, instance.getStudents().size());
        assertEquals(instance, student1.getClassRoom());
        instance.removeStudent(student1.getAm());
        assertNull(instance.contains(student1.getAm()));
        assertEquals(0, instance.getStudents().size());
        assertEquals(null, student1.getClassRoom());
    }

    /**
     * Test of removeAllStudents method, of class ClassRoom.
     */
    @DisplayName("removeAllStudents")
    @Test
    public void testRemoveAllStudents() {
        instance.addStudent(student1);
        instance.addStudent(student2);
        assertNotNull(instance.getStudents());
        assertEquals(2, instance.getStudents().size());
        instance.removeAllStudents();
        assertEquals(0, instance.getStudents().size());
        
    }

    /**
     * Test of hashCode method, of class ClassRoom.
     */
    @DisplayName("hashCode")
    @Test
    public void testHashCode() {
        ClassRoom instance2 = new ClassRoom("Α1");
        ClassRoom instance3 = new ClassRoom("Α2");
        assertEquals(instance2.hashCode(), instance.hashCode());
        assertNotEquals(instance3.hashCode(), instance.hashCode());
    }

    /**
     * Test of equals method, of class ClassRoom.
     */
    @DisplayName("equals")
    @Test
    public void testEquals() {
        ClassRoom instance2 = new ClassRoom("Α1");
        ClassRoom instance3 = new ClassRoom("Α2");
        assertTrue(instance.equals(instance2));
        assertTrue(instance2.equals(instance));
        assertFalse(instance.equals(instance3));
    }

    /**
     * Test of toString method, of class ClassRoom.
     */
    @DisplayName("toString")
    @Test
    public void testToString() {
        instance.addStudent(student1);
        instance.addStudent(student2);
        assertEquals("ClassRoom{name=Α1, size=28, numOfStudents=2}", instance.toString());
    }

}
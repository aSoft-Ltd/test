import test.Person
import kotlin.test.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun should_construct_class_person_with_no_problem() {
        assertEquals(Person("John"), Person("John"))
    }
}
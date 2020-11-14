import tz.co.asoft.Person
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    @JsName("test1")
    fun `should construct class person with no problem`() {
        assertEquals(Person("John"), Person("John"))
    }
}
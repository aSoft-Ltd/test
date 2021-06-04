import android.util.Log;
import org.junit.jupiter.api.Test;

public class LoggingJavaTest {
    @Test
    public void should_log_from_java() {
        var a = new Address("Tanzania", "Dar es Salaam");
        Person p = new Person("John Doe", "john@doe.com", a);
        Log.d("Haya sasa", "Testing " + p);
    }
}

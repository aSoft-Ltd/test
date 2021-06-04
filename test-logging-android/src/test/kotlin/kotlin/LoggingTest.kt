import android.util.Log
import org.junit.jupiter.api.Test

class LoggingTest {
    @Test
    fun should_log_properly() {
        Log.d("Testing", "Debug log")
    }
}
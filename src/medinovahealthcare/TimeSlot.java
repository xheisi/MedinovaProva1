
package medinovahealthcare;
import java.sql.Time;

public class TimeSlot {
    Time start;
    Time end;

    public TimeSlot(Time start, Time end) {
        this.start = start;
        this.end = end;
    }

    // Getters
    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return start.toString() + " - " + end.toString();
    }
}


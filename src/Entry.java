import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by LunaFlores on 1/10/17.
 */
public class Entry {

    public enum Day{
        MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
    }

    private Day day;
    private String note;
    private int duration;

    public Entry (Day day, String note) {
        Random random = new Random();
        this.duration =random.nextInt(100);
        this.day = day;
        this.note = note;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "day=" + day +
                ", note='" + note + '\'' +
                ", duration=" + duration +
                '}';
    }

    public static List<Entry> populate() {
        List<Entry> entries = new ArrayList<>();

        Entry entry = new Entry(Day.MONDAY, "I hate mondays");
        entries.add(entry);


        entry = new Entry(Day.TUESDAY, "Taco Tuesday");
        entries.add(entry);

        entry = new Entry(Day.WEDNESDAY, "Its hump day");
        entries.add(entry);

        entry = new Entry(Day.THURSDAY, "Almost Friday!");
        entries.add(entry);

        entry = new Entry(Day.FRIDAY,"Its Friday, Friday!!");
        entries.add(entry);

        entry = new Entry(Day.SATURDAY,"Sleep in on Saturday!");
        entries.add(entry);

        entry = new Entry(Day.SUNDAY,"Sunday fun day!!");
        entries.add(entry);

        entry = new Entry(Day.MONDAY,"Monday: where is the coffee?!");
        entries.add(entry);

        entry = new Entry(Day.TUESDAY,"It's barely Tuesday!!");
        entries.add(entry);

        entry = new Entry(Day.WEDNESDAY,"Half way there");
        entries.add(entry);

        entry = new Entry(Day.THURSDAY,"Just one more day");
        entries.add(entry);

        entry = new Entry(Day.FRIDAY,"Iron Pints!");
        entries.add(entry);

        return entries;
    }

}

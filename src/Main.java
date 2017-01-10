import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Entry> entries = Entry.populate();
        //one(entries);
        //tuesday(entries);
        //count(entries);
        //weekend(entries);
        set(entries);
    }

    public static void one(List<Entry> entries){
        System.out.println("\n\nenhanced for loop");
        for (Entry entry: entries){
            System.out.println(entry + ",");
        }

        System.out.println("\n\nstream and forEach");
        entries
                .stream()
                .forEach(entry -> System.out.println(entry + ","));
    }

    public static void tuesday(List<Entry> entries){
        System.out.println("\n\nenhanced for loop");
        for (Entry entry: entries){
            if (entry.getDay()== Entry.Day.TUESDAY){
                System.out.println(entry + ",");
            }
        }

        System.out.println("\n\nstream, filter, forEach");
        entries
                .stream()
                .filter(e -> e.getDay() == Entry.Day.TUESDAY)
                .forEach(entry -> System.out.println(entry + ","));
    }

    public static void count(List<Entry> entries){
        System.out.println("\n\nenhanced for loop");
        int sum = 0;
        for (Entry entry: entries){
            if (entry.getDay()== Entry.Day.TUESDAY||entry.getDay()== Entry.Day.WEDNESDAY||entry.getDay() == Entry.Day.THURSDAY){
                sum = sum + 1;
            }
        }
        System.out.println(sum);

        System.out.println("\n\nstream, filter, count");
        long count = entries
                .stream()
                .filter(e -> e.getDay() == Entry.Day.TUESDAY || e.getDay() == Entry.Day.WEDNESDAY || e.getDay() == Entry.Day.THURSDAY)
                .count();
        System.out.println(count);
    }

    public static void weekend(List<Entry> entries){
        List<Entry> weekends = new ArrayList<>();
        System.out.println("\n\nenhanced for loop");
        for (Entry entry : entries){
            if (entry.getDay() == Entry.Day.SATURDAY || entry.getDay() == Entry.Day.SUNDAY){
                weekends.add(entry);
            }
        }
        System.out.println(weekends);

        System.out.println("\n\nstream, filter, list");
        List<Entry> weekend = entries
                .stream()
                .filter(e -> e.getDay()== Entry.Day.SATURDAY||e.getDay()== Entry.Day.SUNDAY)
                .collect(Collectors.toList());

        System.out.println(weekend);
    }

    public static void set(List<Entry> entries){
        System.out.println("\n\nenhanced for loop");
        Set<String> notes = new HashSet<>();
        for (Entry entry: entries){
            if (!(entry.getDay() == Entry.Day.SATURDAY || entry.getDay() == Entry.Day.SUNDAY)){
                notes.add(entry.getNote());
            }
        }
        System.out.println(notes);

        System.out.println("\n\nstream, filter, set");
        Set<String> note = entries
                .stream()
                .filter(e -> e.getDay() != Entry.Day.SATURDAY && e.getDay() != Entry.Day.SUNDAY)
                .map(e -> e.getNote())
                .collect(Collectors.toSet());
        System.out.println(note);
    }
}

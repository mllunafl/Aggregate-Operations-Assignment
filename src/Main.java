import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Entry> entries = Entry.populate();
        //one(entries);
        //tuesday(entries);
        //count(entries);
        //weekend(entries);
        //set(entries);
        //durOver10(entries);
        //max(entries);
        //over50(entries);
        //sort(entries);
        //sortLambda(entries);
        intStream();
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

    public static void durOver10(List<Entry> entries){
        System.out.println("\n\nenhanced for loop");
        for (Entry entry: entries){
            if (entry.getDuration()>10){
                System.out.println(entry);
            }
        }

        System.out.println("\n\nstream");
        entries
                .stream()
                .filter(e -> e.getDuration() > 10)
                .forEach(entry -> System.out.println(entry));
    }

    public static void max(List<Entry> entries){
        System.out.println("\n\nSort");
        Collections.sort(entries,new Compare());
        System.out.println(entries.get(entries.size()-1).getDuration());

        System.out.println("\n\nFor Loop");
        List<Integer> dur = new ArrayList<>();
        for (Entry entry: entries){
            dur.add(entry.getDuration());
        }
        Collections.sort(dur);
        System.out.println(dur.get(dur.size()-1));

        System.out.println("\n\nstream, max, get");
        final Comparator<Entry> comp = (e1, e2) -> Integer.compare(e1.getDuration(),e2.getDuration());
        Entry maxDur = entries
                .stream()
                .max(comp)
                .get();
        System.out.println(maxDur.getDuration());
    }

    public static void over50(List<Entry> entries){
        System.out.println("\n\nforloop");
        List<Entry> entriesover50 = new ArrayList<>();
        for (Entry entry : entries){
            if (entry.getDuration()>50){
                entriesover50.add(entry);
            }
        }
        System.out.println(entriesover50);

        System.out.println("\n\nstream");
        entriesover50 = entries
                .stream()
                .filter(entry -> entry.getDuration()>50)
                .collect(Collectors.toList());
        System.out.println(entriesover50);
    }

    public static void sort(List<Entry> entries){
        System.out.println("\n\nSort");
        Collections.sort(entries,new Compare());
        System.out.println(entries);

        System.out.println("\n\nstream");
        final Comparator<Entry> comp = (e1, e2) -> Integer.compare(e1.getDuration(),e2.getDuration());
        entries
                .stream()
                .sorted(comp)
                .forEach(entry -> System.out.println(entry));
    }

    public static void sortLambda(List<Entry> entries){
        System.out.println("\n\nSort");
        entries.sort((e1, e2) -> Integer.compare(e1.getDuration(),e2.getDuration()));
        System.out.println(entries);

        System.out.println("\n\nstream");
        final Comparator<Entry> comp = (e1, e2) -> Integer.compare(e1.getDuration(),e2.getDuration());
        entries
                .stream()
                .sorted(comp)
                .forEach(entry -> System.out.println(entry));
    }

    public static void intStream(){
        IntStream.range(1,10)
                .forEach(value -> System.out.println(value));

    }


    public  static class Compare implements java.util.Comparator<Entry>{
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.getDuration() < o2.getDuration()? -1 : o1.getDuration() == o2.getDuration() ? 0:1;
        }
    }

}

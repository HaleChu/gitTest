package pers.god.demo.java8.localTime;

public class PeriodDemo {

    public static void main(String[] args) {
        /*DateTimeFormatter timeDtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate startDate = LocalDate.parse("2018-06-28 00:00:00", timeDtf);
        System.out.println(startDate);
        System.out.println(LocalDate.now());
        long months = ChronoUnit.MONTHS.between(startDate, LocalDate.now());

        System.out.println(months);*/

        String str = "371100";
        System.out.println(str.substring(0, 4));

        String s = "0827";
        System.out.println(s.substring(0, 2));
    }
}

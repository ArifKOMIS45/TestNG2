package Works;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class workForMe {
    public static void main(String[] args) {
//        LocalDateTime day=LocalDateTime.now();
//        System.out.println(day.getDayOfMonth()+2);
//        System.out.println(day.getMonth().name().charAt(0)+day.getMonth().name().substring(1,3).toLowerCase());

        String pattern = "MM/dd/yyyy";
        LocalDate today = LocalDate.now().plusDays(20);
        String formattedDate = today.format(DateTimeFormatter.ofPattern(pattern));
        System.out.println(formattedDate);









//        String arif="mkmkms bhhhn 1,5 km kmkmkms";
//        String str=arif.replaceAll("[^\\d,]","");
//        String str2=str.replace(",",".");
//        System.out.println(str2);
//    }
}}

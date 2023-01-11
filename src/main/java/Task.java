import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    public static void main(String[] args) {
        String data1 = "01-12-2023";
        String data2 = "12/11/2023";
        LocalDate local1= LocalDate.parse(data1, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate local2= LocalDate.parse(data2, DateTimeFormatter.ofPattern("MM/d/yyyy"));
        System.out.println(local2.equals(local1));

        System.out.println(local1.isBefore(local2));
    }
}

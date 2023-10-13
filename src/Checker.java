import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Checker {
    public MonthlyReport monthReport;
    public YearlyReport yearReport;
    Scanner scanner;

    public Checker(MonthlyReport monthReport, YearlyReport yearReport, Scanner scanner) {
        this.monthReport = monthReport;
        this.yearReport = yearReport;
        this.scanner = scanner;

    }
    public void check() {
        System.out.println("Введите месяц от 1 до 3");
        int month = scanner.nextInt();
        System.out.println("Сумма доходов за месяц " + month + " : " + monthReport.getCurrentMonthSum(month));
        checkSum(month);
        System.out.println("Сумма расходов за месяц " + month + " : " + monthReport.getCurrentMonthExpense(month));
        checkSumExpense(month);
    }
    public void checkSum(int month) {
if (monthReport.getCurrentMonthSum(month) == yearReport.getMonthSum(month)) {
    System.out.println("Всё в порядке, доходы за месяц " + month + " сошлись c годовыми.");
}
else {
    System.out.println("В месяце " + month + " ошибка в подсчётах доходов.");
}
     }
     public void checkSumExpense(int month) {
if (monthReport.getCurrentMonthExpense(month) == yearReport.getMonthExpense(month)) {
    System.out.println("Всё в порядке, расходы за месяц " + month + " сошлись c годовыми.");
}
else {
    System.out.println("В месяце " + month + " ошибка в подсчётах расходов.");
}
     }



}




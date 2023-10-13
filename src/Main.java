import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MonthlyReport monthReport = new MonthlyReport();
        YearlyReport yearReport = new YearlyReport();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Здравствуйте. Введите команду :\n");
while (true) {

    printInfo();
    int command = scanner.nextInt();
    if (command == 1) {
        System.out.println("Загружаю отчёты за 3 месяца.");
        monthReport.loadFile("m.202101.csv", 1);
        monthReport.loadFile("m.202102.csv", 2);
        monthReport.loadFile("m.202103.csv", 3);
    } else if (command == 2) {
        System.out.println("Загружаю годовой отчёт.");
        yearReport.loadFile("y.2021.csv");

    } else if (command == 3) {
        Checker checker = new Checker(monthReport, yearReport, scanner);
        if (monthReport.checkLoad() == false && yearReport.checkLoad() == false) {
            System.out.println("Данные не загружены. Пожалуйста, загрузите данные и повторите команду.");
            continue;
        }
        checker.check();
    } else if (command == 4) {
        if (monthReport.checkLoad() == false) {
            System.out.println("Данные не загружены. Пожалуйста, загрузите данные и повторите команду.");
            continue;
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Месяц " + (i + 1));
            monthReport.getTopProduct(i + 1);
            monthReport.getTopExpense(i + 1);
        }

    } else if (command == 5) {
        if (yearReport.checkLoad() == false) {
            System.out.println("Данные не загружены. Пожалуйста, загрузите данные и повторите команду.");
            continue;
        }
        for (int i = 0; i < 3; i++) {
            yearReport.sumMonthReport(i+1);
        }
        System.out.println("Cредний расход за все операции в году : " + yearReport.averageExpense());
        System.out.println("Средний доход за все операции в году : " + yearReport.averageSum());
    }
}

    }

    public static void printInfo() {
        System.out.println("1 - Считать все месячные отчёты.");
        System.out.println("2 - Считать годовой отчёт.");
        System.out.println("3 - Сверить отчёты.");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах.");
        System.out.println("5 - Вывести информацию о годовом отчёте.");
        System.out.println("0 - Выйти из программы.");
    }

    }

import java.util.ArrayList;

public class YearlyReport {
    ArrayList<YearOrders> orders = new ArrayList<>();
    FileReader fileReader = new FileReader();

    public void loadFile(String path) {
        ArrayList<String> yearContent = fileReader.readFileContents(path);
        for (int i = 1; i < yearContent.size(); i++) {
            String[] parts = yearContent.get(i).split(",");
            int month = Integer.parseInt(parts[0]);
            int sum = Integer.parseInt(parts[1]);
            boolean vector = Boolean.parseBoolean(parts[2]);

            YearOrders yearOrder = new YearOrders(month, sum, vector);
            orders.add(yearOrder);
        }
    }

    public int getMonthSum(int month) {
        int sum = 0;
        for (YearOrders order : orders) {
            if (order.month == month) {
                if (order.vector == true) {
                    continue;
                }
                sum += order.sum;
            }
        }
        return sum;
    }

    public int getMonthExpense(int month) {
        int sum = 0;
        for (YearOrders order : orders) {
            if (order.month == month) {
                if (order.vector == false) {
                    continue;
                }
                sum += order.sum;
            }
        }
        return sum;
    }

    public boolean checkLoad() {
        if (orders.size() == 0) {
            return false;
        }
        return true;
    }

    public void sumMonthReport(int month) {
        for (YearOrders order : orders) {
            if ((order.month == month) && (order.vector == false))
                System.out.println("За месяц " + month + " было заработано " + getMonthSum(month));
        }
    }
    public double averageExpense() {
        int sum = 0;
        for (YearOrders order : orders) {
            if (order.vector == true) {
                sum += order.sum;
            }
        }
        return sum / (orders.size() / 2);
    }
    public double averageSum() {
        int sum = 0;
        for (YearOrders order : orders) {
            if (order.vector == false) {
                sum +=order.sum;
            }
        }
        return sum / (orders.size() / 2);
    }
}


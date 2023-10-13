import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    FileReader fileReader = new FileReader();
    ArrayList<MonthOrders> orders = new ArrayList<>();

    public void loadFile(String path, int month) {
        ArrayList<String> monthContent = fileReader.readFileContents(path);
        for (int i = 1; i < monthContent.size(); i++) {
            String[] parts = monthContent.get(i).split(",");
            String itemName = parts[0];
            boolean vector = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int unitPrice = Integer.parseInt(parts[3]);

            MonthOrders order = new MonthOrders(itemName, vector, quantity, unitPrice, month);
            orders.add(order);
        }

    }

    public int getCurrentMonthSum(int month) {
        int sum = 0;
        for (MonthOrders order : orders) {
            if (!(order.month == month) && (order.vector == true)) {
                continue;
            }
            sum = order.quantity * order.unitPrice;
        }
        return sum;
    }

    public boolean checkLoad() {
        if (orders.size() == 0) {
            return false;
        }
        return true;
    }

    public int getCurrentMonthExpense(int month) {
        int sum = 0;
        for (MonthOrders order : orders) {
            if ((order.month == month) && (order.vector == true)) {
                sum += order.quantity * order.unitPrice;
            }
        }
        return sum;
    }

    public void getTopProduct(int month) {
        HashMap<String, Integer> productPrices = new HashMap<>();
        String itemName = null;
        int total = 0;
        for (MonthOrders order : orders) {
            itemName = order.itemName;
            total = order.quantity * order.unitPrice;
            if ((order.vector == false) && (order.month == month)) {
                if (productPrices.containsKey(itemName))
                    productPrices.put(order.itemName, productPrices.get(itemName) + total);
                else productPrices.put(itemName, total);
            }

        }
        int max = 0;
        for (Integer result : productPrices.values()) {
            max = Math.max(result, max);
            if (max == result)
                System.out.println("Самый прибыльный товар :" + itemName + " принёс в общей сложности " + result + ".");
        }
    }

    public void getTopExpense(int month) {
        HashMap<String, Integer> expenses = new HashMap<>();
        String itemName = null;
        int total = 0;
        for (MonthOrders order : orders) {
            itemName = order.itemName;
            total = order.quantity * order.unitPrice;
            if ((order.vector == true) && (order.month == month)) {
                if (expenses.containsKey(itemName))
                    expenses.put(order.itemName, expenses.get(itemName) + total);
                else expenses.put(itemName, total);
            }

        }
        int max = 0;
        String maxExpense = null;
        for (String name : expenses.keySet()) {
            max = Math.max(expenses.get(name), max);
            if (max == expenses.get(name)) {
                maxExpense = name;
                System.out.println("Самая большая трата :" + maxExpense + " обошлась в общей сложности в " + max + ".");
            }
        }
    }
}



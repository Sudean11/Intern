import java.util.Date;

/**
 * Created by Sudin on 6/28/2017.
 */
public class Expense
{
    int id;
    String expense;
    int expenseAmt;
    String category;
    String date;

    public Expense(int id, String expense, int expenseAmt, String category, String date) {
        this.id = id;
        this.expense = expense;
        this.expenseAmt = expenseAmt;
        this.category = category;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public int getExpenseAmt() {
        return expenseAmt;
    }

    public void setExpenseAmt(int expenseAmt) {
        this.expenseAmt = expenseAmt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

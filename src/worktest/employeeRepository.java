package worktest;

import java.util.Arrays;

public class employeeRepository {
    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };
    private static Employee[] aaa = null;

    public static Employee findById(int id) {
        return Arrays.stream(arrayOfEmps)
                .filter(employee -> employee.getId() == id)
                .findAny()
                .orElse(null);
    }
}

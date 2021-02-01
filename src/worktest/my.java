package worktest;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summingInt;

public class my {
    public static void main(String[] args) {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        Employee a = new Employee(2, "Bill Gates", 200000.0);
        System.out.println(a.getAbc());


        //peek - 对每一个元素进行操作
        List<Employee> empList = Arrays.asList(arrayOfEmps);
        List<Employee> pmList = empList.stream().peek(e -> e.setSalary(e.getSalary() + 10)).peek(e -> System.out.println(e.getSalary())).collect(Collectors.toList());
        //sorted
        Employee wmList = pmList.stream().sorted(Comparator.comparing(Employee::getName)).findFirst().orElse(null);
        Employee wmList2 = pmList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).findFirst().orElse(null);

        System.out.println(wmList);

        Integer[] empIds = {1, 2, 3};

        List<Employee> employees = Arrays.stream(empIds).map(employeeRepository::findById).collect(Collectors.toList());

//        List<worktest.Employee> aaaa = null;
//        aaaa.stream().toArray();

        List<Integer> intList = Arrays.asList(1, 2, 3);

        Stream.of(1, 2).map(employeeRepository::findById).collect(Collectors.toList());

        Arrays.stream(arrayOfEmps).filter(e -> e.getId() == 2).toArray();

        List<Employee> emList = Arrays.asList(new Employee(), new Employee(), new Employee());
        //List<Integer> salaryList = emList.stream().map(employee -> {employee.getSalary()}).collect(Collectors.toList());

        //Collectors.groupingBy  根据某一属性进行分组 一组为一个list
        Map<Integer, List<Employee>> em = Stream.of(arrayOfEmps).filter(employee -> employee.getName().contains("B")).filter(employee -> employee.salary > 300000).collect(Collectors.groupingBy(Employee::getId));

        //Collectors.groupingBy  第二个参数 可对第一个参数分的组进行再分组或聚集函数计算
        Map<Integer, Integer> eme = Stream.of(arrayOfEmps).collect(Collectors.groupingBy(Employee::getId, summingInt(Employee::getId)));

        System.out.println(eme);

        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));
        //flatMap 对嵌套list做平铺
        List<String> ab = namesNested.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(ab);


        BigDecimal assignedMaxPriceLimit = BigDecimal.valueOf(2);
        //BigDecimal price = assignedMaxPriceLimit.multiply(BigDecimal.valueOf(100));
        BigDecimal price = new BigDecimal(2 * 100);
        System.out.println(price);
//        if(price.compareTo(assignedMaxPriceLimit.multiply(BigDecimal.valueOf(100))) > 0 &&
//                price.compareTo(new BigDecimal(defaultWhitelistMaxPriceLimit * 100)) > 0)
    }
}

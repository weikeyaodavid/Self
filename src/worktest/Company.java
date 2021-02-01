package worktest;

import java.util.List;

public class Company {
    int name;
    List<Employee> employees;

    public Company(int name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public Company() {
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name=" + name +
                ", employees=" + employees +
                '}';
    }
}

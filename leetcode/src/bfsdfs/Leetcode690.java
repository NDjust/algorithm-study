package bfsdfs;

import java.util.*;

public class Leetcode690 {


    public int getImportance(List<Employee> employees, int id) {
        Employee root = null;
        Queue<Employee> queue = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee.id == id) {
                root = employee;
                break;
            }
        }

        queue.add(root);
        int ans = 0;

        while (!queue.isEmpty()) {
            Employee poll = queue.poll();
            ans += poll.importance;

            List<Integer> subordinates = poll.subordinates;

            for (Integer subordinateId : subordinates) {
                Employee employeeById = findEmployeeById(employees, subordinateId);
                queue.add(employeeById);
            }
        }

        return ans;
    }

    private Employee findEmployeeById(final List<Employee> employees, final Integer subordinateId) {
        return employees.stream()
                .filter(employee -> employee.id == subordinateId)
                .findFirst()
                .orElseGet(null);
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}

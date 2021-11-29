package com.example;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 课堂练习：
 *      1. 使用 HashMap 添加 3 个员工对象，并遍历显示工资大于 18000 的员工；
 *      2. 员工类：编号、姓名、工资；
 *
 */
@SuppressWarnings("all")
public class MapCaseOne {

    @Test
    public void test01() {
        Map map = new HashMap();
        map.put("no1", new Employee("1001","张三",17000));
        map.put("no2", new Employee("1002","李四",18000));
        map.put("no3", new Employee("1003","王五",19000));

        Set set = map.entrySet();
        for (Object object : set) {
            Map.Entry entry = (Map.Entry) object;
            Employee employee = (Employee) entry.getValue();
            if (employee.getWage() > 18000) {
                System.out.println(employee);
            }
        }
    }

    static class Employee {
        private String empId;
        private String empName;
        private Integer wage;

        public Employee(String empId, String empName, Integer wage) {
            this.empId = empId;
            this.empName = empName;
            this.wage = wage;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public Integer getWage() {
            return wage;
        }

        public void setWage(Integer wage) {
            this.wage = wage;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(empId, employee.empId) && Objects.equals(empName, employee.empName) && Objects.equals(wage, employee.wage);
        }

        @Override
        public int hashCode() {
            return Objects.hash(empId, empName, wage);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empId='" + empId + '\'' +
                    ", empName='" + empName + '\'' +
                    ", wage=" + wage +
                    '}';
        }

    }
}

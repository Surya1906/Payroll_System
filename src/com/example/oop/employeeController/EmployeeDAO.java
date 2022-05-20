/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.oop.employeeController;

import com.example.oop.model.Employee;
import java.util.List;

/**
 *
 * @author Surya.N
 */
public interface EmployeeDAO {
    public void save(Employee employees);
    public void update(Employee employees);
    public void delete(Employee employees);
    public Employee get(int id);
    public List<Employee> list();
}

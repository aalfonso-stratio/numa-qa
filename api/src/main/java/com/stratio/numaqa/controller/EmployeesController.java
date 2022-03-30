package com.stratio.numaqa.controller;

import com.stratio.numaqa.dto.EmployeeDTO;
import com.stratio.numaqa.dto.EmployeeDTOConverter;
import com.stratio.numaqa.model.Employee;
import com.stratio.numaqa.model.EmployeeBase;
import com.stratio.numaqa.model.Employees;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeesController {

    private Integer counter = 5;
    private final Employees employees = new Employees();
    private final EmployeeDTOConverter employeeDTOConverter;

    public EmployeesController(EmployeeDTOConverter employeeDTOConverter) throws Exception {
        this.employeeDTOConverter = employeeDTOConverter;
    }

    @GetMapping("/getEmpleados")
    public ResponseEntity<?> employees() {
        List<Employee> result = employees.getEmployees();

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            List<EmployeeDTO> dtoList = result.stream().map(employeeDTOConverter::convertToDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(dtoList);
        }
    }

    @GetMapping("/getEmpleadosById/{id}")
    public ResponseEntity<Employee> employeesById(@PathVariable Integer id) {
        Employee employee;
        try {
            employee = employees.findEmployee(id);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }


    // curl -X PUT -H "Content-Type: application/json" -d '{"name":"Ryan","surname":"Reynolds","age":40,"address":"Sesame Street","idNumber":"99999999E","salary":100000,"role":"QA Engineer"}' http://localhost:8080/putEmpleadoById/1
    @PutMapping("/putEmpleadoById/{id}")
    public ResponseEntity<Employee> modifyEmployeeById(@RequestBody EmployeeBase mods, @PathVariable Integer id) {
        Employee employee;
        try {
            employee = employees.modifyEmployee(id, mods);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employee);
    }

    // curl -X POST -H "Content-Type: application/json" -d '{"name":"Megan","surname":"White","age":20,"address":"Elm Street","idNumber":"88888888F","salary":45000,"role":"Senior Software Engineer"}' http://localhost:8080/postEmpleado
    @PostMapping("/postEmpleado")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeBase employee) {
        Employee newEmployee;
        newEmployee = employees.createEmployee(counter++, employee);

        return ResponseEntity.ok(newEmployee);

    }

    // curl -X DELETE http://localhost:8080/delEmpleado/5
    @DeleteMapping("/delEmpleado/{id}")
    public ResponseEntity<?>  deleteEmployee(@PathVariable Integer id) {
        try {
            employees.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.stratio.numaqa.model;

import com.stratio.numaqa.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    public static void DataHandler() {

    }

    public List<Employee> readCSVFile(String file) throws Exception {
        List<Employee> employees = new ArrayList<Employee>();

        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(cvsSplitBy);
                Employee employee = new Employee(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], datos[5], Integer.parseInt(datos[6]), datos[7]);
                employees.add(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return employees;
    }

}

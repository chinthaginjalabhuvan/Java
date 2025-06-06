package com.example;

import java.util.*;

public class Demo {

public static void main(String[] args) {



ArrayList<EmployeeBean> data=User.selectAll();

for(EmployeeBean e:data)

{

System.out.println(e.getEmpid()+" "+e.getEmpname()+" "+e.getEmpsalary());

}

}

}
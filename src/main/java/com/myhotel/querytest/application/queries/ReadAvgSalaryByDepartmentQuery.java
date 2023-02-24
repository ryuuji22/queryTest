package com.myhotel.querytest.application.queries;

import io.jkratz.mediator.core.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ReadAvgSalaryByDepartmentQuery implements Request<Object> {

    private Integer employees;

}

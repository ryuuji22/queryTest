package com.myhotel.querytest.application.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.querytest.domain.interfaces.repositories.IGeneralRepository;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class ReadAvgSalaryByDepartmentQueryHandler implements RequestHandler<ReadAvgSalaryByDepartmentQuery, Object> {

    @Autowired
    private IGeneralRepository repository;

    @Override
    public Object handle(ReadAvgSalaryByDepartmentQuery query) {

        var result = repository.getAverageSalaryByDepartmentEmployeeCount(query.getEmployees());
        if (!result.isPresent()) {
            return null;
        }
        return result.get();

    }

}

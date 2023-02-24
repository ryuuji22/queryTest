package com.myhotel.querytest.application.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.querytest.domain.interfaces.repositories.IGeneralRepository;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class ReadManagerInfoQueryHandler implements RequestHandler<ReadManagerInfoQuery, Object> {

    @Autowired
    private IGeneralRepository repository;

    private static final String MANAGER_SEARCH_TERM="Manager";


    @Override
    public Object handle(ReadManagerInfoQuery query) {
       
        var result = repository.getEmployeeByYearsAndJob(query.getYear(), MANAGER_SEARCH_TERM);
        if (!result.isPresent()) {
            return null;
        }
        return result.get();

    }

}

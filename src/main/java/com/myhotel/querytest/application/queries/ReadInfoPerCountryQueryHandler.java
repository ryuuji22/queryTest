package com.myhotel.querytest.application.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.querytest.domain.interfaces.repositories.IGeneralRepository;

import io.jkratz.mediator.core.RequestHandler;
import lombok.SneakyThrows;

@Component
public class ReadInfoPerCountryQueryHandler implements RequestHandler<ReadInfoPerCountryQuery, Object> {

    @Autowired
    private IGeneralRepository repository;

    @Override
    @SneakyThrows
    public Object handle(ReadInfoPerCountryQuery query) {

        var result = repository.getCountryReport();
        if (!result.isPresent()) {
            return null;
        }
        return result.get();

    }

}

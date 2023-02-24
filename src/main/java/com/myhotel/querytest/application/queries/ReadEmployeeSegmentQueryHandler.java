package com.myhotel.querytest.application.queries;

import com.myhotel.querytest.domain.entities.SegmentCondition;
import com.myhotel.querytest.domain.exceptions.ApplicationDomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myhotel.querytest.domain.interfaces.repositories.IGeneralRepository;

import io.jkratz.mediator.core.RequestHandler;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

@Component
public class ReadEmployeeSegmentQueryHandler implements RequestHandler<ReadEmployeeSegmentQuery, Object> {

    @Autowired
    private IGeneralRepository repository;

    private Map<String, SegmentCondition> segments;

    @PostConstruct
    public void init() {
        segments = new HashMap<>();
        segments.put("A", new SegmentCondition(0D, 3500D));
        segments.put("B", new SegmentCondition(3500D, 8000D));
        segments.put("C", new SegmentCondition(8000D, 99999999D));
    }

    @Override
    public Object handle(ReadEmployeeSegmentQuery query) {
        var segment = segments.get(query.getSegment().toUpperCase());

        if (segment == null) {
            throw new ApplicationDomainException("Segment "+query.getSegment()+" not found.");
        }
        var result = repository.getEmployeeCountBySegmentSalary(segment.getMinSalary(), segment.getMaxSalary());
        if (!result.isPresent()) {
            return null;
        }
        return result.get();

    }

}

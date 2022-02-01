package com.project.service;

import com.project.common.model.SearchRequest;
import com.project.common.model.SearchResponse;
import com.project.data.document.Person;
import com.project.data.repository.BaseRepository;
import com.project.data.repository.PersonRepository;
import com.project.service.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.common.util.ApplicationUtil.getMatchingAllContainsStringMatcher;

@Service
@RequiredArgsConstructor
public class PersonService extends BaseService<Person, PersonDto, Integer> {

    private final PersonRepository repository;

    @Override
    public BaseRepository<Person, Integer> getRepository() {
        return repository;
    }

    @Override
    public SearchResponse<PersonDto> search(SearchRequest searchRequest) {
        final PersonDto searchModel = (PersonDto) searchRequest.getSearchDto();
        final Example<Person> example = Example.of(searchModel.toDocument(), getMatchingAllContainsStringMatcher());
        final Page<Person> personPage = repository.findAll(example, searchRequest.pageRequest());
        final List<PersonDto> personDtoList = (List<PersonDto>) toDto(personPage.toList());
        final int elementCount = Long.valueOf(personPage.getTotalElements()).intValue();
        return new SearchResponse<>(searchRequest.getPagination().getCurrentPage(), elementCount, personDtoList);
    }
}

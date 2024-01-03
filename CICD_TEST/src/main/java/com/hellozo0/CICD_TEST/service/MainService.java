package com.hellozo0.CICD_TEST.service;


import com.hellozo0.CICD_TEST.dto.response.main.EditorChoiceResponse;
import com.hellozo0.CICD_TEST.repository.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainService {

    private final BookJpaRepository bookJpaRepository;

    public List<EditorChoiceResponse> getEditorChoice() {

        Pageable pageable = PageRequest.of(0, 10);

        return bookJpaRepository.findAll(pageable)
                .stream()
                .map(EditorChoiceResponse::of)
                .collect(Collectors.toList());

    }

}

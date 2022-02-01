package com.project.data.repository;

import com.project.data.document.BaseDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseDocument, PK extends Serializable> extends MongoRepository<T, PK>{
}

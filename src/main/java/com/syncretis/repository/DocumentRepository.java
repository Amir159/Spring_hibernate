package com.syncretis.repository;

import com.syncretis.entity.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
    Document findById(String s);
}

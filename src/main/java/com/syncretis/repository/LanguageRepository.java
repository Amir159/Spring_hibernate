package com.syncretis.repository;

import com.syncretis.entity.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Long> {
    Language findById(long id);

    Language findByName(String name);
}

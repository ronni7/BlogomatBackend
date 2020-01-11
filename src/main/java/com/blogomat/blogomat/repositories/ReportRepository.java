package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.PostReport;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<PostReport, Integer> {
}

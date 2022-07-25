package com.bismdhr.bankmgmtsystem.repository;

import com.bismdhr.bankmgmtsystem.model.ResourceFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceFileRepository extends JpaRepository<ResourceFile, Integer> {
}

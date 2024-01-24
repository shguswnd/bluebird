package com.bluebird.bluebird.repository.common;

import com.bluebird.bluebird.domain.FilesLg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FilesLg, String> {
}

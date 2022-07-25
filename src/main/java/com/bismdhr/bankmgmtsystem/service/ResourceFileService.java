package com.bismdhr.bankmgmtsystem.service;

import com.bismdhr.bankmgmtsystem.model.ResourceFile;
import com.bismdhr.bankmgmtsystem.utils.FileType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResourceFileService {
    ResourceFile addFile (MultipartFile multipartFile, FileType fileType);

    ResourceFile findById(int id);
}

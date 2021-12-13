package com.informatorio.emprendimientos.service;

import com.informatorio.emprendimientos.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    
    @Autowired
    TagRepository tagRepository;

   
}

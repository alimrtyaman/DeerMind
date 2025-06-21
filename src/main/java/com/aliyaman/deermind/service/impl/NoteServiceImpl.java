package com.aliyaman.deermind.service.impl;

import com.aliyaman.deermind.dto.DtoNote;
import com.aliyaman.deermind.entity.CustomUserDetails;
import com.aliyaman.deermind.entity.Note;
import com.aliyaman.deermind.entity.User;
import com.aliyaman.deermind.repository.NoteRepository;
import com.aliyaman.deermind.service.INoteService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements INoteService {

    private NoteRepository noteRepository;


}

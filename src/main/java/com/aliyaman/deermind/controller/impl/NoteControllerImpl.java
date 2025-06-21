package com.aliyaman.deermind.controller.impl;

import com.aliyaman.deermind.entity.CustomUserDetails;
import com.aliyaman.deermind.entity.Note;
import com.aliyaman.deermind.entity.User;
import com.aliyaman.deermind.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteControllerImpl {

    @Autowired
    private INoteService iNoteService;


}

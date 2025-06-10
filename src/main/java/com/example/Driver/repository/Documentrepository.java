package com.example.Driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Driver.Entity.Document;

public interface Documentrepository extends JpaRepository<Document, Integer>{

}

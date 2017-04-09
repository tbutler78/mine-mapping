package com.tbutler78.minemapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbutler78.minemapping.domain.Name;

public interface NameRepository extends JpaRepository<Name, Long> {

}

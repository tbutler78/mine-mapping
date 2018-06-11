package com.tbutler78.minemapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbutler78.minemapping.domain.Name;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface NameRepository extends JpaRepository<Name, Long> {

    Name findOneByNameKey(String countyName);
}

package com.pmikeladze.siteScript.repository;

import com.pmikeladze.siteScript.entity.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NumbersRepos extends JpaRepository<Numbers,Long> {
}

package com.pmikeladze.siteScript.repository;

import com.pmikeladze.siteScript.entity.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author miq 16.08.2022
 */
public interface NumbersRepos extends JpaRepository<Numbers,Long> {
}

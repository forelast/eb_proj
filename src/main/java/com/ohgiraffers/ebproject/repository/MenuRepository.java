package com.ohgiraffers.ebproject.repository;

import com.ohgiraffers.ebproject.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository  extends JpaRepository<Menu, Integer> {
}

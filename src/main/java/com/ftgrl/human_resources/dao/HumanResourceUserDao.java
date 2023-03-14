package com.ftgrl.human_resources.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftgrl.human_resources.models.HumanResourceUser;

@Repository
public interface HumanResourceUserDao extends JpaRepository<HumanResourceUser, Integer> {

}

package com.ftgrl.human_resources.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ftgrl.human_resources.models.OperationClaim;

@Repository
public interface OperationClaimDao extends JpaRepository<OperationClaim, Integer> {

	
	@Query("From OperationClaim claim where claim.claimName = :claimName")
	OperationClaim getClaimByClaimName(String claimName);

}

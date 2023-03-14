package com.ftgrl.human_resources.services.managers;

import com.ftgrl.human_resources.services.interfaces.OperationClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftgrl.human_resources.dao.OperationClaimDao;
import com.ftgrl.human_resources.models.OperationClaim;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OperationClaimManager implements OperationClaimService {

	private OperationClaimDao operationClaimDao;
	
	@Autowired
	public OperationClaimManager(OperationClaimDao operationClaimDao) {
		super();
		this.operationClaimDao = operationClaimDao;
	}

	@Override
	public OperationClaim getClaimByClaimName(String claimName) {
		
		log.info("Claim ismiyle getirildi");
		
		return this.operationClaimDao.getClaimByClaimName(claimName);
	}

	
}

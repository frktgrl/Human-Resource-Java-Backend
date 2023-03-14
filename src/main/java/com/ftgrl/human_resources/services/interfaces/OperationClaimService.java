package com.ftgrl.human_resources.services.interfaces;

import com.ftgrl.human_resources.models.OperationClaim;

public interface OperationClaimService {
	
	OperationClaim getClaimByClaimName(String claimName);

}

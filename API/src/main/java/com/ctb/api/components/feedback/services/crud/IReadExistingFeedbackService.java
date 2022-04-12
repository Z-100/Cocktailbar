package com.ctb.api.components.feedback.services.crud;

import com.ctb.api.components.account.dto.AccountDTO;

public interface IReadExistingFeedbackService {

	AccountDTO getAccount(String username);
}

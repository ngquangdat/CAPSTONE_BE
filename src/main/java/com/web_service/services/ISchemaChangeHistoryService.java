package com.web_service.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.web_service.dto.SchemaChangeHistoryDTO;

public interface ISchemaChangeHistoryService {
	List<SchemaChangeHistoryDTO> findAll(Pageable pageable);
	int totalItem();
	SchemaChangeHistoryDTO getById(long id);
	List<SchemaChangeHistoryDTO> search(Long tableId, String changeType, int page, int limit);
	int totalItemSearch(Long tableId, String changeType);
}

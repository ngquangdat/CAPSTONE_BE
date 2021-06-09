package com.hoc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoc.api.output.CurrentTableSchemaOutput;
import com.hoc.api.output.PagingOutput;
import com.hoc.dto.CurrentTableSchemaDTO;
import com.hoc.service.ICurrentTableSchemaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CurrentTableSchemaAPI {
	@Autowired
	private ICurrentTableSchemaService currentTableSchemaService;

	@GetMapping(value = "/api/current_table_schemas")
	public CurrentTableSchemaOutput showCurrentTableSchema(@RequestParam("page") int page,
								@RequestParam("limit") int limit) {
		
		CurrentTableSchemaOutput result = new CurrentTableSchemaOutput();
		Pageable pageable = new PageRequest(page - 1, limit);
		result.setData(currentTableSchemaService.findAll(pageable));
		int totalPage = (int) Math.ceil((double) (currentTableSchemaService.totalItem()) / limit);
		int totalItem = currentTableSchemaService.totalItem();
		result.setMeta(new PagingOutput(page, totalPage, totalItem));

		return result;
	}
	
	@GetMapping(value = "/api/current_table_schemas/{id}")
	public CurrentTableSchemaDTO showCurrentTableSchema(@PathVariable("id") long id) {
		return currentTableSchemaService.getById(id);
	}
}

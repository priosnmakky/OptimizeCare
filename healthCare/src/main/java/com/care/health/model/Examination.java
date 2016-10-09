package com.care.health.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Examination")
public class Examination {
	@Id
	String id;
}

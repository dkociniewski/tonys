package com.gp3.tonys.db.entity;

import java.io.Serializable;

public interface Entity extends Serializable {
	String getId();

	void setId(String id);
}

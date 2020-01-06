package com.auth.dmv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lt_securityquestions")
public class SecurityQuestionsEntity {

	@Id
	private Integer qid;
	
	@Column(length = 100)
	private String Question;

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	@Override
	public String toString() {
		return "SecurityQuestionsEntity [qid=" + qid + ", Question=" + Question + "]";
	}

	
	
}

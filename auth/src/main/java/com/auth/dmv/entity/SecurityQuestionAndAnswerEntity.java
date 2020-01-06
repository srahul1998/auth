package com.auth.dmv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "security_questions_and_answers")
public class SecurityQuestionAndAnswerEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private Integer qa_id;
	
	
    @Column(length = 10)
	private Integer qid;
	

	@NotNull(message="answer is required")
    @Size(max = 40)
    @Column(length = 40)
	private String answer;

	@JsonIgnore(value = true)
	private Integer uid_fk;
	
	
	

	public Integer getUid_fk() {
		return uid_fk;
	}


	public void setUid_fk(Integer uid_fk) {
		this.uid_fk = uid_fk;
	}


	public Integer getQa_id() {
		return qa_id;
	}


	public void setQa_id(Integer qa_id) {
		this.qa_id = qa_id;
	}


	public Integer getQid() {
		return qid;
	}


	public void setQid(Integer qid) {
		this.qid = qid;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "SecurityQuestionAndAnswerEntity [qa_id=" + qa_id + ", qid=" + qid + ", answer=" + answer 
				 +"]";
	}


	
	
	
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "uid" , nullable = false ) private UserDetlsEntity
	 * detlsEntityone;
	 */


	


}

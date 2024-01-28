package com.example.bikeshowroom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_employee")
public class Employee {
	
	@Id
//	@Column(name = "Employee_ID")  If you need to change the column name use like this.
	private Integer employee_id;
	private String employee_name;
	private String dept;
	private Integer attendance;
	private Integer leave_day;
	private Integer checkin;
	private String status;
	
	
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Integer getAttendance() {
		return attendance;
	}
	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}
	public Integer getLeave_day() {
		return leave_day;
	}
	public void setLeave_day(Integer leave_day) {
		this.leave_day = leave_day;
	}
	public Integer getCheckin() {
		return checkin;
	}
	public void setCheckin(Integer checkin) {
		this.checkin = checkin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}

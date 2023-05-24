package com.meng.pojo;

public class Emp {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.emp_id
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    private Integer empId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.emp_name
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    private String empName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.age
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.gender
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column emp.dept_id
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    private Integer deptId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.emp_id
     *
     * @return the value of emp.emp_id
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.emp_id
     *
     * @param empId the value for emp.emp_id
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.emp_name
     *
     * @return the value of emp.emp_name
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.emp_name
     *
     * @param empName the value for emp.emp_name
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.age
     *
     * @return the value of emp.age
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.age
     *
     * @param age the value for emp.age
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.gender
     *
     * @return the value of emp.gender
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.gender
     *
     * @param gender the value for emp.gender
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.dept_id
     *
     * @return the value of emp.dept_id
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.dept_id
     *
     * @param deptId the value for emp.dept_id
     *
     * @mbggenerated Thu Sep 01 14:34:07 CST 2022
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
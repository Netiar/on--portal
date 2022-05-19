package models;

import java.util.Objects;

public class Users {
    private static int id;
    private String name;
    private static String rank;
    private static String staffRole;
    private static int dept_id;
    static String department;


    public Users() {
    }

    public Users(String name, String rank,  String staffRole, int dept_id) {
        this.name = name;
        this.rank = rank;
        this.staffRole = staffRole;
        this.dept_id = dept_id;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users user = (Users) o;
        return id == Users.id && dept_id ==Users.dept_id && name.equals(user.name) && rank.equals(Users.rank) && staffRole.equals(Users.staffRole) && department.equals(Users.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rank, staffRole, dept_id, department);
    }
}

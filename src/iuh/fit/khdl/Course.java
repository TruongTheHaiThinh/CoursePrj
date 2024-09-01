package iuh.fit.khdl;

/**
 * @version 1.0
 * @description:
 * @author: Truong The Hai Thinh
 * @created 25/8/2024
 */
public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    public Course()
    {
        this("", "",0, "");
    }

    public Course(String id, String title, int credit, String department) {
        this.setId(id);
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredit() {
        return credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(String id) {

        if(id.trim().length() < 3)
            throw new IllegalArgumentException("Length of ID is at least 3");
        for (int i = 0; i < id.length(); i++) {
            char ch = id.charAt(i);
            if(!Character.isLetterOrDigit(ch))
                throw new IllegalArgumentException("ID contains only letters or numbers");
        }
        this.id = id;
    }

    public void setTitle(String title) {
        if(title.isEmpty())
            throw new IllegalArgumentException("Cannot be left blank");
        this.title = title;
    }

    public void setCredit(int credit) {
        if(credit < 0)
            throw new IllegalArgumentException("Credit must be greater than 0");
        this.credit = credit;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-25s%10d %-10s", id, title, credit, department);
    }
}

package iuh.fit.khdl;

import java.util.Arrays;

/**
 * @version 1.0
 * @description:
 * @author: Truong The Hai Thinh
 * @created 25/8/2024
 */
public class CourseList {
    private Course[] courses;
    private int count = 0;
    private java.util.Arrays Arrays;

    public CourseList(int n)
    {
        if(n<=0)
            throw new IllegalArgumentException("Length must be greater than 0");
        courses = new Course[n];
    }

    public Course[] getCourses()
    {
        return courses;
    }

    public boolean addCourse(Course course)
    {
        if(course == null)
            return false;
        if(isExists(course)) {
            System.out.println("Course already exists");
            return false;
        }

        if(count==courses.length)
            return false;

        courses[count++] = course;
        return true;
    }


    private boolean isExists(Course course)
    {
        for (int i = 0; i < count; i++)
            if(courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        return false;
    }

    public String findDepartmenWithMostCourse()
    {
        Course departmentMostCourse = courses[0];
        for (int i = 1; i < count; i++)
        {
            if(departmentMostCourse.getCredit()<courses[i].getCredit())
                departmentMostCourse = courses[i];
        }
        return departmentMostCourse.toString();
    }


    public Course[] findMaxCreditCourse()
    {
        int numMax = courses[0].getCredit();
        int j = 0;
        for (int i = 1; i < count; i++)
        {
            if(courses[i].getCredit() > numMax)
                numMax = courses[i].getCredit();
        }
        for (int i = 0; i < count; i++)
            if(courses[i].getCredit() == numMax)
                j++;

        Course[] maxCredit = new Course[j];
        int dem = 0;
        for (int i = 0; i < count; i++)
            if(courses[i].getCredit() == numMax)
            {
                maxCredit[dem] = courses[i];
                dem++;
            }
        return maxCredit;
    }
    public boolean removeCourse(String courseID)
    {
        if(courseID==null || courseID.isEmpty())
            throw new IllegalArgumentException("No course exists!");
        for (int i = 0; i < count; i++)
        {
            if(courses[i].getId().equalsIgnoreCase(courseID)) {
                for (int j = i; j < count - 1; j++)
                    courses[j] = courses[j + 1];
                courses[count - 1] = null;
                count--;
                return true;
            }
        }
        System.out.println("Course not found");
        return false;
    }
    public Course[] searchCourse(String courseTittle)
    {
        if(courseTittle==null || courseTittle.isEmpty()) {
            return null;
        }
        for (int i = 0; i < count; i++)
        {
            if(courses[i].getTitle().equalsIgnoreCase(courseTittle))
                System.out.println(courses[i]);
        }
        return null;
    }
    public Course[] searchCourseByDepartment(String courseDepartment)
    {
        for (int i = 0; i < count; i++)
        {
            if(courses[i].getDepartment().equalsIgnoreCase(courseDepartment))
                System.out.println(courses[i]);
        }
        return null;
    }
    public Course searchCourseByID(String courseID)
    {
        for (int i = 0; i < count; i++)
            if(courses[i].getId().equalsIgnoreCase(courseID))
                return courses[i];
        return null;
    }
    public Course[] sortCourse()
    {
        Course [] copyCourse = Arrays.copyOf(courses, count);
        for (int i = 0; i < count - 1; i++)
        {
            for (int j = i + 1; j < count; j++)
                if(copyCourse[i].getTitle().compareTo(copyCourse[j].getTitle())>0)
                {
                    Course temp = copyCourse[i];
                    copyCourse[i] = copyCourse[j];
                    copyCourse[j] = temp;
                }
        }
        return copyCourse;
    }

}

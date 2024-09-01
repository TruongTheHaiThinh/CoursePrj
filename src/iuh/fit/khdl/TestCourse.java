package iuh.fit.khdl;


/**
 * @version 1.0
 * @description:
 * @author: Truong The Hai Thinh
 * @created 25/8/2024
 */
public class TestCourse {
    public static void main(String[] args) {
        Course c1 = new Course("IT202", "Lap Trinh C", 2, "CS");
        Course c2 = new Course("FR393", "Co So Du Lieu", 3, "SE");
        Course c3 = new Course("CR876", "Ky Thuat Lap Trinh", 1, "CS");
        Course c4 = new Course("IT192", "Khoa Hoc May Tinh", 5, "SE");
        Course c5 = new Course("FR621", "Toan Roi Rac", 4, "CS");

        CourseList courseList = new CourseList(10);
        courseList.addCourse(c1);
        courseList.addCourse(c2);
        courseList.addCourse(c3);
        courseList.addCourse(c4);
        courseList.addCourse(c5);
        for (Course x : courseList.getCourses()) {
            if(x!=null)
                System.out.println(x);
        }
        System.out.println("The department with the most course:\n" + courseList.findDepartmenWithMostCourse());


        courseList.removeCourse("IT192");

        System.out.println("List of courses after removing\n");
        for (Course x : courseList.getCourses())
        {
            if(x!=null)
                System.out.println(x);
        }

        System.out.println("\nCourse with the most credits: ");
        for (Course c : courseList.findMaxCreditCourse())
        {
            if(c!=null)
                System.out.println(c);
        }

        System.out.println("\nSearch for courses by title");
        courseList.searchCourse("Co So Du Lieu");

        System.out.println("\nFind courses by department:");
        courseList.searchCourseByDepartment("SE");

        System.out.println("\nFind course by ID");
        System.out.println(courseList.searchCourseByID("IT202"));
        System.out.println("\nList of Course after sorting");
        for (Course x : courseList.sortCourse())
        {
            if(x!=null)
                System.out.println(x);
        }
    }

}

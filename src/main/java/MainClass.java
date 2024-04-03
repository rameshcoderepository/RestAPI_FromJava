public class MainClass {

    public static void main(String[] args) {

        CourseFromJavaClass courseFromJavaClass = new CourseFromJavaClass(4, "vaisul", "James");

        RestAPI restAPI = new RestAPI();
        CourseFromJavaClass responseCourse = restAPI.submitRestAPIRequest(courseFromJavaClass);

        System.out.println("Response from server:");
        System.out.println("EmpId: " + responseCourse.getEmpId());
        System.out.println("First Name: " + responseCourse.getFirstName());
        System.out.println("Last Name: " + responseCourse.getLastName());
    }

}

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestAPI {

	private static final String JWT_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVbmlxVGVjaCIsImV4cCI6MTcxMjE2MDM4MywiaWF0IjoxNzEyMTQyMzgzfQ.33IE2-DQ-ZZwMf8DE1FQo9HR4EdHjtzwhZAeq-a4SQ44u68SycUeAo4XB9FBFhGaBIGIMjgrmUsNXnJ8YIcv2Q";

	public CourseFromJavaClass submitRestAPIRequest(CourseFromJavaClass course) {
		String restEndPointURI = "http://localhost:8080/course";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + JWT_TOKEN);
		HttpEntity<CourseFromJavaClass> requestEntity = new HttpEntity<>(course, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(restEndPointURI, requestEntity,
				String.class);

		String serverResponse = responseEntity.getBody();

		System.out.println("*********************"+serverResponse);
		// Extract the empId value from the server response
		String[] parts = serverResponse.split(",");
		int empId = Integer.parseInt(parts[0].substring(parts[0].indexOf("=") + 1).trim());
		String firstName = parts[1].substring(parts[1].indexOf("=") + 1).trim();
		String lastName = parts[2].substring(parts[2].indexOf("=") + 1).trim();

		// Create a new instance of CourseFromJavaClass
		CourseFromJavaClass responseCourse = new CourseFromJavaClass(empId, firstName, lastName);

		return responseCourse;
	}

}

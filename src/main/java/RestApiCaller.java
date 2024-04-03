
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestApiCaller {
	private static final String API_URL = "http://localhost:8080/hello";
	private static final String JWT_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVbmlxVGVjaCIsImV4cCI6MTcxMjE2MDM4MywiaWF0IjoxNzEyMTQyMzgzfQ.33IE2-DQ-ZZwMf8DE1FQo9HR4EdHjtzwhZAeq-a4SQ44u68SycUeAo4XB9FBFhGaBIGIMjgrmUsNXnJ8YIcv2Q";

	public static void main(String[] args) {
		// Create HttpHeaders with JWT token
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + JWT_TOKEN);

		// Create a HttpEntity with headers
		HttpEntity<String> entity = new HttpEntity<>(headers);

		// Create a RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Make a GET request with the JWT token
		ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity, String.class);

		// Process the response
		if (response.getStatusCode().OK != null) {
			System.out.println("Response Body: " + response.getBody());
		} else {
			System.out.println("Request failed with status code: " + response.getStatusCode());
		}
	}
}

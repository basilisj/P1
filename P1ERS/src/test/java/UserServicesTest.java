
import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;
import com.example.dao.UsersDao;
import com.example.dao.UsersDaoHib;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.model.UserRoles;
import com.example.model.Users;
import com.example.services.UserServices;
import org.junit.Test;

public class UserServicesTest {
		
			@InjectMocks
			public UserServices uServ;
			
			@Mock
			public UsersDao uDao;
			
			@Before
			public void initMocks() {
				MockitoAnnotations.initMocks(this);
			}
			
			@Test
	public void testValidLogin() {
		UserRoles r1 = new UserRoles(1, "EMPLOYEE");
		UserRoles r2 = new UserRoles(2, "FINANCIAL MANAGER");
		Users u1 = new Users (1, "test", "user",  "test@email.com", "testpass", r1);
		Users not = new Users(0, "test", "user",  "test@mail.com", "testpass", r2);
		
		when(uDao.getUserByUserName(anyString())).thenReturn(u1);
		
		Users loggedIn = uServ.signIn("usertest", "testpass");
		
		assertEquals(u1.getUsername(), loggedIn.getUsername());
	}
			
			@Test
			public void testSignUp() {
			UserRoles r1 = new UserRoles(1, "EMPLOYEE");
				UserRoles r2 = new UserRoles(2, "FINANCIAL MANAGER");
				
				Users u = new Users(1, "User", "Test", "test@email.com", "testpassword", r1);
				Users notUser = new Users(0, "User", "Test", "test@email.com", "testpassword", r2);
				
				when(uDao.getUserByUserName(anyString())).thenReturn(u);
				
				Users signedIn = uServ.signIn("TestUser", "testpassword");
				
				assertEquals(u.getUserId(), signedIn.getUserId());
			}
			
}

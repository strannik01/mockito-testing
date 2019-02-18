package mock1;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import com.dev21.mocktutorial.basecode.AuthenticatorApplication;
import com.dev21.mocktutorial.basecode.AuthenticatorInterface;

public class AuthenticatorApplicationTest {

	@Test
	public void testAuthenticate() {
		AuthenticatorInterface authenticatorMock;
		AuthenticatorApplication authenticator;
		String username = "JavaCodeGeeks";
		String password = "unsafePassword";
		
		authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
		authenticator = new AuthenticatorApplication(authenticatorMock);
		
		when(authenticatorMock.authenticateUser(username, password)).thenReturn(false);
		
		boolean actual = authenticator.authenticate(username, password);
		
		assertFalse(actual);
		
		verify(authenticatorMock).authenticateUser(username, password);
		verify(authenticatorMock, times(1)).authenticateUser(username, password);
		verify(authenticatorMock, atLeastOnce()).authenticateUser(username, password);
		verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
		verify(authenticatorMock, atMost(1)).authenticateUser(username, password);
//		verify(authenticatorMock, never()).authenticateUser(username, password);
		
		InOrder inOrder = Mockito.inOrder(authenticatorMock);
		inOrder.verify(authenticatorMock).foo();
		inOrder.verify(authenticatorMock).authenticateUser(username, password);
		
		verify(authenticatorMock, timeout(100)).authenticateUser(username, password);
		verify(authenticatorMock, timeout(100).times(1)).authenticateUser(username, password);
		
		
		
		
	}
}

package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import antlr.collections.List;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Donation;
import ar.edu.unq.desapp.grupoG.backenddesappapi.model.Location;

public class DonationTest {
	private Donation donation;

    @BeforeEach
    void setUp() {
        donation = new Donation(0, 1, 2, 5000.45);
    }
    
	@Test //EXAMPLE MOCK
	void contextLoads() {
		// mock creation
		List mockedList = mock(List.class);
//		mockedList.add("one");
//		mockedList.add("hola");
		when(mockedList.elementAt(0)).thenReturn("one");
		when(mockedList.elementAt(1)).thenReturn("hola");
		
		assertEquals("hola", mockedList.elementAt(1));
	
	}

    @Test
    void getIdDonationTest(){
        int expectedId = 0;
        assertEquals(expectedId, donation.getId());
    }
    
    @Test
    void getIdUserDonationTest(){
        assertEquals(1, donation.getIdUser());
    }
    
    @Test
    void getIdLocationDonationTest(){
        assertEquals(2, donation.getIdLocation());
    }
    
    @Test
    void getAmountDonationTest(){
        assertEquals(5000.45, donation.getAmount());
    }
}

package MeetingPlanner.src.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import MeetingPlanner.src.main.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestMeetPlanner {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void empty() {
		Calendar calendar = new Calendar();
		try{
			calendar.clearSchedule(2, 13);
		} catch(IndexOutOfBoundsException e) {
		e.printStackTrace();	
		}
		calendar = null;
	}
	
	// Meeting Month to be set as Invalid
	@Test(expected = TimeConflictException.class)
	public void testAddMeetingMonth() {
		
		Meeting toAd = new Meeting(13,2);
		Calendar calendar = new Calendar();
		try{
			calendar.addMeeting(toAd);			
		} catch(TimeConflictException e) {
			e.printStackTrace();
		}
		calendar = null;
	}

	// Meeting Month to set Valid & should be available
	@Test
	public void testAddMeetingValid() {
		int month = 12;
		int day = 2;
		int start = 4;
		int end = 5;
		Person person = new Person("GREG GAY");
		ArrayList<Person> attendees = new ArrayList<>();
		attendees.add(person);
		Room room = new Room("2A01");
		String description = "valid Meeting check";
		
		Meeting toAd = new Meeting(month,day,start,end,attendees,room,description);
		
		Meeting result = new Meeting();
		Calendar calendar = new Calendar();
		try{
			calendar.addMeeting(toAd);			
		} catch(TimeConflictException e) {
			e.printStackTrace();
		}
		result = calendar.getMeeting(12, 2, 0);
		assertSame(result, toAd);
		calendar = null;
	}
	
	// Meeting Date as Feb29 to be set; No Implication of year taken
	// Feb29 is legitimate Date for 2016 & all Leap years.
	@Test(expected = Exception.class)
	public void testAddMeetingFeb29() {
		
		// Meeting Date as Feb29 to be set
		Meeting toAd = new Meeting(29,2);
		Calendar calendar = new Calendar();
		try{
			calendar.addMeeting(toAd);			
		} catch(TimeConflictException e) {
			e.printStackTrace();
		}
		calendar = null;
	}
	
	@Test(expected = TimeConflictException.class)
	public void testaddMeetingDay() {
		// Meeting Month to be set as valid but code does not cover
		Meeting toAdd = new Meeting(2,29);
		Calendar calendar = new Calendar();
		try{
			calendar.addMeeting(toAdd);			
		} catch(TimeConflictException e) {
			e.printStackTrace();
		}
		calendar = null;
		toAdd = null;
	}

	/* Meeting Start time before busy (existing meeting start) time & Meeting End time after (existing meeting End)
	for Example. Previous meeting is 10-11 
	And 		 New Meeting is      09-12
	*/
	
	@Test(expected = TimeConflictException.class)
	public void testaddMeetingOverLapFulltime() {
		
		int month = 3;
		int day = 29;
		int start = 10;
		int end = 11;
		Person person = new Person("GREG GAY");
		ArrayList<Person> attendees = new ArrayList<>();
		attendees.add(person);
		Room room = new Room("2A01");
		String description1 = "valid Meeting check";
		
		// Meeting Month to be set as Invalid
		Meeting prev = new Meeting(month,day,start,end,attendees,room,description1);
		
		start = 9;
		end = 12;
		description1 = "OverLapping Time for Start & END Both Meeting check";
		
		Meeting next = new Meeting(month,day,start,end,attendees,room,description1);
		
		Calendar calendar = new Calendar();
		try{
			calendar.addMeeting(prev);
			calendar.addMeeting(next);
		} catch(TimeConflictException e) {
			e.printStackTrace();
		}
		calendar = null;
		prev = null;
		next = null;
	}
	

	// Invalid Input and No checking of @param of PrintAgenda Function
	@Test
	public void testPrintagenda() {
		String agenda = null;
		Calendar calendar = new Calendar();
		try{
			// Entering Agenda for 0 month
			agenda = calendar.printAgenda(0,0);
		} catch(Exception e) {
			e.printStackTrace();
		}
		assertNull(agenda);
	}

	// Invalid Input and No checking of param of GetMeeting Function
	@Test(expected = TimeConflictException.class)
	public void testGetMeeting() {

		Calendar calendar = new Calendar();
		try{
			Meeting meet = new Meeting();
			// No Input Check on Get Meeting Parameters for 0 month
			meet = calendar.getMeeting(0, 0, 2);
			System.out.println(meet);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Invalid Input and No checking of @param of RemoveMeeting Function
		@Test(expected = TimeConflictException.class)
		public void testRemoveMeeting() {
		
			Calendar calendar = new Calendar();
			try {
			// No Input Check on Get Meeting Parameters for 0 month
			 calendar.removeMeeting(0, 0, 2);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}

	

}

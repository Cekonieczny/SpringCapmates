package com.capgemini.jst.SpringCapmates.repositories;

import java.time.LocalTime;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import org.springframework.stereotype.Repository;
import com.capgemini.jst.SpringCapmates.data.UserHoursOfAvailability;

@Repository
public class UserHoursOfAvailabilityDao {
	List<UserHoursOfAvailability > listOfHoursOfAvailability;
	

	public UserHoursOfAvailabilityDao() {
		listOfHoursOfAvailability = new LinkedList<>();
		LocalTime from1 = LocalTime.of(11, 30);
		LocalTime to1 = LocalTime.of(12, 30);
		LocalTime from2 = LocalTime.of(10, 30);
		LocalTime to2 = LocalTime.of(14, 30);
		LocalTime from3 = LocalTime.of(10, 30);
		LocalTime to3 = LocalTime.of(12, 30);
		LocalTime from4 = LocalTime.of(7, 30);
		LocalTime to4 = LocalTime.of(12, 30);
		LocalTime from5 = LocalTime.of(18, 30);
		LocalTime to5 = LocalTime.of(22, 30);
		LocalTime from6 = LocalTime.of(11, 30);
		LocalTime to6 = LocalTime.of(12, 30);
		LocalTime from7 = LocalTime.of(12, 00);
		LocalTime to7 = LocalTime.of(12, 30);
		LocalTime from8 = LocalTime.of(18, 30);
		LocalTime to8 = LocalTime.of(22, 30);
		LocalTime from9 = LocalTime.of(8, 30);
		LocalTime to9 = LocalTime.of(23, 30);
		LocalDate date1 = LocalDate.of(2018, 12, 27);
		LocalDate date2 = LocalDate.of(2018, 12, 27);
		LocalDate date3 = LocalDate.of(2018, 12, 27);
		LocalDate date4 = LocalDate.of(2018, 12, 27);
		LocalDate date5 = LocalDate.of(2018, 12, 27);
		LocalDate date6 = LocalDate.of(2018, 12, 27);
		LocalDate date7 = LocalDate.of(2018, 12, 27);
		LocalDate date8 = LocalDate.of(2018, 12, 26);
		LocalDate date9 = LocalDate.of(2018, 12, 26);
		listOfHoursOfAvailability.add(new UserHoursOfAvailability(10L,from1,to1, date1, 1L));
		listOfHoursOfAvailability.add(new UserHoursOfAvailability(20L,from2,to2, date2, 2L));
		listOfHoursOfAvailability.add(new UserHoursOfAvailability(30L,from3,to3, date3, 3L));
		listOfHoursOfAvailability.add(new UserHoursOfAvailability(40L,from4,to4, date4, 4L));
		listOfHoursOfAvailability.add(new UserHoursOfAvailability(50L,from5,to5, date5, 5L));
		listOfHoursOfAvailability.add(new UserHoursOfAvailability(60L,from6,to6, date6, 6L));
		listOfHoursOfAvailability.add(new UserHoursOfAvailability(70L,from7,to7, date7, 7L));
		listOfHoursOfAvailability.add(new UserHoursOfAvailability(80L,from8,to8, date8, 8L));
		listOfHoursOfAvailability.add(new UserHoursOfAvailability(90L,from9,to9, date9, 9L));
	}
	
	public UserHoursOfAvailability find(Long userHoursOfAvailabilityId) {
		for (UserHoursOfAvailability hours : listOfHoursOfAvailability) {
			if (hours.getUserHoursOfAvailabilityId().equals(userHoursOfAvailabilityId)) {
				return hours;
			}
		}
		return null;
	}
	
	public List<UserHoursOfAvailability> findAll(){
		return listOfHoursOfAvailability;
	}
	
	public List<UserHoursOfAvailability> filterByDate(LocalDate date){
		return listOfHoursOfAvailability.stream().filter(p -> p.getDate().equals(date))
				.collect(Collectors.toList());
	}
	public List<UserHoursOfAvailability> filterByUserId(Long userId) {
		return  listOfHoursOfAvailability.stream().filter(p -> p.getUserId().equals(userId))
				.collect(Collectors.toList());
	}
	

	public void create(UserHoursOfAvailability userHoursOfAvailability) {
		if (userHoursOfAvailability.getUserHoursOfAvailabilityId() != null) {
			throw new IllegalArgumentException("User Hours of Availability entity is already created, it is not null.");
		} else {
			userHoursOfAvailability.setUserHoursOfAvailabilityId(System.currentTimeMillis());
			listOfHoursOfAvailability.add(userHoursOfAvailability);
		}
		
	}

	public void delete(UserHoursOfAvailability userHoursOfAvailability) {
		UserHoursOfAvailability userHoursToRemove = new UserHoursOfAvailability();
		for (UserHoursOfAvailability tempHours : listOfHoursOfAvailability) {
			if (tempHours.getUserHoursOfAvailabilityId().equals(userHoursOfAvailability.getUserHoursOfAvailabilityId())) {
				userHoursToRemove = tempHours;
			}	
		}
		listOfHoursOfAvailability.remove(userHoursToRemove);
		userHoursOfAvailability.setActive(false);
		listOfHoursOfAvailability.add(userHoursOfAvailability);
	}

}


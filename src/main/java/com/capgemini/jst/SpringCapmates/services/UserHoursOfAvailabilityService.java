package com.capgemini.jst.SpringCapmates.services;

import java.time.Duration;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.jst.SpringCapmates.data.UserHoursOfAvailability;
import com.capgemini.jst.SpringCapmates.mappers.UserHoursOfAvailabilityMapper;
import com.capgemini.jst.SpringCapmates.repositories.UserHoursOfAvailabilityDao;
import com.capgemini.jst.SpringCapmates.transferObjects.ChallengeDto;
import com.capgemini.jst.SpringCapmates.transferObjects.UserHoursOfAvailabilityDto;

@Service
public class UserHoursOfAvailabilityService {
	private final UserHoursOfAvailabilityDao userHoursOfAvailabilityDao;
	private final UserHoursOfAvailabilityMapper userHoursOfAvailabilityMapper;
	private List<Long> listOfMatchedUsers;

	@Autowired
	public UserHoursOfAvailabilityService(UserHoursOfAvailabilityDao userHoursOfAvailabilityDao,
			UserHoursOfAvailabilityMapper userHoursOfAvailabilityMapper) {
		this.userHoursOfAvailabilityDao = userHoursOfAvailabilityDao;
		this.userHoursOfAvailabilityMapper = userHoursOfAvailabilityMapper;
	}

	public List<Long> getListOfPlayersToChallenge(Long userId, long durationOfGameInMinutes) {
		listOfMatchedUsers = findMatchingUsers(userId, durationOfGameInMinutes);
		return listOfMatchedUsers;
	}

	public List<ChallengeDto> createChallenges(Long userId) {
		List<ChallengeDto> listOfChallenges = new LinkedList<>();
	
		for (Long matchedUserId : listOfMatchedUsers) {
			ChallengeDto challengeDto = new ChallengeDto(matchedUserId, userId,
					userHoursOfAvailabilityDao.find(matchedUserId).getFrom(),
					userHoursOfAvailabilityDao.find(matchedUserId).getTo(),
					userHoursOfAvailabilityDao.find(matchedUserId).getDate());
			listOfChallenges.add(challengeDto);
	
		}
		return listOfChallenges;
	}

	public void addUserHoursOfAvailability(UserHoursOfAvailabilityDto userHoursOfAvailabilityDto) {
		UserHoursOfAvailability userHoursOfAvailability = new UserHoursOfAvailability();
		userHoursOfAvailabilityDao.create(userHoursOfAvailabilityMapper
				.mapUserGameCollectionDtoToUser(userHoursOfAvailabilityDto, userHoursOfAvailability));
	}

	public UserHoursOfAvailability deleteUserHoursOfAvailability(Long hoursId, String comment) {
		UserHoursOfAvailability userHours = userHoursOfAvailabilityDao.find(hoursId);
		userHours.setComment(comment);
		userHoursOfAvailabilityDao.delete(userHours);
		return userHours;
	}

	private List<Long> findMatchingUsers(Long userId, long durationOfGameInMinutes) {
	
		List<UserHoursOfAvailability> hoursByUser = userHoursOfAvailabilityDao.filterByUserId(userId);
		List<Long> listOfMatchingUsersId = new LinkedList<>();
	
		for (UserHoursOfAvailability specificUserhours : hoursByUser) {
			LocalDate specificUserDate = specificUserhours.getDate();
			for (UserHoursOfAvailability allHours : userHoursOfAvailabilityDao.findAll()) {
				if (!allHours.getUserId().equals(userId)&& specificUserDate.isEqual(allHours.getDate())) {
					if (areHoursMatching(durationOfGameInMinutes, specificUserhours, allHours)) {
						listOfMatchingUsersId.add(allHours.getUserId());
					}
				}
			}
		}
	
		return listOfMatchingUsersId;
	}

	private boolean areHoursMatching(long durationOfGameInMinutes, UserHoursOfAvailability userHoursOfAvailability1,
			UserHoursOfAvailability userHoursOfAvailability2) {
	
		long commonPeriodOfTime = 0;
		
		/*long from1 = Time.valueOf(userHoursOfAvailability1.getFrom()).getTime();
		long to1 = Time.valueOf(userHoursOfAvailability1.getTo()).getTime();
		long from2 = Time.valueOf(userHoursOfAvailability2.getFrom()).getTime();
		long to2 = Time.valueOf(userHoursOfAvailability2.getTo()).getTime();
		
		if(from1>=from2&&to1>=to2){
			
		}
		else if(from1)*/
	
		if (userHoursOfAvailability1.getTo().isBefore(userHoursOfAvailability2.getFrom())
				|| userHoursOfAvailability2.getTo().isBefore(userHoursOfAvailability1.getFrom())) {
			return false;
	
		} else if (userHoursOfAvailability1.getFrom().equals(userHoursOfAvailability2.getTo()) 
				|| userHoursOfAvailability2.getFrom().equals(userHoursOfAvailability1.getTo()) ) {
			return false;
	
		} else if ((userHoursOfAvailability1.getTo().isBefore(userHoursOfAvailability2.getTo()))
				&& userHoursOfAvailability1.getTo().isAfter(userHoursOfAvailability2.getFrom())) {
	
			commonPeriodOfTime = Duration.between(userHoursOfAvailability2.getFrom(), userHoursOfAvailability1.getTo())
					.toMinutes();
	
		} else if (userHoursOfAvailability2.getTo().isBefore(userHoursOfAvailability1.getTo())
				&& userHoursOfAvailability2.getTo().isAfter(userHoursOfAvailability1.getFrom())) {
	
			commonPeriodOfTime = Duration.between(userHoursOfAvailability1.getFrom(), userHoursOfAvailability2.getTo())
					.toMinutes();
	
		}else if ((userHoursOfAvailability1.getTo().equals(userHoursOfAvailability2.getTo()))
				&& userHoursOfAvailability1.getTo().isAfter(userHoursOfAvailability2.getFrom())) {
	
			commonPeriodOfTime = Duration.between(userHoursOfAvailability2.getFrom(), userHoursOfAvailability1.getTo())
					.toMinutes();
	
		} else if (userHoursOfAvailability2.getTo().equals(userHoursOfAvailability1.getTo())
				&& userHoursOfAvailability2.getTo().isAfter(userHoursOfAvailability1.getFrom())) {
	
			commonPeriodOfTime = Duration.between(userHoursOfAvailability1.getFrom(), userHoursOfAvailability2.getTo())
					.toMinutes();
	
		}else if (userHoursOfAvailability1.getFrom().equals(userHoursOfAvailability2.getFrom())) {
			if (userHoursOfAvailability1.getTo().isBefore(userHoursOfAvailability2.getTo())) {
				commonPeriodOfTime = Duration
						.between(userHoursOfAvailability1.getFrom(), userHoursOfAvailability1.getTo()).toMinutes();
			} else if (userHoursOfAvailability2.getTo().isBefore(userHoursOfAvailability1.getTo())) {
				commonPeriodOfTime = Duration
						.between(userHoursOfAvailability2.getFrom(), userHoursOfAvailability2.getTo()).toMinutes();
			}
			else if (userHoursOfAvailability2.getTo().equals(userHoursOfAvailability1.getTo())){
				commonPeriodOfTime = Duration
						.between(userHoursOfAvailability2.getFrom(), userHoursOfAvailability2.getTo()).toMinutes();
			}
		}
	
		if (commonPeriodOfTime >= durationOfGameInMinutes) {
			return true;
		}
	
		return false;
	
	}
}

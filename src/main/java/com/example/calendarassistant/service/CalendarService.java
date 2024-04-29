package com.example.calendarassistant.service;



import com.example.calendarassistant.model.Calendar;
import com.example.calendarassistant.model.CalendarRequest;
import com.example.calendarassistant.model.Meeting;
import com.example.calendarassistant.model.MeetingRequest;
import com.example.calendarassistant.repository.CalendarRepository;
import com.example.calendarassistant.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;
    public Calendar createCalendar(CalendarRequest request) {
        Calendar calendar = new Calendar(request.getName(), request.getDescription());
        return calendarRepository.save(calendar);
    }

    @Autowired
    private MeetingRepository meetingRepository;


    public Meeting bookMeeting(MeetingRequest request) {
        // Fetch the Calendar entity based on the calendarId from the request
        Calendar calendar = calendarRepository.findById(request.getCalendarId())
                .orElseThrow(() -> new RuntimeException("Calendar not found"));

        // Create a new Meeting object with the fetched Calendar entity
        Meeting meeting = new Meeting(request.getStartTime(), request.getEndTime(), calendar);

        // Save the new Meeting object to the database
        meetingRepository.save(meeting);

        return meeting;
    }


    public List<Meeting> findMeetingConflicts(Long calendarId, LocalDateTime start, LocalDateTime end) {
        return meetingRepository.findConflictingMeetings(calendarId, start, end, null);
    }

    public List<LocalDateTime> findFreeSlots(Long calendarId, Duration meetingDuration) {
        Calendar calendar = calendarRepository.findById(calendarId).orElseThrow(() -> new RuntimeException("Calendar not found"));
        List<Meeting> meetings = meetingRepository.findByCalendarId(calendarId);
        List<LocalDateTime> freeSlots = new ArrayList<>();

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime endOfDay = currentTime.withHour(23).withMinute(59).withSecond(59);

        while (currentTime.isBefore(endOfDay)) {
            boolean isFree = true;
            for (Meeting meeting : meetings) {
                if (meeting.getStartTime().isBefore(currentTime.plus(meetingDuration)) && meeting.getEndTime().isAfter(currentTime)) {
                    isFree = false;
                    break;
                }
            }
            if (isFree) {
                freeSlots.add(currentTime);
            }
            currentTime = currentTime.plusMinutes(30); // Assuming we're looking for 30-minute slots
        }

        return freeSlots;
    }

    public List<String> checkForConflicts(MeetingRequest request) {
        List<String> conflicts = new ArrayList<>();
        for (Long participantId : request.getParticipantIds()) {
            Calendar participantCalendar = calendarRepository.findById(participantId).orElseThrow(() -> new RuntimeException("Participant calendar not found"));
            List<Meeting> participantMeetings = meetingRepository.findByCalendarId(participantId);
            for (Meeting meeting : participantMeetings) {
                if (meeting.getStartTime().isBefore(request.getEndTime()) && meeting.getEndTime().isAfter(request.getStartTime())) {
                    conflicts.add("Participant " + participantId + " has a meeting conflict.");
                }
            }
        }
        return conflicts;
    }
}

package de.share_your_idea.user_meeting.service;

import de.share_your_idea.user_meeting.entity.UserEntity;
import de.share_your_idea.user_meeting.entity.UserMeetingEntity;
import de.share_your_idea.user_meeting.repository.MeetingEntityRepository;
import de.share_your_idea.user_meeting.repository.UserEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static de.share_your_idea.user_meeting.entity.UserRole.ROLE_USER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

class UserMeetingServiceTest {
    @Mock
    private UserEntityRepository userEntityRepository;
    @Mock
    private MeetingEntityRepository meetingEntityRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Captor
    private ArgumentCaptor<UserEntity> userEntityArgumentCaptor;
    private ArgumentCaptor<UserMeetingEntity> userMeetingEntityArgumentCaptor;
    private UserMeetingService userMeetingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userMeetingService = new UserMeetingService(userEntityRepository, meetingEntityRepository, null);
    }

    @Test
    void itShouldSaveMeeting() {
        /* Given */
        UserMeetingEntity userMeetingEntity = new UserMeetingEntity(1L, "testMeetingName", "testCommunicationLink", null);
        /* Mocking the Return if Method save() is called */
        given(meetingEntityRepository.save(any(UserMeetingEntity.class))).willReturn(any(UserMeetingEntity.class));
        /* When */
        UserMeetingEntity insertResult = userMeetingService.saveMeeting(userMeetingEntity);
        /* Then */
        then(meetingEntityRepository).should().save(userMeetingEntityArgumentCaptor.capture());
        UserMeetingEntity userMeetingEntityFromService = userMeetingEntityArgumentCaptor.getValue();
        assertThat(userMeetingEntityFromService.getMeetingId()).isEqualTo(userMeetingEntity.getMeetingId());
        assertThat(userMeetingEntityFromService.getMeetingName()).isEqualTo(userMeetingEntity.getMeetingName());
        assertThat(userMeetingEntityFromService.getCommunicationLink()).isEqualTo(userMeetingEntity.getCommunicationLink());
        assertThat(userMeetingEntityFromService.getUserEntityList()).isEqualTo(userMeetingEntity.getUserEntityList());
        assertThat(insertResult).isEqualTo(any(UserMeetingEntity.class));
    }

    @Test
    void itShouldFindMeetingByMeetingName() {
        /* Given */
        /* When */
        /* Then */
    }
}
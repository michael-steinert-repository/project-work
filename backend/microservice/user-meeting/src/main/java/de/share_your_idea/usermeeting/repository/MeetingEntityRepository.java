package de.share_your_idea.usermeeting.repository;

import de.share_your_idea.usermeeting.entity.UserMeetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface MeetingEntityRepository extends JpaRepository<UserMeetingEntity, UUID> {
    UserMeetingEntity findMeetingEntityByMeetingName(String meetingName);

    @Modifying
    @Transactional(readOnly = false)
    int deleteMeetingEntityByMeetingName(String meetingName);
}
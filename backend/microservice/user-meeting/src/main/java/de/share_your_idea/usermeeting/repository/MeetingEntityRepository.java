package de.share_your_idea.usermeeting.repository;

import de.share_your_idea.usermeeting.entity.MeetingEntity;
import de.share_your_idea.usermeeting.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface MeetingEntityRepository extends JpaRepository<MeetingEntity, UUID> {
    MeetingEntity findMeetingEntityByMeetingName(String meetingName);

    @Modifying
    @Transactional(readOnly = false)
    int deleteMeetingEntityByMeetingName(String meetingName);
}

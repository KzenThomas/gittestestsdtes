package ChatApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ChatApp.Entities.Messages;

@Repository
public interface MessageRepo extends CrudRepository<Messages, String>{
	
	@Query(value = "Select messagetext from Messages", nativeQuery = true)
	List<Messages> getAllMessages();
	
	@Query(value = "select m from Messages m where m.conversations.conversationsid = :conversationsid")
	List<Messages>getAllMessagesFromconversations(Integer conversationsid);

}	
package org.solovyev.android.messenger.chats;

import org.solovyev.android.messenger.entities.Entity;
import org.solovyev.android.messenger.accounts.AccountConnectionException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * User: serso
 * Date: 6/6/12
 * Time: 3:29 PM
 */
public interface AccountChatService {

	@Nonnull
	List<ChatMessage> getChatMessages(@Nonnull String accountUserId) throws AccountConnectionException;

	@Nonnull
	List<ChatMessage> getNewerChatMessagesForChat(@Nonnull String accountChatId, @Nonnull String accountUserId) throws AccountConnectionException;

	@Nonnull
	List<ChatMessage> getOlderChatMessagesForChat(@Nonnull String accountChatId, @Nonnull String accountUserId, @Nonnull Integer offset) throws AccountConnectionException;

	@Nonnull
	List<ApiChat> getUserChats(@Nonnull String accountUserId) throws AccountConnectionException;

	/**
	 * Method sends message to the realm and, if possible, returns message is. If message id could not be returned
	 * (due, for example, to the asynchronous nature of realm) - null is returned (in that case realm connection must receive message id)
	 *
	 * @param chat    chat in which message was created
	 * @param message message to be sent
	 * @return message id of sent message if possible
	 */
	@Nullable
	String sendChatMessage(@Nonnull Chat chat, @Nonnull ChatMessage message) throws AccountConnectionException;

	@Nonnull
	Chat newPrivateChat(@Nonnull Entity accountChat, @Nonnull String accountUserId1, @Nonnull String accountUserId2) throws AccountConnectionException;
}

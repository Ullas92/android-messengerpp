package org.solovyev.android.messenger.realms;

import org.solovyev.android.captcha.ResolvedCaptcha;
import org.solovyev.android.messenger.security.InvalidCredentialsException;
import org.solovyev.common.BuilderWithData;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface AccountBuilder extends BuilderWithData<Account, AccountBuilder.Data> {

	@Nonnull
	RealmDef getRealmDef();

	@Nullable
	Account getEditedAccount();

	void connect() throws ConnectionException;

	void disconnect() throws ConnectionException;

	void loginUser(@Nullable ResolvedCaptcha resolvedCaptcha) throws InvalidCredentialsException;

	@Nonnull
	AccountConfiguration getConfiguration();

	public static final class Data {

		@Nonnull
		private final String accountId;

		public Data(@Nonnull String accountId) {
			this.accountId = accountId;
		}

		@Nonnull
		public String getAccountId() {
			return accountId;
		}
	}

	public static class ConnectionException extends Exception {

		public ConnectionException() {
		}

		public ConnectionException(Throwable throwable) {
			super(throwable);
		}
	}
}

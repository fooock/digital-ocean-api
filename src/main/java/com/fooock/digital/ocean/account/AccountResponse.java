package com.fooock.digital.ocean.account;

/**
 * Response for {@link AccountService#account()}. All user information is returned
 * in the {@link Account} object
 */
public class AccountResponse {

    private final Account account;

    /**
     * Create this object
     *
     * @param account {@code Account}
     */
    public AccountResponse(Account account) {
        this.account = account;
    }

    public Account account() {
        return account;
    }
}

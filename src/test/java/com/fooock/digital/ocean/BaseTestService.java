package com.fooock.digital.ocean;

import okhttp3.OkHttpClient;
import org.junit.After;
import org.junit.Before;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

/**
 *
 */
public class BaseTestService<T> {

    protected Retrofit retrofit;
    protected BehaviorDelegate<T> behaviorDelegate;

    private MockRetrofit mockRetrofit;

    private final Class<T> clazzType;

    /**
     * @param clazz Class type
     */
    public BaseTestService(Class<T> clazz) {
        clazzType = clazz;
    }

    @Before
    public void setUp() throws Exception {
        retrofit = new Retrofit.Builder()
                .baseUrl(DigitalOcean.ENDPOINT_V2)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final NetworkBehavior behavior = NetworkBehavior.create();
        behavior.setFailurePercent(0);
        mockRetrofit = new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior)
                .build();
        behaviorDelegate = mockRetrofit.create(clazzType);
    }

    @After
    public void tearDown() throws Exception {
        retrofit = null;
        mockRetrofit = null;
        behaviorDelegate = null;
    }
}

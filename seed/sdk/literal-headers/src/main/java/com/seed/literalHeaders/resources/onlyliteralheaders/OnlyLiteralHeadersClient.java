/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.literalHeaders.resources.onlyliteralheaders;

import com.seed.literalHeaders.core.ApiError;
import com.seed.literalHeaders.core.ClientOptions;
import com.seed.literalHeaders.core.ObjectMappers;
import com.seed.literalHeaders.core.RequestOptions;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OnlyLiteralHeadersClient {
    protected final ClientOptions clientOptions;

    public OnlyLiteralHeadersClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public void get(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("only-literal-headers")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return;
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void get() {
        get(null);
    }
}

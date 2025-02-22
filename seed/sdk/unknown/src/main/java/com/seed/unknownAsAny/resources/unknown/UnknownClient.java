/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.unknownAsAny.resources.unknown;

import com.fasterxml.jackson.core.type.TypeReference;
import com.seed.unknownAsAny.core.ApiError;
import com.seed.unknownAsAny.core.ClientOptions;
import com.seed.unknownAsAny.core.MediaTypes;
import com.seed.unknownAsAny.core.ObjectMappers;
import com.seed.unknownAsAny.core.RequestOptions;
import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UnknownClient {
    protected final ClientOptions clientOptions;

    public UnknownClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public List<Object> post(Object request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response =
                    clientOptions.httpClient().newCall(okhttpRequest).execute();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(
                        response.body().string(), new TypeReference<List<Object>>() {});
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object> post(Object request) {
        return post(request, null);
    }
}

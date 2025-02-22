/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.idempotencyHeaders.resources.payment;

import com.seed.idempotencyHeaders.core.ApiError;
import com.seed.idempotencyHeaders.core.ClientOptions;
import com.seed.idempotencyHeaders.core.MediaTypes;
import com.seed.idempotencyHeaders.core.ObjectMappers;
import com.seed.idempotencyHeaders.core.RequestOptions;
import com.seed.idempotencyHeaders.resources.payment.requests.CreatePaymentRequest;
import java.io.IOException;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PaymentClient {
    protected final ClientOptions clientOptions;

    public PaymentClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public UUID create(CreatePaymentRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("payment")
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
                return ObjectMappers.JSON_MAPPER.readValue(response.body().string(), UUID.class);
            }
            throw new ApiError(
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(response.body().string(), Object.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UUID create(CreatePaymentRequest request) {
        return create(request, null);
    }

    public void delete(String paymentId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("payment")
                .addPathSegment(paymentId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
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

    public void delete(String paymentId) {
        delete(paymentId, null);
    }
}

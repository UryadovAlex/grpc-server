package com.example.grpcserver.service;

import com.example.grpcserver.proto_gen.Request;
import com.example.grpcserver.proto_gen.Response;
import com.example.grpcserver.proto_gen.TestGrpcServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class MyServiceImpl extends TestGrpcServiceGrpc.TestGrpcServiceImplBase {

    @Override
    public void test(Request request, StreamObserver<Response> responseObserver) {
        Response reply = Response.newBuilder()
                .setMessage("Hello ==> " + request.getPayload())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
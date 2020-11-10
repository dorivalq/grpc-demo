package greet;

import com.proto.dummy.Dummy;
import com.proto.dummy.DummyServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {
    public static void main(String[] args) {
        System.out.println("Hello from gRPC Client");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051).build();

        System.out.println("Creating stub");
        DummyServiceGrpc.DummyServiceBlockingStub synClient = DummyServiceGrpc.newBlockingStub(channel);
//        DummyServiceGrpc.DummyServiceFutureStub asyncClient = DummyServiceGrpc.newFutureStub(channel);

        System.out.println("Shutting down channel");
        channel.shutdown();
    }
}
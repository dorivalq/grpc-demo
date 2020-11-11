package greet.client;

import com.proto.dummy.Dummy;
import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {
    public static void main(String[] args) {
        System.out.println("Hello from gRPC Client");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051)
                .usePlaintext()
                .build();

        System.out.println("Creating stub");
        //Old Dummy
//        DummyServiceGrpc.DummyServiceBlockingStub synClient = DummyServiceGrpc.newBlockingStub(channel);
//        DummyServiceGrpc.DummyServiceFutureStub asyncClient = DummyServiceGrpc.newFutureStub(channel);

        //Crete service cli
        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);
        // protocol buffer Greeting
        Greetging greetging = Greetging.newBuilder()
                .setFirstName("Dorival")
                .setLastName("Querino")
                .build();

        //request
        GreetRequest greetRequest = GreetRequest.newBuilder()
                .setGreeting(greetging)
                .build();

        //get the response
        GreetResponse greetResponse = greetClient.greet(greetRequest);

        System.out.println("greetResponse.getResult() = " + greetResponse.getResult());
        
        System.out.println("Shutting down channel");
        channel.shutdown();
    }
}
package greet;

import greet.client.GreetServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello gRPC" );
        Server server = ServerBuilder.forPort(50051)
                .addService(new GreetServiceImpl())
                .build();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread( ()->{
            System.out.println("Recieved shutdown request");
            server.shutdown();
            System.out.println("Successfuly stoped the server");
        } ));

        server.awaitTermination();

    }
}

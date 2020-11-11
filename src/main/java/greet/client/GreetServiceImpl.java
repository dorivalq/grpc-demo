package greet.client;

import com.proto.greet.*;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        Greetging greeting = request.getGreeting();
        String firstName = greeting.getFirstName();
        String lastName = greeting.getLastName();
        String result =  "Hello "+ firstName;
        GreetResponse response = GreetResponse.newBuilder()
                .setResult(result)
                .build();

        //send response
        responseObserver.onNext(response);

        //complete the rcp call
        responseObserver.onCompleted();

//        super.greet(request, responseObserver);
    }
}

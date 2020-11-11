package calculator;

import com.proto.calculator.CalculatorServiceGrpc;
import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import io.grpc.stub.StreamObserver;


public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {
    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
    SumResponse sumResponse = SumResponse.newBuilder()
            .setResult(request.getFirstNumber() + request.getSecondNumber())
            .build();

    responseObserver.onNext(sumResponse);

    responseObserver.onCompleted();
    }

}

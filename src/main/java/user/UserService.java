package user;

import com.momo.grpc.UserGrpc.UserImplBase;
import com.momo.grpc.UserOuterClass.APIResponse;
import com.momo.grpc.UserOuterClass.Empty;
import com.momo.grpc.UserOuterClass.LoginRequest;

import io.grpc.stub.StreamObserver;

public class UserService extends UserImplBase {

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("Inside login");

		String userName = request.getUsername();
		String password = request.getPassword();

		APIResponse.Builder response = APIResponse.newBuilder();
		if (userName.equals(password)) {
			// return success message
			response.setResponseCode(1).setResponseMessage("SUCCESS");
		} else {
			response.setResponseCode(0).setResponseMessage("INVALID PASSWORD");
		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		// TODO Auto-generated method stub
		super.logout(request, responseObserver);
	}

}

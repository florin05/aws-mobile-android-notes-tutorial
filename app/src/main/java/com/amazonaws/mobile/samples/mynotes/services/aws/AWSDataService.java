package com.amazonaws.mobile.samples.mynotes.services.aws;

import android.annotation.TargetApi;
import android.content.Context;
import android.provider.SyncStateContract;
import android.util.Log;

import com.amazonaws.amplify.generated.graphql.CreateDriverStatusInfoMutation;
import com.amazonaws.amplify.generated.graphql.GetDriverStatusInfoQuery;
import com.amazonaws.amplify.generated.graphql.StatusByUserNameQuery;
import com.amazonaws.amplify.generated.graphql.UpdateDriverStatusInfoMutation;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatus;
import com.amazonaws.mobile.samples.mynotes.models.DriverStatusInfo;
import com.amazonaws.mobile.samples.mynotes.models.Note;
import com.amazonaws.mobile.samples.mynotes.models.PagedListConnectionResponse;
import com.amazonaws.mobile.samples.mynotes.models.ResultCallback;
import com.amazonaws.mobile.samples.mynotes.services.DataService;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.amazonaws.mobileconnectors.appsync.sigv4.APIKeyAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicAPIKeyAuthProvider;
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicCognitoUserPoolsAuthProvider;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.api.Input;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
/*import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.api.Error;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;*/

import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nonnull;

/*import type.CreateNoteInput;
import type.UpdateNoteInput;
import type.DeleteNoteInput;*/

import type.CreateDriverStatusInfoInput;
import type.UpdateDriverStatusInfoInput;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;

public  class AWSDataService implements DataService {
    private static final String TAG = "AWSDataService";
    public static String loggedInUserName;
    private AWSAppSyncClient client;

    public AWSDataService(Context context, AWSService awsService) {
        // Create an AppSync client from the AWSConfiguration
        AWSConfiguration config = awsService.getConfiguration();
        CognitoUserPool userPool = new CognitoUserPool(context, awsService.getConfiguration());
        client = AWSAppSyncClient.builder()
                .context(context)
                .awsConfiguration(config)
                .apiKey(new BasicAPIKeyAuthProvider("da2-rj2dz5yakvdktmevdc6nroogsu"))
                .build();
    }


    @Override
    public void getDriverStatusInfo(String userName, ResultCallback<DriverStatusInfo> callback) {
        StatusByUserNameQuery query = StatusByUserNameQuery.builder().userName(userName).build();
        // GetDriverStatusInfoQuery query = GetDriverStatusInfoQuery.builder().id(userName).build();
        client.query(query)
                .responseFetcher(AppSyncResponseFetchers.NETWORK_ONLY)
                .enqueue(new GraphQLCall.Callback<StatusByUserNameQuery.Data>() {
                    @Override
                    public void onResponse(@Nonnull Response<StatusByUserNameQuery.Data> response) {
                        StatusByUserNameQuery.StatusByUserName result = response.data().statusByUserName();
                        if (result == null || result.items().size() == 0 ) {
                            runOnUiThread(() -> callback.onResult(null));
                        } else {
                            StatusByUserNameQuery.Item driverStatusInfoInDb =  result.items().get(0); // only expecting one
                            final DriverStatusInfo status = new DriverStatusInfo(Enum.valueOf(DriverStatus.class,  driverStatusInfoInDb.driverStatus()));
                            status.setId( driverStatusInfoInDb.id());
                            status.setVersion(driverStatusInfoInDb._version());
                            status.setUserName(driverStatusInfoInDb.userName());
                            runOnUiThread(() -> callback.onResult(status));
                        }
                    }

                    @Override
                    public void onFailure(@Nonnull ApolloException e) {
                        Log.e(TAG, String.format(Locale.ENGLISH, "Error during GraphQL Operation: %s", e.getMessage()), e);
                    }
                });
    }



    @Override
    public void createDriverStatusInfo(String userName, DriverStatus status, ResultCallback<DriverStatusInfo> callback) {
        CreateDriverStatusInfoInput input = CreateDriverStatusInfoInput.builder()
                .userName(userName)
                .driverStatus(status.name())
                .build();
        CreateDriverStatusInfoMutation mutation = CreateDriverStatusInfoMutation.builder().input(input).build();

        client.mutate(mutation)
                .enqueue(new GraphQLCall.Callback<CreateDriverStatusInfoMutation.Data>() {
                    @Override
                    public void onResponse(@Nonnull Response<CreateDriverStatusInfoMutation.Data> response) {
                        if (response.hasErrors()) {
                            showErrors(response.errors());
                            runOnUiThread(() -> callback.onResult(null));
                        } else {
                            CreateDriverStatusInfoMutation.CreateDriverStatusInfo item = response.data().createDriverStatusInfo();
                            final DriverStatusInfo returnedDriverStatsInfo = new DriverStatusInfo( Enum.valueOf(DriverStatus.class,  item.driverStatus()));
                            returnedDriverStatsInfo.setUserName(item.userName());
                            returnedDriverStatsInfo.setId(item.id());
                            returnedDriverStatsInfo.setVersion(item._version());
                            runOnUiThread(() -> callback.onResult(returnedDriverStatsInfo));
                        }
                    }

                    @Override
                    public void onFailure(@Nonnull ApolloException e) {
                        Log.e(TAG, String.format(Locale.ENGLISH, "Error during GraphQL Operation: %s", e.getMessage()), e);
                    }
                });
    }


    @Override
    @TargetApi(26)
    public void updateDriverStatusInfo(DriverStatusInfo status, ResultCallback<DriverStatusInfo> callback) {

        UpdateDriverStatusInfoInput input = UpdateDriverStatusInfoInput.builder()
                .id(status.getId())
                .lastStatusChange( ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_INSTANT ))
                .latitude(status.getLatitude())
                .longitude(status.getLongitude())
                .userName(status.getUserName())
                .driverStatus(status.getStatus().name())
                ._version(status.getVersion())
                .build();
        UpdateDriverStatusInfoMutation mutation = UpdateDriverStatusInfoMutation.builder().input(input).build();

        client.mutate(mutation)
                .enqueue(new GraphQLCall.Callback<UpdateDriverStatusInfoMutation.Data>() {
                    @Override
                    public void onResponse(@Nonnull Response<UpdateDriverStatusInfoMutation.Data> response) {
                        if (response.hasErrors()) {
                            showErrors(response.errors());
                            runOnUiThread(() -> callback.onResult(null));
                        } else {
                            UpdateDriverStatusInfoMutation.UpdateDriverStatusInfo item = response.data().updateDriverStatusInfo();
                            final DriverStatusInfo returnedStatus = new DriverStatusInfo( Enum.valueOf(DriverStatus.class,  item.driverStatus()));
                            returnedStatus.setUserName(item.userName());
                            returnedStatus.setId(item.id());
                            returnedStatus.setVersion(item._version());
                            returnedStatus.setLongitude(item.longitude());
                            returnedStatus.setLatitude(item.latitude());
                            runOnUiThread(() -> callback.onResult(returnedStatus));
                        }
                    }

                    @Override
                    public void onFailure(@Nonnull ApolloException e) {
                        Log.e(TAG, String.format(Locale.ENGLISH, "Error during GraphQL Operation: %s", e.getMessage()), e);
                    }
                });
    }

    private void showErrors(List<com.apollographql.apollo.api.Error> errors) {
        Log.e(TAG, "Response has errors:");
        for (com.apollographql.apollo.api.Error e : errors) {
            Log.e(TAG, String.format(Locale.ENGLISH, "Error: %s", e.message() ));
        }
        Log.e(TAG, "End of Response errors");
    }

    public void getDriverStatus(ResultCallback<DriverStatusInfo> callback) {

    }

    public void updateDriverStatus(DriverStatusInfo status, ResultCallback<DriverStatusInfo> callback) {

    }
}
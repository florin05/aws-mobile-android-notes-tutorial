package com.amazonaws.amplify.generated.graphql;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import type.CustomType;
import type.ModelDriverStatusInfoConditionInput;
import type.UpdateDriverStatusInfoInput;

@Generated("Apollo GraphQL")
public final class UpdateDriverStatusInfoMutation implements Mutation<UpdateDriverStatusInfoMutation.Data, UpdateDriverStatusInfoMutation.Data, UpdateDriverStatusInfoMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation UpdateDriverStatusInfo($input: UpdateDriverStatusInfoInput!, $condition: ModelDriverStatusInfoConditionInput) {\n"
      + "  updateDriverStatusInfo(input: $input, condition: $condition) {\n"
      + "    __typename\n"
      + "    userName\n"
      + "    driverStatus\n"
      + "    lastStatusChange\n"
      + "    latitude\n"
      + "    longitude\n"
      + "    _version\n"
      + "    _deleted\n"
      + "    _lastChangedAt\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "UpdateDriverStatusInfo";
    }
  };

  private final UpdateDriverStatusInfoMutation.Variables variables;

  public UpdateDriverStatusInfoMutation(@Nonnull UpdateDriverStatusInfoInput input,
      @Nullable ModelDriverStatusInfoConditionInput condition) {
    Utils.checkNotNull(input, "input == null");
    variables = new UpdateDriverStatusInfoMutation.Variables(input, condition);
  }

  @Override
  public String operationId() {
    return "ecde3c2aecad008cbfea974e49c2ce80f7c7be279901707d3f26ec6b4ead7877";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public UpdateDriverStatusInfoMutation.Data wrapData(UpdateDriverStatusInfoMutation.Data data) {
    return data;
  }

  @Override
  public UpdateDriverStatusInfoMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<UpdateDriverStatusInfoMutation.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    private @Nonnull UpdateDriverStatusInfoInput input;

    private @Nullable ModelDriverStatusInfoConditionInput condition;

    Builder() {
    }

    public Builder input(@Nonnull UpdateDriverStatusInfoInput input) {
      this.input = input;
      return this;
    }

    public Builder condition(@Nullable ModelDriverStatusInfoConditionInput condition) {
      this.condition = condition;
      return this;
    }

    public UpdateDriverStatusInfoMutation build() {
      Utils.checkNotNull(input, "input == null");
      return new UpdateDriverStatusInfoMutation(input, condition);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull UpdateDriverStatusInfoInput input;

    private final @Nullable ModelDriverStatusInfoConditionInput condition;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull UpdateDriverStatusInfoInput input,
        @Nullable ModelDriverStatusInfoConditionInput condition) {
      this.input = input;
      this.condition = condition;
      this.valueMap.put("input", input);
      this.valueMap.put("condition", condition);
    }

    public @Nonnull UpdateDriverStatusInfoInput input() {
      return input;
    }

    public @Nullable ModelDriverStatusInfoConditionInput condition() {
      return condition;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeObject("input", input.marshaller());
          writer.writeObject("condition", condition != null ? condition.marshaller() : null);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("updateDriverStatusInfo", "updateDriverStatusInfo", new UnmodifiableMapBuilder<String, Object>(2)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
        .put("condition", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "condition")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable UpdateDriverStatusInfo updateDriverStatusInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable UpdateDriverStatusInfo updateDriverStatusInfo) {
      this.updateDriverStatusInfo = updateDriverStatusInfo;
    }

    public @Nullable UpdateDriverStatusInfo updateDriverStatusInfo() {
      return this.updateDriverStatusInfo;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], updateDriverStatusInfo != null ? updateDriverStatusInfo.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updateDriverStatusInfo=" + updateDriverStatusInfo
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.updateDriverStatusInfo == null) ? (that.updateDriverStatusInfo == null) : this.updateDriverStatusInfo.equals(that.updateDriverStatusInfo));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (updateDriverStatusInfo == null) ? 0 : updateDriverStatusInfo.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final UpdateDriverStatusInfo.Mapper updateDriverStatusInfoFieldMapper = new UpdateDriverStatusInfo.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final UpdateDriverStatusInfo updateDriverStatusInfo = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<UpdateDriverStatusInfo>() {
          @Override
          public UpdateDriverStatusInfo read(ResponseReader reader) {
            return updateDriverStatusInfoFieldMapper.map(reader);
          }
        });
        return new Data(updateDriverStatusInfo);
      }
    }
  }

  public static class UpdateDriverStatusInfo {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("userName", "userName", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("driverStatus", "driverStatus", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("lastStatusChange", "lastStatusChange", null, true, CustomType.AWSDATETIME, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("latitude", "latitude", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("longitude", "longitude", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("_version", "_version", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forBoolean("_deleted", "_deleted", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("_lastChangedAt", "_lastChangedAt", null, false, CustomType.AWSTIMESTAMP, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String userName;

    final @Nonnull String driverStatus;

    final @Nullable String lastStatusChange;

    final @Nullable Double latitude;

    final @Nullable Double longitude;

    final int _version;

    final @Nullable Boolean _deleted;

    final long _lastChangedAt;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public UpdateDriverStatusInfo(@Nonnull String __typename, @Nonnull String userName,
        @Nonnull String driverStatus, @Nullable String lastStatusChange, @Nullable Double latitude,
        @Nullable Double longitude, int _version, @Nullable Boolean _deleted, long _lastChangedAt) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.userName = Utils.checkNotNull(userName, "userName == null");
      this.driverStatus = Utils.checkNotNull(driverStatus, "driverStatus == null");
      this.lastStatusChange = lastStatusChange;
      this.latitude = latitude;
      this.longitude = longitude;
      this._version = _version;
      this._deleted = _deleted;
      this._lastChangedAt = _lastChangedAt;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nonnull String userName() {
      return this.userName;
    }

    public @Nonnull String driverStatus() {
      return this.driverStatus;
    }

    public @Nullable String lastStatusChange() {
      return this.lastStatusChange;
    }

    public @Nullable Double latitude() {
      return this.latitude;
    }

    public @Nullable Double longitude() {
      return this.longitude;
    }

    public int _version() {
      return this._version;
    }

    public @Nullable Boolean _deleted() {
      return this._deleted;
    }

    public long _lastChangedAt() {
      return this._lastChangedAt;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], userName);
          writer.writeString($responseFields[2], driverStatus);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[3], lastStatusChange);
          writer.writeDouble($responseFields[4], latitude);
          writer.writeDouble($responseFields[5], longitude);
          writer.writeInt($responseFields[6], _version);
          writer.writeBoolean($responseFields[7], _deleted);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[8], _lastChangedAt);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "UpdateDriverStatusInfo{"
          + "__typename=" + __typename + ", "
          + "userName=" + userName + ", "
          + "driverStatus=" + driverStatus + ", "
          + "lastStatusChange=" + lastStatusChange + ", "
          + "latitude=" + latitude + ", "
          + "longitude=" + longitude + ", "
          + "_version=" + _version + ", "
          + "_deleted=" + _deleted + ", "
          + "_lastChangedAt=" + _lastChangedAt
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof UpdateDriverStatusInfo) {
        UpdateDriverStatusInfo that = (UpdateDriverStatusInfo) o;
        return this.__typename.equals(that.__typename)
         && this.userName.equals(that.userName)
         && this.driverStatus.equals(that.driverStatus)
         && ((this.lastStatusChange == null) ? (that.lastStatusChange == null) : this.lastStatusChange.equals(that.lastStatusChange))
         && ((this.latitude == null) ? (that.latitude == null) : this.latitude.equals(that.latitude))
         && ((this.longitude == null) ? (that.longitude == null) : this.longitude.equals(that.longitude))
         && this._version == that._version
         && ((this._deleted == null) ? (that._deleted == null) : this._deleted.equals(that._deleted))
         && this._lastChangedAt == that._lastChangedAt;
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= userName.hashCode();
        h *= 1000003;
        h ^= driverStatus.hashCode();
        h *= 1000003;
        h ^= (lastStatusChange == null) ? 0 : lastStatusChange.hashCode();
        h *= 1000003;
        h ^= (latitude == null) ? 0 : latitude.hashCode();
        h *= 1000003;
        h ^= (longitude == null) ? 0 : longitude.hashCode();
        h *= 1000003;
        h ^= _version;
        h *= 1000003;
        h ^= (_deleted == null) ? 0 : _deleted.hashCode();
        h *= 1000003;
        h ^= _lastChangedAt;
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<UpdateDriverStatusInfo> {
      @Override
      public UpdateDriverStatusInfo map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String userName = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String driverStatus = reader.readString($responseFields[2]);
        final String lastStatusChange = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        final Double latitude = reader.readDouble($responseFields[4]);
        final Double longitude = reader.readDouble($responseFields[5]);
        final int _version = reader.readInt($responseFields[6]);
        final Boolean _deleted = reader.readBoolean($responseFields[7]);
        final long _lastChangedAt = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[8]);
        return new UpdateDriverStatusInfo(__typename, userName, driverStatus, lastStatusChange, latitude, longitude, _version, _deleted, _lastChangedAt);
      }
    }
  }
}

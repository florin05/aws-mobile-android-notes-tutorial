package com.amazonaws.amplify.generated.graphql;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
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

@Generated("Apollo GraphQL")
public final class GetDriverStatusInfoQuery implements Query<GetDriverStatusInfoQuery.Data, GetDriverStatusInfoQuery.Data, GetDriverStatusInfoQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetDriverStatusInfo($id: ID!) {\n"
      + "  getDriverStatusInfo(id: $id) {\n"
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
      return "GetDriverStatusInfo";
    }
  };

  private final GetDriverStatusInfoQuery.Variables variables;

  public GetDriverStatusInfoQuery(@Nonnull String id) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetDriverStatusInfoQuery.Variables(id);
  }

  @Override
  public String operationId() {
    return "d91feaf853f3a65af965e772b751bcadb371d05cfe0c8ef89d5e9d6e119bb972";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetDriverStatusInfoQuery.Data wrapData(GetDriverStatusInfoQuery.Data data) {
    return data;
  }

  @Override
  public GetDriverStatusInfoQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetDriverStatusInfoQuery.Data> responseFieldMapper() {
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
    private @Nonnull String id;

    Builder() {
    }

    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    public GetDriverStatusInfoQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetDriverStatusInfoQuery(id);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id) {
      this.id = id;
      this.valueMap.put("id", id);
    }

    public @Nonnull String id() {
      return id;
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
          writer.writeString("id", id);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("getDriverStatusInfo", "getDriverStatusInfo", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable GetDriverStatusInfo getDriverStatusInfo;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable GetDriverStatusInfo getDriverStatusInfo) {
      this.getDriverStatusInfo = getDriverStatusInfo;
    }

    public @Nullable GetDriverStatusInfo getDriverStatusInfo() {
      return this.getDriverStatusInfo;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], getDriverStatusInfo != null ? getDriverStatusInfo.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "getDriverStatusInfo=" + getDriverStatusInfo
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
        return ((this.getDriverStatusInfo == null) ? (that.getDriverStatusInfo == null) : this.getDriverStatusInfo.equals(that.getDriverStatusInfo));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (getDriverStatusInfo == null) ? 0 : getDriverStatusInfo.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final GetDriverStatusInfo.Mapper getDriverStatusInfoFieldMapper = new GetDriverStatusInfo.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final GetDriverStatusInfo getDriverStatusInfo = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<GetDriverStatusInfo>() {
          @Override
          public GetDriverStatusInfo read(ResponseReader reader) {
            return getDriverStatusInfoFieldMapper.map(reader);
          }
        });
        return new Data(getDriverStatusInfo);
      }
    }
  }

  public static class GetDriverStatusInfo {
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

    public GetDriverStatusInfo(@Nonnull String __typename, @Nonnull String userName,
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
        $toString = "GetDriverStatusInfo{"
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
      if (o instanceof GetDriverStatusInfo) {
        GetDriverStatusInfo that = (GetDriverStatusInfo) o;
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

    public static final class Mapper implements ResponseFieldMapper<GetDriverStatusInfo> {
      @Override
      public GetDriverStatusInfo map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String userName = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String driverStatus = reader.readString($responseFields[2]);
        final String lastStatusChange = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        final Double latitude = reader.readDouble($responseFields[4]);
        final Double longitude = reader.readDouble($responseFields[5]);
        final int _version = reader.readInt($responseFields[6]);
        final Boolean _deleted = reader.readBoolean($responseFields[7]);
        final long _lastChangedAt = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[8]);
        return new GetDriverStatusInfo(__typename, userName, driverStatus, lastStatusChange, latitude, longitude, _version, _deleted, _lastChangedAt);
      }
    }
  }
}

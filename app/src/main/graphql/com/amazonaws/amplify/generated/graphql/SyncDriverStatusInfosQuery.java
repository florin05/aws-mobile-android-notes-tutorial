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
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import type.CustomType;
import type.ModelDriverStatusInfoFilterInput;

@Generated("Apollo GraphQL")
public final class SyncDriverStatusInfosQuery implements Query<SyncDriverStatusInfosQuery.Data, SyncDriverStatusInfosQuery.Data, SyncDriverStatusInfosQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query SyncDriverStatusInfos($filter: ModelDriverStatusInfoFilterInput, $limit: Int, $nextToken: String, $lastSync: AWSTimestamp) {\n"
      + "  syncDriverStatusInfos(filter: $filter, limit: $limit, nextToken: $nextToken, lastSync: $lastSync) {\n"
      + "    __typename\n"
      + "    items {\n"
      + "      __typename\n"
      + "      userName\n"
      + "      driverStatus\n"
      + "      lastStatusChange\n"
      + "      latitude\n"
      + "      longitude\n"
      + "      _version\n"
      + "      _deleted\n"
      + "      _lastChangedAt\n"
      + "    }\n"
      + "    nextToken\n"
      + "    startedAt\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "SyncDriverStatusInfos";
    }
  };

  private final SyncDriverStatusInfosQuery.Variables variables;

  public SyncDriverStatusInfosQuery(@Nullable ModelDriverStatusInfoFilterInput filter,
      @Nullable Integer limit, @Nullable String nextToken, @Nullable Long lastSync) {
    variables = new SyncDriverStatusInfosQuery.Variables(filter, limit, nextToken, lastSync);
  }

  @Override
  public String operationId() {
    return "022a3e7c6578f0706bcc26860279a1093532a1f3af6bb2d5532977c895975251";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public SyncDriverStatusInfosQuery.Data wrapData(SyncDriverStatusInfosQuery.Data data) {
    return data;
  }

  @Override
  public SyncDriverStatusInfosQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<SyncDriverStatusInfosQuery.Data> responseFieldMapper() {
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
    private @Nullable ModelDriverStatusInfoFilterInput filter;

    private @Nullable Integer limit;

    private @Nullable String nextToken;

    private @Nullable Long lastSync;

    Builder() {
    }

    public Builder filter(@Nullable ModelDriverStatusInfoFilterInput filter) {
      this.filter = filter;
      return this;
    }

    public Builder limit(@Nullable Integer limit) {
      this.limit = limit;
      return this;
    }

    public Builder nextToken(@Nullable String nextToken) {
      this.nextToken = nextToken;
      return this;
    }

    public Builder lastSync(@Nullable Long lastSync) {
      this.lastSync = lastSync;
      return this;
    }

    public SyncDriverStatusInfosQuery build() {
      return new SyncDriverStatusInfosQuery(filter, limit, nextToken, lastSync);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable ModelDriverStatusInfoFilterInput filter;

    private final @Nullable Integer limit;

    private final @Nullable String nextToken;

    private final @Nullable Long lastSync;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable ModelDriverStatusInfoFilterInput filter, @Nullable Integer limit,
        @Nullable String nextToken, @Nullable Long lastSync) {
      this.filter = filter;
      this.limit = limit;
      this.nextToken = nextToken;
      this.lastSync = lastSync;
      this.valueMap.put("filter", filter);
      this.valueMap.put("limit", limit);
      this.valueMap.put("nextToken", nextToken);
      this.valueMap.put("lastSync", lastSync);
    }

    public @Nullable ModelDriverStatusInfoFilterInput filter() {
      return filter;
    }

    public @Nullable Integer limit() {
      return limit;
    }

    public @Nullable String nextToken() {
      return nextToken;
    }

    public @Nullable Long lastSync() {
      return lastSync;
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
          writer.writeObject("filter", filter != null ? filter.marshaller() : null);
          writer.writeInt("limit", limit);
          writer.writeString("nextToken", nextToken);
          writer.writeLong("lastSync", lastSync);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("syncDriverStatusInfos", "syncDriverStatusInfos", new UnmodifiableMapBuilder<String, Object>(4)
        .put("filter", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "filter")
        .build())
        .put("lastSync", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "lastSync")
        .build())
        .put("nextToken", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "nextToken")
        .build())
        .put("limit", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "limit")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable SyncDriverStatusInfos syncDriverStatusInfos;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable SyncDriverStatusInfos syncDriverStatusInfos) {
      this.syncDriverStatusInfos = syncDriverStatusInfos;
    }

    public @Nullable SyncDriverStatusInfos syncDriverStatusInfos() {
      return this.syncDriverStatusInfos;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], syncDriverStatusInfos != null ? syncDriverStatusInfos.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "syncDriverStatusInfos=" + syncDriverStatusInfos
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
        return ((this.syncDriverStatusInfos == null) ? (that.syncDriverStatusInfos == null) : this.syncDriverStatusInfos.equals(that.syncDriverStatusInfos));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (syncDriverStatusInfos == null) ? 0 : syncDriverStatusInfos.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final SyncDriverStatusInfos.Mapper syncDriverStatusInfosFieldMapper = new SyncDriverStatusInfos.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final SyncDriverStatusInfos syncDriverStatusInfos = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<SyncDriverStatusInfos>() {
          @Override
          public SyncDriverStatusInfos read(ResponseReader reader) {
            return syncDriverStatusInfosFieldMapper.map(reader);
          }
        });
        return new Data(syncDriverStatusInfos);
      }
    }
  }

  public static class SyncDriverStatusInfos {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("items", "items", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("nextToken", "nextToken", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("startedAt", "startedAt", null, true, CustomType.AWSTIMESTAMP, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Item> items;

    final @Nullable String nextToken;

    final @Nullable Long startedAt;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public SyncDriverStatusInfos(@Nonnull String __typename, @Nullable List<Item> items,
        @Nullable String nextToken, @Nullable Long startedAt) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.items = items;
      this.nextToken = nextToken;
      this.startedAt = startedAt;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable List<Item> items() {
      return this.items;
    }

    public @Nullable String nextToken() {
      return this.nextToken;
    }

    public @Nullable Long startedAt() {
      return this.startedAt;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], items, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Item) value).marshaller());
            }
          });
          writer.writeString($responseFields[2], nextToken);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[3], startedAt);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "SyncDriverStatusInfos{"
          + "__typename=" + __typename + ", "
          + "items=" + items + ", "
          + "nextToken=" + nextToken + ", "
          + "startedAt=" + startedAt
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof SyncDriverStatusInfos) {
        SyncDriverStatusInfos that = (SyncDriverStatusInfos) o;
        return this.__typename.equals(that.__typename)
         && ((this.items == null) ? (that.items == null) : this.items.equals(that.items))
         && ((this.nextToken == null) ? (that.nextToken == null) : this.nextToken.equals(that.nextToken))
         && ((this.startedAt == null) ? (that.startedAt == null) : this.startedAt.equals(that.startedAt));
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
        h ^= (items == null) ? 0 : items.hashCode();
        h *= 1000003;
        h ^= (nextToken == null) ? 0 : nextToken.hashCode();
        h *= 1000003;
        h ^= (startedAt == null) ? 0 : startedAt.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<SyncDriverStatusInfos> {
      final Item.Mapper itemFieldMapper = new Item.Mapper();

      @Override
      public SyncDriverStatusInfos map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<Item> items = reader.readList($responseFields[1], new ResponseReader.ListReader<Item>() {
          @Override
          public Item read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Item>() {
              @Override
              public Item read(ResponseReader reader) {
                return itemFieldMapper.map(reader);
              }
            });
          }
        });
        final String nextToken = reader.readString($responseFields[2]);
        final Long startedAt = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        return new SyncDriverStatusInfos(__typename, items, nextToken, startedAt);
      }
    }
  }

  public static class Item {
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

    public Item(@Nonnull String __typename, @Nonnull String userName, @Nonnull String driverStatus,
        @Nullable String lastStatusChange, @Nullable Double latitude, @Nullable Double longitude,
        int _version, @Nullable Boolean _deleted, long _lastChangedAt) {
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
        $toString = "Item{"
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
      if (o instanceof Item) {
        Item that = (Item) o;
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

    public static final class Mapper implements ResponseFieldMapper<Item> {
      @Override
      public Item map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String userName = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String driverStatus = reader.readString($responseFields[2]);
        final String lastStatusChange = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[3]);
        final Double latitude = reader.readDouble($responseFields[4]);
        final Double longitude = reader.readDouble($responseFields[5]);
        final int _version = reader.readInt($responseFields[6]);
        final Boolean _deleted = reader.readBoolean($responseFields[7]);
        final long _lastChangedAt = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[8]);
        return new Item(__typename, userName, driverStatus, lastStatusChange, latitude, longitude, _version, _deleted, _lastChangedAt);
      }
    }
  }
}

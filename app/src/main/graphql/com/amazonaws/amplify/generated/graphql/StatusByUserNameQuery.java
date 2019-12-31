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
import type.ModelIDKeyConditionInput;
import type.ModelSortDirection;

@Generated("Apollo GraphQL")
public final class StatusByUserNameQuery implements Query<StatusByUserNameQuery.Data, StatusByUserNameQuery.Data, StatusByUserNameQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query StatusByUserName($userName: ID, $id: ModelIDKeyConditionInput, $sortDirection: ModelSortDirection, $filter: ModelDriverStatusInfoFilterInput, $limit: Int, $nextToken: String) {\n"
      + "  statusByUserName(userName: $userName, id: $id, sortDirection: $sortDirection, filter: $filter, limit: $limit, nextToken: $nextToken) {\n"
      + "    __typename\n"
      + "    items {\n"
      + "      __typename\n"
      + "      id\n"
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
      return "StatusByUserName";
    }
  };

  private final StatusByUserNameQuery.Variables variables;

  public StatusByUserNameQuery(@Nullable String userName, @Nullable ModelIDKeyConditionInput id,
      @Nullable ModelSortDirection sortDirection, @Nullable ModelDriverStatusInfoFilterInput filter,
      @Nullable Integer limit, @Nullable String nextToken) {
    variables = new StatusByUserNameQuery.Variables(userName, id, sortDirection, filter, limit, nextToken);
  }

  @Override
  public String operationId() {
    return "4fba951ac0a103001ff13e51c24f5b1b68855ac43dfe4f528bdcd099387cd0ac";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public StatusByUserNameQuery.Data wrapData(StatusByUserNameQuery.Data data) {
    return data;
  }

  @Override
  public StatusByUserNameQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<StatusByUserNameQuery.Data> responseFieldMapper() {
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
    private @Nullable String userName;

    private @Nullable ModelIDKeyConditionInput id;

    private @Nullable ModelSortDirection sortDirection;

    private @Nullable ModelDriverStatusInfoFilterInput filter;

    private @Nullable Integer limit;

    private @Nullable String nextToken;

    Builder() {
    }

    public Builder userName(@Nullable String userName) {
      this.userName = userName;
      return this;
    }

    public Builder id(@Nullable ModelIDKeyConditionInput id) {
      this.id = id;
      return this;
    }

    public Builder sortDirection(@Nullable ModelSortDirection sortDirection) {
      this.sortDirection = sortDirection;
      return this;
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

    public StatusByUserNameQuery build() {
      return new StatusByUserNameQuery(userName, id, sortDirection, filter, limit, nextToken);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable String userName;

    private final @Nullable ModelIDKeyConditionInput id;

    private final @Nullable ModelSortDirection sortDirection;

    private final @Nullable ModelDriverStatusInfoFilterInput filter;

    private final @Nullable Integer limit;

    private final @Nullable String nextToken;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable String userName, @Nullable ModelIDKeyConditionInput id,
        @Nullable ModelSortDirection sortDirection,
        @Nullable ModelDriverStatusInfoFilterInput filter, @Nullable Integer limit,
        @Nullable String nextToken) {
      this.userName = userName;
      this.id = id;
      this.sortDirection = sortDirection;
      this.filter = filter;
      this.limit = limit;
      this.nextToken = nextToken;
      this.valueMap.put("userName", userName);
      this.valueMap.put("id", id);
      this.valueMap.put("sortDirection", sortDirection);
      this.valueMap.put("filter", filter);
      this.valueMap.put("limit", limit);
      this.valueMap.put("nextToken", nextToken);
    }

    public @Nullable String userName() {
      return userName;
    }

    public @Nullable ModelIDKeyConditionInput id() {
      return id;
    }

    public @Nullable ModelSortDirection sortDirection() {
      return sortDirection;
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

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeString("userName", userName);
          writer.writeObject("id", id != null ? id.marshaller() : null);
          writer.writeString("sortDirection", sortDirection != null ? sortDirection.name() : null);
          writer.writeObject("filter", filter != null ? filter.marshaller() : null);
          writer.writeInt("limit", limit);
          writer.writeString("nextToken", nextToken);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("statusByUserName", "statusByUserName", new UnmodifiableMapBuilder<String, Object>(6)
        .put("filter", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "filter")
        .build())
        .put("sortDirection", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "sortDirection")
        .build())
        .put("nextToken", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "nextToken")
        .build())
        .put("limit", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "limit")
        .build())
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
        .build())
        .put("userName", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "userName")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable StatusByUserName statusByUserName;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable StatusByUserName statusByUserName) {
      this.statusByUserName = statusByUserName;
    }

    public @Nullable StatusByUserName statusByUserName() {
      return this.statusByUserName;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], statusByUserName != null ? statusByUserName.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "statusByUserName=" + statusByUserName
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
        return ((this.statusByUserName == null) ? (that.statusByUserName == null) : this.statusByUserName.equals(that.statusByUserName));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (statusByUserName == null) ? 0 : statusByUserName.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final StatusByUserName.Mapper statusByUserNameFieldMapper = new StatusByUserName.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final StatusByUserName statusByUserName = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<StatusByUserName>() {
          @Override
          public StatusByUserName read(ResponseReader reader) {
            return statusByUserNameFieldMapper.map(reader);
          }
        });
        return new Data(statusByUserName);
      }
    }
  }

  public static class StatusByUserName {
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

    public StatusByUserName(@Nonnull String __typename, @Nullable List<Item> items,
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
        $toString = "StatusByUserName{"
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
      if (o instanceof StatusByUserName) {
        StatusByUserName that = (StatusByUserName) o;
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

    public static final class Mapper implements ResponseFieldMapper<StatusByUserName> {
      final Item.Mapper itemFieldMapper = new Item.Mapper();

      @Override
      public StatusByUserName map(ResponseReader reader) {
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
        return new StatusByUserName(__typename, items, nextToken, startedAt);
      }
    }
  }

  public static class Item {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
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

    final @Nonnull String id;

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

    public Item(@Nonnull String __typename, @Nonnull String id, @Nonnull String userName,
        @Nonnull String driverStatus, @Nullable String lastStatusChange, @Nullable Double latitude,
        @Nullable Double longitude, int _version, @Nullable Boolean _deleted, long _lastChangedAt) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
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

    public @Nonnull String id() {
      return this.id;
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
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[2], userName);
          writer.writeString($responseFields[3], driverStatus);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[4], lastStatusChange);
          writer.writeDouble($responseFields[5], latitude);
          writer.writeDouble($responseFields[6], longitude);
          writer.writeInt($responseFields[7], _version);
          writer.writeBoolean($responseFields[8], _deleted);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[9], _lastChangedAt);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Item{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
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
         && this.id.equals(that.id)
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
        h ^= id.hashCode();
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
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String userName = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[2]);
        final String driverStatus = reader.readString($responseFields[3]);
        final String lastStatusChange = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[4]);
        final Double latitude = reader.readDouble($responseFields[5]);
        final Double longitude = reader.readDouble($responseFields[6]);
        final int _version = reader.readInt($responseFields[7]);
        final Boolean _deleted = reader.readBoolean($responseFields[8]);
        final long _lastChangedAt = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[9]);
        return new Item(__typename, id, userName, driverStatus, lastStatusChange, latitude, longitude, _version, _deleted, _lastChangedAt);
      }
    }
  }
}

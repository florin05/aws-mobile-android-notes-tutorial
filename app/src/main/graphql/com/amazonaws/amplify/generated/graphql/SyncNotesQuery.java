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
import type.ModelNoteFilterInput;

@Generated("Apollo GraphQL")
public final class SyncNotesQuery implements Query<SyncNotesQuery.Data, SyncNotesQuery.Data, SyncNotesQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query SyncNotes($filter: ModelNoteFilterInput, $limit: Int, $nextToken: String, $lastSync: AWSTimestamp) {\n"
      + "  syncNotes(filter: $filter, limit: $limit, nextToken: $nextToken, lastSync: $lastSync) {\n"
      + "    __typename\n"
      + "    items {\n"
      + "      __typename\n"
      + "      id\n"
      + "      title\n"
      + "      content\n"
      + "      blabla\n"
      + "      _version\n"
      + "      _deleted\n"
      + "      _lastChangedAt\n"
      + "      owner\n"
      + "    }\n"
      + "    nextToken\n"
      + "    startedAt\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "SyncNotes";
    }
  };

  private final SyncNotesQuery.Variables variables;

  public SyncNotesQuery(@Nullable ModelNoteFilterInput filter, @Nullable Integer limit,
      @Nullable String nextToken, @Nullable Long lastSync) {
    variables = new SyncNotesQuery.Variables(filter, limit, nextToken, lastSync);
  }

  @Override
  public String operationId() {
    return "a1b554f649697adabc1ef33ae526e22ed463901d4bbe6454508628455c7919b1";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public SyncNotesQuery.Data wrapData(SyncNotesQuery.Data data) {
    return data;
  }

  @Override
  public SyncNotesQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<SyncNotesQuery.Data> responseFieldMapper() {
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
    private @Nullable ModelNoteFilterInput filter;

    private @Nullable Integer limit;

    private @Nullable String nextToken;

    private @Nullable Long lastSync;

    Builder() {
    }

    public Builder filter(@Nullable ModelNoteFilterInput filter) {
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

    public SyncNotesQuery build() {
      return new SyncNotesQuery(filter, limit, nextToken, lastSync);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable ModelNoteFilterInput filter;

    private final @Nullable Integer limit;

    private final @Nullable String nextToken;

    private final @Nullable Long lastSync;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable ModelNoteFilterInput filter, @Nullable Integer limit,
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

    public @Nullable ModelNoteFilterInput filter() {
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
      ResponseField.forObject("syncNotes", "syncNotes", new UnmodifiableMapBuilder<String, Object>(4)
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

    final @Nullable SyncNotes syncNotes;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable SyncNotes syncNotes) {
      this.syncNotes = syncNotes;
    }

    public @Nullable SyncNotes syncNotes() {
      return this.syncNotes;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], syncNotes != null ? syncNotes.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "syncNotes=" + syncNotes
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
        return ((this.syncNotes == null) ? (that.syncNotes == null) : this.syncNotes.equals(that.syncNotes));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (syncNotes == null) ? 0 : syncNotes.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final SyncNotes.Mapper syncNotesFieldMapper = new SyncNotes.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final SyncNotes syncNotes = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<SyncNotes>() {
          @Override
          public SyncNotes read(ResponseReader reader) {
            return syncNotesFieldMapper.map(reader);
          }
        });
        return new Data(syncNotes);
      }
    }
  }

  public static class SyncNotes {
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

    public SyncNotes(@Nonnull String __typename, @Nullable List<Item> items,
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
        $toString = "SyncNotes{"
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
      if (o instanceof SyncNotes) {
        SyncNotes that = (SyncNotes) o;
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

    public static final class Mapper implements ResponseFieldMapper<SyncNotes> {
      final Item.Mapper itemFieldMapper = new Item.Mapper();

      @Override
      public SyncNotes map(ResponseReader reader) {
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
        return new SyncNotes(__typename, items, nextToken, startedAt);
      }
    }
  }

  public static class Item {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("title", "title", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("content", "content", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("blabla", "blabla", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("_version", "_version", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forBoolean("_deleted", "_deleted", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("_lastChangedAt", "_lastChangedAt", null, false, CustomType.AWSTIMESTAMP, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("owner", "owner", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String title;

    final @Nonnull String content;

    final @Nonnull String blabla;

    final int _version;

    final @Nullable Boolean _deleted;

    final long _lastChangedAt;

    final @Nullable String owner;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Item(@Nonnull String __typename, @Nonnull String id, @Nonnull String title,
        @Nonnull String content, @Nonnull String blabla, int _version, @Nullable Boolean _deleted,
        long _lastChangedAt, @Nullable String owner) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.title = Utils.checkNotNull(title, "title == null");
      this.content = Utils.checkNotNull(content, "content == null");
      this.blabla = Utils.checkNotNull(blabla, "blabla == null");
      this._version = _version;
      this._deleted = _deleted;
      this._lastChangedAt = _lastChangedAt;
      this.owner = owner;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nonnull String id() {
      return this.id;
    }

    public @Nonnull String title() {
      return this.title;
    }

    public @Nonnull String content() {
      return this.content;
    }

    public @Nonnull String blabla() {
      return this.blabla;
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

    public @Nullable String owner() {
      return this.owner;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], title);
          writer.writeString($responseFields[3], content);
          writer.writeString($responseFields[4], blabla);
          writer.writeInt($responseFields[5], _version);
          writer.writeBoolean($responseFields[6], _deleted);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[7], _lastChangedAt);
          writer.writeString($responseFields[8], owner);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Item{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "title=" + title + ", "
          + "content=" + content + ", "
          + "blabla=" + blabla + ", "
          + "_version=" + _version + ", "
          + "_deleted=" + _deleted + ", "
          + "_lastChangedAt=" + _lastChangedAt + ", "
          + "owner=" + owner
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
         && this.title.equals(that.title)
         && this.content.equals(that.content)
         && this.blabla.equals(that.blabla)
         && this._version == that._version
         && ((this._deleted == null) ? (that._deleted == null) : this._deleted.equals(that._deleted))
         && this._lastChangedAt == that._lastChangedAt
         && ((this.owner == null) ? (that.owner == null) : this.owner.equals(that.owner));
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
        h ^= title.hashCode();
        h *= 1000003;
        h ^= content.hashCode();
        h *= 1000003;
        h ^= blabla.hashCode();
        h *= 1000003;
        h ^= _version;
        h *= 1000003;
        h ^= (_deleted == null) ? 0 : _deleted.hashCode();
        h *= 1000003;
        h ^= _lastChangedAt;
        h *= 1000003;
        h ^= (owner == null) ? 0 : owner.hashCode();
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
        final String title = reader.readString($responseFields[2]);
        final String content = reader.readString($responseFields[3]);
        final String blabla = reader.readString($responseFields[4]);
        final int _version = reader.readInt($responseFields[5]);
        final Boolean _deleted = reader.readBoolean($responseFields[6]);
        final long _lastChangedAt = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[7]);
        final String owner = reader.readString($responseFields[8]);
        return new Item(__typename, id, title, content, blabla, _version, _deleted, _lastChangedAt, owner);
      }
    }
  }
}
